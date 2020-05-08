<%-- 
    Document   : editTrainer
    Created on : May 8, 2020, 11:40:29 PM
    Author     : Odisseas KD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer Edit</title>
    </head>
    <body>
        <h1>Edit a Trainer</h1>
        <form:form method="POST" modelAttribute="trainer">
            <form:input type="hidden" path="id" id="id"/>
            First Name: <form:input path="firstName" />
            <br/>
            Last Name: <form:input path="lastName" />
            <br/>
            Subject : <form:input path="subject" />
            <br/>            
            <input type="submit" value="Click to Update Trainer">
        </form:form>
        <div id="msg">${message}</div>
        <div id="list"><a href="<c:url value='/${listurl}' />">Click to go back to the list of Trainers</a></div>
    </body>
</html>
