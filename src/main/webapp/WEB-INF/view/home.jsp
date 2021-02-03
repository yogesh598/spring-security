<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home Page</title>
	</head>
	<body>
		<h2>way2solution home page</h2><hr>
		<p>Welcome to way2solution company home page</p>
		
		<!-- Display user name and Role -->
		<hr>
			<p>User: <security:authentication property="principal.username"/> <br>
			</p>Role(s): <security:authentication property="principal.authorities"/>
		<hr>
		
		<security:authorize access="hasRole('MANAGER')">
			<!-- Add link for /leaders..... this is  for Manager -->
			<p><a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				(Only for Managers)
			</p>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">	
			<!-- Add link for /systems..... this is  for Admins -->
			<p><a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
				(Only for Admins)
			</p>
			
			<p><a href="${pageContext.request.contextPath}/list-customers">Customers</a>
				
			</p>
		</security:authorize>
		
		<!-- Add logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" 
				    method="POST">
			<input type="submit" value="Logout"/>
		</form:form>
	</body>
</html>