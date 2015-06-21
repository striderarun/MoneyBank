<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/urls.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/transfer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bank.css" type="text/css" media="all" />



</head>
<body>


	<div class="container">

		<nav class="navbar navbar-default navalign">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">
			      	<a class="navbar-brand" href="#">
	        			<img alt="Brand" src="glyphicon-gbp">
	     		    </a>
		        <div class="appName">Papa Bank</div>
		      </a>
		    </div>
		    <ul class="nav navbar-nav navbar-right">
      			<li><a href="${pageContext.request.contextPath}/logout" class="logoutBtn">Logout</a></li>
			</ul>
		  </div>
		</nav>
		<div class="body">
			<div>
				<ul class="nav nav-pills nav-justified">
					<li><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/transfer" data-toggle="tab">Funds Transfer</a></li>
				</ul>
			</div>
			<div class="border-content" style="overflow: auto">
				<div class="form-horizontal" align="center">

						<form class="alignForm">
							<div class="form-inline">
								<div class="form-group">
									<input type="text" class="form-control sizeInc" id="accountNo"
										placeholder="Enter Account Number">
									<div class="input-group">
										<div class="input-group-addon">INR</div>
										<input type="text" class="form-control" id="amount"
											placeholder="Amount">
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-primary btnAlign"
								id="transfer">Transfer cash</button>
						</form>
						<br>
						<form class="alignForm">
							<div class="form-inline">
								<div class="form-group">
									<input type="text" class="form-control" id="message"
										placeholder="Enter Your Message">

								</div>
							</div>
							<button type="button" class="btn btn-primary btnAlign"
								id="messageButton">Send</button>
						</form>
						<br>

						<form class="alignForm">
							<div class="form-inline">
								<div class="form-group">
									<input type="text" class="form-control" id="messageGateway"
										placeholder="Enter Your Message again">

								</div>
							</div>
							<button type="button" class="btn btn-primary btnAlign"
								id="messageGatewayButton">Send</button>
						</form>

				</div>
			</div>
		</div>
	</div>


</body>
</html>