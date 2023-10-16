package service.member;

import java.util.List;

import dao.member.BankDAO;
import dao.member.Bank_AccountDAO;
import dao.member.MemberDAO;
import vo.member.BankVO;
import vo.member.Bank_AccountVO;
import vo.member.MemberVO;

public class BankService {

	private BankDAO bankDao;
	private Bank_AccountDAO bank_accountDao;
	private MemberDAO memberDao;
	
	public BankService(BankDAO bankDao, Bank_AccountDAO bank_accountDao, MemberDAO memberDao) {
		this.bankDao = bankDao;
		this.bank_accountDao = bank_accountDao;
		this.memberDao = memberDao;
	}
	
	// 은행 목록
	public List<BankVO> selectList(){
		return bankDao.selectList();
	}
	
	// 계좌 등록
	public int accountInsert(Bank_AccountVO vo) {
		return bank_accountDao.insert(vo);
	}
	
	// 페이 등록 여부 1로 변경
	public int payStatus(int m_seq) {
		return memberDao.payStatus(m_seq);
	}
	
	// 계좌 등록 및 수정 전 본인인증
	public int payIdentity(MemberVO vo) {
		return memberDao.payIdentity(vo);
	}
	
	// 나의 계좌 내용
	public Bank_AccountVO accountOne(int m_seq) {
		return bank_accountDao.accountOne(m_seq);
	}
	
	// 계좌 업데이트
	public int accountUpdate(Bank_AccountVO vo) {
		return bank_accountDao.accountUpdate(vo);
	}
	
	// 충전하기
	public int chargePoint(Bank_AccountVO vo) {
		return bank_accountDao.chargePoint(vo);
	}
	
	// 거래자 모두 페이 이용하는지
	public int payUse(Bank_AccountVO vo) {
		return bank_accountDao.payUse(vo);
	}
	
	// 나의 페이 잔액
	public int myPoint(int m_seq) {
	return bank_accountDao.myPoint(m_seq);
	}
	
	// 페이 송금
	public int paySome(Bank_AccountVO vo) {
		return bank_accountDao.paySome(vo);
	}

	// 페이 입금
	public int sellSome(Bank_AccountVO vo) {
		return bank_accountDao.sellSome(vo);
	}
	
}
