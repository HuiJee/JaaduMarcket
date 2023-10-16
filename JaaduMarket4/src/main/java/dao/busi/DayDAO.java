package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.DayVO;

public class DayDAO {

	private SqlSession sqlSession;
	
	public DayDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	public List<DayVO> selectDayList(){
		return sqlSession.selectList("day.selectDayList");
	}
	
	public List<DayVO> selectNameList(){
		return sqlSession.selectList("day.selectName");
	}
	
}
