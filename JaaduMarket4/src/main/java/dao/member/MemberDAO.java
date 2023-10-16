package dao.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.member.CollectionVO;
import vo.member.MemberVO;
import vo.member.BlockVO;
import vo.used.UsedVO;

public class MemberDAO {

	private SqlSession sqlSession;

	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 단비
	public int checkLogin(MemberVO vo) {
		int m_seq = 0;

		try {
			m_seq = sqlSession.selectOne("member.checkLogin", vo);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return m_seq;
	}

	public String findId(MemberVO vo) {
		return sqlSession.selectOne("member.findId", vo);
	}

	public String findPw(MemberVO vo) {
		return sqlSession.selectOne("member.findPw", vo);
	}

	// 새미
	public int insertMember(MemberVO vo) {
		return sqlSession.insert("member.insertMember", vo);
	}

	public int Memberupdate(MemberVO vo) {
		return sqlSession.update("member.Memberupdate", vo);
	}

	public int updateStatus(MemberVO vo) {
		return sqlSession.update("member.statusUpdate", vo);
	}

	public int getSeq() {
		return sqlSession.selectOne("member.getSeq");
	}
	
	public String checkId(String m_id) {
		return sqlSession.selectOne("member.checkId", m_id);
	}
	public Double getDegree(int m_seq){
		return sqlSession.selectOne("member.getDegree", m_seq);
	}

	// 희지
	public MemberVO selectOne(int m_seq) {
		return sqlSession.selectOne("member.selectOne", m_seq);
	}

	public String nickname(int m_seq) {
		return sqlSession.selectOne("member.nickname", m_seq);
	}

	public List<MemberVO> myCollection(int m_seq) {
		return sqlSession.selectList("member.myCollection", m_seq);
	}

	public List<MemberVO> myBlock(int m_seq) {
		return sqlSession.selectList("member.myBlock", m_seq);
	}

	public int payStatus(int m_seq) {
		return sqlSession.update("member.payStatus", m_seq);
	}

	public int payIdentity(MemberVO vo) {
		return sqlSession.selectOne("member.payIdentity", vo);
	}

	public List<MemberVO> sellerChatList(int u_seq) {
		return sqlSession.selectList("member.sellerChatList", u_seq);
	}

	public List<MemberVO> buyerChatList(int seq) {
		return sqlSession.selectList("member.buyerChatList", seq);
	}
	
	public int pwRight(MemberVO vo) {
		return sqlSession.selectOne("member.pwRight", vo);
	}
	
	public int delete(int m_seq) {
		return sqlSession.update("member.delete", m_seq);
	}
	
	
	//현지
	public List<MemberVO> selectRegular_MList(int busi_seq) {
		return sqlSession.selectList("member.selectRegular_MList", busi_seq);
	}
	
	public MemberVO selectOneM(int m_seq) {
		return sqlSession.selectOne("member.selectOneM", m_seq);
	}

	
	
	
}
