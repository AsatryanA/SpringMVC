<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Hello world</h1><br/><br/>

<% if (request.getAttribute("message") != null) {  %>
<%=request.getAttribute("message")%>
<% } %>
<br><br>

<form method="post" action="<%=request.getServletContext().getContextPath()%>/login">
    username : <input type="text" name="username"><br/>
    password : <input type="text" name="password"><br>
    remember : <input type="checkbox" name="remember"><br>
    <input type="submit" name="submit"><br>
</form>
<a href="<%=request.getServletContext().getContextPath()%>go-forget-password">forget password</a>
<a href="<%=request.getServletContext().getContextPath()%>go-register">register</a>


<br>
<br>
</body>
</html>
