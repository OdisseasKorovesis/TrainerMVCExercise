<%-- 
    Document   : alltrainers
    Created on : May 8, 2020, 10:58:10 PM
    Author     : Odisseas KD
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>List of Trainers</title>
    </head>
    <body>
        <div class="container mt-5">
        <h1 class="text-center">Trainer List</h1>
        <div id="msg" class="text-center bg-primary mt-3">
            ${msg}
        </div>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID (Click to Edit)</th><th>First Name</th><th>Last Name</th><th>Subject</th><th>Click to Delete</th>
                </tr>
            </thead>	
            <c:forEach items="${trainers}" var="trainer">
                <tr>

                    <td><a href="<c:url value='${editurl}/${trainer.id}' />">${trainer.id}</a></td>
                    <td>${trainer.firstName}</td>
                    <td>${trainer.lastName}</td>
                    <td>${trainer.subject}</td>                            
                    <td><a href="<c:url value='${deleteurl}/${trainer.id}' />">delete</a></td>
                </tr>
            </c:forEach>
        </table>        
        <div class="row justify-content-center">
            <a href="<c:url value='/${newurl}'/>" class="btn btn-primary col-4">Click here to register a new trainer</a></div>  
        </div>
    </body>
</html>
