
<%@page import="java.util.List"%>
<%@page import="model.Resumes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">
        <title>Cv Of Candidates</title>
    </head>
    <body>
        <h1>Resumes</h1>
        <form action="CvOfCandidatesServlet" method="post">
            
        <%   if("CANDIDATE".equals(session.getAttribute("s_role")) ){           
            if(request.getAttribute("action")== "newCV"){  %>    
        Main Skills<textarea name="mainSkill" rows="3" cols="100"></textarea> <br>
        Work Experience<textarea name="workEx" rows="10" cols="100"></textarea> <br>
        Education<textarea name="Education" rows="5" cols="100"></textarea> <br>
        <input type="hidden"  name="action" value="ADDCV">
        
          <% } else if(request.getAttribute("action")== "editCV") { 
                Resumes cv=(Resumes)request.getAttribute("CV");
          %> 
        Main Skills<textarea name="mainSkill" rows="5" cols="60"><%=cv.getMainSkill()%></textarea> <br>
        Work Experience<textarea name="workEx" rows="20" cols="60"><%=cv.getWorkExperience()%></textarea> <br>
        Education<textarea name="Education" rows="10" cols="60"><%=cv.getEducation()%></textarea> <br>
        <input type="hidden"  name="action" value="EDITCV">
         <% } %>
         <input type="submit" name="save" value="Save">
         <input type="submit" name="save" value="Delete">
         </form> 
        <% } else if("COMPANY".equals(session.getAttribute("s_role"))) {   %>          
         <table border="1">
            <tr>
                <th>MAIN SKILL</th>
                <th>WORK EXPERIENCE</th>
                <th>EDUCATION</th>
            </tr>
            
            <%
                List<Resumes> cvList = (List<Resumes>)request.getAttribute("cvList");                
                for(Resumes cv : cvList){                  
            %>
                <tr>
                     <td>
                        <%= cv.getMainSkill()%>
                    </td>
                    <td>
                        <%= cv.getWorkExperience()%>
                    </td>
                    <td>
                        <%= cv.getEducation() %>
                    </td>      
                </tr>
            <% } %>            
        </table>         
         <% } %>  
         <div><a href="LogoutServlet">Logout</a></div>
         
    </body>      
</html>
