<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Pet Store</title>
</head>
<body>
	<h1>Available Pets</h1>
	
	<table>
	<tr>
		<th>Pet Name></th>
		<th>Breed</th>
		<th>Price</th>
	</tr>
	<c:forEach items="${pets}" varStatus="loop">
		<tr>
			<td>${pets[loop.index].petName}</td>
			<td>${pets[loop.index].petBreed}</td>
			<td>${pets[loop.index].petPrice}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>