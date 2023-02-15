<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>House Hunter Dashboard</title>
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
        <h1>Wellcome ${user.userName}!</h1>
        <a href="/logout">Logout</a>
    </div>
    <div class="d-grid gap-2 col-6 mx-auto">
        <a href="/listing/new" class="btn btn-secondary">Add Listing</a>
    </div>
<div>
    <table class="table table-striped-columns">
        <thead>
        <tr>
            <th>Address</th>
            <th>Listed On</th>
            <th>Added By</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="haouse" items="${hunter}">
            <tr>
                <td><a href="/listing/${haouse.id}">${haouse.address}</a></td>
                <td><fmt:formatDate value="${haouse.listedOn}" pattern="dd/MM/yy"/></td>
                <td>${haouse.added.userName}</td>
                <td>$ ${haouse.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>