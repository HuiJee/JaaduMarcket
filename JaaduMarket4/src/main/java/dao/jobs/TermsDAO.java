package dao.jobs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.TermsVO;

public class TermsDAO {
	
	private SqlSession sqlSession;
	
	public TermsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	

	
	public List<TermsVO> selectList() {
		return sqlSession.selectList("terms.selectList");
	}
	

}






