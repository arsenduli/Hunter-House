<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Listing</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <!-- For any Bootstrap that uses JS-->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Edit Listing</h1>
<a href="/home">dashboard</a>
<div class="container">
    <%--@elvariable id="newHunter" type="com"--%>
    <form:form action="/listing/${newHunter.id}/edit" method="put" modelAttribute="newHunter">
        <div class="mb-3">
            <form:label path="address" class="form-label">Address</form:label>
            <form:input path="address" class="form-control" />
            <form:errors path="address"  class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="price" class="form-label">Price</form:label>
            <form:input path="price" class="form-control"/>
            <form:errors path="price"  class="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="listedOn" class="form-label">Listed On</form:label>
            <form:input path="listedOn"  class="form-control" type="date" pattern="yyyy-MM-dd" value="${newHunter.listedOn}"/>
            <form:errors path="listedOn" class="text-danger"/>
        </div>
        <button class="btn btn-primary">Submit</button>
    </form:form>

</div>
</body>
</html>
