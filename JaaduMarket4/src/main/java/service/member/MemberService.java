package service.member;

import java.util.List;

import dao.addr.Addr3DAO;
import dao.member.BlockDAO;
import dao.member.CollectionDAO;
import dao.member.Key_SearchlistDAO;
import dao.member.Manners_DegreeDAO;
import dao.member.MemberDAO;
import vo.addr.Addr3VO;
import vo.member.BlockVO;
import vo.member.CollectionVO;
import vo.member.Key_SearchlistVO;
import vo.member.Manners_DegreeVO;
import vo.member.MemberVO;

public class MemberService {

	private MemberDAO memberDao;
	private CollectionDAO collectionDao;
	private BlockDAO blockDao;
	private Key_SearchlistDAO key_searchlistDao;
	
	private Addr3DAO addr3Dao;

	public MemberService(MemberDAO memberDao, 
						CollectionDAO collectionDao, 
						BlockDAO blockDao,
						Key_SearchlistDAO key_searchlistDao, 
						Addr3DAO addr3Dao) {
		
		this.memberDao = memberDao;
		this.collectionDao = collectionDao;
		this.blockDao = blockDao;
		this.key_searchlistDao = key_searchlistDao;
		
		this.addr3Dao = addr3Dao;
	}

	// 새미
	public int insertMember(MemberVO vo) {
		return memberDao.insertMember(vo);
	}

	public int getSeq() {
		return memberDao.getSeq();
	}

	public int Memberupdate(MemberVO vo) {
		return memberDao.Memberupdate(vo);
	}
	
	public int selectAddr3_No(String addr3_name) {
		return addr3Dao.selectAddr3_No(addr3_name);
	}
	
	public Addr3VO selectAddr(int addr3_no) {
		return addr3Dao.selectAddr(addr3_no);
	}
	
	public List<Addr3VO> searchAddr3(String addr3_name){
		return addr3Dao.searchAddr3(addr3_name);
	}
	
	public int updateStatus(MemberVO vo) {
		return memberDao.updateStatus(vo);
	}
	 
	public boolean checkId(String m_id) {
		return memberDao.checkId(m_id) != null;
	}
	
	public Double getDegree(int m_seq){
		return memberDao.getDegree(m_seq); 
	}
	

	// 희지
	// mypage 용
	public MemberVO selectOne(int m_seq) {
		return memberDao.selectOne(m_seq);
	}

	// 닉네임 뽑기
	public String nickname(int m_seq) {
		return memberDao.nickname(m_seq);
	}

	// 모아보기 추사
	public boolean collectionAdd(CollectionVO vo) {
		boolean check = false;
		if (collectionDao.collectionAdd(vo) != 0) {
			check = true;
		}
		return check;
	}

	// 모아보기 삭제
	public boolean collectionDel(CollectionVO vo) {
		boolean check = false;
		if (collectionDao.collectionDel(vo) != 0) {
			check = true;
		}
		return check;
	}

	// 모아보기 여부
	public boolean checkCollec(CollectionVO vo) {
		boolean check = false;
		if (collectionDao.checkCollec(vo) != null) {
			check = true;
		}
		return check;
	}

	// 내가 모아본 사람들
	public List<MemberVO> myCollection(int m_seq) {
		return memberDao.myCollection(m_seq);
	}

	// 차단하기
	public boolean blockAdd(BlockVO vo) {
		boolean check = false;
		if (blockDao.blockAdd(vo) != 0) {
			check = true;
		}
		return check;
	}

	// 차단 해제
	public boolean blockDel(BlockVO vo) {
		boolean check = false;
		if (blockDao.blockDel(vo) != 0) {
			check = true;
		}
		return check;
	}

	// 차단 여부
	public boolean checkBlock(BlockVO vo) {
		boolean check = false;
		if (blockDao.checkBlock(vo) != null) {
			check = true;
		}
		return check;
	}

	// 나의 차단내역
	public List<MemberVO> myBlock(int m_seq) {
		return memberDao.myBlock(m_seq);
	}

	// 나의 채팅 리스트
	public List<MemberVO> buyerChatList(int seq) {
		return memberDao.buyerChatList(seq);
	}

	// 게시물 채팅 리스트
	public List<MemberVO> sellerChatList(int u_seq) {
		return memberDao.sellerChatList(u_seq);
	}

	// 키워드 검색
	public int keyInsert(Key_SearchlistVO vo) {
		return key_searchlistDao.keyInsert(vo);
	}

	// 내가 검색한 리스트
	public List<String> myKey(int m_seq) {
		return key_searchlistDao.myKey(m_seq);
	}
	
	// 
	public List<String> topKey(){
		return key_searchlistDao.topKey();
	}
	
	// 오늘의 키워드 순위
	public List<String> keyRanking(){
		return key_searchlistDao.keyRanking();
	}
	
	// 내가 이미 동일한 키워드 검색 했는지
	public int sameKey(Key_SearchlistVO vo) {
		return key_searchlistDao.sameKey(vo);
	}
	
	// 동일한 키워드 검색 시 검색 일자 변경
	public int keyDate(Key_SearchlistVO vo) {
		return key_searchlistDao.keyDate(vo);
	}

	// 탈퇴 시 비밀번호 일치 확인
	public int pwRight(MemberVO vo) {
		return memberDao.pwRight(vo);
	}
	
	// 탈퇴 처리
	public int delete(int m_seq) {
		return memberDao.delete(m_seq);
	}
	
}
