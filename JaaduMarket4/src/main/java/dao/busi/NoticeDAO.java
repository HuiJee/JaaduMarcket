package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.NoticeVO;

public class NoticeDAO {
	
	private SqlSession sqlSession;
	
	public NoticeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(NoticeVO vo) {
		return sqlSession.insert("notice.insert", vo);
	}
	
	public int update(NoticeVO vo) {
		return sqlSession.update("notice.update", vo);
	}
	
	public int updateViews(int notice_seq) {
		return sqlSession.update("notice.updateViews", notice_seq);
	}
	
	public int deleteNotice(int notice_seq) {
		return sqlSession.delete("notice.deleteNotice", notice_seq);
	}
	
	public NoticeVO selectOneForUpdate(int notice_seq) {
		return sqlSession.selectOne("notice.selectOneForUpdate", notice_seq);
	}
	
	public List<NoticeVO> selectNoticeList(int busi_seq){
		return sqlSession.selectList("notice.selectNoticeList", busi_seq);
	}
	
	public NoticeVO selectNotice(int notice_seq){
		return sqlSession.selectOne("notice.selectNotice", notice_seq);
	}
	
	public int maxNotice_Seq() {
		return sqlSession.selectOne("notice.maxNotice_Seq");
	}
	
	public List<NoticeVO> selectNoticeFour(int busi_seq){
		return sqlSession.selectList("notice.selectNoticeFour", busi_seq);
	}
	
}
