<%--
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import=" static Myproject.methods.methods.student"%>
<%@page import="java.util.ArrayList"%>
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
            function editSRecord(id){
                url="EditSRecord";
                window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
                
            }
            function editSDelete(id){
                url="DeleteSRecord";
                window.location.href="http://localhost:90/Myproject/"+url+"?id="+id;
           
    }
        </script>
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
        <hr>
        <h1>
            Table Represent Student Records
        </h1><hr>
        <table class="pure-table pure-table-horizontal" style="font-size: 13px">
            <thead align="center">
            <td>ID</td>
            <td>FIRST NAME</td>
            <td>LAST NAME</td>
            <td>DOB</td>
            <td>SEX</td>
            <td>ADDRESS</td>
            <td>EMAIL</td>
            <td>Phone</td>
            <td>Teacher ID</td>
            <td>Department ID</td>
           
            <td>Edit</td>
            <td>delete</td>
        </thead>
        <% Iterator stu;%>
        <%List studentData = (List) request.getAttribute("data");
        for(stu = studentData.iterator(); stu.hasNext();){
        %>
        <tr>
        
            <% String s=(String) stu.next();%>

            
            <td><%=s%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            <td><%=stu.next()%></td>
            
            <td><input type ="submit" value="Edit" name="edit" onclick="editSRecord(<%=s%>);" class="pure-button pure-button-primary"></td>
            <td><input type ="submit" value="Delete" name="delete" onclick="editSDelete(<%=s%>);" class="pure-button pure-button-primary"></td>
            <%}%>
        </tr>    
    </table>
        <br>
        <br>
        

    </body>
</html>
