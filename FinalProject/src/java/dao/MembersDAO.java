
package dao;

import model.Members;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mehdi Miri
 */
public interface MembersDAO {
    
//    public List<Members> getAllMember() throws SQLException;
    public Members getMemberById(Integer memberId) throws SQLException;
//    public void addMember() throws SQLException;
//    public void deleteMember(Members member) throws SQLException;
    public void updateMember(Members member) throws SQLException;
    public void insertMember(Members member) throws SQLException;
    
}
