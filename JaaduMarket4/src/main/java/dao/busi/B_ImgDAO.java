package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.B_ImgVO;

public class B_ImgDAO {

	
	private SqlSession sqlSession;
	
	public B_ImgDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(B_ImgVO vo) {
		return sqlSession.insert("b_img.insert", vo);
	}
	
	public int update(B_ImgVO vo) {
		return sqlSession.update("b_img.update", vo);
	}
	
	
	public int deleteB_Img(int busi_seq) {
		return sqlSession.delete("b_img.deleteB_Img", busi_seq);
	}
	
	
	public String selectB_Img_Name(int busi_seq) {
		return sqlSession.selectOne("b_img.selectB_Img_Name", busi_seq);
	}
	
//	public List<String> selectImgList(int busi_seq){
//		return sqlSession.selectList("b_img.selectImgList", busi_seq);
//	}
	
	public List<String> selectImgList(int busi_seq){
		List<String> list = sqlSession.selectList("b_img.selectImgList", busi_seq) == null ? null : sqlSession.selectList("b_img.selectImgList", busi_seq);
		
		return list;
	}
	
}
