package swust.edu.cn.zzxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swust.edu.cn.zzxt.dao.GjjxjMapper;
import swust.edu.cn.zzxt.dao.GjzxjMapper;
import swust.edu.cn.zzxt.dao.InstitutionMapper;
import swust.edu.cn.zzxt.dao.InstructorMapper;
import swust.edu.cn.zzxt.dao.LstdMapper;
import swust.edu.cn.zzxt.dao.MajorMapper;
import swust.edu.cn.zzxt.dao.RewardMapper;
import swust.edu.cn.zzxt.dao.StudentMapper;
import swust.edu.cn.zzxt.dao.StudentclassMapper;
import swust.edu.cn.zzxt.dao.StudentinfoMapper;
import swust.edu.cn.zzxt.dao.UserMapper;
import swust.edu.cn.zzxt.dao.WorkstepfolwMapper;
import swust.edu.cn.zzxt.model.Gjjxj;
import swust.edu.cn.zzxt.model.GjjxjWithBLOBs;
import swust.edu.cn.zzxt.model.Gjzxj;
import swust.edu.cn.zzxt.model.GjzxjWithBLOBs;
import swust.edu.cn.zzxt.model.Institution;
import swust.edu.cn.zzxt.model.Major;
import swust.edu.cn.zzxt.model.Student;
import swust.edu.cn.zzxt.model.Studentclass;
import swust.edu.cn.zzxt.model.Studentinfo;
import swust.edu.cn.zzxt.model.User;
import swust.edu.cn.zzxt.model.Workstepfolw;
import swust.edu.cn.zzxt.selfmodel.CountModal;
import swust.edu.cn.zzxt.selfmodel.ListModal;
import swust.edu.cn.zzxt.selfmodel.LstdListModel;
import swust.edu.cn.zzxt.service.CommonService;

@Service("CommonServiceImpl")
public class CommonServiceImpl implements CommonService {
    private UserMapper userMapper;
    private StudentMapper studentMapper;
    private StudentclassMapper studentclassMapper;
    private StudentinfoMapper studentinfoMapper;
    private WorkstepfolwMapper workstepfolwMapper;
    private MajorMapper majorMapper;
    private InstitutionMapper institutionMapper;
    private GjzxjMapper gjzxjMapper;
    private RewardMapper rewardMapper;
    private GjjxjMapper gjjxjMapper;
    private InstructorMapper instructorMapper;
    private LstdMapper lstdMapper;
    private List<ListModal> listModals;

    public LstdMapper getLstdMapper() {
        return lstdMapper;
    }

    @Autowired
    public void setLstdMapper(LstdMapper lstdMapper) {
        this.lstdMapper = lstdMapper;
    }

    public InstructorMapper getInstructorMapper() {
        return instructorMapper;
    }

    @Autowired
    public void setInstructorMapper(InstructorMapper instructorMapper) {
        this.instructorMapper = instructorMapper;
    }

    public GjjxjMapper getGjjxjMapper() {
        return gjjxjMapper;
    }

    @Autowired
    public void setGjjxjMapper(GjjxjMapper gjjxjMapper) {
        this.gjjxjMapper = gjjxjMapper;
    }

    public RewardMapper getRewardMapper() {
        return rewardMapper;
    }

    @Autowired
    public void setRewardMapper(RewardMapper rewardMapper) {
        this.rewardMapper = rewardMapper;
    }

    public InstitutionMapper getInstitutionMapper() {
        return institutionMapper;
    }

    @Autowired
    public void setInstitutionMapper(InstitutionMapper institutionMapper) {
        this.institutionMapper = institutionMapper;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public StudentclassMapper getStudentclassMapper() {
        return studentclassMapper;
    }

    @Autowired
    public void setStudentclassMapper(StudentclassMapper studentclassMapper) {
        this.studentclassMapper = studentclassMapper;
    }

    public StudentinfoMapper getStudentinfoMapper() {
        return studentinfoMapper;
    }

    @Autowired
    public void setStudentinfoMapper(StudentinfoMapper studentinfoMapper) {
        this.studentinfoMapper = studentinfoMapper;
    }

    public WorkstepfolwMapper getWorkstepfolwMapper() {
        return workstepfolwMapper;
    }

    @Autowired
    public void setWorkstepfolwMapper(WorkstepfolwMapper workstepfolwMapper) {
        this.workstepfolwMapper = workstepfolwMapper;
    }

    public MajorMapper getMajorMapper() {
        return majorMapper;
    }

    @Autowired
    public void setMajorMapper(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    public GjzxjMapper getGjzxjMapper() {
        return gjzxjMapper;
    }

    @Autowired
    public void setGjzxjMapper(GjzxjMapper gjzxjMapper) {
        this.gjzxjMapper = gjzxjMapper;
    }

    @SuppressWarnings("finally")
    public List<CountModal> findAllCountInfo(int userid, int workid, List<ListModal> listModals) {
        List<CountModal> countModals = new ArrayList<CountModal>();
        List<Institution> institutions = new ArrayList<Institution>();
        User user = userMapper.selectByPrimaryKey(userid);
        try {
            if (user.getUserType() == 6) {
                institutions = institutionMapper.selectAllInstitutions();
                for (int i = 0; i < institutions.size(); ++i) {
                    CountModal countModal = new CountModal();
                    List<ListModal> applyStudents = null;
                    List<User> allStudents = userMapper.selectStuUserByInstId(institutions.get(i).getInstId());
                    if (workid == 7)
                        applyStudents = gjjxjMapper.selectAcademyAllList(institutions.get(i).getInstId());
                    else {
                        applyStudents = gjzxjMapper.selectAcademyAllList(institutions.get(i).getInstId());
                    }
                    int passsum = 0;
                    for (int j = 0; j < applyStudents.size(); ++j) {
                        if (applyStudents.get(j).getStatus() == 1)
                            passsum++;
                    }
                    countModal.setPasssum(passsum);
                    countModal.setName(institutions.get(i).getInstName());
                    countModal.setInstid(institutions.get(i).getInstId());
                    countModal.setApplysum(applyStudents.size());
                    countModal.setSum(allStudents.size());
                    countModals.add(countModal);
                }
            } else if (user.getUserType() == 2) {
                List<Studentclass> studentclasses = studentclassMapper.selectByInstId(instructorMapper.selectByUserId(
                        userid).getInstId());

                for (int i = 0; i < studentclasses.size(); ++i) {
                    CountModal countModal = new CountModal();
                    int sum = studentMapper.selectByClassId(studentclasses.get(i).getClassId()).size();// 记录班级总人数
                    int applysum = 0;
                    int passsum = 0;

                    for (int j = 0; j < listModals.size(); ++j) {
                        if (listModals.get(j).getStuclassid() == studentclasses.get(i).getClassId()) {
                            applysum++;

                            if (listModals.get(j).getStatus() == 1)
                                passsum++;
                        }
                    }
                    countModal.setName(studentclasses.get(i).getClassName());
                    countModal.setPasssum(passsum);
                    countModal.setInstid(studentclasses.get(i).getClassId());
                    countModal.setApplysum(applysum);
                    countModal.setSum(sum);
                    countModals.add(countModal);
                }
            } else if (user.getUserType() > 2 && user.getUserType() < 6) {
                List<Major> majors = majorMapper.selectByInstId(user.getUserInstid());
                for (int i = 0; i < majors.size(); ++i) {
                    CountModal countModal = new CountModal();
                    int sum = studentMapper.selectByMajorId(majors.get(i).getMajrId()).size();// 记录班级总人数
                    int applysum = 0;
                    int passsum = 0;

                    for (int j = 0; j < listModals.size(); ++j) {
                        if (listModals.get(j).getMajorid() == majors.get(i).getMajrId()) {
                            applysum++;

                            if (listModals.get(j).getStatus() == 1)
                                passsum++;
                        }
                    }
                    countModal.setName(majors.get(i).getMajrName());
                    countModal.setPasssum(passsum);
                    countModal.setInstid(majors.get(i).getMajrId());
                    countModal.setApplysum(applysum);
                    countModal.setSum(sum);
                    countModals.add(countModal);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (countModals.size() <= 0)
                countModals = null;
            return countModals;
        }
    }

    @SuppressWarnings("finally")
    public List<ListModal> findAllInfo(int role, int workid, int userid) {
        User user = userMapper.selectByPrimaryKey(userid);

        Student student = new Student();
        Studentinfo studentinfo = new Studentinfo();
        Studentclass studentclass = new Studentclass();
        Institution institution = new Institution();
        Major major = new Major();
        try {
            if (role == 1) {
                listModals = new ArrayList<ListModal>();
                student = studentMapper.selectInfoByUserId(userid);
                studentinfo = studentinfoMapper.selectBystudInfoStudId(student.getStudId());
                studentclass = studentclassMapper.selectByPrimaryKey(student.getStudClassid());// 获取班级信息
                institution = institutionMapper.selectByPrimaryKey(user.getUserInstid());// 获取学院
                major = majorMapper.selectByPrimaryKey(studentclass.getClassMajrid());// 获取专业

                /* 下面则是对不同工作流进行判断 做不同的处理 */
                if (workid == 10) {
                    List<GjzxjWithBLOBs> gjzxjs = new ArrayList<GjzxjWithBLOBs>();
                    gjzxjs = gjzxjMapper.selectByStuId(student.getStudId());// 获取助学金表
                    for (int i = 0; i < gjzxjs.size(); ++i) {
                        ListModal listModal = new ListModal();
                        // 如果工作流为0则表明尚未提交，则不显示该条记录；
                        if (gjzxjs.get(i).getGzxjWsflid() == 0)
                            continue;
                        if (gjzxjs.get(i).getGzxjWsflid() != -1) {
                            Workstepfolw workstepfolw = workstepfolwMapper.selectByPrimaryKey(gjzxjs.get(i)
                                    .getGzxjWsflid());
                            listModal.setStatusdescript(workstepfolw.getWsflName());
                        } else {
                            listModal.setStatusdescript("申请通过");
                        }

                        listModal.setName(student.getStudName());
                        listModal.setSex(studentinfo.getStinSex());

                        listModal.setAcademy(institution.getInstShortname());
                        listModal.setAcademyid(institution.getInstId());
                        listModal.setMajor(major.getMajrName());
                        listModal.setMajorid(major.getMajrId());
                        listModal.setStuclass(studentclass.getClassName());
                        listModal.setStuclassid(studentclass.getClassId());
                        listModal.setStatus(gjzxjs.get(i).getGzxjState());
                        listModal.setAnnual(gjzxjs.get(i).getGzxjAnnual());
                        listModal.setListid(gjzxjs.get(i).getGzxjId());
                        listModal.setStuid(student.getStudId());
                        listModal.setStunumber(student.getStudNumber());
                        listModal.setType(1);
                        
                        listModal.setIdNumber(student.getStudIdnumber());
                        listModal.setBankNumber(studentinfo.getStinBanknumber());
                        listModal.setLevel(gjzxjs.get(i).getGzxjLevel());
                        listModal.setMoney(gjzxjs.get(i).getGzxjMoney());
                        
                        listModals.add(listModal);
                    }
                } else if (workid == 7) {
                    List<GjjxjWithBLOBs> gjjxj = new ArrayList<GjjxjWithBLOBs>();
                    gjjxj = gjjxjMapper.selectByStudid(student.getStudId());// 获取助学金表
                    for (int i = 0; i < gjjxj.size(); ++i) {
                        ListModal listModal = new ListModal();
                        Workstepfolw workstepfolw = null;
                        // 如果工作流为0则表明尚未提交，则不显示该条记录；
                        if (gjjxj.get(i).getGjxjWsflid() == 0)
                            continue;
                        if (gjjxj.get(i).getGjxjWsflid() != -1) {
                            workstepfolw = workstepfolwMapper.selectByPrimaryKey(gjjxj.get(i).getGjxjWsflid());
                            listModal.setStatusdescript(workstepfolw.getWsflName());

                        } else {
                            listModal.setStatusdescript("申请通过");
                        }

                        listModal.setName(student.getStudName());
                        listModal.setSex(studentinfo.getStinSex());
                        listModal.setAcademy(institution.getInstShortname());
                        listModal.setAcademyid(institution.getInstId());
                        listModal.setMajor(major.getMajrName());
                        listModal.setMajorid(major.getMajrId());
                        listModal.setStuclass(studentclass.getClassName());
                        listModal.setStuclassid(studentclass.getClassId());
                        listModal.setStatus(gjjxj.get(i).getGjxjState());
                        listModal.setAnnual(gjjxj.get(i).getGjxjAnnual());
                        listModal.setListid(gjjxj.get(i).getGjxjId());
                        listModal.setStuid(student.getStudId());
                        listModal.setStunumber(student.getStudNumber());
                        listModal.setType(1);
                        
                        listModals.add(listModal);
                    }
                }
            } else if (role == 2) {
                if (workid == 10) {
                    listModals = instfindAllGjzxjInfo(role, workid, userid);
                } else if (workid == 7) {
                    listModals = instfindAllGjjxjInfo(role, workid, userid);
                }// 当角色为经办老老师以上级别 学生处级别以下时
            } else if (role > 2 && role < 15) {
                // 大于经办老师级别
                if (role > 12) {
                    if (workid == 10)
                        listModals = findAcademyGjzxjInfo(role, workid, userid);
                    if (workid == 7)
                        listModals = findAcademyGjjxjInfo(role, workid, userid);
                } else {

                    if (role == workid && workid == 10) {
                        // 助学金经办老师
                        listModals = findAcademyGjzxjInfo(role, workid, userid);
                    } else if (role == workid && workid == 7) {
                        listModals = findAcademyGjjxjInfo(role, workid, userid);
                    }
                }
            } else if (role >= 15) {
                if (workid == 10)
                    listModals = findSchoolGjzxjInfo(role, workid, userid);
                if (workid == 7)
                    listModals = findSchoolGjjxjInfo(role, workid, userid);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            return listModals;
        }
    }

    public List<ListModal> instfindAllGjzxjInfo(int role, int workid, int userid) {
        System.out.println("辅导员1");
        List<ListModal> listModals = new ArrayList<ListModal>();
        listModals = gjzxjMapper.selectClassAllList(userid);
        return listModals;
    }

    public List<ListModal> instfindAllGjjxjInfo(int role, int workid, int userid) {
        List<ListModal> listModals = new ArrayList<ListModal>();
        listModals = gjjxjMapper.selectClassAllList(userid);
        return listModals;
    }

    public List<ListModal> findAcademyGjzxjInfo(int role, int workid, int userid) {
        List<ListModal> listModals = new ArrayList<ListModal>();
        User user = userMapper.selectByPrimaryKey(userid);
        listModals = gjzxjMapper.selectAcademyAllList(user.getUserInstid());
        for (int i = 0; i < listModals.size(); ++i) {
            Gjzxj gjzxj = gjzxjMapper.selectByPrimaryKey(listModals.get(i).getListid());
            if (gjzxj.getGzxjWsflid() != -1) {
                Workstepfolw workstepfolw = workstepfolwMapper.selectByPrimaryKey(gjzxj.getGzxjWsflid());

                if (workstepfolw.getWsflRoleid() == role) {
                    listModals.get(i).setType(2);
                } else {
                    listModals.get(i).setType(1);
                }
            }
        }
        return listModals;
    }

    // gjjxj
    public List<ListModal> findAcademyGjjxjInfo(int role, int workid, int userid) {
        List<ListModal> listModals = new ArrayList<ListModal>();
        User user = userMapper.selectByPrimaryKey(userid);
        listModals = gjjxjMapper.selectAcademyAllList(user.getUserInstid());
        for (int i = 0; i < listModals.size(); ++i) {
            Gjjxj gjjxj = gjjxjMapper.selectByPrimaryKey(listModals.get(i).getListid());
            if (gjjxj.getGjxjWsflid() != -1) {
                Workstepfolw workstepfolw = workstepfolwMapper.selectByPrimaryKey(gjjxj.getGjxjWsflid());

                if (workstepfolw.getWsflRoleid() == role) {
                    listModals.get(i).setType(2);
                } else {
                    listModals.get(i).setType(1);
                }
            }
        }
        return listModals;
    }

    public List<ListModal> findSchoolGjzxjInfo(int role, int workid, int userid) {
        List<ListModal> listModals = new ArrayList<ListModal>();
        List<GjzxjWithBLOBs> gjzxjs = new ArrayList<GjzxjWithBLOBs>();
        User user = userMapper.selectByPrimaryKey(userid);
        // 获取所有表信息
        gjzxjs = gjzxjMapper.selectAllInfo();
        System.out.println(gjzxjs.size());
        for (int k = 0; k < gjzxjs.size(); ++k) {
            GjzxjWithBLOBs gjzxj = gjzxjs.get(k);// 获取当前表信息
            Student student = studentMapper.selectInfoByStuId(gjzxj.getGzxjStudid());
            Studentinfo studentinfo = studentinfoMapper.selectBystudInfoStudId(student.getStudId());
            Studentclass studentclass = studentclassMapper.selectByPrimaryKey(student.getStudClassid());
            Major major = majorMapper.selectByPrimaryKey(studentclass.getClassMajrid());
            Institution institution = institutionMapper.selectByPrimaryKey(major.getMajrInstid());
            Workstepfolw workstepfolw = new Workstepfolw();
            if (gjzxj.getGzxjWsflid() != -1)
                workstepfolw = workstepfolwMapper.selectByPrimaryKey(gjzxj.getGzxjWsflid());// 查找工作流信息
            else {
                workstepfolw = null;
            }
            ListModal listModal = new ListModal();
            listModal.setName(student.getStudName());
            System.out.println(student.getStudId());
            System.out.println(studentinfo);
            listModal.setSex(studentinfo.getStinSex());
            listModal.setAcademy(institution.getInstShortname());
            listModal.setAcademyid(institution.getInstId());
            listModal.setMajor(major.getMajrName());
            listModal.setMajorid(major.getMajrId());
            listModal.setStuclass(studentclass.getClassName());
            listModal.setStuclassid(studentclass.getClassId());
            listModal.setStatus(gjzxj.getGzxjState());
            listModal.setAnnual(gjzxj.getGzxjAnnual());
            listModal.setListid(gjzxj.getGzxjId());
            listModal.setStuid(student.getStudId());
            listModal.setStunumber(student.getStudNumber());
            
            listModal.setIdNumber(student.getStudIdnumber());
            listModal.setBankNumber(studentinfo.getStinBanknumber());
            listModal.setLevel(gjzxj.getGzxjLevel());
            listModal.setMoney(gjzxj.getGzxjMoney());
            
            if (workstepfolw == null || workstepfolw.getWsflRoleid() != role) {
                listModal.setType(1);// 不能修改
            } else {
                listModal.setType(2);// 可修改
            }
            if (workstepfolw != null)
                listModal.setStatusdescript(workstepfolw.getWsflName());
            else {
                listModal.setStatusdescript("审核通过！");
            }
            listModals.add(listModal);
        }
        return listModals;
    }

    public List<ListModal> findSchoolGjjxjInfo(int role, int workid, int userid) {
        List<ListModal> listModals = new ArrayList<ListModal>();
        List<GjjxjWithBLOBs> gjjxjWithBLOBs = new ArrayList<GjjxjWithBLOBs>();
        User user = userMapper.selectByPrimaryKey(userid);
        // 获取所有表信息
        gjjxjWithBLOBs = gjjxjMapper.selectAllInfo();
        for (int k = 0; k < gjjxjWithBLOBs.size(); ++k) {
            GjjxjWithBLOBs gjjxjWithBLOBs2 = gjjxjWithBLOBs.get(k);// 获取当前表信息
            Student student = studentMapper.selectInfoByStuId(gjjxjWithBLOBs2.getGjxjStudid());
            Studentinfo studentinfo = studentinfoMapper.selectBystudInfoStudId(student.getStudId());
            Studentclass studentclass = studentclassMapper.selectByPrimaryKey(student.getStudClassid());
            Major major = majorMapper.selectByPrimaryKey(studentclass.getClassMajrid());
            Institution institution = institutionMapper.selectByPrimaryKey(major.getMajrInstid());
            Workstepfolw workstepfolw = new Workstepfolw();
            if (gjjxjWithBLOBs2.getGjxjWsflid() != -1)
                workstepfolw = workstepfolwMapper.selectByPrimaryKey(gjjxjWithBLOBs2.getGjxjWsflid());// 查找工作流信息
            else {
                workstepfolw = null;
            }
            ListModal listModal = new ListModal();
            listModal.setName(student.getStudName());
            listModal.setSex(studentinfo.getStinSex());
            listModal.setAcademy(institution.getInstShortname());
            listModal.setAcademyid(institution.getInstId());
            listModal.setMajor(major.getMajrShortname());
            listModal.setMajorid(major.getMajrId());
            listModal.setStuclass(studentclass.getClassName());
            listModal.setStuclassid(studentclass.getClassId());
            listModal.setStatus(gjjxjWithBLOBs2.getGjxjState());
            listModal.setAnnual(gjjxjWithBLOBs2.getGjxjAnnual());
            listModal.setListid(gjjxjWithBLOBs2.getGjxjId());
            listModal.setStuid(student.getStudId());
            listModal.setStunumber(student.getStudNumber());
            System.out.println(role + "---------" + workstepfolw.getWsflRoleid());
            if (workstepfolw == null || workstepfolw.getWsflRoleid() != role) {
                listModal.setType(1);// 不能修改
            } else {
                listModal.setType(2);// 可修改
            }
            if (workstepfolw != null) {
                listModal.setStatusdescript(workstepfolw.getWsflName());
            } else {
                listModal.setStatusdescript("审核通过！");
            }
            listModals.add(listModal);
        }
        return listModals;
    }


    @SuppressWarnings("finally")
    public List<CountModal> findlstdCountInfo(int workid) {
        List<CountModal> countModals = new ArrayList<CountModal>();
        List<Institution> institutions = new ArrayList<Institution>();
            try {
                institutions = institutionMapper.selectAllInstitutions();
               for (int i = 0; i < institutions.size(); ++i) {
                    CountModal countModal = new CountModal();
                    List<LstdListModel> applyStudents = null;
                    List<User> allStudents = userMapper.selectStuUserByInstId(institutions.get(i).getInstId());
                    applyStudents = lstdMapper.selectAcademyAllList(institutions.get(i).getInstId());
                    int passsum=0;
                    for(int j=0;j<applyStudents.size();j++){
                        if(applyStudents.get(j).getLstdState() == 1)
                            passsum++;
                    }
                    System.out.println(applyStudents.size()+"=====================@@");
                    countModal.setPasssum(passsum);
                    countModal.setName(institutions.get(i).getInstName());
                    countModal.setInstid(institutions.get(i).getInstId());
                    countModal.setApplysum(applyStudents.size());
                    countModal.setSum(allStudents.size());
                    countModals.add(countModal);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(countModals.size()<=0)
                    countModals = null;
                return countModals;
            }
    }

	@SuppressWarnings("finally")
	public List<CountModal> findlstdCountInfo2(int workid,Integer instid) {
		List<CountModal> countModals = new ArrayList<CountModal>();
		try {
			List<Major> major = majorMapper.selectByInstId(instid);
			for(int i=0;i<major.size();i++){
				List<Student> allStudents = null;
				allStudents = studentMapper.selectByMajorId(major.get(i).getMajrId());
				CountModal countModal = new CountModal();
                List<LstdListModel> applyStudents = null;
                applyStudents = lstdMapper.selectinfoBymajorid(major.get(i).getMajrId());
                int passum = 0;
                for(int j=0;j<applyStudents.size();j++){
                	if(applyStudents.get(j).getLstdState()==1){
                		passum++;
                	}
                }
                countModal.setName(major.get(i).getMajrName());
                countModal.setInstid(major.get(i).getMajrId());
                countModal.setPasssum(passum);
                countModal.setSum(allStudents.size());
                countModal.setApplysum(applyStudents.size());
                countModals.add(countModal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(countModals.size()<=0)
	            countModals = null;
	        return countModals;
		}
		
	}

	@SuppressWarnings("finally")
	public List<CountModal> findlstdCountInfo3(int workid, User user) {
		List<CountModal> countModals = new ArrayList<CountModal>();
		try {
			List<Studentclass> studentclass = new ArrayList<Studentclass>();
			studentclass = studentclassMapper.selectByInstId(instructorMapper.selectByUserId(user.getUserId()).getInstId());
			//List<Student> allStudents = studentMapper.selectAllStuInfoByinstUserId(user.getUserId());
			for(int i=0;i<studentclass.size();i++){
				List<Student> allStudents = studentMapper.selectByClassId(studentclass.get(i).getClassId());
				CountModal countModal = new CountModal();
			    List<LstdListModel> applyStudents = null;
			    applyStudents = lstdMapper.selectinfoByclassid(studentclass.get(i).getClassId());
			    int passum = 0;
			    for(int j=0;j<applyStudents.size();j++){
			    	if(applyStudents.get(j).getLstdState() == 1){
			    		passum++;
			    	}
			    }
			    System.out.println(studentclass.get(i).getClassName()+"@@"+allStudents.size());
			    countModal.setName(studentclass.get(i).getClassName());
			    countModal.setInstid(studentclass.get(i).getClassId());
			    countModal.setPasssum(passum);
			    countModal.setSum(allStudents.size());
			    countModal.setApplysum(applyStudents.size());
			    countModals.add(countModal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(countModals.size()<=0)
	            countModals = null;
	        return countModals;
		}
		
	}
}
