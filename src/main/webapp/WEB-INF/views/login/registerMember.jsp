<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<title>===== 평 쩜 =====</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=PT+Sans:400,700">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Oleo+Script:400,700">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

<!-- Javascript -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>
	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form action="" method="post">
					<h2>
						<span class="red"><strong>평쩜</strong></span>
					</h2>
					<label for="firstname">First Name</label> <input type="text" id="firstname"
						name="firstname" placeholder="enter your first name..."> <label
						for="lastname">Last Name</label> <input type="text" id="lastname"
						name="lastname" placeholder="enter your first name..."> <label
						for="username">Username</label> <input type="text" id="username"
						name="username" placeholder="choose a username..."> <label
						for="email">Email</label> <input type="text" id="email" name="email"
						placeholder="enter your email..."> <label for="password">Password</label>
					<input type="password" id="password" name="password"
						placeholder="choose a password...">
					<button type="submit">REGISTER</button>
				</form>
			</div>
		</div>
	</div>

</body>


</html>

