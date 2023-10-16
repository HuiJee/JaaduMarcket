package dao.addr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.addr.Addr2VO;

public class Addr2DAO {

	private SqlSession sqlSession;
	
	public Addr2DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Addr2VO> selectList(){
		return sqlSession.selectList("addr2.selectList");
	}
	
	public List<Addr2VO> selectSome(int addr1_no){
		return sqlSession.selectList("addr2.selectSome", addr1_no);
	}
	
}
