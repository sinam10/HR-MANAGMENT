

<%@page import="model.Jobs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">        
        <title>Make Job Offer</title>

    </head>
    <body>
        <h1>Make Job Offer</h1>
        <form action="JobListsServlet" method="post">
            
            <%  if("newJobOffer".equals(request.getAttribute("action"))){  %>
            Title<input type="text" name="title" ><br>
            Description<input type="text" name="desc" ><br> 
            Salary /hr<input type="number" name="sal" ><br> 
            Type<select name="type" >
                    <option value="Permanent">Permanent</option>
                    <option value="Contract">Contract</option>
                    <option value="Internship">Internship</option>
                    <option value="Freelance">Freelance</option>
                </select><br>
            Required skills<input type="text" name="req" ><br> 
            Company Name<input type="text" name="compname" ><br> 
            Company Description<input type="text" name="compdesc" ><br> 
            City<input type="text" name="city" ><br>
            <input type="hidden"  name="action" value="ADDJOBOFFER">
            <%  } else if("editJobOffer".equals(request.getAttribute("action"))){ 
                Jobs job=(Jobs)request.getAttribute("theJob");
            %>
            
            Title<input type="text" name="title" value="<%=job.getTitle()%>"  ><br>
            Description<input type="text" name="desc" value="<%=job.getDescrip()%>" ><br> 
            Salary /hr<input type="number" name="sal" value="<%=job.getSalary()%>"  ><br> 
            Type<select name="type"  value="<%=job.getType()%>" >
                    <option value="Permanent">Permanent</option>
                    <option value="Contract">Contract</option>
                    <option value="Internship">Internship</option>
                    <option value="Freelance">Freelance</option>
                </select><br>
            Required skills<input type="text" name="req"  value="<%=job.getRequestedSkill()%>" ><br> 
            Company Name<input type="text" name="compname"  value="<%=job.getCompanyName()%>" ><br> 
            Company Description<input type="text" name="compdesc"  value="<%=job.getCoDescription()%>" ><br> 
            City<input type="text" name="city"  value="<%=job.getCity()%>" ><br> 
             <input type="hidden"  name="action" value="EDITJOBOFFER">
            
            <% } %>
            <input type="submit" name="save" value="confirm">
            <input type="submit" name="save" value="Delete">
        </form> 
            <div><a href="LogoutServlet">Logout</a></div>
    </body>
</html>
