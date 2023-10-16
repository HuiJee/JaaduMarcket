package service.login;

import dao.member.MemberDAO;
import vo.member.MemberVO;

public class LoginService {

	private MemberDAO memberDao;
	
	public LoginService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public int checkLogin(MemberVO vo) {
		return memberDao.checkLogin(vo);
	}

	public String findM_id(MemberVO vo) {
		return memberDao.findId(vo);
	}

	public String findPassword(MemberVO vo) {
		return memberDao.findPw(vo);
	}

	}
