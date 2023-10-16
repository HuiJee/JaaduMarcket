package service.jobs;

import java.util.List;

import dao.jobs.J_PeriodDAO;
import vo.jobs.J_PeriodVO;

public class J_PeriodService {

		private J_PeriodDAO jperiodDao;
		
		public J_PeriodService( J_PeriodDAO jperiodDao) {
			this.jperiodDao = jperiodDao;
		}
		
		public List<J_PeriodVO> getList() {
			return jperiodDao.getList();
		}

}
