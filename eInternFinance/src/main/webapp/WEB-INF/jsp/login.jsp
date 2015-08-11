<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css" />
<!-- 	<link rel="stylesheet" href="assets/css/style.css" > -->
<title>Login Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">


</head>
<!-- spring security focus on username -->
<body onload='document.f.j_username.focus();'>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Sign in to the eIntern Finance
					Manager</h1>
				
				<div class="account-wall">
				<c:if test="${not empty error}">
					<div class="errorblock">
						Your login was unsuccessful. <br /> Caused:
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</div>
				</c:if>
					<form class="form-signin" action="<c:url value="/j_spring_security_check"></c:url>" name="f"
						method="post">
						<input name="j_username" type="text" class="form-control"
							placeholder="username" required autofocus> <input
							name="j_password" type="password" class="form-control"
							placeholder="Password" required>
						<button class="btn btn-lg btn-primary btn-block" id="submit"
							type="submit" value="submit">Sign in</button>
						<button class="btn btn-lg btn-primary btn-block" id="submit"
							type="reset" name="reset">Reset</button>
						
						<!--< label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me
                </label> -->
						<!-- <a href="#" class="pull-right need-help">Need help? </a><span
							class="clearfix"></span> -->
					</form>
				</div>
				<!-- <a href="AdminPages/register.jsp" class="text-center new-account">Create
					an account </a> -->
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</body>
</html>