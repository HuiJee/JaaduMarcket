package dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.member.MannersVO;
import vo.member.Manners_DefaultVO;
import vo.member.Manners_ListVO;

public class Manners_DefaultDAO {

	private SqlSession sqlSession;
	
	public Manners_DefaultDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int defaultInsert(Manners_DefaultVO vo) {
		return sqlSession.insert("manners_default.insert", vo);
	}
	
	public int defaultDelete(Manners_DefaultVO vo) {
		return sqlSession.delete("manners_default.delete", vo);
	}
	
	public List<Manners_DefaultVO> defaultList(Manners_DefaultVO vo){
		return sqlSession.selectList("manners_default.select", vo);
	}
}
