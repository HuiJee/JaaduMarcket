package dao.addr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.addr.Addr1VO;

public class Addr1DAO {

	private SqlSession sqlSession;
	
	public Addr1DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Addr1VO> selectList(){
		return sqlSession.selectList("addr1.selectList");
	}
	
}
