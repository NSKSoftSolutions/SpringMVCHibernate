<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Brand Added Successfully....To NSKCart 

<table border="2px solid blue" cellpadding="5px" cellspacing="2px" bordercolor="green">

     <tr>
        <th>BrandNname</th>
        <th>CategoryName</th>
        <th>price</th>
        <th>itemName</th>
     
     </tr>
     <tr>
       <td>${brand.brand_name}</td> 
       <td>${cat.cat_name}</td> 
       <td>${item.price}</td> 
       <td>${item.item_name}</td>
      </tr>




</table>


</body>
</html>