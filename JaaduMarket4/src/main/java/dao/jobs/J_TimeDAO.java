package dao.jobs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.J_TimeVO;

public class J_TimeDAO {
	private SqlSession sqlSession;

	public J_TimeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int JTimeInsert(J_TimeVO vo) {
		return sqlSession.insert("jtime.insert", vo);

	}
	
	public int JTimeUpdate(J_TimeVO vo) {
		return sqlSession.insert("jtime.update", vo);

	}

	public int  JTimeDelete(int j_seq) {
		return sqlSession.insert("jtime.delete",j_seq);
		
	}


	public List<J_TimeVO> getTimeType(int j_seq) {
		return sqlSession.selectList("jtime.getJ_time_Type",j_seq);
	}

}










