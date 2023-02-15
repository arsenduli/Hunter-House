<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>House Hunter</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <!-- For any Bootstrap that uses JS-->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
    <!-- Beginning of Container -->
    <div
            class="d-flex flex-column justify-content-center align-items-center gap-2">
        <h1>House Hunter</h1>
    </div>
    <div
            class="d-flex justify-content-center gap-5 mt-3">
        <div class = "bg-light p-5">
            <h3>Register</h3>
            <%--@elvariable id="user" type="com"--%>
            <form:form class="form d-flex flex-column gap-3" action="/register"
                       method="post" modelAttribute="user">
                <div
                        class=" d-flex flex-column justify-content-center align-items-center gap-2">
                    <form:errors path="userName" class="errors text-danger"></form:errors>
                    <form:label path="userName">Name: </form:label>
                    <form:input class="form-control" type="text" path="userName"></form:input>
                </div>
                <div
                        class=" d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="email" class="errors text-danger"></form:errors>
                    <form:label path="email">Email: </form:label>
                    <form:input class="form-control" type="text" path="email"></form:input>
                </div>
                <div
                        class=" d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="password" class="errors text-danger"></form:errors>
                    <form:label path="password">Password: </form:label>
                    <form:input class="form-control" type="password" path="password"></form:input>
                </div>
                <div
                        class=" d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="passwordConfirmation" class="errors text-danger"></form:errors>
                    <form:label path="passwordConfirmation">Confirm Password: </form:label>
                    <form:input class="form-control" type="password" path="passwordConfirmation"></form:input>
                </div>
                <input class="w-50 btn btn-primary" type="submit" value="Submit" />
            </form:form>
        </div>
        <div class = "bg-light p-5">
            <h3>Log In</h3>
            <%--@elvariable id="newLogin" type="java"--%>
            <%--@elvariable id="loginUser" type="com"--%>
            <form:form class="form d-flex flex-column gap-3" action="/login"
                       method="post" modelAttribute="loginUser">
                <div
                        class=" d-flex flex-column  justify-content-center align-items-center gap-2">
                    <form:errors path="email" class="errors text-danger"></form:errors>
                    <form:label path="email">Email: </form:label>
                    <form:input class="form-control" type="text" path="email"></form:input>
                </div>
                <div
                        class=" d-flex flex-column  justify-content-center align-items-center gap-2">

                    <form:label path="password">Password: </form:label>
                    <form:input class="form-control" type="password" path="password"></form:input>
                    <form:errors path="password" class="errors text-danger"></form:errors>
                </div>
                <input class="w-50 btn btn-primary" type="submit" value="Submit" />
            </form:form>
        </div>
    </div>
</div>
</body>
</html>