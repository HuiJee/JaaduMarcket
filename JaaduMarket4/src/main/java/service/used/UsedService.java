package service.used;

import java.util.List;
import java.util.Map;

import dao.addr.Addr1DAO;
import dao.addr.Addr2DAO;
import dao.used.U_ChatDAO;
import dao.used.U_FavDAO;
import dao.used.U_TradelistDAO;
import dao.used.UsedDAO;
import vo.addr.Addr1VO;
import vo.addr.Addr2VO;
import vo.used.U_ChatVO;
import vo.used.U_FavVO;
import vo.used.U_TradelistVO;
import vo.used.UsedVO;

public class UsedService {

	private UsedDAO usedDao;
	private U_ChatDAO u_chatDao;
	private U_TradelistDAO u_tradelistDao;
	private U_FavDAO u_favDao;
	private Addr1DAO addr1Dao;
	private Addr2DAO addr2Dao;

	public UsedService(UsedDAO usedDao, U_ChatDAO u_chatDao, 
			U_TradelistDAO u_tradelistDao, U_FavDAO u_favDao,
			Addr1DAO addr1dao, Addr2DAO addr2dao) {
		this.usedDao = usedDao;
		this.u_chatDao = u_chatDao;
		this.u_tradelistDao = u_tradelistDao;
		this.u_favDao = u_favDao;
		this.addr1Dao = addr1dao;
		this.addr2Dao = addr2dao;
	}

	// 게시물 작성
	public int insert(UsedVO vo) {
		return usedDao.insert(vo);
	}

	// 게시물 클릭 시 상세	
	public UsedVO selectOne(int u_seq) {
		return usedDao.selectOne(u_seq);
	}

	// 채팅용 판매자 정보
	public UsedVO selectOnly(int u_seq) {
		return usedDao.selectOnly(u_seq);
	}
	
	// 조회수 증가
	public int plusHit(int u_seq) {
		return usedDao.plusHit(u_seq);
	}
	
	// 사진 저장하기 위해 최근 seq 뽑기
	public int maxSeq() {
		return usedDao.maxSeq();
	}

	// 여러 가지 리스트 뽑기
	public List<UsedVO> selectList(Map<String, Object> map) {
		return usedDao.selectList(map);
	}
	
	// 시도 리스트 뽑기
	public List<Addr1VO> selectAddr1(){
		return addr1Dao.selectList();
	}
	
	// 특정 시도에 해당하는 시군구 뽑기
	public List<Addr2VO> selectAddr2(int addr1_no){
		return addr2Dao.selectSome(addr1_no);
	}

	// 관심 체크 여부
	public boolean checkFav(U_FavVO vo) {
		boolean check = false;
		if (u_favDao.checkFav(vo) != null) {
			check = true;
		}
		return check;
	}

	// 관심
	public boolean addFav(U_FavVO vo) {
		boolean check = false;
		if (u_favDao.addFav(vo) != 0) {
			check = true;
		}
		return check;
	}

	// 관심 해제
	public boolean delFav(U_FavVO vo) {
		boolean check = false;
		if (u_favDao.delFav(vo) != 0) {
			check = true;
		}
		return check;
	}

	// 게시물 삭제
	public int delete(int u_seq) {
		int su = usedDao.delete(u_seq);
		return su;
	}

	// 판매여부(판매)
	public boolean sell(int u_seq) {
		boolean check = false;
		if (usedDao.sell(u_seq) != 0) {
			check = true;
		}
		return check;
	}
	
	// 판매여부(예약)-자두페이 송금 대기중
	public int reserve(int u_seq) {
		return usedDao.reserve(u_seq);
	}

	// 판매여부 체크
	public boolean checkSell(int u_seq) {
		boolean check = false;
		if (usedDao.checkSell(u_seq) == 1) {
			check = true;
		}
		return check;
	}

	// 관심 수 count
	public int favCount(int u_seq) {
		return u_favDao.favCount(u_seq);
	}

	// 인기 게시물
	public List<UsedVO> topSelect() {
		return usedDao.topSelect();
	}

	// 전체 게시물 수
	public int allCount() {
		return usedDao.allCount();
	}

	// 상황별 게시물 수
	public int someCount(Map<String, Object> map) {
		return usedDao.someCount(map);
	}

	// 게시물 테이블 전체
	public UsedVO getOne(int u_seq) {
		return usedDao.getOne(u_seq);
	}

	// 게시물 수정
	public int update(UsedVO vo) {
		return usedDao.update(vo);
	}

	// 끌올 여부(1일 1회 제한)
	public boolean checkBoost(int u_seq) {
		boolean check = false;
		if (usedDao.checkBoost(u_seq) != 0) {
			check = true;
		}
		return check;
	}

	// 끌올
	public boolean boost(int u_seq) {
		boolean check = false;
		if (usedDao.boost(u_seq) != 0) {
			check = true;
		}
		return check;
	}

	// 내 게시물 6개
	public List<UsedVO> selectMine(int m_seq) {
		return usedDao.selectMine(m_seq);
	}
	
//////////////////// 채팅 ////////////////////////////////////
	
	// 채팅
	public int chatInsert(U_ChatVO vo) {
		return u_chatDao.chatInsert(vo);
	}

	// 한 채팅의 대화내역
	public List<U_ChatVO> oneChat(U_ChatVO vo) {
		return u_chatDao.oneChat(vo);
	}
	
	// 게시물 채팅 수
	public int oneCount(int u_seq) {
		return u_chatDao.oneCount(u_seq);
	}

//////////////////// 거래 ////////////////////////////////////
	
	// 거래
	public int tradeInsert(U_TradelistVO vo) {
		return u_tradelistDao.tradeInsert(vo);
	}
	
	// 해당 게시물이 나로 예약되었는지
	public int myReserve(U_TradelistVO vo) {
		return u_tradelistDao.myReserve(vo);
	}
	
	// 거래 예약 -> 송금 완료
	public int sellFinish(int u_seq) {
		return u_tradelistDao.sellFinish(u_seq);
	}
	
	// 거래 내역 삭제
	public int tradeDelete(int u_seq) {
		return u_tradelistDao.tradeDelete(u_seq);
	}
	
	// 거래 취소(status 변경)
	public int noSell(int u_seq) {
		return usedDao.noSell(u_seq);
	}
	
	// 게시물 구매자 확인
	public int whoBuy(int u_seq) {
		return u_tradelistDao.whoBuy(u_seq);
	}
	
	// 나의 구매내역 count
	public int myBuyCount(int buyer_seq) {
		return usedDao.myBuyCount(buyer_seq);
	}
	
	// 나의 구매내역
	public List<UsedVO> myBuy(Map<String, Object> map){
		return usedDao.myBuy(map);
	}
	
	// 거래 수단
	public int tradeType(int u_seq) {
		return u_tradelistDao.tradeType(u_seq);
	}

}
