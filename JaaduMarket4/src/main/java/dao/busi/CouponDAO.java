package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.CouponVO;

public class CouponDAO {
	
	private SqlSession sqlSession;
	
	public CouponDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(CouponVO vo) {
		return sqlSession.insert("coupon.insert", vo);
	}
	
	public int update(CouponVO vo) {
		return sqlSession.update("coupon.update", vo);
	}
	
	public int updateAct(CouponVO vo) {
		return sqlSession.update("coupon.updateAct", vo);
	}
	
	public int deleteCoupon(int coupon_seq) {
		return sqlSession.delete("coupon.deleteCoupon", coupon_seq);
	}
	
	public List<CouponVO> selectCouponList(int busi_seq){
		return sqlSession.selectList("coupon.selectCouponList", busi_seq);
	}
	
	public List<CouponVO> selectAvailableCouponFour(int busi_seq){
		return sqlSession.selectList("coupon.selectAvailableCouponFour", busi_seq);
	}
	
	public List<CouponVO> selectAvailableCoupon(int busi_seq){
		return sqlSession.selectList("coupon.selectAvailableCoupon", busi_seq);
	}
	
	public CouponVO selectOneCoupon(int coupon_seq) {
		return sqlSession.selectOne("coupon.selectOneCoupon", coupon_seq);
	}
}
