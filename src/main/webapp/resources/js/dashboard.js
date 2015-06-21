var PapaBank = PapaBank || {};
jQuery(function ($) {

	PapaBank.Run = {

			init: function () {
			    this.getAccountDetails();
			},

			getAccountDetails: function() {
				var accountDetailsResponse = PapaBank.App.getData(PapaBank.Url.getAccountDetails);

				accountDetailsResponse.success(function(data){
					var accountTemplate = Handlebars.compile($("#account-details").html());
					$("#accountDetails").html(accountTemplate(data.accountDetails));
					PapaBank.Run.tableLoader(data.transactionDetails);
				});
			},

			tableLoader: function (data) {
				var table = $('#table_id').dataTable(
						{
							"sPaginationType" : "full_numbers",
							"bSort": true,
							"bFilter": false,
							"bLengthChange": false,
							"aaData" : data,
							"aoColumns" : [
							               {
							            	   "sTitle" : "<div><p>Account No</p></div>",
							            	   "mData" : "accountNo",
							            	   "sWidth" : "43px"
							               },
							               {
							            	   "sTitle" : "<div><p>Transaction Remarks</p></div>",
							            	   "mData" : "transactionRemarks",
							            	   "sWidth" : "83px"
							               },
							               {
							            	   "sTitle" : "<div><p>Transaction Type</p></div>",
							            	   "mData" : "transactionType",
							            	   "sWidth" : "83px"
							               },
							               {
							            	   "sTitle" : "<div><p>Transaction Amount </p></div>",
							            	   "mData" : "transactionAmount",
							            	   "sWidth" : "83px"
							               }
							               ],
							               "bDestroy" : true,
							               "bAutoWidth" : false

					 });

				$(".table-container").show();

				},

		}

	PapaBank.Run.init();
});

