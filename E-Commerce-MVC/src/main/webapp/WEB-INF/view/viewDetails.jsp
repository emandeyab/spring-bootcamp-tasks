<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/details.css">
</head>
<body>
<form:form action="details" modelAttribute="product" method="get">

<table class="table table-bordered">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Available</th>
        <th>Expiration Date</th>
        <th>Manufacturer</th>
    </tr>
        <tr>
            <td>${product.name}</td>
            <td>${product.details.name}</td>
            <td>${product.details.price}</td>
            <td>${product.details.available}</td>
            <td>${product.details.expirationDate}</td>
            <td>${product.details.manufacturer}</td>
        </tr>
</table>
    <a href="${pageContext.request.contextPath}">Back</a>
</form:form>
</body>
</html>

