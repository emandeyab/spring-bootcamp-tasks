<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add.css">
</head>
<body>
<form:form action="addProduct" modelAttribute="product" method="post">
    <label for="prodName">Product Name</label>
    <form:input id="prodName" type="text" placeholder="Enter product name" path="name"/>
    <br>
    <label for="description">Description</label>
    <form:input id="description" type="text" placeholder="Enter product description" path="details.name"/>
    <br>
    <label for="price">Price</label>
    <form:input id="price" type="text" placeholder="Enter product price" path="details.price"/>
    <br>
    <label for="manufacturer">Manufacturer</label>
    <form:input id="manufacturer" type="text" placeholder="Enter product manufacturer" path="details.manufacturer"/>
    <br>
    <label for="expirationDate">Expiration Date</label>
    <form:input id="expirationDate" type="date" placeholder="Enter product expirationDate" path="details.expirationDate"/>
    <br>
    <div class="radio-group">
        <label>Availability</label>
        <div>
            <form:radiobutton path="details.available" value="true" id="avail1"/>
            <label for="avail1">Available</label>
        </div>
        <div>
            <form:radiobutton path="details.available" value="false" id="avail2"/>
            <label for="avail2">Not Available</label>
        </div>
    </div>
    <br>
    <input type="submit" value="Add Product">
</form:form>
</body>
</html>

