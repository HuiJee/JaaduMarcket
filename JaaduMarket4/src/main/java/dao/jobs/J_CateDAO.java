package dao.jobs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.J_CateVO;

public class J_CateDAO {

	private SqlSession sqlSession;

	public J_CateDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	public List<J_CateVO> selectAll() {
	    	
	   return sqlSession.selectList("jcate.selectAllJ_Cate");
	    	
	  }

}
