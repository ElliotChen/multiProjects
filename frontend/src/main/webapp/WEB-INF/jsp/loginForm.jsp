<%@ include file="/WEB-INF/jsp/commons/base.jsp"%>
<html>
<body>
<h2>Login Form</h2>
<form:form action="${ctx}/login" method="post">
	<fieldset>
		<legend>Please Login</legend>
		<c:if test="${param.error != null}">
			<div class="alert alert-error">
				Invalid username and password.
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="alert alert-success">
				You have been logged out.
			</div>
		</c:if>
		<label for="username">Username</label>
		<input type="text" id="username" name="username" value="${username}"/>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>
		<div class="form-actions">
			<button type="submit" class="btn">Log in</button>
		</div>
	</fieldset>
</form:form>
</div>
</body>
</html>
