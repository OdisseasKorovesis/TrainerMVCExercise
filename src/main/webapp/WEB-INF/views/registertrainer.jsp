<%-- 
    Document   : registertrainer
    Created on : May 8, 2020, 11:12:48 PM
    Author     : Odisseas KD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Trainer Registration</title>
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center">Register a New Trainer</h1>
            <form:form method="POST" modelAttribute="trainer">
                <div class="form-group mt-2 p-3 border rounded">
                    <form:input type="hidden" path="id" id="id" class="form-control"/>
                    First Name: <form:input path="firstName" class="form-control" placeholder="Enter trainer first name" maxlength="45" required="true"/>
                    <form:errors path="firstName" cssClass="error"/>
                    <br/>
                    Last Name: <form:input path="lastName" class="form-control" placeholder="Enter trainer last name" maxlength="45" required="true"/>
                    <form:errors path="lastName" cssClass="error"/>
                    <br/>
                    Subject : <form:input path="subject" class="form-control" placeholder="Enter trainer subject" maxlength="45" required="true"/>
                    <form:errors path="subject" cssClass="error"/>
                    <br/>            
                    <input type="submit" value="Click to Register" class="btn btn-warning">
                </form:form>
                <div id="msg">${message}</div>                
            </div>
            <div id="list" class="row justify-content-center"><a href="<c:url value='/${listurl}' />" class="btn btn-primary col-4">
                    Click to go back to the list of Trainers</a>
            </div>
        </div>
    </body>
</html>

