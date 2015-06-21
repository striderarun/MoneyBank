var PapaBank = PapaBank || {};
jQuery(function ($) {

	PapaBank.Run = {

			init: function () {
				this.bindEvents();
			},

			bindEvents: function () {
				$('body')
					.on('click', '#transfer', $.proxy(this.transferFunds, this))
					.on('click', '#messageButton', $.proxy(this.sendMessage, this))
					.on('click', '#messageGatewayButton', $.proxy(this.sendMessageGateway, this))
			},

			transferFunds: function (evt) {
				evt.preventDefault();
				var transferObj = {
						'accountNo'	: parseInt($('#accountNo').val()),
						'amount' 	: parseInt($('#amount').val())
					   };
				var	transferResponse = PapaBank.App.postData(PapaBank.Url.transferFunds,transferObj);
				transferResponse.success(function (data) {
					if(data.statusMessage == "SUCCESS") {
						alert("Transfer Successful");
					}

				});
			},

			sendMessage: function () {
				var url = PapaBank.Url.sendMessage+'?message=' + $('#message').val();
				console.log("URL" + url);
				PapaBank.App.getData(url);

			},

			sendMessageGateway: function () {
				var url = PapaBank.Url.sendMessageGateway+'?message=' + $('#messageGateway').val();
				console.log("URL" + url);
				PapaBank.App.getData(url);

			}


		}

	PapaBank.Run.init();
});

