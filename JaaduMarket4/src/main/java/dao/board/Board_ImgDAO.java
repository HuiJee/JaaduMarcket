package dao.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.board.Board_ImgVO;

public class Board_ImgDAO {

private SqlSession sqlSession;
	
	public Board_ImgDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(Board_ImgVO vo) {
		return sqlSession.insert("board.insert",vo);
	}
	
	public int delete(int board_seq) {
		return sqlSession.delete("board.delete",board_seq);
	}
	
	public int update(Board_ImgVO vo) {
		return sqlSession.update("board.update",vo);
	}
	
	public Board_ImgVO selectOne(int board_seq) {
		return sqlSession.selectOne("board_Img.selectOne", board_seq);
	}
	
	public List<Board_ImgVO> selectBoard_ImgList(int board_seq){
		return sqlSession.selectList("board_img.selectBoard_ImgList", board_seq);
	}
}


