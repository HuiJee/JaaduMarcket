package dao.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.member.Key_SearchlistVO;
import vo.used.U_ChatVO;
import vo.used.U_FavVO;
import vo.used.U_TradelistVO;
import vo.used.UsedVO;

public class Key_SearchlistDAO {

	private SqlSession sqlSession;
	
	public Key_SearchlistDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int keyInsert(Key_SearchlistVO vo) {
		return sqlSession.insert("key_searchlist.insert", vo);
	}
	
	public List<String> myKey(int m_seq){
		return sqlSession.selectList("key_searchlist.myKey", m_seq);
	}
	
	public List<String> topKey(){
		return sqlSession.selectList("key_searchlist.topKey");
	}
	
	public List<String> keyRanking(){
		return sqlSession.selectList("key_searchlist.keyRanking");
	}
	
	public int sameKey(Key_SearchlistVO vo) {
		return sqlSession.selectOne("key_searchlist.sameKey", vo);
	}
	
	public int keyDate(Key_SearchlistVO vo) {
		return sqlSession.update("key_searchlist.keyDate", vo);
	}
	
}
