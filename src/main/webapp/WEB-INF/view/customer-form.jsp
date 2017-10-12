<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Customer</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
        <link type="text/css" rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>Customer Relationship Manager</h2>
            </div>
            <div id="container">
                <h3>Save Customer</h3>
                <form:form action="saveCustomer" modelAttribute="customer" method="POST">
                    <table>
                        <tbody>
                            <tr>
                                <td><label>First Name:</label></td>
                                <td><form:input path="firstName"></form:input></td>
                            </tr>
                            <tr>
                                <td><label>Last Name:</label></td>
                                <td><form:input path="lastName"></form:input></td>
                            </tr>
                            <tr>
                                <td><label>Email:</label></td>
                                <td><form:input path="email"></form:input></td>
                            </tr>
                            <tr>
                                <td><label></label></td>
                            </tr>
                            <td>
                                <input class="save" type="submit" value="Save"/>
                            </td>
                        </tbody>
                    </table>
                </form:form>

                <div style="clear; both;"></div>
                <p><a href="${pageContext.request.contextPath}/customer/list">Back to List</a></p>
            </div>
    </body>
</html>
