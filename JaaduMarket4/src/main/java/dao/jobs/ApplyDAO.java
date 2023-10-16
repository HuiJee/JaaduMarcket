package dao.jobs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.ApplyVO;

public class ApplyDAO {
	
	private SqlSession sqlSession;
	
	public ApplyDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public ApplyVO getApply(int m_seq) {
		return sqlSession.selectOne("apply.selectOne",m_seq );
	}
	
	public int insert(ApplyVO vo) {
		return sqlSession.insert("apply.insert",vo);
	}

	public ApplyVO getSelect(int m_seq) {
		return sqlSession.selectOne("apply.getSelect",m_seq);
	}
	
	public boolean CheckApply(int m_seq) {
		return sqlSession.selectOne("apply.CheckApply",m_seq);
	}

	
	public int update(ApplyVO vo) {
		return sqlSession.update("apply.update",vo);
		
	}

	
	public int delete(ApplyVO apvo) {
		return sqlSession.update("apply.delete", apvo);
	}
	
	
	public int getApplySeq(int m_seq) {
		return sqlSession.selectOne("apply.getSeq", m_seq);
	}
	
	//해당지원자의 지원서 정보 (지원취소 제외)
	public List<ApplyVO> ApplicantInfo2(int j_seq) {
		return sqlSession.selectList("apply.ApplicantInfo2", j_seq);
		
	}
	

	//해당지원자의 지원서 정보 (구직중)
	public List<ApplyVO> ApplicantInfo(int j_seq) {
		return sqlSession.selectList("apply.ApplicantInfo", j_seq);
		
	}
	

	//해당지원자의 지원서 정보 (채용완료)
	public List<ApplyVO> ApplicantInfo1(int j_seq) {
		return sqlSession.selectList("apply.ApplicantInfo1", j_seq);
		
	}
	

	//해당지원자의 지원서 정보 (거절됨)
	public List<ApplyVO> ApplicantInfo3(int j_seq) {
		return sqlSession.selectList("apply.ApplicantInfo3", j_seq);
		
	}
	
	

	

}
