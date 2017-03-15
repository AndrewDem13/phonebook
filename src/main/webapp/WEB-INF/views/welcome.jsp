<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </c:if>
    <br/>

    <form:form method="POST" modelAttribute="contactForm" action="/welcome/add">
        <h2 class="form-signin-heading">Create new contact</h2>
        <spring:bind path="owner">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="owner" class="form-control" placeholder="Name of owner"
                            autofocus="true"></form:input>
                <form:errors path="owner"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="last_name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="last_name" class="form-control" placeholder="Last Name"></form:input>
                <form:errors path="last_name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="first_name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="first_name" class="form-control" placeholder="First Name"></form:input>
                <form:errors path="first_name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="middle_name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="middle_name" class="form-control"
                            placeholder="Middle Name"></form:input>
                <form:errors path="middle_name"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="number_mob">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="number_mob" class="form-control"
                            placeholder="Mobile Number"></form:input>
                <form:errors path="number_mob"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

    <br/>

    <form:form action="/contacts">
        <h2>Show contacts of User:</h2>
        <input type="text" name="owner" id="owner"
               placeholder="username">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
    </form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>