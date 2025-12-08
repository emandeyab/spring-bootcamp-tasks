<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Data</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<h2>Enter Your Data:</h2>
    <form:form modelAttribute="user" action="dataForm">
        <div class="form-group">
            <label for="userName">Username:</label>
            <form:input type="text" class="form-control" id="userName" placeholder="username" path="userName"/>
            <form:errors path="userName" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <form:input type="email" class="form-control" id="email" placeholder="email" path="email"/>
            <form:errors path="email" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:input type="password" class="form-control" id="password" placeholder="password" path="password"/>
            <form:errors path="password" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="confirmPassword">Condirmed Password:</label>
            <form:input type="password" class="form-control" id="confirmPassword" placeholder="condirmed password" path="confirmPassword"/>
            <form:errors path="confirmPassword" cssClass="alert-danger" />
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>
</form>
</body>
</html>
