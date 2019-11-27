<%--

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">

    </head>
    <body>
         <div class="top">
                 
            <h1>Student Details</h1>
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
       <script type="text/javascript">
            function editDRecord(id){
                url="EditDRecord";
                window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
             }
            function editDDelete(id){
                url="DeleteDRecord";
              window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
            }
            </script>
            
             <hr>
        <h1>
            Table Represent Department Details
        </h1>
        <hr>
                 
        <table id='instable' class="pure-table pure-table-horizontal">
            <thead>
            <td>Department Id</td>
            <td>Department Name</td>
            <td>Edit</td>
            <td>delete</td>
        </thead>
            
        <% Iterator ins;%>
        <%List insData = (List) request.getAttribute("depdata");
        for(ins = insData.iterator(); ins.hasNext();){
        %>
        <tr>
        
            <% String s=(String) ins.next();%>
            <td><%=s%></td>
            <td><%=ins.next()%></td>
            <td><input type ="submit" value="Edit" name="edit" onclick="editDRecord(<%=s%>);" class="pure-button pure-button-primary"></td>
            <td><input type ="submit" value="Delete" name="delete" onclick="editDDelete(<%=s%>);" class="pure-button pure-button-primary"></td>
            <%}%>
         </tr>
    </table>
            
    </body>
</html>
