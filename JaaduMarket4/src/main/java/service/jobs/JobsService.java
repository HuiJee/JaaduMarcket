package service.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.jobs.ApplicationDAO;
import dao.jobs.ApplyDAO;
import dao.busi.DayDAO;
import dao.jobs.J_TimeDAO;

import dao.jobs.JobsDAO;

import dao.jobs.TermsDAO;
import vo.jobs.ApplicationVO;
import vo.jobs.ApplyVO;
import vo.busi.DayVO;
import vo.jobs.J_CateVO;
import vo.jobs.J_TimeVO;

import vo.jobs.JobsVO;

import vo.jobs.TermsVO;

public class JobsService {

	private JobsDAO jobsDao;
	private DayDAO dayDao;
	private TermsDAO termsDao;
	private J_TimeDAO jtimeDao;
	private ApplicationDAO applicationDao;
	private ApplyDAO applyDao;

	public JobsService(JobsDAO jobsDao, DayDAO dayDao, TermsDAO termsDao, J_TimeDAO jtimeDao,ApplicationDAO applicationDao,ApplyDAO applyDao) {
		this.jobsDao = jobsDao;
		this.dayDao = dayDao;
		this.termsDao = termsDao;
		this.jtimeDao = jtimeDao;
		this.applicationDao = applicationDao;
		this.applyDao = applyDao;
	}

	public List<DayVO> selectDayList() {
		return dayDao.selectDayList();
	}

	public List<DayVO> selectDayNameList() {
		return dayDao.selectNameList();
	}

	public List<TermsVO> selectTermsList() {
		return termsDao.selectList();
	}

	public int JCate_INsert(JobsVO jvo) {
		return jobsDao.JCate_INsert(jvo);
	}

	public int inJCateList(HashMap<String, Object> map) {
		return jobsDao.inJCateList(map);
	}

	public int insertJob(JobsVO vo) {
		return jobsDao.insertJob(vo);

	}

	public int getJSeq() {
		return jobsDao.getJSeq();
	}

	public int JTimeInsert(J_TimeVO vo) {
		return jtimeDao.JTimeInsert(vo);

	}
	
	public int JTimeUpdate(J_TimeVO vo) {
		return jtimeDao.JTimeUpdate(vo);
	}
	

	public int  JTimeDelete(int j_seq) {
		return jtimeDao.JTimeDelete(j_seq);
		
	}

	public int updateJob(JobsVO jvo) {
		return jobsDao.updateJob(jvo);
	}

	public List<JobsVO> selectList() {
		return jobsDao.selectList();
	}

	public JobsVO getJobsOne(int j_seq) {
		jobsDao.readCount(j_seq);
		return jobsDao.getJobsOne(j_seq);

	}
	

//해당회원 공고내역 조회 and 구인중
	public List<JobsVO> getJobMember(int m_seq) {
		return jobsDao.getJobMember(m_seq);
	}
	//해당회원 공고내역 조회 and 채용완료
		public List<JobsVO> getJobMember1(int m_seq) {
			return jobsDao.getJobMember1(m_seq);
		}
		//해당회원 공고내역 조회 and 거절함
		public List<JobsVO> getJobMember3(int m_seq) {
			return jobsDao.getJobMember3(m_seq);
		}

	// 장단기 요일,날짜 조회
	public List<J_TimeVO> getTimeType(int j_seq) {
		return jtimeDao.getTimeType(j_seq);
	}
	
	public int readCount(int j_seq) {
		return jobsDao.readCount(j_seq);
	}
	
	//지원서application(지원내역) CRUD
	
	public int insertApp(ApplicationVO appVO) {
		return applicationDao.insertApp(appVO);
	}
	
	public List<ApplicationVO> getApplication(int m_seq) {
		return applicationDao.getApplication(m_seq);
	}
	
	//지원서 상태 업데이트 
	public int appStatus(ApplicationVO apvo) {
	return applicationDao.appStatus(apvo);
	}
	

	//지원서(apply) 시퀀스 번호
	public int getApplySeq(int m_seq) {
		return applyDao.getApplySeq(m_seq);
	}
	
	//지원내역 count
	
	public int AppCount(int j_seq) {
		return applicationDao.AppCount(j_seq);
	}
	
	//지원서가 작성 되어 있는지 체크
	public boolean CheckApply(int m_seq) {
		return applyDao.CheckApply(m_seq);
	}
	
	//해당 회원 지원 내역 조회

	public List<ApplicationVO> getApply(int m_seq) {
		return applicationDao.SelectOne(m_seq);
	}
	
	//해당회원 제외 모든 공고리스트 조회
	
		public List<JobsVO> outOFMember(Map<String, Object> map) {
			
			List<JobsVO> list = jobsDao.outOFMember(map);
			if(list.isEmpty()) {
				list=null;
			}
			return jobsDao.outOFMember(map);
		}
		
		
	//<!-- 본인 제외 공고 게시글(구인중)개수 -->
		public int getTotal(Map<String, Object> map) {
			return jobsDao.getTotal(map);
		}
		
		//해당회원 제외 모든 공고리스트 조회(단기)
		
			public List<JobsVO> outOFMemberShort(Map<String, Object> map) {
				
				List<JobsVO> list = jobsDao.outOFMemberShort(map);
				if(list.isEmpty()) {
					list=null;
				}
				return jobsDao. outOFMemberShort(map);
			}
			
			//<!-- 본인 제외 공고 게시글(구인중)개수 -->
			public int getTotalShort(Map<String, Object> map) {
				return jobsDao.getTotalShort(map);
			}
			
		
		//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수 
		public int appCount(int m_seq) {
			return applicationDao.appCount(m_seq);
		}
		//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수 (응답대기)
		public int appCount0(int m_seq) {
			return applicationDao.appCount0(m_seq);
		}

		//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수 (채용중)
		public int appCount1(int m_seq) {
			return applicationDao.appCount1(m_seq);
		}

		//지원하기 취소 제외 해당 회원이 지원한 지원 내역 개수 (거절)
		public int appCount3(int m_seq) {
			return applicationDao.appCount3(m_seq);
		}
		
		
		//주소 포함해서 해당 공고 번호로 공고게시물 조회
		public JobsVO AllJobsOne(int j_seq) {
			jobsDao.readCount(j_seq);
			return jobsDao.AllJobsOne(j_seq);
			
		}
		
		//선택한 하는일 조회
		public List<JobsVO> CateName(int j_seq) {
			return jobsDao.CateName(j_seq);
		}

		//공고 상태 변경

		public int statusChange(JobsVO jvo) {
			
			return jobsDao.statusChange(jvo);
		}
		
		//해당지원자의 해당게시물 지원서 정보 (구직중인상태)
		public List<ApplyVO> ApplicantInfo(int j_seq) {
			return applyDao.ApplicantInfo(j_seq);
			
		}
		//해당지원자의 해당게시물 지원서 정보 (지원취소 제외)
		public List<ApplyVO> ApplicantInfo2(int j_seq) {
			return applyDao.ApplicantInfo2(j_seq);
			
		}
		//해당지원자의 해당게시물 지원서 정보 (채용완료)
		public List<ApplyVO> ApplicantInfo1(int j_seq) {
			return applyDao.ApplicantInfo1(j_seq);
			
		}
		//해당지원자의 해당게시물 지원서 정보 (거절함)
		public List<ApplyVO> ApplicantInfo3(int j_seq) {
			return applyDao.ApplicantInfo3(j_seq);
			
		}
		
		// 해당 회원 지원내역 (응답대기중 0 )  조회

		public List<ApplicationVO> waiting(int m_seq) {
			return applicationDao.waiting(m_seq);
		}

		// 해당 회원 지원내역 (채용됨 1 )  조회
		public List<ApplicationVO> doneRecruit(int m_seq) {
			return applicationDao.doneRecruit(m_seq);
		}
		//해당 회원 지원내역 (삭제 2)  조회

		public List<ApplicationVO> DeleteList(int m_seq) {
			return applicationDao.DeleteList(m_seq);
		}
		//- 해당 회원 지원내역 (거절 3)  조회

		public List<ApplicationVO> Rejected(int m_seq) {
			return applicationDao.Rejected(m_seq);
		}
		
		public int myJobCoun(int m_seq) {
			return jobsDao.myJobCoun(m_seq);
		}
		
		//<!-- 중복 지원체크 -->

		 public ApplicationVO  checkDupli(int j_seq, int m_seq) {
			
				return applicationDao.checkDupli(j_seq, m_seq);
			}
		 

		
		
	


}
