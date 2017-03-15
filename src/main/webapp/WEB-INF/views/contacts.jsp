<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="post" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Admin Page ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </c:if>

    <c:if test="${!empty listContacts}">
        <table class="tg">
            <tr>
                <th width="30">ID</th>
                <th width="100">Owner</th>
                <th width="100">Last Name</th>
                <th width="100">Middle Name</th>
                <th width="100">First Name</th>
                <th width="100">Mobile No</th>
                <th width="100">Home No</th>
                <th width="100">Address</th>
                <th width="100">Email</th>
            </tr>
            <c:forEach items="${listContacts}" var="contact">
                <tr>
                    <td>${contact.id}</td>
                    <td>${contact.owner}</td>
                    <td>${contact.last_name}</td>
                    <td>${contact.middle_name}</td>
                    <td>${contact.first_name}</td>
                    <td>${contact.number_mob}</td>
                    <td>${contact.number_home}</td>
                    <td>${contact.address}</td>
                    <td>${contact.email}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>