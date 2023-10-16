package service.used;

import java.util.List;
import java.util.Map;

import dao.member.Bank_AccountDAO;
import dao.member.Key_SearchlistDAO;
import dao.used.Cate_CheckDAO;
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

public class U_CateService {

	private U_CateDAO u_cateDao;
	private Cate_CheckDAO cate_checkDao;

	public U_CateService(U_CateDAO u_cateDao, Cate_CheckDAO cate_checkDao) {
		this.u_cateDao = u_cateDao;
		this.cate_checkDao = cate_checkDao;
	}

	public List<U_CateVO> cateList() {
		return u_cateDao.cateList();
	}

	public List<Cate_CheckVO> subCate() {
		return cate_checkDao.subCate();
	}

}
