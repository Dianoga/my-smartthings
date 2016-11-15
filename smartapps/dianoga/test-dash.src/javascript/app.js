var APP = {
	init: function() {
		console.log("in APP.init(), will make call to getInitialData");
		ST.request("getInitialData")
			.success(function(data) {
				console.log(data);
				console.log(data);
				APP.render(data.currentState);
				APP.addBindings();
			})
			.GET();
	},

	render: function(state) {
		console.log("will update button css to reflect status of " + state);
		if (state == "on") {
			$("#button").addClass("on");
		} else {
			$("#button").removeClass("on");
		}
	},

	addBindings: function() {
		console.log("will add bindings to client events");
		// we listen to both click and touchend events so it can work in the
		// simulator as well as mobile clients.
		$("#button").on("touchend", function() {
			console.log("will toggle switch");
			ST.request("toggleSwitch").POST();
		});
	},

	eventReceiver: function(evt) {
		// this is where we handle events from the SmartApp.
		console.log("in eventReceiver with event name: " + evt.name);
		switch (evt.name) {
			case "buttonState":
				APP.render(evt.value);
				break;
		}
	}
}

// bootstrap the app
$('document').ready(function() {
	console.log("document ready, will initialize app");
	APP.init();
	// register event handler
	ST.addEventHandler(APP.eventReceiver);
});
