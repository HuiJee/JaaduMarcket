package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.B_Review_ImgVO;

public class B_Review_ImgDAO {
	
	private SqlSession sqlSession;
	
	public B_Review_ImgDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(B_Review_ImgVO vo) {
		return sqlSession.insert("b_review_img.insert", vo);
	}
	
	public int update(B_Review_ImgVO vo) {
		return sqlSession.update("b_review_img.update", vo);
	}
	
	public int deleteB_ReviewImg(int b_review_seq) {
		return sqlSession.delete("b_review_img.deleteB_ReviewImg", b_review_seq);
	}
	
	public List<B_Review_ImgVO> selectB_ReviewImg_List(int b_review_seq){
		return sqlSession.selectList("b_review_img.selectB_ReviewImg_List", b_review_seq);
	}
	
	
}
