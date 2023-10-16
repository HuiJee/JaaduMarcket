package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.B_ReviewVO;

public class B_ReviewDAO {

	
	private SqlSession sqlSession;
	
	public B_ReviewDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(B_ReviewVO vo) {
		return sqlSession.insert("b_review.insert",vo);
	}
	
	public int update(B_ReviewVO vo) {
		return sqlSession.update("b_review.update", vo);
	}
	
	public int deleteB_Review(int b_review_seq) {
		return sqlSession.delete("b_review.deleteB_Review", b_review_seq);
	}
	
	public List<B_ReviewVO> selectB_Review_List(int busi_seq){
		return sqlSession.selectList("b_review.selectB_Review_List", busi_seq);
	}
	
	public B_ReviewVO selectB_Review_One(int b_review_seq) {
		return sqlSession.selectOne("b_review.selectB_Review_One", b_review_seq);
	}
	
	public int maxReview_seq() {
		return sqlSession.selectOne("b_review.maxReview_seq");
	}
}
