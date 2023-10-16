package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.BusiVO;

public class BusiDAO {
	
	private SqlSession sqlSession;
	
	public BusiDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(BusiVO vo) {
		return sqlSession.insert("busi.insert", vo);
	}
	
	public int update(BusiVO vo) {
		return sqlSession.update("busi.update", vo);
	}
	
	public int updateBusiProfile(BusiVO vo) {
		return sqlSession.update("busi.updateBusiProfile", vo);
	}
	
	public int delete(int busi_seq) {
		return sqlSession.delete("busi.delete", busi_seq);
	}
	
	public List<BusiVO> selectList(){
		return sqlSession.selectList("busi.selectList");
	}
	
	public BusiVO selectOne(int busi_seq) {
		return sqlSession.selectOne("busi.selectOne", busi_seq);
	}
	
	public int maxSeq() {
		return sqlSession.selectOne("busi.maxSeq");
	}
	
	public List<BusiVO> selectMyBusiList(int m_seq){
		return sqlSession.selectList("busi.selectMyBusiList", m_seq);
	}
	
	public int selectM_seqInBusi(int busi_seq) {
		return sqlSession.selectOne("busi.selectM_seqInBusi", busi_seq);
	}
	
	public List<BusiVO> selectMyRegList(int m_seq) {
		return sqlSession.selectList("busi.selectMyRegList", m_seq);
	}
	
	public int getTotal() {
		return sqlSession.selectOne("busi.getTotal");
	}
	
}
