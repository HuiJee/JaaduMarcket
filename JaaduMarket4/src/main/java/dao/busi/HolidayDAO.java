package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.HolidayVO;

public class HolidayDAO {
	
	private SqlSession sqlSession;
	
	public HolidayDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<HolidayVO> selectHoliday() {
		return sqlSession.selectList("holiday.selectHoliday");
	}

}
