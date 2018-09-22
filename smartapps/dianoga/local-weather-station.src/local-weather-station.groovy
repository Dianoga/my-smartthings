/**
 *  Local Weather Station
 *
 *  Copyright 2018 Brian Steere
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
	name: "Local Weather Station",
	namespace: "dianoga",
	author: "Brian Steere",
	description: "Weather station using combined local and cloud data",
	category: "Green Living",
	iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
	iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
	iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
	singleInstance: true
)


preferences {
	section("Setup") {
		paragraph "Nothing to see here. Hit done and move along"
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

def uninstalled() {
	getChildDevices().each { deleteChildDevice(it.deviceNetworkId) }
}

def initialize() {
	def deviceId = "local-weather-station"

	try {
		addChildDevice("dianoga", "Local Weather Station", deviceId, [name: "Device.${deviceId}", label: "Local Weather Station", completedSetup: true])
	} catch (Exception e) {
		log.error "Error creating device: ${e}"
	}
}
