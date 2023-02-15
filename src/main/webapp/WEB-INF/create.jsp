<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Listing</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <!-- For any Bootstrap that uses JS-->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div
        class="d-flex  justify-content-sm-between align-items-center gap-2">
    <h1>New Listing</h1>
    <a href="/home">dashboard</a>
</div>
    <%--@elvariable id="newHunter" type="com"--%>
    <form:form action="/listing/new" method="post" modelAttribute="newHunter">
        <div class="mb-3">
            <form:label path="address" class="form-label">Address</form:label>
            <form:input path="address"  class="form-control"/>
            <form:errors path="address" class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="price" class="form-label">Price</form:label>
            <form:input path="price"  class="form-control"/>
            <form:errors path="price" class="text-danger"/>
        </div>
        <div class="d-grid gap-2 col-6 mx-auto">
            <button class="btn btn-primary">Submit</button>
        </div>
    </form:form>
</div>
</body>
</html>