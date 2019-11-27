<%@page import="model.Jobs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">
        <title>Jobs</title>

    </head>
    <body>
        <h1>The Job</h1>
        <%  
        Jobs job=(Jobs)request.getAttribute("theJobView");
        %>
        
        Title: <div><%=job.getTitle()%></div><br>
        Description: <div><%=job.getDescrip()%></div><br> 
        Salary/hr: <div> <%=job.getSalary()%></div><br> 
        Type: <div> <%=job.getType()%></div><br>
        Required skills: <div> <%=job.getRequestedSkill()%></div><br> 
        Company Name: <div> <%=job.getCompanyName()%></div><br> 
        Company Description: <div> <%=job.getCoDescription()%></div><br> 
        City: <div> <%=job.getCity()%></div><br>
        Creation Date: <div> <%=job.getCreationDate()%></div><br>
        End Date: <div> <%=job.getEndDate()%></div><br>
       <%   %>
    </body>
</html>
