<!DOCTYPE html>
<html lang="en">
<head>
<title >Papa Bank</title>
<meta charset="utf-8" />
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css"/>
<script src="${pageContext.request.contextPath}/resources/js/login.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/urls.js"></script>
</head>
<body>
<section class="container">
    <div class="login">
      <h1>Login to Papa Bank</h1>

        <p><input type="text" name="login" value=""  id="userId" placeholder="User ID "></p>
        <p><input type="password" name="password" value="" id="password" placeholder="Password"></p>

        <p class="submit"><input type="submit" name="commit" value="Login" id="login"></p>
         </div>
</section>
</body>

</html>