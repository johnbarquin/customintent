var customintent = {
	fireIntent: function(successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'CustomIntent',
			'custom',
			[]
		);
	}
}

module.exports = customintent;