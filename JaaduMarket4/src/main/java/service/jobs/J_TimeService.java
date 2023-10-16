package service.jobs;

import dao.jobs.J_TimeDAO;
import vo.jobs.J_TimeVO;

public class J_TimeService {

	private J_TimeDAO jtimeDao;
	
	public J_TimeService(J_TimeDAO jtimeDao) {
		this.jtimeDao = jtimeDao;
	}
	
	public int JTimeUpdate(J_TimeVO vo) {
		return jtimeDao.JTimeUpdate(vo);
	}

	

}
