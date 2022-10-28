<%@ page import="static am.basic.springTest.util.constants.ParameterKeys.USERNAME_PARAM_KEY" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% if (request.getAttribute("message") != null) { %>
<%=request.getAttribute("message")%>
<% } %>
<br><br>


<form method="post" action="<%=request.getServletContext().getContextPath()%>/recover-password">
    <input type="hidden" name="username" value="<%=request.getAttribute(USERNAME_PARAM_KEY)%>">
    code: <input type="text" name="code"><br>
    new password : <input type="text" name="password"><br>
    <input type="submit" name="submit"><br>
</form>

</body>
</html>
