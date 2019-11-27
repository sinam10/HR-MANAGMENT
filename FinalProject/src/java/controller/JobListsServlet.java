package controller;

import dao.JobsDAO;
import dao.JobsDAOImpl;
import dao.MembersDAO;
import dao.MembersDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Members;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Jobs;

@WebServlet("/jobOfferServlet")
public class JobListsServlet  extends HttpServlet{   
       private JobsDAO dao= new JobsDAOImpl(); 
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String act=request.getParameter("act");
        HttpSession session = request.getSession(true);
        int mbrID=0;
        
         try {             
             if(act.equals("VIEWJOBLIST")){
                List<Jobs> jobList= dao.getAllJobs();
                System.out.println("servlet**************************"+ jobList.size());
                request.setAttribute("theJobList", jobList);
                request.getRequestDispatcher("/listAllJobs.jsp").forward(request, response);
             }else if(act.equals("GETJOBBYID")){ 
                Jobs job= dao.getJobById(Integer.parseInt(request.getParameter("mbrJobId")));
                request.setAttribute("theJobView", job);
                request.getRequestDispatcher("/ListOfJobs.jsp").forward(request, response);
             }else{
             mbrID=(Integer) session.getAttribute("s_memberID");
        if (dao.isEmployerJobOffer(mbrID)=="T") { 
            Jobs job= dao.getJobById(mbrID);
            request.setAttribute("theJob", job);
            request.setAttribute("action", "editJobOffer");
            request.getRequestDispatcher("/MakeJobOffer.jsp").forward(request, response);
        } else if(dao.isEmployerJobOffer(mbrID)=="F") {
                request.setAttribute("action", "newJobOffer");
                request.getRequestDispatcher("/MakeJobOffer.jsp").forward(request, response);
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
            Jobs job = new Jobs();           
            job.setTitle(request.getParameter("title"));
            job.setDescrip(request.getParameter("desc"));
            job.setSalary(Integer.parseInt(request.getParameter("sal")));
            job.setType(request.getParameter("type"));
            job.setRequestedSkill(request.getParameter("req"));
            job.setCompanyName(request.getParameter("compname"));
            job.setCoDescription(request.getParameter("compdesc"));
            job.setCity(request.getParameter("city"));         
            job.setMemberId((Integer) session.getAttribute("s_memberID"));
            
            if(action.equals("ADDJOBOFFER")){
                dao.addJob(job);              
            } else if(action.equals("EDITJOBOFFER")){
                dao.updateJob(job);
            }
            
            if("Delete".equals(request.getParameter("save"))) {
                dao.deleteJob((Integer) session.getAttribute("s_memberID"));
            }            
            request.getRequestDispatcher("/AllLinks.jsp").forward(request, response);            
        } catch (SQLException ex) {
            Logger.getLogger(UsersProfilsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}  
    
  