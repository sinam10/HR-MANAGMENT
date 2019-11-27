package controller;

import dao.DAOLogin;
import dao.DAOLoginImpl;
import dao.MembersDAO;
import dao.MembersDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Members;

@WebServlet("/userProfileServlet")
public class UsersProfilsServlet extends HttpServlet{ 
       private MembersDAO dao= new MembersDAOImpl(); 
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action=request.getParameter("action");
        HttpSession session = request.getSession(true);
        
        if(action.equals("GETUSERPROFILE")){
        Members member;
            try {  
                System.out.println("session.getAttribute(\"s_memberID\"):**************************" + session.getAttribute("s_memberID"));
                
                member = dao.getMemberById((Integer) session.getAttribute("s_memberID"));
                request.setAttribute("the_member", member);                
                request.getRequestDispatcher("/UserSProfils.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(UsersProfilsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }             
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession(true);
         try{            
            Members mbr = new Members();           
            mbr.setFirstName(request.getParameter("fname"));
            mbr.setLastName(request.getParameter("lname"));
            mbr.setEmail(request.getParameter("email"));
            mbr.setUserName(request.getParameter("uname"));
            mbr.setPass(request.getParameter("pass"));
            
            mbr.setMemberId((Integer) session.getAttribute("s_memberID"));
            dao.updateMember(mbr);
            request.getRequestDispatcher("/AllLinks.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(UsersProfilsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}  
    
    

