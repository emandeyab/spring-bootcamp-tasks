<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Data</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<h2>Enter Your Data:</h2>
    <form action="dataForm">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName">
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastName">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Email" name="email">
        </div>
        <div class="form-group">
            <label for="date_of_Birth">Date of Birth:</label>
            <input type="date" class="form-control" id="date_of_Birth" placeholder="Your date of Birth" name="date_of_Birth">
        </div>
        <div class="form-group">
            <label for="city">Email:</label>
            <input type="text" class="form-control" id="city" placeholder="City" name="city">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</form>
</body>
</html>
