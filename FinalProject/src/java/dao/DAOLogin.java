
package dao;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Mehdi Miri
 */
public interface DAOLogin {
    public String userPass(String username, String password) throws SQLException;
    public String userRole(String username) throws SQLException;
    public int getMemberId(String user, String pass)  throws SQLException;
    public String getMemberRole(Integer mbrId)  throws SQLException;
}
