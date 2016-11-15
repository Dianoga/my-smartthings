/**
*  Test Dash
*
*  <TODO: Enter some description of your smart app project here>
*
*  Copyright undefined Brian
*
*  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License. You may obtain a copy of the License at:
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*/
definition(
	name: "Test Dash",
	namespace: "dianoga",
	author: "Brian",
	description: "Enter some description of your smart app project here",
	category: "",
	iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
	iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
	iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")


preferences {
    section("Title") {
        input "button", "capability.switch", title: "Select a switch", required: true
    }
}

cards {
    // this app has just one card.
    card(name: "home", type: "html", action: "home") {}
}

// expose all the endpoints that the JavaScript client will call.
mappings {
    path("/home") {
        action: [
            GET: "home"
        ]
    }
    path("/getInitialData") {
        action:[
            GET: "getInitialData"
        ]
    }
    path("/toggleSwitch") {
        action:[
            POST: "toggleSwitch"
        ]
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    subscribe(button, "switch", buttonEventHandler)
    updateSolutionSummary()
}

// send a SOLUTION_SUMMARY event that will update the
// subtext seen in the dashboard for this solution
def updateSolutionSummary(){
    def summaryData = []
    if (button.currentSwitch == "on") {
    	summaryData << [icon:"indicator-dot-green",iconColor:"#79b821",value:"switch is on"]
    } else {
    	summaryData << [icon:"indicator-dot-red",iconColor:"#e86d13",value:"switch is off"]
    }

    // generate a SOLUTION_SUMMARY event that can include status icon indicators
    sendEvent(linkText:'link text', descriptionText: 'description text',
          eventType:"SOLUTION_SUMMARY",
          name: "summary",
          value: "switch is ${button.currentSwitch}",
          data: summaryData,
          displayed: false)
}

// returns the current state of the configured switch
def getInitialData() {
    log.debug "getting initial data for html button"
    [name: "initialData", currentState: button.currentValue("switch")]
}

def toggleSwitch() {
    log.debug "will toggle switch state"
    if(button.currentValue("switch") == "on"){
        button.off()
    }else{
        button.on()
    }
}

// generate an event when the state of the switch changes, so the client
// can update its UX as needed.
def buttonEventHandler(evt) {
    log.debug "switch state changed to ${evt.value}"
    sendEvent(name: "buttonState", value: button.currentValue("switch"))
    // update the solution summary since the state changed
    updateSolutionSummary()
}

// render the home view
def home() {
    log.debug "will render index html"
    html('views/index.html', [
        page: [
            title: 'Button',
            description: 'An example HTML SmartApp'
        ]
    ])
}
