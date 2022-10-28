<%@ page import="static am.basic.springTest.util.constants.ParameterKeys.MESSAGE_ATTRIBUTE_KEY" %>
<%@ page import="am.basic.springTest.model.Card" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="<%=request.getServletContext().getContextPath()%>/logout" style="float: right">Logout</a>
<a href="<%=request.getServletContext().getContextPath()%>/secure/home">Home</a>

<br><br>
<% if (request.getAttribute(MESSAGE_ATTRIBUTE_KEY) != null) { %>
<%=request.getAttribute(MESSAGE_ATTRIBUTE_KEY)%>
<% } %>
<br><br>



<br>
<form method="post" action="<%=request.getServletContext().getContextPath()%>/secure/cards/add">
    Name : <input type="text" name="name">
    Number : <input type="text" name="number">
    Cvv : <input type="text" name="cvv">
    <input type="submit" value="add">
</form>
<br>
<br>


<%
    List<Card> cards = (List<Card>) request.getAttribute("card");
%>

<table border="solid 1px">


    <%
        for (Card card : cards) {
    %>
    <tr>

        <td>
            <form method="post" action="<%=request.getServletContext().getContextPath()%>/secure/cards/edit">
                <input type="hidden" name="id" value="<%=card.getId()%>">
                <input type="text" name="name" value="<%=card.getName()%>">
                <input type="text" name="number" value="<%=card.getNumber()%>">
                <input type="text" name="cvv" value="<%=card.getCvv()%>">
                <input type="submit" name="submit" value="DELETE">
                <input type="submit" name="submit" value="UPDATE">
            </form>
        </td>
            <%
        }
    %>

</table>



</body>
</html>
