
package dao;

import java.sql.Connection;
import java.sql.Statement;
import model.Resumes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseConnection;

/**
 *
 * @author Mehdi Miri
 */
public class ResumesDAOImpl implements ResumesDAO{

    @Override
    public Resumes getCvById(Integer mbrId) throws SQLException {
        java.sql.Connection conn = DatabaseConnection.getConnection();
        String sql="SELECT * FROM cvs where member_id =" + mbrId;
        PreparedStatement ps=conn.prepareStatement(sql);  
        ResultSet result = ps.executeQuery(sql);
        Resumes cvs =  new Resumes();
        if(result.next()){           
            cvs.setCvId(result.getInt("CV_ID"));
            cvs.setMainSkill(result.getString("MAIN_SKILL"));
            cvs.setWorkExperience(result.getString("WORK_EXPERIENCE"));
            cvs.setEducation(result.getString("EDUCATION"));
        }
        return cvs;
    }
        
    @Override
    public void addCv(Resumes cv) throws SQLException {
           java.sql.Connection conn = DatabaseConnection.getConnection();
        try{
        String sql =" insert into cvs(cv_id, main_skill, work_experience, education,member_id) values(CVS_CV_SEQ.nextval, ?,?,?,?) ";
          PreparedStatement pst = conn.prepareStatement(sql);
         pst.setString(1, cv.getMainSkill());
         pst.setString(2, cv.getWorkExperience());
         pst.setString(3, cv.getEducation());
         pst.setInt(4, cv.getMemberId());
         pst.executeUpdate(); 
        }catch( SQLException ex){
        ex.printStackTrace();
        }
    }
    

    @Override
    public void deleteCv(Integer mbrId) throws SQLException {
         java.sql.Connection conn = DatabaseConnection.getConnection();
        try {
            String sql = "DELETE FROM CVS WHERE member_ID = ?";
            PreparedStatement   pst = conn.prepareStatement(sql);            
            pst.setInt(1, mbrId);            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }

    @Override
    public void updateCv(Resumes cv) throws SQLException {
        java.sql.Connection conn = DatabaseConnection.getConnection();
        try {
            String sql = " UPDATE CVS SET MAIN_SKILL=?, WORK_EXPERIENCE=?, EDUCATION=? where member_id=?";            
            PreparedStatement pst = conn.prepareStatement(sql);            
            pst.setString(1, cv.getMainSkill());
            pst.setString(2, cv.getWorkExperience());
            pst.setString(3, cv.getEducation());
            pst.setInt(4, cv.getMemberId());            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    
    @Override
    public String isMemberCv(int memberId) throws SQLException {
   java.sql.Connection conn = DatabaseConnection.getConnection();        
    int num1 = 0;    
    String sql1="select count(*) as theCount from cvs where member_id=?";
    PreparedStatement st1 = conn.prepareStatement(sql1);
    st1.setInt(1, memberId);
    ResultSet result1 = st1.executeQuery();
    while(result1.next()){
        num1 = (result1.getInt("theCount"));
    }   
    return num1==1?"T":"F";
    }
    
    @Override
    public List<Resumes> getAllCVs()throws SQLException {
       Connection conn = DatabaseConnection.getConnection();
        ArrayList<Resumes> cvs = new ArrayList();
        try(Statement st = conn.createStatement()){
            String sql = "select * from cvs";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                Resumes cv = new Resumes();
                cv.setCvId(result.getInt("CV_ID"));
               cv.setMainSkill(result.getString("MAIN_SKILL"));
               cv.setWorkExperience(result.getString("WORK_EXPERIENCE"));
               cv.setEducation(result.getString("EDUCATION"));
               cv.setMemberId(result.getInt("MEMBER_ID"));
               cvs.add(cv);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ResumesDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        return cvs;
    }
    
    }

    

