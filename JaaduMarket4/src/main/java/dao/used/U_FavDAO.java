package dao.used;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.member.Key_SearchlistVO;
import vo.used.U_ChatVO;
import vo.used.U_FavVO;
import vo.used.U_TradelistVO;
import vo.used.UsedVO;

public class U_FavDAO {

	private SqlSession sqlSession;
	
	public U_FavDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public U_FavVO checkFav(U_FavVO vo) {
		return sqlSession.selectOne("u_fav.checkFav", vo);
	}
	
	public int addFav(U_FavVO vo) {
		return sqlSession.insert("u_fav.insert", vo);
	}
	
	public int delFav(U_FavVO vo) {
		return sqlSession.insert("u_fav.delete", vo);
	}
	
	public int favCount(int u_seq) {
		return sqlSession.selectOne("u_fav.favCount", u_seq);
	}
	
}
