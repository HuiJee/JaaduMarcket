package dao.busi;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.busi.Coupon_DownVO;

public class Coupon_DownDAO {

	private SqlSession sqlSession;
	
	public Coupon_DownDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public int insert(Coupon_DownVO vo) {
		return sqlSession.insert("coupon_down.insert", vo);
	}
	
	public int update(Coupon_DownVO vo) {
		return sqlSession.update("coupon_down.update", vo);
	}
	
	public int deleteCoupon_Down(int coupon_down_seq) {
		return sqlSession.delete("coupon_down.deleteCoupon_Down", coupon_down_seq);
	}
	
	public List<Coupon_DownVO> selectCouponDownList(int m_seq){
		return sqlSession.selectList("coupon_down.selectCouponDownList", m_seq);
	}
	
	public Coupon_DownVO selectOneCouponDown(Coupon_DownVO vo) {
		return sqlSession.selectOne("coupon_down.selectOneCouponDown", vo);
	}
	
	
	
	
}
