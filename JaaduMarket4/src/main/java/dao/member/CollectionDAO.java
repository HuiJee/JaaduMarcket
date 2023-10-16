package dao.member;


import org.apache.ibatis.session.SqlSession;

import vo.member.CollectionVO;

public class CollectionDAO {

	private SqlSession sqlSession;
	
	public CollectionDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int collectionAdd(CollectionVO vo) {
		return sqlSession.insert("collection.insert", vo);
	}
	
	public int collectionDel(CollectionVO vo) {
		return sqlSession.delete("collection.delete", vo);
	}
	
	public CollectionVO checkCollec(CollectionVO vo) {
		return sqlSession.selectOne("collection.checkCollec", vo);
	}
}
