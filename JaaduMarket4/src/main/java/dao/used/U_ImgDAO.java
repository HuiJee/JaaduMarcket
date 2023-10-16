package dao.used;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.used.U_ImgVO;

public class U_ImgDAO {

	private SqlSession sqlSession;
	
	public U_ImgDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(U_ImgVO vo) {
		return sqlSession.insert("u_img.insert", vo);
	}
	
	public List<String> selectPhotos(int u_seq){
		return sqlSession.selectList("u_img.selectAll", u_seq);
	}
	
	public int delete(String u_img_name) {
		return sqlSession.delete("u_img.delete", u_img_name);
	}
	
}
