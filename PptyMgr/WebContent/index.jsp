<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>	
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>index -</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>
<body onload="">
<script type="text/javascript">
function submitForm(){
	alert("submitting the form");
document.forms[0].action='test.sd';
document.forms[0].submit();
}
</script>
<form action="" method="POST">
	<script type="text/javascript">
	submitForm();
	</script>
</form>
</body>
</html>
