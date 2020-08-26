<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student registration form</title>
</head>
<body>
	<form:form action="processform" modelAttribute="student">
First name: <form:input path="firstName" />
		<br>
		<br>
Last name : <form:input path="lastName" />
		<br>
		<br>
		
Country:

<form:select path="country">
			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="India" label="India" />
			<form:option value="Venezuala" label="Venezuala" />

		</form:select>
		<br>
		<br>
		Favourite Language:
		Java<form:radiobutton path="favouritelanguage" value="java" />
		C#<form:radiobutton path="favouritelanguage" value="c#" />
		Python<form:radiobutton path="favouritelanguage" value="python" />"
		Ruby<form:radiobutton path="favouritelanguage" value="ruby" />
		<br><br>
		Operating Systems:
		Linux<form:checkbox path="operatingsystem" value="linux" />
		Windows<form:checkbox path="operatingsystem" value="windows"/>
		Ubuntu<form:checkbox path="operatingsystem" value="ubuntu"/>
		Mac<form:checkbox path="operatingsystem" value="mac"/>
		<input type="submit" />
	</form:form>
</body>
</html>