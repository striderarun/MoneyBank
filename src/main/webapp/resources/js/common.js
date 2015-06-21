var PapaBank = PapaBank || {};
jQuery(function ($) {

	PapaBank.App = {

			postData : function (url, data) {
				console.log('postData', url, JSON.stringify(data));
			    var options = {
			                    url: url,
			                    type: 'POST',
			                    headers: {
			                        'Accept': 'application/json; charset=utf-8',
			                        'Content-Type': 'application/json; charset=UTF-8',
			                        }
			                  };
			    options.data = JSON.stringify(data)
			    return $.ajax(options);
			},

			 getData : function(url, params) {
	            console.log('getData', url, params);
	            data: params || {};
	            var options = {
	                    url: url,
	                    type: 'GET',
	                    data: params,
	                    headers: {
	                        'Accept': 'application/json; charset=utf-8',
	                        'Content-Type': 'application/json; charset=UTF-8',

	                    }
	                };

	                return $.ajax(options);
			}

		}


});

