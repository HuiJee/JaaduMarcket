package dao.used;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.used.Cate_CheckVO;
import vo.used.U_CateVO;

public class U_CateDAO {

	private SqlSession sqlSession;
	
	public U_CateDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<U_CateVO> cateList() {
		return sqlSession.selectList("u_cate.cateList");
	}
	
}
