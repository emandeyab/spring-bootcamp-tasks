<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body>
        <form:form action="processForm" modelAttribute="userModel">
            <label for="un">User Name</label>
            <form:input id="un" type="text" placeholder="Enter your user name" path="userName"/>
            <br>
            <label for="pass">Password</label>
            <form:input id="pass" type="password" placeholder="Enter your user password" path="password"/>
            <br>
            <label for="c">Country</label>
            <form:select id="c" path="country">
                <form:option value="Egypt" label="Egypt"/>
                <form:option value="Palastine" label="Palastine"/>
                <form:option value="UAE" label="UAE"/>
                <form:option value="France" label="France"/>
            </form:select>
            <br>
            <label>Programming Language: </label>
            <form:radiobutton path="programmingLanguage" label="Java" value="java"/>
            <form:radiobutton path="programmingLanguage" label="C++" value="c++"/>
            <form:radiobutton path="programmingLanguage" label="C#" value="c#"/>
            <form:radiobutton path="programmingLanguage" label="Python" value="python"/>
            <br>
            <label>Operating Systems: </label>
            <form:checkbox path="operatingSystems" label="Windows" value="windows"/>
            <form:checkbox path="operatingSystems" label="Linux" value="linux"/>
            <form:checkbox path="operatingSystems" label="Mac OS" value="mac"/>
            <br>
            <input type="submit">
        </form:form>
    </body>
</html>

