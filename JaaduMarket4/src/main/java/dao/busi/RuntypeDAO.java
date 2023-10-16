package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.RuntypeVO;

public class RuntypeDAO {

	private SqlSession sqlSession;
	
	public RuntypeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<RuntypeVO> selectRuntype(){
		return sqlSession.selectList("runtype.selectRuntype");
	}
	
}
