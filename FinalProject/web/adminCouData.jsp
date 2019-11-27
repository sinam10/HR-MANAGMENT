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
        
            
        <script type="text/javascript">
            function editCRecord(id){
                url="EditCRecord";
                window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
                
            }
            function editCDelete(id){
                url="DeleteCRecord";
              window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
            }
            </script>
             <div class="top">
                 
            <h1>Course Details</h1>
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
            Table Represent Course Details
        </h1>
<hr>
        <table id='instable' class="pure-table pure-table-horizontal">
            <thead>
            <td>Course Id</td>
            <td>Course TITLE</td>
            <td>Course DESC</td>
            <td>Course CREDIT</td>
            <td>Edit</td>
            <td>delete</td>
        </thead>
            
        <% Iterator ins;%>
        <%List insData = (List) request.getAttribute("coudata");
        for(ins = insData.iterator(); ins.hasNext();){
        %>
        <tr>
        
            <% String s=(String) ins.next();%>

            
            <td><%=s%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            
            <td><input type ="submit" class="pure-button pure-button-primary" value="Edit" name="edit" onclick="editCRecord(<%=s%>);"></td>
            <td><input type ="submit" value="Delete" name="delete" class="pure-button pure-button-primary" onclick="editCDelete(<%=s%>);"></td>
            <%}%>
       
        </tr>
    </table>
    </body>
</html>
