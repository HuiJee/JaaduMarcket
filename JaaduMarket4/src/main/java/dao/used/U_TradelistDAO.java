package dao.used;


import org.apache.ibatis.session.SqlSession;

import vo.used.U_TradelistVO;

public class U_TradelistDAO {

	private SqlSession sqlSession;
	
	public U_TradelistDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int tradeInsert(U_TradelistVO vo) {
		return sqlSession.insert("u_tradelist.insert", vo);
	}
	
	public int myReserve(U_TradelistVO vo) {
		return sqlSession.selectOne("u_tradelist.myReserve", vo);
	}
	
	public int sellFinish(int u_seq) {
		return sqlSession.update("u_tradelist.sellFinish", u_seq);
	}
	
	public int tradeDelete(int u_seq) {
		return sqlSession.delete("u_tradelist.tradeDelete", u_seq);
	}
	
	public int whoBuy(int u_seq) {
		return sqlSession.selectOne("u_tradelist.whoBuy", u_seq);
	}
	
	public int tradeType(int u_seq) {
		return sqlSession.selectOne("u_tradelist.tradeType", u_seq);
	}
	
}
