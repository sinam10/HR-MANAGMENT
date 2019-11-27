
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Profile Resumes</h1>
        <div><a href="UsersprofilsServlet?action=GETUSERPROFILE">User Profile</a></div> <br>
        <div><a href="CvOfCandidatesServlet">User CV</a></div> <br>
        <% if("COMPANY".equals(session.getAttribute("s_role"))) {  %>
        <div><a href="JobListsServlet?act=CREATEJOBOFFER">Job Offer</a></div> <br>
        <%  } %>
        <div><a href="LogoutServlet">Logout</a></div>
        

    </body>

</html>
