package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.Notice_CmtVO;

public class Notice_CmtDAO {
	
	private SqlSession sqlSession;
	
	public Notice_CmtDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(Notice_CmtVO vo) {
		return sqlSession.insert("notice_cmt.insert", vo);
	}
	
	public int update(Notice_CmtVO vo) {
		return sqlSession.update("notice_cmt.update", vo);
	}
	
	public int deleteNoticeCmtAll(int notice_seq) {
		return sqlSession.delete("notice_cmt.deleteNoticeCmtAll", notice_seq);
	}
	
	public int deleteNoticeCmt(int notice_cmt_seq) {
		return sqlSession.delete("notice_cmt.deleteNoticeCmt", notice_cmt_seq);
	}
	
	public List<Notice_CmtVO> selectCmtList(int notice_seq){
		return sqlSession.selectList("notice_cmt.selectCmtList", notice_seq);
	}
	
	
	
	
	
}
