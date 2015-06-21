var PapaBank = PapaBank || {};
jQuery(function ($) {

	PapaBank.Run = {
			init: function () {
			    this.bindEvents();
			},

			bindEvents: function () {
				$('body')
					.on('click', '#login', $.proxy(this.userLogin, this))
			},

			userLogin: function () {
				var userObj = {
						'userName'	: $('#userId').val(),
						'password' 	: $('#password').val()
					   };

				var	loginResponse = PapaBank.App.postData(PapaBank.Url.userLogin,userObj);
				console.log("Response" , userObj);
				loginResponse.success(function (data) {
					console.log(data);
					if(data.statusMessage == "SUCCESS") {
						console.log("Registration Successful");
						window.location = "./dashboard"
					}

				});
			}

		}

	PapaBank.Run.init();

});

