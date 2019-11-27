package controller;

import dao.ResumesDAOImpl;
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
import model.Resumes;
import model.Members;
import dao.ResumesDAO;

@WebServlet("/candidateCvServlet")
public class CvOfCandidatesServlet  extends HttpServlet {
      private ResumesDAO dao= new ResumesDAOImpl(); 
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action=request.getParameter("action");
        HttpSession session = request.getSession(true);        
        int mbrID=(Integer) session.getAttribute("s_memberID");
        String mbrRole= (String) session.getAttribute("s_role");
        
            try { 
                if (dao.isMemberCv(mbrID)=="T") { 
                    Resumes cv= dao.getCvById(mbrID);
                    request.setAttribute("CV", cv);
                    request.setAttribute("action", "editCV");
                    request.getRequestDispatcher("/CvOfCandidate.jsp").forward(request, response);
                } else if(dao.isMemberCv(mbrID)=="F") {
                    
                    if (mbrRole.equals("CANDIDATE")) {
                        request.setAttribute("action", "newCV"); 
                        request.getRequestDispatcher("/CvOfCandidate.jsp").forward(request, response);
                    } else if (mbrRole.equals("COMPANY")) {
                        request.setAttribute("action", "showCVs"); 
                        request.setAttribute("cvList", dao.getAllCVs()); 
                        request.getRequestDispatcher("/CvOfCandidate.jsp").forward(request, response);
                    }                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsersProfilsServlet.class.getName()).log(Level.SEVERE, null, ex);
            }             
           }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String action=request.getParameter("action");
        HttpSession session = request.getSession(true);
         try{            
            Resumes cv = new Resumes();           
            cv.setMainSkill(request.getParameter("mainSkill"));
            cv.setWorkExperience(request.getParameter("workEx"));
            cv.setEducation(request.getParameter("Education"));
            cv.setMemberId((Integer) session.getAttribute("s_memberID"));
            
            if(action.equals("ADDCV")){
                dao.addCv(cv);                
            } else if(action.equals("EDITCV")){
                dao.updateCv(cv);
            }
            
            if("Delete".equals(request.getParameter("save"))) {
                dao.deleteCv((Integer) session.getAttribute("s_memberID"));
                request.getRequestDispatcher("/AllLinks.jsp").forward(request, response);
            }
            
            request.getRequestDispatcher("/AllLinks.jsp").forward(request, response);
         } catch (SQLException ex) {
            Logger.getLogger(UsersProfilsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
