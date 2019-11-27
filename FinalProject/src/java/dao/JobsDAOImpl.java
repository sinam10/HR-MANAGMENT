
package dao;


import model.Jobs;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;
import java.sql.Statement;
import java.sql.ResultSet;
import model.Resumes;

/**
 *
 * @author Mehdi Miri
 */
public class JobsDAOImpl implements JobsDAO{
    
    @Override
    public List<Jobs> getAllJobs() throws SQLException {
         Connection conn = DatabaseConnection.getConnection();
         ArrayList<Jobs> jobs = new ArrayList();
         try(Statement st = conn.createStatement()){          
             String sql = "select * from jobs";
         ResultSet result = st.executeQuery(sql);
         while(result.next()){
            Jobs j = new Jobs();            
           j.setEmployerId(result.getInt("EMPLOYER_ID"));
           j.setTitle(result.getString("TITLE"));
           j.setDescrip(result.getString("DESCRIP"));
           j.setSalary(result.getInt("SALARY"));
           j.setRequestedSkill(result.getString("REQUIRED_SKILL"));
           j.setCoDescription(result.getString("CO_DESCRPTION"));
           j.setCity(result.getString("CITY"));
           j.setType(result.getString("TYPE"));
           j.setCompanyName(result.getString("COMPANY_NAME"));
           j.setCreationDate(result.getDate("CREATION_DATE"));
           j.setEndDate(result.getDate("END_DATE"));
           j.setMemberId(result.getInt("MEMBER_ID"));
           jobs.add(j);         
         }         
         } catch (SQLException ex) {
             System.out.println("!*********************************");
            Logger.getLogger(JobsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return jobs;
    }

    
    
    
    @Override
    public Jobs getJobById(Integer memberId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "select * from jobs where member_id = " + memberId;
        Statement ps=conn.createStatement();  
        ResultSet result = ps.executeQuery(sql);
        Jobs j =  new Jobs();
        
        if(result.next()){
           j.setEmployerId(result.getInt("EMPLOYER_ID"));
           j.setTitle(result.getString("TITLE"));
           j.setDescrip(result.getString("DESCRIP"));
           j.setSalary(result.getInt("SALARY"));
           j.setRequestedSkill(result.getString("REQUIRED_SKILL"));
           j.setCoDescription(result.getString("CO_DESCRPTION"));
           j.setCity(result.getString("CITY"));
           j.setType(result.getString("TYPE"));
           j.setCompanyName(result.getString("COMPANY_NAME"));
           j.setCreationDate(result.getDate("CREATION_DATE"));
           j.setEndDate(result.getDate("END_DATE"));          
        }
        return j;
    }


    @Override
    public void addJob(Jobs job) throws SQLException {        
        String sql="INSERT INTO jobs (employer_id, title, descrip, salary, REQUIRED_SKILL, CO_DESCRPTION, city, member_id, type, company_name) "
                + "VALUES(MEMBERS_MEMBER_SEQ.nextval,?,?,?,?,?,?,?,?,?)";
        
         PreparedStatement pst = DatabaseConnection.getConnection().prepareCall(sql);
         pst.setString(1, job.getTitle());
         pst.setString(2, job.getDescrip());
         pst.setInt(3, job.getSalary());
         pst.setString(4, job.getRequestedSkill());
         pst.setString(5, job.getCoDescription());
         pst.setString(6, job.getCity());
         pst.setInt(7, job.getMemberId());
         pst.setString(8, job.getType());
         pst.setString(9, job.getCompanyName());
         pst.execute();  
    }

    @Override
    public void deleteJob(Integer mbrId) throws SQLException {
         Connection conn = DatabaseConnection.getConnection();          
         String sql ="delete from Jobs where member_id = ?";
         PreparedStatement ps=conn.prepareStatement(sql);
         ps.setInt(1, mbrId);
         ps.executeUpdate();
    }

    @Override
    public void updateJob(Jobs job) throws SQLException {
         Connection conn = DatabaseConnection.getConnection();
         String sql = "update jobs set title=?, descrip=?, salary=?, REQUIRED_SKILL=?, CO_DESCRPTION=?, city=?, type=?,company_name=?  where MEMBER_id=?";
         PreparedStatement pst = conn.prepareCall(sql);
         pst.setString(1, job.getTitle());
         pst.setString(2, job.getDescrip());
         pst.setInt(3, job.getSalary());
         pst.setString(4, job.getRequestedSkill());
         pst.setString(5, job.getCoDescription());
         pst.setString(6, job.getCity());
         pst.setString(7, job.getType());         
         pst.setString(8, job.getCompanyName());
         pst.setInt(9, job.getMemberId());
         pst.execute();
    }
    
     @Override
    public String isEmployerJobOffer(int memberId) throws SQLException {
    java.sql.Connection conn = DatabaseConnection.getConnection();        
    int num1 = 0;    
    String sql1="select count(*) as theCount from jobs where member_ID=?";
    PreparedStatement st1 = conn.prepareStatement(sql1);
    st1.setInt(1, memberId);
    ResultSet result1 = st1.executeQuery();
    while(result1.next()){
        num1 = (result1.getInt("theCount"));
    }   
    return num1==1?"T":"F";
    }
    
}
