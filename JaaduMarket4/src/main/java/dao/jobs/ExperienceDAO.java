package dao.jobs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.ExperienceVO;

public class ExperienceDAO {

	private SqlSession sqlSession;

	public ExperienceDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insert(ExperienceVO vo) {
		return sqlSession.insert("experience.insert", vo);

	}

	public List<ExperienceVO> selectOne(int m_seq) {
		return sqlSession.selectList("experience.selectOne", m_seq);
	}

	public int getCount(int m_seq) {
		return sqlSession.selectOne("experience.getCount", m_seq);
	}

	public int delete(int m_seq) {
		return sqlSession.delete("experience.delete", m_seq);
	}
	

	public int deleteOne(int experience_seq) {
		return sqlSession.delete("experience.deleteOne", experience_seq);
	}
	


public int updateOne(ExperienceVO evo ) {
	return sqlSession.update("experience.updateOne", evo);
	
}


public ExperienceVO expOne(int experience_seq) {
	return sqlSession.selectOne("experience.expOne", experience_seq);

}


	
	

}
