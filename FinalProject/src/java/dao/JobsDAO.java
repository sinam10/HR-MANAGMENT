
package dao;

import model.Jobs;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mehdi Miri
 */
public interface JobsDAO {
    
    public List<Jobs> getAllJobs() throws SQLException;
    public Jobs getJobById(Integer jobId) throws SQLException;
    public void addJob(Jobs job) throws SQLException;
    public void deleteJob(Integer mbrId) throws SQLException;
    public void updateJob(Jobs job) throws SQLException;
    public String isEmployerJobOffer(int memberId) throws SQLException;
    
}
