package controller;

import dao.DAOLogin;
import dao.DAOLoginImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class loginServlet  extends HttpServlet{ 
      private DAOLogin dao= new DAOLoginImpl();
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        PrintWriter out = response.getWriter();        
        HttpSession session = request.getSession(true);        
        
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        int memberId=0;
        
          try {
              memberId=dao.getMemberId(username, password);
              if(dao.userPass(username, password).equals("T")){                  
                  request.setAttribute("memberID", memberId); 
                  session.setAttribute("s_memberID", memberId);
                  session.setAttribute("s_role", dao.getMemberRole(memberId));
                  
                request.getRequestDispatcher("/AllLinks.jsp").forward(request, response);
              } else {
                  out.println("Wrong user/password");
                  request.getRequestDispatcher("/error.html").forward(request, response);
              } } catch (SQLException ex) {       
              Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("in doGet*********************************");
    }
}

    
    
    

