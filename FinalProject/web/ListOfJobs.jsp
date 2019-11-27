

<%@page import="model.Jobs"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">        
        <title>List Of Jobs</title>

    </head>
    <body>
        <h1>List All Jobs</h1>
        
        <table border="1">                
                    <tr>
                        <th>Title</th>

                        <th>Type</th>
                        <th>Company Name</th>
                        <th>City</th>
                        <th>Creation Date</th>
                    </tr>                             
                
                <%
                List<Jobs> jobList = (List<Jobs>)request.getAttribute("theJobList");                
                for(Jobs j : jobList){                  
                %>
                    <tr>
                        <td><%= j.getTitle()%></td>
                        <td><%= j.getType()%></td>
                        <td><%= j.getCompanyName()%></td>
                        <td><%= j.getCity()%></td>
                        <td><%= j.getCreationDate()%></td>
                        <td><a href="JobListsServlet?act=GETJOBBYID&mbrJobId=<%=j.getMemberId()%>" >View</a></td>
                    </tr>
                    <% } %>                  
        </table><br>
        <div><a href="LogoutServlet">Logout</a></div>
    </body>
</html>
