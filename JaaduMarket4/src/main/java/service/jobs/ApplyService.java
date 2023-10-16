package service.jobs;

import dao.jobs.ApplyDAO;
import vo.jobs.ApplyVO;

public class ApplyService {
	
	private ApplyDAO applyDAO;
	
	public ApplyService(ApplyDAO applyDAO) {
	this.applyDAO = applyDAO;
	}

	public ApplyVO getApply(int m_seq) {
		ApplyVO appl = applyDAO.getApply(m_seq);
		if(appl == null) {
			appl=null;
		}
		return applyDAO.getApply(m_seq);
	}
	
	public int insert(ApplyVO vo) {
		return applyDAO.insert(vo);
	}
	
	public ApplyVO getSelect(int m_seq) {
		return applyDAO.getSelect(m_seq);
	}
	
	
	
	

	
	public int update(ApplyVO vo) {
		return applyDAO.update(vo);
		
	}
	public int delete(ApplyVO apvo) {
		return applyDAO.delete(apvo);
	}

}
