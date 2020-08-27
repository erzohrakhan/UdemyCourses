<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>
	The customer is confirmed:${customer.firstName} ${customer.lastName}
	<br>
	<br> Number of passes: ${customer.freePasses}
	<br>
	<br> Postal code: ${customer.pinCode}
</body>
</html>