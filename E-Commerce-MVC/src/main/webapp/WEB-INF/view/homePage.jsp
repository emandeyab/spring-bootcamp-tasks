<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Products List</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">
</head>
<body>
<h2>Products List</h2>

<form action="${pageContext.request.contextPath}/search">
  <input type="text" name="search" placeholder="Search by name"
         value="${search != null ? search : ''}"/>
  <button type="submit">Search</button>
</form>

<a href="${pageContext.request.contextPath}/add">Add New Product</a>

<table border="1" cellpadding="5">
  <tr>
    <th>Name</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.name}</td>
      <td>
        <a href="${pageContext.request.contextPath}/update?id=${product.id}">Update</a>
        <a href="${pageContext.request.contextPath}/delete?id=${product.id}" onclick="return confirm('Are you sure?')">Delete</a>
        <a href="${pageContext.request.contextPath}/details?id=${product.id}">View Details</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
