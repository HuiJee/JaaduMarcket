package dao.jobs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.J_PeriodVO;

public class J_PeriodDAO {
	private SqlSession sqlSession;
	
	public J_PeriodDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<J_PeriodVO> getList() {
	
		return sqlSession.selectList("jperiod.getList");
		
		
	}

}
