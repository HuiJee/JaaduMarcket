package dao.used;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.member.Key_SearchlistVO;
import vo.used.U_ChatVO;
import vo.used.U_FavVO;
import vo.used.U_TradelistVO;
import vo.used.UsedVO;

public class UsedDAO {

	private SqlSession sqlSession;
	
	public UsedDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(UsedVO vo) {
		return sqlSession.insert("used.insert", vo);
	}
	
	public UsedVO selectOne(int u_seq) {
		return sqlSession.selectOne("used.selectOne", u_seq);
	}
	
	public UsedVO selectOnly(int u_seq) {
		return sqlSession.selectOne("used.selectOnly", u_seq);
	}
	
	public int plusHit(int u_seq) {
		return sqlSession.update("used.plusHit", u_seq);
	}
	
	public int maxSeq() {
		return sqlSession.selectOne("used.maxSeq");
	}
	
	public List<UsedVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("used.selectList", map);
	}

	public int delete(int u_seq) {
		return sqlSession.update("used.delete", u_seq);
	}
	
	public int sell(int u_seq) {
		return sqlSession.update("used.sell", u_seq);
	}
	
	public int reserve(int u_seq) {
		return sqlSession.update("used.reserve", u_seq);
	}
	
	public int checkSell(int u_seq) {
		return sqlSession.selectOne("used.checkSell", u_seq);
	}
	
	public List<UsedVO> topSelect(){
		return sqlSession.selectList("used.topSelect");
	}
	
	public int allCount() {
		return sqlSession.selectOne("used.allCount");
	}
	
	public int someCount(Map<String, Object> map) {
		return sqlSession.selectOne("used.someCount", map);
	}
	
	public UsedVO getOne(int u_seq) {
		return sqlSession.selectOne("used.getOne", u_seq);
	}
	
	public int update(UsedVO vo) {
		return sqlSession.update("used.update", vo);
	}
	
	public int checkBoost(int u_seq) {
		return sqlSession.selectOne("used.checkBoost", u_seq);
	}
	
	public int boost(int u_seq) {
		return sqlSession.update("used.boost", u_seq);
	}
	
	public List<UsedVO> selectMine(int m_seq) {
		return sqlSession.selectList("used.selectMine", m_seq);
	}
	
	public int noSell(int u_seq) {
		return sqlSession.update("used.noSell", u_seq);
	}
	
	public int myBuyCount(int buyer_seq) {
		return sqlSession.selectOne("used.myBuyCount", buyer_seq);
	}
	
	public List<UsedVO> myBuy(Map<String, Object> map) {
		return sqlSession.selectList("used.myBuy", map);
	}
	
}
