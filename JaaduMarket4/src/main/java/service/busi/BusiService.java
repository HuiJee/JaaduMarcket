package service.busi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import dao.addr.Addr3DAO;
import dao.busi.B_ImgDAO;
import dao.busi.B_RegularDAO;
import dao.busi.B_ReviewDAO;
import dao.busi.B_Review_ImgDAO;
import dao.busi.B_Review_KeyDAO;
import dao.busi.BusiDAO;
import dao.busi.Busi_CateDAO;
import dao.busi.CouponDAO;
import dao.busi.Coupon_DownDAO;
import dao.busi.DayDAO;
import dao.busi.HolidayDAO;
import dao.busi.HoursDAO;
import dao.busi.NoticeDAO;
import dao.busi.Notice_CmtDAO;
import dao.busi.Notice_ImgDAO;
import dao.busi.ProductDAO;
import dao.busi.RuntypeDAO;
import dao.member.MemberDAO;
import vo.addr.Addr3VO;
import vo.busi.B_ImgVO;
import vo.busi.B_RegularVO;
import vo.busi.B_ReviewVO;
import vo.busi.B_Review_ImgVO;
import vo.busi.B_Review_KeyVO;
import vo.busi.BusiVO;
import vo.busi.Busi_CateVO;
import vo.busi.CouponVO;
import vo.busi.Coupon_DownVO;
import vo.busi.DayVO;
import vo.busi.HolidayVO;
import vo.busi.HoursVO;
import vo.busi.NoticeVO;
import vo.busi.Notice_CmtVO;
import vo.busi.Notice_ImgVO;
import vo.busi.ProductVO;
import vo.busi.RuntypeVO;
import vo.member.MemberVO;

public class BusiService {

	private BusiDAO busiDao;
	private Addr3DAO addr3Dao;
	private Busi_CateDAO busi_cateDao;
	private B_ImgDAO b_ImgDao;
	private NoticeDAO noticeDao;
	private Notice_ImgDAO notice_ImgDao;
	private HolidayDAO holidayDao;
	private DayDAO dayDao;
	private RuntypeDAO runtypeDao;
	private HoursDAO hoursDao;
	private ProductDAO productDao;
	private MemberDAO memberDao;
	private Notice_CmtDAO notice_CmtDao;
	private CouponDAO couponDao;
	private B_RegularDAO b_RegularDao;
	private Coupon_DownDAO coupon_DownDao;
	private B_Review_ImgDAO b_Review_ImgDao;
	private B_ReviewDAO b_ReviewDao;
	private B_Review_KeyDAO b_Review_KeyDao;
	
	@Autowired
	public BusiService(BusiDAO busiDao, 
						Addr3DAO addr3Dao, 
						Busi_CateDAO busi_cateDao, 
						B_ImgDAO b_ImgDao, 
						NoticeDAO noticeDao, 
						Notice_ImgDAO notice_ImgDao, 
						HolidayDAO holidayDao, 
						DayDAO dayDao,
						RuntypeDAO runtypeDao,
						HoursDAO hoursDao,
						ProductDAO productDao,
						MemberDAO memberDao,
						Notice_CmtDAO notice_CmtDao,
						CouponDAO couponDao,
						B_RegularDAO b_RegularDao,
						Coupon_DownDAO coupon_DownDao,
						B_Review_ImgDAO b_Review_ImgDao,
						B_ReviewDAO b_ReviewDao,
						B_Review_KeyDAO b_Review_KeyDao) {
		this.busiDao = busiDao;
		this.addr3Dao = addr3Dao;
		this.busi_cateDao = busi_cateDao;
		this.b_ImgDao = b_ImgDao;
		this.noticeDao = noticeDao;
		this.notice_ImgDao = notice_ImgDao;
		this.holidayDao = holidayDao;
		this.dayDao = dayDao;
		this.runtypeDao = runtypeDao;
		this.hoursDao = hoursDao;
		this.productDao = productDao;
		this.memberDao = memberDao;
		this.notice_CmtDao = notice_CmtDao;
		this.couponDao = couponDao;
		this.b_RegularDao = b_RegularDao;
		this.coupon_DownDao = coupon_DownDao;
		this.b_Review_ImgDao = b_Review_ImgDao;
		this.b_ReviewDao = b_ReviewDao;
		this.b_Review_KeyDao = b_Review_KeyDao;
	}
	
	
	public int insert(BusiVO vo) {
		return busiDao.insert(vo);
	}
	
	public int update(BusiVO vo) {
		return busiDao.update(vo);
	}
	
	public int updateBusiProfile(BusiVO vo) {
		return busiDao.updateBusiProfile(vo);
	}
	
	public int delete(int busi_seq) {
		return busiDao.delete(busi_seq);
	}
	
	
	public List<BusiVO> selectList(){
		return busiDao.selectList();
	}
	
	public BusiVO selectOneBusi(int busi_seq) {
		return busiDao.selectOne(busi_seq);
	}
	
	public int getTotal() {
		return busiDao.getTotal();
	}
	

	
	
	public List<Addr3VO> searchAddr3(String addr3_name){
		//System.out.println("서비스 실행중?? " +addr3_name);
		return addr3Dao.searchAddr3(addr3_name);
	}
	
	public Addr3VO selectAddr(int addr3_no) {
		return addr3Dao.selectAddr(addr3_no);
	}
	
	public int selectAddr3_No(String addr3_name) {
		return addr3Dao.selectAddr3_No(addr3_name);
	}
	
	public int maxSeq() {
		return busiDao.maxSeq();
	}
	
	public List<BusiVO> selectMyBusiList(int m_seq){
		return busiDao.selectMyBusiList(m_seq);
	}
	
	public int selectM_seqInBusi(int busi_seq) {
		return busiDao.selectM_seqInBusi(busi_seq);
	}
	
	public List<BusiVO> selectMyRegList(int m_seq){
		return busiDao.selectMyBusiList(m_seq);
	}
	
	
	public String selectAddr3_Name(int addr3_no) {
		return addr3Dao.selectAddr3_Name(addr3_no);
	}
	
	
	public List<Busi_CateVO> selectBusiCateList(){
		return busi_cateDao.selectBusiCateList();
	}
	
	public String selectBusi_Cate_Name(int busi_cate_seq) {
		return busi_cateDao.selectBusi_Cate_Name(busi_cate_seq);
	}
	
	
	public void insert(List<B_ImgVO> files) {
		for(B_ImgVO vo : files) {
			 b_ImgDao.insert(vo);
		}
	}
	
	public int update(B_ImgVO vo) {
		return b_ImgDao.update(vo);
	}
	
	public int deleteB_Img(int busi_seq) {
		return b_ImgDao.deleteB_Img(busi_seq);
	}
	
	
	public String selectB_Img_Name(int busi_seq) {
		String name = b_ImgDao.selectB_Img_Name(busi_seq) == null ? "none" :  b_ImgDao.selectB_Img_Name(busi_seq);
		
		return name;
	}
	
	
	public List<String> selectImgList(int busi_seq){
		return b_ImgDao.selectImgList(busi_seq);
	}
	
	
	public int insert(NoticeVO vo) {
		return noticeDao.insert(vo);
	}
	
	public int update(NoticeVO vo) {
		return noticeDao.update(vo);
	}
	
	public int updateViews(int notice_seq) {
		return noticeDao.updateViews(notice_seq);
	}
	
	public int deleteNotice(int notice_seq) {
		return noticeDao.deleteNotice(notice_seq);
	}
	
	public NoticeVO selectOneForUpdate(int notice_seq) {
		return noticeDao.selectOneForUpdate(notice_seq);
	}
	
	
	public List<NoticeVO> selectNoticeList(int busi_seq){
		List<NoticeVO> list = noticeDao.selectNoticeList(busi_seq) == null ? null: noticeDao.selectNoticeList(busi_seq);
		
		return list;
	}
	
	
	public NoticeVO selectNotice(int notice_seq){
		noticeDao.updateViews(notice_seq);
		
		return noticeDao.selectNotice(notice_seq);
	}
	
	public void insertNotice_Img(List<Notice_ImgVO> files) {
		for(Notice_ImgVO vo : files) {
			notice_ImgDao.insert(vo);
		}
	}
	
	
	public void update(List<Notice_ImgVO> files) {
		for(Notice_ImgVO vo : files) {
			notice_ImgDao.update(vo);
		}
	}
	
	public int deleteNotice_Img(int notice_seq) {
		return notice_ImgDao.deleteNotice_Img(notice_seq);
	}
	
	public List<String> selectNotice_Img_List(int notice_seq){
		return notice_ImgDao.selectNotice_Img_List(notice_seq);
	}
	
	public List<Notice_ImgVO> selectNotice_Img(int notice_seq){
		return notice_ImgDao.selectNotice_Img(notice_seq);
	}
	
	
	public int maxNotice_Seq() {
		return noticeDao.maxNotice_Seq();
	}
	
	public List<NoticeVO> selectNoticeFour(int busi_seq){
		return noticeDao.selectNoticeFour(busi_seq);
	}
	
	
	public Addr3VO selectAddrThroughBusi_seq(int busi_seq) {
		return addr3Dao.selectAddrThroughBusi_seq(busi_seq);
	}
	
	
	public List<HolidayVO> selectHoliday(){
		return holidayDao.selectHoliday();
	}
	
	
	public List<DayVO> selectDayList(){
		return dayDao.selectDayList();
	}
	
	
	public List<RuntypeVO> selectRuntype(){
		return runtypeDao.selectRuntype();
	}
	
	
	public int insert(HoursVO vo) {
		return hoursDao.insert(vo);
	}
	
	public int update(HoursVO vo) {
		return hoursDao.update(vo);
	}
	
	public int deleteHours(int hours_seq) {
		return hoursDao.deleteHours(hours_seq);
	}
	
	public List<HoursVO> selectHours(int busi_seq){
		return hoursDao.selectHours(busi_seq);
	}
	
	public int selectHours_maxSeq() {
		return hoursDao.selectHours_maxSeq();
	}
	
	
	public int insert(ProductVO vo) {
		return productDao.insert(vo);
	}
	
	public int update(ProductVO vo) {
		return productDao.update(vo);
	}
	
	public int deleteProduct(int product_seq) {
		return productDao.deleteProduct(product_seq);
	}
	
	public List<ProductVO> selectProductList(int busi_seq){
		return productDao.selectProductList(busi_seq);
	}
	
	public List<ProductVO> selectProductsFour(int busi_seq){
		return productDao.selectProductsFour(busi_seq);
	}
	
	public ProductVO selectProduct(int product_seq) {
		return productDao.selectProduct(product_seq);
	}
	
	public MemberVO selectOneM(int m_seq) {
		return memberDao.selectOneM(m_seq);
	}
	
	
	public int insert(Notice_CmtVO vo) {
		return notice_CmtDao.insert(vo);
	}
	
	public int update(Notice_CmtVO vo) {
		return notice_CmtDao.update(vo);
	}
	
	public int deleteNoticeCmtAll(int notice_seq) {
		return notice_CmtDao.deleteNoticeCmtAll(notice_seq);
	}
	
	public int deleteNoticeCmt(int notice_cmt_seq) {
		return notice_CmtDao.deleteNoticeCmt(notice_cmt_seq);
	}
	
	public List<Notice_CmtVO> selectCmtList(int notice_seq){
		return notice_CmtDao.selectCmtList(notice_seq);
	}
	
	
	public int insert(CouponVO vo) {
		return couponDao.insert(vo);
	}
	
	public int update(CouponVO vo) {
		return couponDao.update(vo);
	}
	
	public int updateAct(CouponVO vo) {
		return couponDao.updateAct(vo);
	}
	
	public int deleteCoupon(int coupon_seq) {
		return couponDao.deleteCoupon(coupon_seq);
	}
	
	public List<CouponVO> selectCouponList(int busi_seq){
		return couponDao.selectCouponList(busi_seq);
	}
	
	public List<CouponVO> selectAvailableCouponFour(int busi_seq){
		return couponDao.selectAvailableCouponFour(busi_seq);
	}
	
	public List<CouponVO> selectAvailableCoupon(int busi_seq){
		return couponDao.selectAvailableCoupon(busi_seq);
	}
	
	public CouponVO selectOneCoupon(int coupon_seq) {
		return couponDao.selectOneCoupon(coupon_seq);
	}
	
	
	public int insert(B_RegularVO vo) {
		return b_RegularDao.insert(vo);
	}
	
	public int update(B_RegularVO vo) {
		return b_RegularDao.update(vo);
	}
	
	public int deleteRegular(B_RegularVO vo) {
		return b_RegularDao.deleteRegular(vo);
	}
	
	public int countRegular(int busi_seq) {
		return b_RegularDao.countRegular(busi_seq);
	}
	
	public B_RegularVO isRegular(int m_seq) {
		return b_RegularDao.isRegular(m_seq);
	}
	
	public List<MemberVO> selectRegular_MList(int busi_seq){
		return memberDao.selectRegular_MList(busi_seq);
	}
	
	
	public int insert(Coupon_DownVO vo) {
		return coupon_DownDao.insert(vo);
	}
	
	public int update(Coupon_DownVO vo) {
		return coupon_DownDao.update(vo);
	}
	
	public int deleteCoupon_Down(int coupon_down_seq) {
		return coupon_DownDao.deleteCoupon_Down(coupon_down_seq);
	}
	
	public List<Coupon_DownVO> selectCouponDownList(int m_seq){
		return coupon_DownDao.selectCouponDownList(m_seq);
	}
	
	public Coupon_DownVO selectOneCouponDown(Coupon_DownVO vo) {
		return coupon_DownDao.selectOneCouponDown(vo);
	}
	
	
	
	public void insertReview_Img(List<B_Review_ImgVO> files) {
		for(B_Review_ImgVO vo : files) {
			b_Review_ImgDao.insert(vo);
		}
	}
	
	public void updateReview_Img(List<B_Review_ImgVO> files) {
		for(B_Review_ImgVO vo : files) {
			b_Review_ImgDao.update(vo);
		}
	}
	
	public int deleteB_ReviewImg(int b_review_seq) {
		return b_Review_ImgDao.deleteB_ReviewImg(b_review_seq);
	}
	
	public List<B_Review_ImgVO> selectB_ReviewImg_List(int b_review_seq){
		return b_Review_ImgDao.selectB_ReviewImg_List(b_review_seq);
	}
	
	
	
	public int insert(B_ReviewVO vo) {
		return b_ReviewDao.insert(vo);
	}
	
	public int update(B_ReviewVO vo) {
		return b_ReviewDao.update(vo);
	}
	
	public int deleteB_Review(int b_review_seq) {
		return b_ReviewDao.deleteB_Review(b_review_seq);
	}
	
	public List<B_ReviewVO> selectB_Review_List(int busi_seq){
		return b_ReviewDao.selectB_Review_List(busi_seq);
	}
	
	public B_ReviewVO selectB_Review_One(int b_review_seq) {
		return b_ReviewDao.selectB_Review_One(b_review_seq);
	}
	
	public int maxReview_seq() {
		return b_ReviewDao.maxReview_seq();
	}
	
	
	public int insert(B_Review_KeyVO vo) {
		return b_Review_KeyDao.insert(vo);
	}
	
	public int update(B_Review_KeyVO vo) {
		return b_Review_KeyDao.update(vo);
	}
	
	public int deleteB_Review_Key(int b_review_key_seq) {
		return b_Review_KeyDao.deleteB_Review_Key(b_review_key_seq);
	}
	
	public List<B_Review_KeyVO> selectB_ReviewKeyList(){
		return b_Review_KeyDao.selectB_ReviewKeyList();
	}
	
	public String selectB_Review_Key_Name(int b_review_key_seq) {
		return b_Review_KeyDao.selectB_Review_Key_Name(b_review_key_seq);
	}
	
	
	
	
	
	
	
	
}
