package dao.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.jobs.ApplicationVO;

public class ApplicationDAO {

	private SqlSession sqlSession;

	public ApplicationDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insertApp(ApplicationVO appVO) {
		return sqlSession.insert("app.insert", appVO);
	}

	public List<ApplicationVO> getApplication(int m_seq) {
		return sqlSession.selectList("app.getApplication", m_seq);
	}

// 구직 중 상태 업데이트
	public int appStatus( ApplicationVO apvo) {
	 return sqlSession.update("app.appStatus", apvo);
	}
	
	
	public int AppCount(int j_seq) {
		return sqlSession.selectOne("app.Count", j_seq);
	}

	// 해당 회원 지원 내역 조회

	public List<ApplicationVO> SelectOne(int m_seq) {
		return sqlSession.selectList("app.SelectOne", m_seq);
	}

	public int appStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 

	//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수 
	public int appCount(int m_seq) {
		return sqlSession.selectOne("app.appCount", m_seq);
	}
	

	//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수(응답대기) 
	public int appCount0(int m_seq) {
		return sqlSession.selectOne("app.appCount0", m_seq);
	}
	

	//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수 (채용중)
	public int appCount1(int m_seq) {
		return sqlSession.selectOne("app.appCount1", m_seq);
	}
	

	//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수(거절) 
	public int appCount3(int m_seq) {
		return sqlSession.selectOne("app.appCount3", m_seq);
	}
	

// 해당 회원 지원내역 (응답대기중 0 )  조회

public List<ApplicationVO> waiting(int m_seq) {
	return sqlSession.selectList("app.waiting",m_seq );
}

// 해당 회원 지원내역 (채용됨 1 )  조회
public List<ApplicationVO> doneRecruit(int m_seq) {
	return sqlSession.selectList("app.doneRecruit",m_seq );
}
//해당 회원 지원내역 (삭제 2)  조회

public List<ApplicationVO> DeleteList(int m_seq) {
	return sqlSession.selectList("app.DeleteList",m_seq );
}
//- 해당 회원 지원내역 (거절 3)  조회

public List<ApplicationVO> Rejected(int m_seq) {
	return sqlSession.selectList("app.Rejected",m_seq );
}


//<!-- 중복 지원체크 -->




 public ApplicationVO checkDupli(int j_seq, int m_seq) {
	Map<String,Object> map = new HashMap<String, Object>();
	map.put("j_seq", j_seq);
	map.put("m_seq", m_seq);
		return sqlSession.selectOne("app.checkDupli", map);
	}
}







