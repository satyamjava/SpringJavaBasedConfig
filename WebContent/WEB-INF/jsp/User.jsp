<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Users</title>
<script src="/SpringExportPdfWithAjax/js/jquery.js"></script>

</head>
<body>
<h1>Users........</h1>
<form:form method="POST" commandName="user" action="ShowUsers.htm">
	<table>
		<tr><td>Enter your name : </td><td> <form:input path="name" /><br/></td></tr>
		<tr><td>Age : </td><td> <form:input path="age" /><br/></td></tr>
		<tr><td colspan="2"><input type="submit" value="show user"></div></td></tr>
	</table>
</form:form>
</body>
</html>