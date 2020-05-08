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
        <title>List of Trainers</title>
    </head>
    <body>
        <h1>Trainer List</h1>
        <table>
		<tr>
                    <td>ID</td><td>First Name</td><td>Last Name</td><td>Subject</td><td></td>
		</tr>
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
        <div id="msg">${msg}</div>
        <div><a href="<c:url value='/${newurl}' />">Click here to register a new trainer</a></div>
    </body>
</html>
