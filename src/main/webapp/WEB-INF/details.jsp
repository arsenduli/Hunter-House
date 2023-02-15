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
    <title>View Listing</title>
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
        <h1>Details for ${hunter.address}</h1>
        <a href="/home">dashboard</a>
    </div>
    <div>
        <p>Address: ${hunter.address} </p>
        <p>Listing Date:<fmt:formatDate value="${hunter.listedOn}" pattern="dd/MM/yy"/></p>

        <p>Price:$ ${hunter.price} </p>

    </div>
    <c:if test="${user.id == hunter.added.id}">
        <a href="/listing/${hunter.id}/edit" class="btn btn-warning">Edit</a>
        <a href="/listing/delete/${hunter.id}">Delete</a>
    </c:if>

<h3>Notes:</h3>
<iframe src="/notes/${hunter.id}" title="Notes Iframe"></iframe>
<div>
    <%--@elvariable id="notes" type="com"--%>
    <form:form action="/listing/notes/${hunter.id}" method="post" modelAttribute="notes">
        <div>
            <form:label path="addNotes">Notes</form:label>
            <form:input path="addNotes"/>
            <form:errors path="addNotes"/>
        </div>
        <button>Add Notes</button>
    </form:form>
</div>
</div>
</body>
</html>