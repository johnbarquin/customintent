var customintent = {
	fireIntent: function(successCallback, errorCallback) {
		console.log("Before exec");

		cordova.exec(
			successCallback,
			errorCallback,
			'CustomIntent',
			'geo',
			[]
		);

		console.log("After intent");
	}
}

module.exports = customintent;