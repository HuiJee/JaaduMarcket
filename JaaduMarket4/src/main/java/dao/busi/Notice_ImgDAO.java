package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.Notice_ImgVO;


public class Notice_ImgDAO {

	private SqlSession sqlSession;
	
	public Notice_ImgDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(Notice_ImgVO vo) {
		return sqlSession.insert("notice_img.insert", vo);
	}
	
	public int update(Notice_ImgVO vo) {
		return sqlSession.update("notice_img.update", vo);
	}
	
	public int deleteNotice_Img(int notice_seq) {
		return sqlSession.delete("notice_img.deleteNotice_Img", notice_seq);
	}
	
	public List<String> selectNotice_Img_List(int notice_seq){
		return sqlSession.selectList("notice_img.selectNotice_Img_List", notice_seq);
	}
	
	public List<Notice_ImgVO> selectNotice_Img(int notice_seq){
		return sqlSession.selectList("notice_img.selectNotice_Img", notice_seq);
	}
	
}
