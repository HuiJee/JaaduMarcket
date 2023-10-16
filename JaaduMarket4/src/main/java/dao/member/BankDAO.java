package dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.member.BankVO;

public class BankDAO {

	private SqlSession sqlSession;
	
	public BankDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<BankVO> selectList(){
		return sqlSession.selectList("bank.selectList");
	}
	
}
