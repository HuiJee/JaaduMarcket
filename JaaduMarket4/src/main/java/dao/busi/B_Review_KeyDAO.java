package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.B_Review_KeyVO;

public class B_Review_KeyDAO {
	
	private SqlSession sqlSession;
	
	public B_Review_KeyDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(B_Review_KeyVO vo) {
		return sqlSession.insert("b_review_key.insert", vo);
	}
	
	public int update(B_Review_KeyVO vo) {
		return sqlSession.update("b_review_key.update", vo);
	}
	
	public int deleteB_Review_Key(int b_review_key_seq) {
		return sqlSession.delete("b_review_key.deleteB_Review_Key", b_review_key_seq);
	}
	
	public List<B_Review_KeyVO> selectB_ReviewKeyList(){
		return sqlSession.selectList("b_review_key.selectB_ReviewKeyList");
	}
	
	public String selectB_Review_Key_Name(int b_review_key_seq) {
		return sqlSession.selectOne("b_review_key.selectB_Review_Key_Name", b_review_key_seq);
	}
	
	
}
