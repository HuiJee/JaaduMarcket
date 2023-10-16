package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.HoursVO;

public class HoursDAO {

	private SqlSession sqlSession;
	
	public HoursDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(HoursVO vo) {
		return sqlSession.insert("hours.insert", vo);
	}
	
	public int update(HoursVO vo) {
		return sqlSession.update("hours.update", vo);
	}
	
	public int deleteHours(int hours_seq) {
		return sqlSession.delete("hours.deleteHours", hours_seq);
	}
	
	public List<HoursVO> selectHours(int busi_seq){
		return sqlSession.selectList("hours.selectHours", busi_seq);
	}
	
	public int selectHours_maxSeq() {
		return sqlSession.selectOne("hours.selectHours_maxSeq");
	}
	
}
