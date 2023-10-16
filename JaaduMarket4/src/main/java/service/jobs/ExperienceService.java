package service.jobs;

import java.util.List;

import dao.jobs.ExperienceDAO;
import vo.jobs.ExperienceVO;

public class ExperienceService {
	
	private  ExperienceDAO experienceDAO;
	
	public ExperienceService(ExperienceDAO experienceDAO) {
		this.experienceDAO = experienceDAO;
	}

	public int insert(ExperienceVO vo) {
		return experienceDAO.insert(vo);
		
	}
	
	public List<ExperienceVO > selectOne(int m_seq) {
		return experienceDAO.selectOne(m_seq);
	}
	
	
	public int getCount(int m_seq) { 
		return experienceDAO.getCount(m_seq);
	}
	
	public int delete(int m_seq) {
		return experienceDAO.delete(m_seq);
	}
	
	public int deleteOne(int experience_seq) {
		return experienceDAO.deleteOne(experience_seq);
	}
	
	public int updateOne(ExperienceVO evo ) {
		return experienceDAO.updateOne(evo);
		
	}
	
	public ExperienceVO expOne(int experience_seq) {
		return experienceDAO.expOne(experience_seq);

	}



	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
