package dao.used;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.used.Cate_CheckVO;
import vo.used.U_CateVO;

public class Cate_CheckDAO {

	private SqlSession sqlSession;
	
	public Cate_CheckDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Cate_CheckVO> subCate(){
		return sqlSession.selectList("cate_check.subCate");
	}
	
}
