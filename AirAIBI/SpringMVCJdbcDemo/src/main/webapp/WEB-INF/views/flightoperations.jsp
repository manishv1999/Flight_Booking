<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flight Operations</title>
        <link rel="stylesheet" href="resources/style.css" >
    </head>
    <body>
        <h1>AIRAIBI Flight Details</h1>
        <br>
        <form:form method="POST" action="createflight"
          modelAttribute="Flight">
            <form:label path="flightCode">Flight Code</form:label>
            <form:input path="flightCode" />
            <br><br>
            <form:label path="flightNumber">Flight Number</form:label>
            <form:input path="flightNumber" />
<br><br>
            <form:label path="arrivalAirport">Arrival Airport</form:label>
            <form:input path="arrivalAirport" />
<br><br>
            <form:label path="departureAirport">Departure Airport</form:label>
            <form:input path="departureAirport" />
<br><br>
            <input type="submit" value="Submit" />
        </form:form>
<br><br><br>
        <table>
            <tr>
                <th>Row No</th>
                <th>Flight Code</th>
                <th>Flight Number</th>
                <th>Departure Airport</th>
                <th>Arrival Airport</th>
            </tr>
             <c:forEach items="${flightList}" var="flight">
                <tr>
                    <td><c:out value="${flight.rowId}"/></td>
                    <td><c:out value="${flight.flightCode}"/></td>
                    <td><c:out value="${flight.flightNumber}"/></td>
                    <td><c:out value="${flight.departureAirport}"/></td>
                    <td><c:out value="${flight.arrivalAirport}"/></td>
                </tr>
             </c:forEach>
        </table>
    </body>
</html>
