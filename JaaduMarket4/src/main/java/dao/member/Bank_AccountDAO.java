package dao.member;

import org.apache.ibatis.session.SqlSession;

import vo.member.Bank_AccountVO;

public class Bank_AccountDAO {

	private SqlSession sqlSession;
	
	public Bank_AccountDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Bank_AccountVO vo) {
		return sqlSession.insert("bank_account.insert", vo);
	}
	
	public int chargePoint(Bank_AccountVO vo) {
		return sqlSession.update("bank_account.chargePoint", vo);
	}
	
	public Bank_AccountVO accountOne(int m_seq) {
		return sqlSession.selectOne("bank_account.accountOne", m_seq);
	}
	
	public int accountUpdate(Bank_AccountVO vo) {
		return sqlSession.update("bank_account.accountUpdate", vo);
	}
	
	public int payUse(Bank_AccountVO vo) {
		return sqlSession.selectOne("bank_account.payUse", vo);
	}
	
	public int myPoint(int m_seq) {
		return sqlSession.selectOne("bank_account.myPoint", m_seq);
	}
	
	public int paySome(Bank_AccountVO vo) {
		return sqlSession.update("bank_account.paySome", vo);
	}
	
	public int sellSome(Bank_AccountVO vo) {
		return sqlSession.update("bank_account.sellSome", vo);
	}
}
