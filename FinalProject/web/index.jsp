<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">
        <title>index</title>
    </head>
    
    <body>
        <form method="post" action="loginServlet">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Sign In </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Please Register and Comeback Again ): !! <a href="reg.jsp">Sign Up</a></td>
                    </tr>
                </tbody>
            </table>
                
                
                <div><a href="JobListsServlet?act=VIEWJOBLIST">Candidate Resumes</a></div> <br>
                
            </center>
        </form>
        
    </body>
</html>