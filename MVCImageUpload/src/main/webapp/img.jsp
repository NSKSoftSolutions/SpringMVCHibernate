<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC - Hibernate File Upload to Database Demo</title>
</head>
<body>

	<form method="post" action="doUpload" enctype="multipart/form-data">

		First_name <input type="text" name="first_name" /> <br />Last_name <input
			type="text" name="last_name" /><br /> Email <input type="text"
			name="email" /><br /> Choose File to Upload <input type="file"
			name="fileUpload" size="50" /><br /> <input type="submit"
			value="Saved" />
	</form>
</body>
</html>