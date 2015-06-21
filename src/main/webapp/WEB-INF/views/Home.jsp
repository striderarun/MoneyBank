<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/handlebars.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/urls.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css" type="text/css" media="all" />
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
					<li class="active"><a href="${pageContext.request.contextPath}/dashboard" data-toggle="tab">Dashboard</a></li>
					<li><a href="${pageContext.request.contextPath}/transfer">Funds Transfer</a></li>
				</ul>
			</div>
			<div class="border-content" style="overflow: auto">

					<div class="panel panel-default panelWidth">
					  <div class="panel-heading">
					    <h3 class="panel-title">Account Summary</h3>
					  </div>
					  <div class="panel-body">
					   <div id="accountDetails" align = "center"></div>
					  </div>

					</div>

				<div class="table-container hideit">
      					<h3>Transactions</h3>
						<br><table id="table_id" class="table bordered rounded"></table>
				</div>
			</div>
		</div>
	</div>
<script id="account-details" type="text/x-handlebars-template">

	<ul class="list-group">
  		<li class="list-group-item">
    		<span class="badge">{{userName}}</span>
    		User Name
  		</li>
		<li class="list-group-item">
    		<span class="badge">{{accNo}}</span>
    		Account Number
  		</li>
		<li class="list-group-item">
    		<span class="badge">{{balance}}</span>
    		Balance (Rs.)
  		</li>
	</ul>
</script>

</body>
</html>