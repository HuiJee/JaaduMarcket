package dao.used;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.member.Key_SearchlistVO;
import vo.used.U_ChatVO;
import vo.used.U_FavVO;
import vo.used.U_TradelistVO;
import vo.used.UsedVO;

public class U_ChatDAO {

	private SqlSession sqlSession;
	
	public U_ChatDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int chatInsert(U_ChatVO vo) {
		return sqlSession.insert("u_chat.insert", vo);
	}
	
	public List<U_ChatVO> oneChat(U_ChatVO vo){
		return sqlSession.selectList("u_chat.oneChat", vo);
	}
	
	public int oneCount(int u_seq) {
		return sqlSession.selectOne("u_chat.oneCount", u_seq);
	}
	
//	public int chatDelete(int u_seq) {
//		return sqlSession.delete("u_chat.delete", u_seq);
//	}
	
	
}
