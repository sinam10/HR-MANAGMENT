<%@page import="model.Members"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">        
        <title>User Profile</title> 

    </head>
    <body>
        <h1>Profile</h1>
        <form action="UsersProfilsServlet" method="post">
        <%
            Members member=(Members)request.getAttribute("the_member");
        %>    
            
        First Name<input type="text" name="fname" value="<%=member.getFirstName()%>" /><br>
        Last Name<input type="text" name="lname" value="<%=member.getLastName()%>" /><br>
        Email<input type="text" name="email" value="<%=member.getEmail()%>" /><br>
        User Name<input type="text" name="uname" value="<%=member.getUserName()%>" /><br>
        Password<input type="password" name="pass" value="<%=member.getPass()%>" /><br>
                 <input type="submit" value="Save" />
        </form> 
            <div><a href="LogoutServlet">Logout</a></div>
    </body>
</html>
