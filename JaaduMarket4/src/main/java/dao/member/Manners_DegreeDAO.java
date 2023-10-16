package dao.member;


import org.apache.ibatis.session.SqlSession;

import vo.member.Manners_DegreeVO;

public class Manners_DegreeDAO {

	private SqlSession sqlSession;
	
	public Manners_DegreeDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 희지
	public int degreeUpdate(int m_seq) {
		return sqlSession.update("manners_degree.update", m_seq);
	}
	
	// 새미
	public int InsertDegree(Manners_DegreeVO mdvo) {
		return sqlSession.insert("manners_degree.InsertDegree", mdvo );
	}
	
}
