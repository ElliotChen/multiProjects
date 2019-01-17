<%@ include file="/WEB-INF/jsp/commons/base.jsp"%>
<html>
<body>
<div class="container">
	<h1>This is secured!</h1>
	<p>
		Hello <b>${pageContext.request.remoteUser}</b>
	</p>
	<c:url var="logoutUrl" value="/logout"/>
	<a href="/task/index">Task</a>
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</div>
</body>
</html>
