package service.member;

import java.util.List;

import dao.member.MannersDAO;
import dao.member.Manners_DefaultDAO;
import dao.member.Manners_DegreeDAO;
import dao.member.Manners_ListDAO;
import vo.member.MannersVO;
import vo.member.Manners_DefaultVO;
import vo.member.Manners_DegreeVO;
import vo.member.Manners_ListVO;

public class MannersService {

	private MannersDAO mannersDao;
	private Manners_DefaultDAO manners_defaultDao;
	private Manners_ListDAO manners_listDao;
	private Manners_DegreeDAO manners_degreeDao;
	
	public MannersService(MannersDAO mannersDao, Manners_DefaultDAO manners_defaultDao,
			Manners_ListDAO manners_listDao, Manners_DegreeDAO manners_degreeDao) {
		this.mannersDao = mannersDao;
		this.manners_defaultDao = manners_defaultDao;
		this.manners_listDao = manners_listDao;
		this.manners_degreeDao = manners_degreeDao;
	}
	
	// 새미
	public int InsertDegree(Manners_DegreeVO mdvo) {
		return manners_degreeDao.InsertDegree(mdvo);
	}
	
	
	// 희지
	// 기본 평가 항목
	public List<MannersVO> selectDefault(){
		return mannersDao.selectDefault();
	}
	
	// 거래 후 평가 항목
	public List<MannersVO> selectList(){
		return mannersDao.selectList();
	}
	
	// 기본 평가하기
	public int defaultInsert(Manners_DefaultVO vo) {
		return manners_defaultDao.defaultInsert(vo);
	}
	
	// 내가 한 기본 평가 삭제
	public int defaultDelete(Manners_DefaultVO vo) {
		return manners_defaultDao.defaultDelete(vo);
	}
	
	// 내가 판매자에게 한 기본 평가(거래 없이)
	public List<Manners_DefaultVO> defaultList(Manners_DefaultVO vo){
		return manners_defaultDao.defaultList(vo);
	}
	
	// 거래 후 평가하기
	public int mannersInsert(Manners_ListVO vo) {
		return manners_listDao.mannersInsert(vo);
	}
	
	// 거래 후 내가 준 평가
	public List<Manners_ListVO> mannersGive(Manners_ListVO vo) {
		return manners_listDao.mannersGive(vo);
	}
	
	// 거래 후 내가 받은 평가
	public List<Manners_ListVO> mannersReceive(Manners_ListVO vo) {
		return manners_listDao.mannersReceive(vo);
	}
	
	// 거래 후 매너평가 한 내용
	public List<String> mannersList(Manners_ListVO vo){
		return manners_listDao.mannersList(vo);
	}
	
	// 내가 한 매너평가 삭제
	public int mannersDelete(Manners_ListVO vo) {
		return manners_listDao.mannersDelete(vo);
	}
	
	// 매너온도 업데이트
	public int degreeUpdate(int m_seq) {
		return manners_degreeDao.degreeUpdate(m_seq);
	}
	
	// 거래 취소 후 매너 평가 없애기
	public int deleteAll(int u_seq) {
		return manners_listDao.deleteAll(u_seq);
	}
	
	// 나의 매너평가 중 양수
	public List<MannersVO> myMannersGood(int m_seq){
		return mannersDao.myMannersGood(m_seq);
	}
	
	// 나의 매너평가 중 음수
	public List<MannersVO> myMannersBad(int m_seq){
		return mannersDao.myMannersBad(m_seq);
	}
}
