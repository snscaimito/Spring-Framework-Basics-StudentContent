<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Pet Store - Add Pet</title>
</head>
<body>
	<h1>Add Pet</h1>
	
	<form:form commandName="pet">
	<table>
	<tr>
		<td>Pet Name:</td>
		<td><form:input path="petName"/></td>
		<td><form:errors path="petName"/></td>
	</tr>
	<tr>
		<td>Pet Breed:</td>
		<td><form:input path="petBreed"/></td>
		<td><form:errors path="petBreed"/></td>
	</tr>
	<tr>
		<td>Pet Price:</td>
		<td><form:input path="petPrice"/></td>
		<td><form:errors path="petPrice"/></td>
	</tr>
	<tr>
		<td colspan="3" align="right">
			<input type="submit" value="Save"/>
		</td>
	</tr>
	</table>
	</form:form>
</body>
</html>