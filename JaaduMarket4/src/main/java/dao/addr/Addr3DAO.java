package dao.addr;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import vo.addr.Addr3VO;

public class Addr3DAO {

	private SqlSession sqlSession;
	
	// 새미, 현지
	public Addr3DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Addr3VO> searchAddr3(String addr3_name){
		return sqlSession.selectList("addr3.searchAddr3", addr3_name);
	}

	public List<Addr3VO> selectListAddr3(){
		return sqlSession.selectList("addr3.selectList");
	}
	
	public Addr3VO selectAddr(int addr3_no) {
		return sqlSession.selectOne("addr3.selectAddr", addr3_no);
	}
	
	public int selectAddr3_No(String addr3_name) {
		return sqlSession.selectOne("addr3.selectAddr3_No", addr3_name);
	}
	
	public String selectAddr3_Name(int addr3_no) {
		return sqlSession.selectOne("addr3.selectAddr3_Name", addr3_no);
	}
	
	
	//현지
	public Addr3VO selectAddrThroughBusi_seq(int busi_seq) {
		return sqlSession.selectOne("addr3.selectAddrThroughBusi_seq", busi_seq);
	}
	
	

	
}
