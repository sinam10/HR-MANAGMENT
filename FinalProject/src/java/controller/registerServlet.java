
package controller;

import dao.MembersDAO;
import dao.MembersDAOImpl;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Members;

@WebServlet("/registerServlet")
public class registerServlet  extends HttpServlet{
    
    private MembersDAO dao= new MembersDAOImpl();
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
         try{
             
             
             
             
             
    Members members = new Members();
    members.setFirstName(request.getParameter("fname"));
    members.setLastName(request.getParameter("lname"));
    members.setEmail(request.getParameter("email"));
    members.setUserName(request.getParameter("uname"));
    members.setPass(request.getParameter("pass"));
    
    dao.insertMember(members);
    request.getRequestDispatcher("/Welcome.jsp").forward(request, response);

    }catch(Exception e){
        out.print("<p >Notice:change your username, please. </p>" + e.getMessage());
    }finally{
    }
       
    }
    
    
    
    
    
    
   
}
