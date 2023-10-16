package service.jobs;

import java.util.List;

import dao.jobs.J_CateDAO;
import vo.jobs.J_CateVO;
import vo.jobs.JobsVO;

public class J_CateService {

	private J_CateDAO jcateDAO;
	
	public J_CateService(J_CateDAO jcateDAO) {
		this.jcateDAO =jcateDAO;
	}
	
	public List<J_CateVO> selectAll() {
    	
		   return jcateDAO.selectAll();
		    	
		  }
	
	
}
