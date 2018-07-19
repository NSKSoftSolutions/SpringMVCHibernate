<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
h4 {
	color: white;
	background: black;
	padding: 20px;
	widows: 20px;
	text-align: left;
}


</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>Shoppers Cart </h4>
	<h5>${list[0].firstname}</h5>
    <form action="uploaddata" enctype="multipart/form-data" method="post">
    
    <input type="file" name="filedata">
    <input type="submit" value="Upload"/>
    </form>


</body>
</html>