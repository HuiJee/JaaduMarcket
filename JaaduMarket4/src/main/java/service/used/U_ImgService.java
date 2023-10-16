package service.used;

import java.util.List;
import java.util.Map;

import dao.member.Bank_AccountDAO;
import dao.member.Key_SearchlistDAO;
import dao.used.U_CateDAO;
import dao.used.U_ImgDAO;
import dao.used.UsedDAO;
import vo.member.Bank_AccountVO;
import vo.member.Key_SearchlistVO;
import vo.used.Cate_CheckVO;
import vo.used.U_CateVO;
import vo.used.U_ChatVO;
import vo.used.U_FavVO;
import vo.used.U_ImgVO;
import vo.used.U_TradelistVO;
import vo.used.UsedVO;

public class U_ImgService {

	private U_ImgDAO u_imgDao;

	public U_ImgService(U_ImgDAO u_imgDao) {
		this.u_imgDao = u_imgDao;
	}

	public int insertPhoto(U_ImgVO vo) {
		return u_imgDao.insert(vo);
	}

	public boolean imgDelete(String u_img_name) {
		boolean check = false;
		if (u_imgDao.delete(u_img_name) != 0) {
			check = true;
		}

		return check;
	}

	public List<String> selectPhotos(int u_seq) {
		return u_imgDao.selectPhotos(u_seq);
	}

}
