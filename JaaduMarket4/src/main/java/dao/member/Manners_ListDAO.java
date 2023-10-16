package dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.member.MannersVO;
import vo.member.Manners_DefaultVO;
import vo.member.Manners_ListVO;

public class Manners_ListDAO {

	private SqlSession sqlSession;
	
	public Manners_ListDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int mannersInsert(Manners_ListVO vo) {
		return sqlSession.insert("manners_list.insert", vo);
	}
	
	public List<Manners_ListVO> mannersGive(Manners_ListVO vo) {
		return sqlSession.selectList("manners_list.mannersGive", vo);
	}
	
	public List<Manners_ListVO> mannersReceive(Manners_ListVO vo) {
		return sqlSession.selectList("manners_list.mannersReceive", vo);
	}
	
	public List<String> mannersList(Manners_ListVO vo){
		return sqlSession.selectList("manners_list.mannersList", vo);
	}
	
	public int mannersDelete(Manners_ListVO vo) {
		return sqlSession.delete("manners_list.mannersDelete", vo);
	}
	
	public int deleteAll(int u_seq) {
		return sqlSession.delete("manners_list.deleteAll", u_seq);
	}
	
}
