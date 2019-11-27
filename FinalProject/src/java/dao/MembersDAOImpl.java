
package dao;

import model.Members;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DatabaseConnection;
import static util.DatabaseConnection.getConnection;

/**
 *
 * @author Mehdi Miri
 */
public class MembersDAOImpl implements MembersDAO{
    

    
    Connection conn=null;
    PreparedStatement statement=null;
    ResultSet rs=null;


        @Override
    public Members getMemberById(Integer memberId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql="SELECT member_id, first_name, last_name, email, uname, pass, regdate FROM members where member_id = " + memberId;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(sql);
        Members member =  new Members();
        if(result.next()){
            
            member.setMemberId(result.getInt("MEMBER_ID"));
            member.setFirstName(result.getString("FIRST_NAME"));
            member.setLastName(result.getString("LAST_NAME"));
            member.setEmail(result.getString("EMAIL"));
            member.setUserName(result.getString("UNAME"));
            member.setPass(result.getString("PASS"));
            member.setRegDate(result.getDate("REGDATE"));
            
//        System.out.println("last_name:***************************"+result.getString("LAST_NAME")); 
        }
        return member;
    }



    @Override
    public void updateMember(Members member) throws SQLException {
        
        try {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pst = conn.prepareCall( "update members set first_name=?, last_name=?, email=?, uname=?, pass=?  where member_id=?");
        
        pst.setString(1, member.getFirstName());
        pst.setString(2, member.getLastName());
        pst.setString(3, member.getEmail());
        pst.setString(4, member.getUserName());
        pst.setString(5, member.getPass());
        pst.setInt(6, member.getMemberId());
        pst.execute();  
         }catch (SQLException e) {
            throw new RuntimeException(e);
    } 
//        finally {
//            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
//        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
//        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
//    }
    }
    
    @Override
    public void insertMember(Members member) throws SQLException {        
        try {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pst = conn.prepareCall( "insert into members(MEMBER_ID,first_name,last_name,email,uname,pass) values(MEMBERS_MEMBER_SEQ.nextval,?,?,?,?,?)");
        
        pst.setString(1, member.getFirstName());
        pst.setString(2, member.getLastName());
        pst.setString(3, member.getEmail());
        pst.setString(4, member.getUserName());
        pst.setString(5, member.getPass());
        pst.execute();  
         }catch (SQLException e) {
            throw new RuntimeException(e);

    } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }
    }
    
}
