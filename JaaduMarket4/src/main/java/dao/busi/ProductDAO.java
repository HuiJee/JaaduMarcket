package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.ProductVO;

public class ProductDAO {
	
	private SqlSession sqlSession;
	
	public ProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(ProductVO vo) {
		return sqlSession.insert("product.insert", vo);
	}
	
	public int update(ProductVO vo) {
		return sqlSession.update("product.update", vo);
	}
	
	public int deleteProduct(int product_seq) {
		return sqlSession.delete("product.deleteProduct",product_seq);
	}
	
	public List<ProductVO> selectProductList(int busi_seq){
		return sqlSession.selectList("product.selectProductList", busi_seq);
	}
	
	public List<ProductVO> selectProductsFour(int busi_seq){
		return sqlSession.selectList("product.selectProductsFour", busi_seq);
	}
	
	public ProductVO selectProduct(int product_seq) {
		return sqlSession.selectOne("product.selectProduct", product_seq);
	}
	
}
