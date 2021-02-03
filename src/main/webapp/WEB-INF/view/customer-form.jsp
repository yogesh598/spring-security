<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!Doctype html>
<html>
	<head>
		<title>Save Customer</title>
		
		<!-- reference our style sheet -->
		<link	type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />	
				
		<link	type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	</head>
	<body>
	
			<div id="wrapper">
				<div id="header">
					<h2>CRM - Customer RelationShip Manager</h2>
				</div>
			</div>
		
			<div id="container">
				<h3>Save Customer</h3>
				
				<form:form action="saveCustomer" modelAttribute="customer" method="POST">
					
					<!-- need to associate this data with customer id -->
					<form:hidden path="id"/>	<!-- on which customer we perform the update operation -->
					
					<table>
						<tbody>
							<tr>
								<td><label>First Name :</label></td>
								<td><form:input path="firstName"/></td>
							</tr>
							<tr>
								<td><label>Last Name :</label></td>
								<td><form:input path="lastName"/></td>
							</tr>
							<tr>
								<td><label>Email :</label></td>
								<td><form:input path="email"/></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save" class="save"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>
				
		
		</div>
	</body>
	
</html>