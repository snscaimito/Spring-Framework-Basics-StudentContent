<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Pet Store</title>
</head>
<body>
	<h1>Available Breeds</h1>
	
	<table>
	<tr>
		<th>Breed (<a href="availableBreedsSorted?order=ASC">ASC</a>, <a href="availableBreedsSorted?order=DESC">DESC</a>)</th>
	</tr>
	<c:forEach items="${breeds}" varStatus="loop">
		<tr>
			<td>${breeds[loop.index]}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>