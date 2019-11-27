
package dao;

import model.Resumes;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mehdi Miri
 */
public interface ResumesDAO {
    
    public Resumes getCvById(Integer cvId) throws SQLException;
    public void addCv(Resumes cv) throws SQLException;
    public void deleteCv(Integer mbrId) throws SQLException;
    public void updateCv(Resumes cv) throws SQLException;
    public String isMemberCv(int memberId) throws SQLException;
    public List<Resumes> getAllCVs()throws SQLException;
}
