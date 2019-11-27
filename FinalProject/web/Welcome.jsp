

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">        
        <title>successfully register Page</title>
              

    </head>
    <body>
        <%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
        %>
          Please Try Again You are not logged in<br/>
        <a href="index.jsp">Please Login</a>
        <%} else {
           %>
       Welcome <%=session.getAttribute("userid")%>
        <a href='logout.jsp'>Log out</a>
             <%
          }
         %>
    </body>
    <div><a href="LogoutServlet">Logout</a></div>
</html>
