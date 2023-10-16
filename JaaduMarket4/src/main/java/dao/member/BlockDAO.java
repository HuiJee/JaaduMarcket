package dao.member;


import org.apache.ibatis.session.SqlSession;

import vo.member.BlockVO;

public class BlockDAO {

	private SqlSession sqlSession;
	
	public BlockDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int blockAdd(BlockVO vo) {
		return sqlSession.insert("block.insert", vo);
	}
	
	public int blockDel(BlockVO vo) {
		return sqlSession.delete("block.delete", vo);
	}
	
	public BlockVO checkBlock(BlockVO vo) {
		return sqlSession.selectOne("block.checkBlock", vo);
	}
}
