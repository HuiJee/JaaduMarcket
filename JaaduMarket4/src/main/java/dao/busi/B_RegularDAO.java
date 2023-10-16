package dao.busi;


import org.apache.ibatis.session.SqlSession;

import vo.busi.B_RegularVO;

public class B_RegularDAO {

	private SqlSession sqlSession;
	
	public B_RegularDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(B_RegularVO vo) {
		return sqlSession.insert("b_regular.insert", vo);
	}
	
	public int update(B_RegularVO vo){
		return sqlSession.update("b_regular.update", vo);
	}
	
	public int deleteRegular(B_RegularVO vo) {
		return sqlSession.delete("b_regular.deleteRegular", vo);
	}
	
	public int countRegular(int busi_seq) {
		return sqlSession.selectOne("b_regular.countRegular", busi_seq);
	}
	
	public B_RegularVO isRegular(int m_seq) {
		return sqlSession.selectOne("b_regular.isRegular", m_seq);
	}
	
	
}
