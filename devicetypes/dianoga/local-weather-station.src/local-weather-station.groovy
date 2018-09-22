/**
 *  SmartWeather Station
 *
 *  Author: SmartThings
 *
 *  Date: 2013-04-30
 */
// for the UI
metadata {
	// Automatically generated. Make future change here.
	definition (name: "Local Weather Station", namespace: "dianoga", author: "SmartThings") {
		capability "Illuminance Measurement"
		capability "Temperature Measurement"
		capability "Relative Humidity Measurement"
		capability "Polling"

		attribute "wind", "number"
		attribute "windGust", "number"
		attribute "dewPoint", "number"
		attribute "feelsLike", "number"
		attribute "windDirection", "number"
		attribute "rainInches", "number"
		attribute "rainDailyInches", "number"
		attribute "rainWeeklyInches", "number"
		attribute "rainMonthlyInches", "number"
		attribute "rainYearlyInches", "number"
		attribute "pressureInches", "number"

		attribute "localSunrise", "string"
		attribute "localSunset", "string"
		attribute "city", "string"
		attribute "timeZoneOffset", "string"
		attribute "weather", "string"
		attribute "weatherIcon", "string"
		attribute "forecastIcon", "string"
		attribute "percentPrecip", "string"
		attribute "alert", "string"
		attribute "alertKeys", "string"
		attribute "sunriseDate", "string"
		attribute "sunsetDate", "string"

		command "refresh"
	}

	preferences {
		input "zipCode", "text", title: "Zip Code (optional)", description: "Used for alerts", required: false
	}

	tiles {
		valueTile("temperature", "device.temperature") {
			state "default", label:'${currentValue}°',
				backgroundColors:[
					[value: 31, color: "#153591"],
					[value: 44, color: "#1e9cbb"],
					[value: 59, color: "#90d2a7"],
					[value: 74, color: "#44b621"],
					[value: 84, color: "#f1d801"],
					[value: 95, color: "#d04e00"],
					[value: 96, color: "#bc2323"]
				]
		}

		valueTile("humidity", "device.humidity", decoration: "flat") {
			state "default", label:'${currentValue}% humidity'
		}

		standardTile("weatherIcon", "device.weatherIcon", decoration: "flat") {
			state "chanceflurries", icon:"st.custom.wu1.chanceflurries", label: ""
			state "chancerain", icon:"st.custom.wu1.chancerain", label: ""
			state "chancesleet", icon:"st.custom.wu1.chancesleet", label: ""
			state "chancesnow", icon:"st.custom.wu1.chancesnow", label: ""
			state "chancetstorms", icon:"st.custom.wu1.chancetstorms", label: ""
			state "clear", icon:"st.custom.wu1.clear", label: ""
			state "cloudy", icon:"st.custom.wu1.cloudy", label: ""
			state "flurries", icon:"st.custom.wu1.flurries", label: ""
			state "fog", icon:"st.custom.wu1.fog", label: ""
			state "hazy", icon:"st.custom.wu1.hazy", label: ""
			state "mostlycloudy", icon:"st.custom.wu1.mostlycloudy", label: ""
			state "mostlysunny", icon:"st.custom.wu1.mostlysunny", label: ""
			state "partlycloudy", icon:"st.custom.wu1.partlycloudy", label: ""
			state "partlysunny", icon:"st.custom.wu1.partlysunny", label: ""
			state "rain", icon:"st.custom.wu1.rain", label: ""
			state "sleet", icon:"st.custom.wu1.sleet", label: ""
			state "snow", icon:"st.custom.wu1.snow", label: ""
			state "sunny", icon:"st.custom.wu1.sunny", label: ""
			state "tstorms", icon:"st.custom.wu1.tstorms", label: ""
			state "cloudy", icon:"st.custom.wu1.cloudy", label: ""
			state "partlycloudy", icon:"st.custom.wu1.partlycloudy", label: ""
			state "nt_chanceflurries", icon:"st.custom.wu1.nt_chanceflurries", label: ""
			state "nt_chancerain", icon:"st.custom.wu1.nt_chancerain", label: ""
			state "nt_chancesleet", icon:"st.custom.wu1.nt_chancesleet", label: ""
			state "nt_chancesnow", icon:"st.custom.wu1.nt_chancesnow", label: ""
			state "nt_chancetstorms", icon:"st.custom.wu1.nt_chancetstorms", label: ""
			state "nt_clear", icon:"st.custom.wu1.nt_clear", label: ""
			state "nt_cloudy", icon:"st.custom.wu1.nt_cloudy", label: ""
			state "nt_flurries", icon:"st.custom.wu1.nt_flurries", label: ""
			state "nt_fog", icon:"st.custom.wu1.nt_fog", label: ""
			state "nt_hazy", icon:"st.custom.wu1.nt_hazy", label: ""
			state "nt_mostlycloudy", icon:"st.custom.wu1.nt_mostlycloudy", label: ""
			state "nt_mostlysunny", icon:"st.custom.wu1.nt_mostlysunny", label: ""
			state "nt_partlycloudy", icon:"st.custom.wu1.nt_partlycloudy", label: ""
			state "nt_partlysunny", icon:"st.custom.wu1.nt_partlysunny", label: ""
			state "nt_sleet", icon:"st.custom.wu1.nt_sleet", label: ""
			state "nt_rain", icon:"st.custom.wu1.nt_rain", label: ""
			state "nt_sleet", icon:"st.custom.wu1.nt_sleet", label: ""
			state "nt_snow", icon:"st.custom.wu1.nt_snow", label: ""
			state "nt_sunny", icon:"st.custom.wu1.nt_sunny", label: ""
			state "nt_tstorms", icon:"st.custom.wu1.nt_tstorms", label: ""
			state "nt_cloudy", icon:"st.custom.wu1.nt_cloudy", label: ""
			state "nt_partlycloudy", icon:"st.custom.wu1.nt_partlycloudy", label: ""
		}
		valueTile("feelsLike", "device.feelsLike", decoration: "flat") {
			state "default", label:'feels like ${currentValue}°'
		}

		valueTile("wind", "device.wind", decoration: "flat") {
			state "default", label:'wind ${currentValue} mph'
		}

		valueTile("weather", "device.weather", decoration: "flat") {
			state "default", label:'${currentValue}'
		}

		valueTile("city", "device.city", decoration: "flat") {
			state "default", label:'${currentValue}'
		}

		valueTile("percentPrecip", "device.percentPrecip", decoration: "flat") {
			state "default", label:'${currentValue}% precip'
		}

		standardTile("refresh", "device.weather", decoration: "flat") {
			state "default", label: "", action: "refresh", icon:"st.secondary.refresh"
		}

		valueTile("alert", "device.alert", width: 3, height: 1, decoration: "flat") {
			state "default", label:'${currentValue}'
		}

		valueTile("rise", "device.localSunrise", decoration: "flat") {
			state "default", label:'${currentValue}'
		}

		valueTile("set", "device.localSunset", decoration: "flat") {
			state "default", label:'${currentValue}'
		}

		valueTile("light", "device.illuminance", decoration: "flat") {
			state "default", label:'${currentValue} lux'
		}

		valueTile("rain", "device.rainInches", decoration: "flat") {
			state "default", label:'${currentValue} in'
		}

		valueTile("rainDaily", "device.rainDailyInches", decoration: "flat") {
			state "default", label:'${currentValue} in'
		}

		valueTile("rainWeekly", "device.rainWeeklyInches", decoration: "flat") {
			state "default", label:'${currentValue} in'
		}

		valueTile("rainDaily", "device.rainDailyInches", decoration: "flat") {
			state "default", label:'${currentValue} in'
		}

		valueTile("rainYearly", "device.rainYearlyInches", decoration: "flat") {
			state "default", label:'${currentValue} in'
		}

		valueTile("pressure", "device.pressureInches", decoration: "flat") {
			state "default", label:'${currentValue} in'
		}

		main(["temperature", "weatherIcon","feelsLike"])
		details([
			"temperature",
			"humidity",
			"weatherIcon",
			"feelsLike",
			"wind",
			"weather",
			"city",
			"percentPrecip",
			"refresh",
			"alert",
			"rise",
			"set",
			"light",
			"rain",
			"rainDaily",
			"rainWeekly",
			"rainDaily",
			"rainYearly",
			"pressure"
		])}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
}

// handle commands
def poll() {
	log.debug "Executing 'poll', location: ${location.name}"

	// Current conditions
	def obs = get("conditions")?.current_observation
	if (obs) {
		def weatherIcon = obs.icon_url.split("/")[-1].split("\\.")[0]
		send(name: "weather", value: obs.weather)
		send(name: "weatherIcon", value: weatherIcon, displayed: false)

		if (obs.local_tz_offset != device.currentValue("timeZoneOffset")) {
			send(name: "timeZoneOffset", value: obs.local_tz_offset, isStateChange: true)
		}

		def cityValue = "${obs.display_location.city}, ${obs.display_location.state}"
		if (cityValue != device.currentValue("city")) {
			send(name: "city", value: cityValue, isStateChange: true)
		}

		// Sunrise / sunset
		def a = get("astronomy")?.moon_phase
		def today = localDate("GMT${obs.local_tz_offset}")
		def ltf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")
		ltf.setTimeZone(TimeZone.getTimeZone("GMT${obs.local_tz_offset}"))
		def utf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
		utf.setTimeZone(TimeZone.getTimeZone("GMT"))

		def sunriseDate = ltf.parse("${today} ${a.sunrise.hour}:${a.sunrise.minute}")
		def sunsetDate = ltf.parse("${today} ${a.sunset.hour}:${a.sunset.minute}")

		def tf = new java.text.SimpleDateFormat("h:mm a")
		tf.setTimeZone(TimeZone.getTimeZone("GMT${obs.local_tz_offset}"))
		def localSunrise = "${tf.format(sunriseDate)}"
		def localSunset = "${tf.format(sunsetDate)}"
		send(name: "localSunrise", value: localSunrise, descriptionText: "Sunrise today is at $localSunrise")
		send(name: "localSunset", value: localSunset, descriptionText: "Sunset today at is $localSunset")
	} else {
		log.warn "Current conditions not found"
	}

	// Forecast
	def f = get("forecast")
	def f1= f?.forecast?.simpleforecast?.forecastday
	if (f1) {
		def icon = f1[0].icon_url.split("/")[-1].split("\\.")[0]
		def value = f1[0].pop as String // as String because of bug in determining state change of 0 numbers
		send(name: "percentPrecip", value: value, unit: "%")
		send(name: "forecastIcon", value: icon, displayed: false)
	}
	else {
		log.warn "Forecast not found"
	}

	// Alerts
	def alerts = get("alerts")?.alerts
	def newKeys = alerts?.collect{it.type + it.date_epoch} ?: []
	log.debug "WUSTATION: newKeys: $newKeys"
	log.trace device.currentState("alertKeys")
	def oldKeys = device.currentState("alertKeys")?.jsonValue
	log.debug "WUSTATION: oldKeys: $oldKeys"

	def noneString = "no current weather alerts"
	if (!newKeys && oldKeys == null) {
		send(name: "alertKeys", value: newKeys.encodeAsJSON(), displayed: false)
		send(name: "alert", value: noneString, descriptionText: "${device.displayName} has no current weather alerts", isStateChange: true)
	}
	else if (newKeys != oldKeys) {
		if (oldKeys == null) {
			oldKeys = []
		}
		send(name: "alertKeys", value: newKeys.encodeAsJSON(), displayed: false)

		def newAlerts = false
		alerts.each {alert ->
			if (!oldKeys.contains(alert.type + alert.date_epoch)) {
				def msg = "${alert.description} from ${alert.date} until ${alert.expires}"
				send(name: "alert", value: pad(alert.description), descriptionText: msg, isStateChange: true)
				newAlerts = true
			}
		}

		if (!newAlerts && device.currentValue("alert") != noneString) {
			send(name: "alert", value: noneString, descriptionText: "${device.displayName} has no current weather alerts", isStateChange: true)
		}
	}
}

def refresh() {
	poll()
}

def configure() {
	poll()
}

private pad(String s, size = 25) {
	def n = (size - s.size()) / 2
	if (n > 0) {
		def sb = ""
		n.times {sb += " "}
		sb += s
		n.times {sb += " "}
		return sb
	}
	else {
		return s
	}
}

private get(feature) {
	getWeatherFeature(feature, zipCode)
}

private localDate(timeZone) {
	def df = new java.text.SimpleDateFormat("yyyy-MM-dd")
	df.setTimeZone(TimeZone.getTimeZone(timeZone))
	df.format(new Date())
}

private send(map) {
	log.debug "WUSTATION: event: $map"
	sendEvent(map)
}