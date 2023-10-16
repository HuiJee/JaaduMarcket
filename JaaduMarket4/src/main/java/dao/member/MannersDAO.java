package dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.member.MannersVO;
import vo.member.Manners_DefaultVO;
import vo.member.Manners_ListVO;

public class MannersDAO {

	private SqlSession sqlSession;
	
	public MannersDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MannersVO> selectDefault() {
		return sqlSession.selectList("manners.selectDefault");
	}
	
	public List<MannersVO> selectList() {
		return sqlSession.selectList("manners.selectList");
	}
	
	public List<MannersVO> myMannersGood(int m_seq){
		return sqlSession.selectList("manners.myMannersGood", m_seq);
	}
	
	public List<MannersVO> myMannersBad(int m_seq){
		return sqlSession.selectList("manners.myMannersBad", m_seq);
	}
}
