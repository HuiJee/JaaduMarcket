package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.Busi_CateVO;

public class Busi_CateDAO {

	private SqlSession sqlSession;
	
	public Busi_CateDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<Busi_CateVO> selectBusiCateList(){
		return sqlSession.selectList("busi_cate.selectBusiCateList");
	}
	
	public String selectBusi_Cate_Name(int busi_cate_seq) {
		return sqlSession.selectOne("busi_cate.selectBusi_Cate_Name", busi_cate_seq);
	}
	
	
	
}
