package dao.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.ApplicationVO;
import vo.jobs.J_CateVO;
import vo.jobs.JobsVO;

public class JobsDAO {

	private SqlSession sqlSession;

	public JobsDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int JCate_INsert(JobsVO jcvo) {
		return sqlSession.insert("jobs.insertJ_seq", jcvo);
	}

	public int inJCateList(HashMap<String, Object> map) {
		return sqlSession.insert("jobs.inJCateList", map);
	}

	public int insertJob(JobsVO vo) {
		return sqlSession.insert("jobs.insertJob", vo);

	}

	public List<JobsVO> selectList() {
		return sqlSession.selectList("jobs.selectList");
	}

	public JobsVO getJobsOne(int j_seq) {
		return sqlSession.selectOne("jobs.getJobsOne", j_seq);

	}
//<!-- 해당회원이 작성한 공고 조회 and 구인중 -->
	public List<JobsVO> getJobMember(int m_seq) {
		return sqlSession.selectList("jobs.getJobMember",m_seq);
	}
	//해당회원이 작성한 공고 조회 and 채용함
	public List<JobsVO> getJobMember1(int m_seq) {
		return sqlSession.selectList("jobs.getJobMember1",m_seq);
	}
	//해당회원이 작성한 공고 조회 and 거절함
	public List<JobsVO> getJobMember3(int m_seq) {
		return sqlSession.selectList("jobs.getJobMember3",m_seq);
	}

	public int getJSeq() {
		return sqlSession.selectOne("jobs.getJSeq");
	}

	public int readCount(int j_seq) {
		return sqlSession.update("jobs.readCount", j_seq);
	}
	
	//해당회원 제외 모든 공고리스트 조회
	
	public List<JobsVO> outOFMember(Map<String, Object> map) {
		
		return sqlSession.selectList("jobs.outOFMember", map);
	}
		//<!-- 본인 제외 공고 게시글(구인중)개수 -->
	public int getTotal(Map<String, Object> map) {
		
		 
		return sqlSession.selectOne("jobs.getTotal", map);
	}
	

	//해당회원 제외 모든 공고리스트 조회(단기)
	
	public List<JobsVO> outOFMemberShort(Map<String, Object> map) {
		
		return sqlSession.selectList("jobs.outOFMemberShort", map);
	}
	
	//<!-- 본인 제외 공고 게시글(구인중)개수(단기) -->
	public int getTotalShort(Map<String, Object> map) {
		
		 
		return sqlSession.selectOne("jobs.getTotalShort", map);
	}
	
	
	//공고 상태 변경

	public int statusChange(JobsVO jvo) {
		
		return sqlSession.update("jobs.statusChange",jvo);
	}
	
	
	
	
	//주소 포함해서 해당 공고 번호로 공고게시물 조회
	
	public JobsVO AllJobsOne(int j_seq) {
		return sqlSession.selectOne("jobs.AllJobsOne", j_seq);
		
	}

	//선택한 하는일 조회
	public List<JobsVO> CateName(int j_seq) {
		return sqlSession.selectList("jobs.CateName",j_seq);
	}
	
	
	
	public int updateJob(JobsVO jvo) {
		return sqlSession.update("jobs.updateJob",jvo);
	}
	


	public int myJobCoun(int m_seq) {
		return sqlSession.selectOne("jobs.myJobCount", m_seq);
	}


}




