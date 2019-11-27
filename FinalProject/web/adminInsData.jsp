
<%--
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Teacher Information </title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
         <link rel="stylesheet" href="http:pure/pure-min.css">

         
    </head>
    <body>
        <script type="text/javascript">
            function editIRecord(id){
                url="EditIRecord";
                window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
                
            }
            function editIDelete(id){
                url="DeleteIRecord";
              window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
            }
            </script>
             <div class="top">
                 
            <h1>Teacher Details</h1>
        </div>
        <div style="float: right">
        <%= new java.util.Date()%>
        
        </div>
        
        <div class="pure-menu pure-menu-open pure-menu-horizontal">
         
        <ul>
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="login.jsp">Logout</a></li>
        </ul>
    </div>
             <hr>
        <h1>
            Table Represent Teacher Details
        </h1>
<hr>
        <table class="pure-table pure-table-horizontal">
            <thead>
            <td>ID</td>
            <td>FIRST_NAME</td>
            <td>LAST_NAME</td>
            <td>DOB</td>
            <td>SEX</td>
            <td>ADDRESS</td>
            <td>EMAIL</td>
            <td>Phone</td>
            <td>Department Id</td>
            <td>Edit</td>
            <td>delete</td>
        </thead>
            
        <% Iterator ins;%>
        <%List insData = (List) request.getAttribute("insdata");
        for(ins = insData.iterator(); ins.hasNext();){
        %>
        <tr>
        
            <% String s=(String) ins.next();%>
         
            <td><%=s%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><input type ="submit" value="Edit" name="edit" onclick="editIRecord(<%=s%>);" class="pure-button pure-button-primary"></td>
            <td><input type ="submit" value="Delete" name="delete" onclick="editIDelete(<%=s%>);" class="pure-button pure-button-primary"></td>
            <%}%>
       
        </tr>
    </table>
    </body>
</html>
