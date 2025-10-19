<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Age Calculator</title>
</head>
<body>
<h1>Hello to Age Calculator</h1>


    <form action="calcAge">
        <div class="form-group">
            <label for="year">Years:</label>
            <input type="text" class="form-control" id="year" placeholder="Year" name="year">
        </div>
        <div class="form-group">
            <label for="month">Months:</label>
            <input type="text" class="form-control" id="month" placeholder="Month" name="month">
        </div>
        <div class="form-group">
            <label for="day">Days:</label>
            <input type="text" class="form-control" id="day" placeholder="Day" name="day">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</form>
</body>
</html>
