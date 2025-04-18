<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Calculator</a>
<form>

  <input type="number" name="txtNum1" placeholder="num1">
  <input type="number" name="txtNum2" placeholder="num2">
  <input type="number" name="txtOperator" placeholder="result">
  <button>Calculator</button>
</form>
</body>
</html>