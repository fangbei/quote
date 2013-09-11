<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions"
    xmlns:form="http://www.springframework.org/tags/form"
    xmlns:spring="http://www.springframework.org/tags"
    xmlns:sec="http://www.springframework.org/security/tags"
    xmlns:tags="urn:jsptagdir:/WEB-INF/tags" version="2.0">
  <jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
  <jsp:output omit-xml-declaration="true" />
  <jsp:output doctype-root-element="HTML"
              doctype-system="about:legacy-compat" />
<!DOCTYPE html>              
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>登录</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" media="screen">
<link href="assets/css/login.css" rel="stylesheet" media="screen">

<!-- Favicons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="assets/ico/favicon.ico">
</head>
<body>

	<div class="container">
		<div data-bind="visible: showErrorMessage" class="alert alert-error">
			登录失败，请检查输入项</div>
		<form class="form-signin" method="post" action="login.html">
			<h3 class="text-muted form-signin-heading">请登录</h3>
			<input type="text" class="form-control" placeholder="用户名"
				name="username" autofocus /> 
			<input type="password"
				class="form-control" placeholder="密码" name="password" /> 
			<label
				class="checkbox"> 
				<input type="checkbox" name="remember-me" />
				记住登录
			</label>
			<button class="btn btn-large btn-primary btn-block" type="submit">登录</button>
			<hr>
			<p class="text-info">
				<small> 测试用户 <strong>admin/admin</strong> 或 <strong>test/test</strong></small>
			</p>
		</form>
	</div>
	<!-- /container -->

	<script src="assets/js/knockout-2.3.0.js"></script>

	<script type="text/javascript">
		ko.applyBindings({
			showErrorMessage : ko.computed(function() {
				var query = window.location.search;
				return query ? (query.indexOf('error') != -1) : false;
			}),
		});
	</script>


</body>
</html>
</jsp:root>