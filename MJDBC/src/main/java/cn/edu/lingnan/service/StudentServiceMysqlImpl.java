package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.ScoreDao;
import cn.edu.lingnan.dao.ScoreDaoMysqlImpl;
import cn.edu.lingnan.dao.StudentDao;
import cn.edu.lingnan.dao.StudentDaoMysqlImpl;
import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Vector;

public class StudentServiceMysqlImpl implements StudentService {
    //业务逻辑层
    StudentDao studentDao = new StudentDaoMysqlImpl();
    ScoreDao scoreDao = new ScoreDaoMysqlImpl();

//    CourseDao courseDao = new CourseDao();

//    public boolean updateStudentPassword(String sid,String newPassword){
//        boolean flag=false;
//        Connection conn = null;
//        PreparedStatement prep = null;
//
//        try {
//            conn = DBConnection.getInstance().getConnection();
//            String sql="update student set password=? where sid=?";
//            prep = conn.prepareStatement(sql);
//
//            prep.setString(1, newPassword);
//            prep.setString(2,sid);
//            if(flag = prep.executeUpdate()==1){
//                flag = false;
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally{
//            DBConnection.getInstance().close(conn,prep);
//        }
//        return flag;
//    }

    public StudentServiceMysqlImpl() {
        super();
    }


    @Override
    public Student findStudentNameAndPassword(String sname, String password) {
        return studentDao.findStudentNameAndPassword(sname,password);//直接调用
    }

    @Override
    public List<Student> findStudentByName(String sname) {
        return studentDao.findStudentByName(sname);
    }

    @Override
    public Vector<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }

    @Override
    public Student findStudentById(String sid) {
        return studentDao.findStudentById(sid);
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return updateStudent(student);
    }

    @Override
    public boolean updateStudentPassword(String sname, String oldPassword, String newPassword) {
        boolean flag =false;
        Student student = studentDao.findStudentNameAndPassword(sname,oldPassword);//组合式调用
        System.out.println(student.getSid());//测试上一步是否执行
        if(student.getSid()!=null){
            flag = studentDao.updateStudentPassword(student.getSid(),newPassword);
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(String sid) {
        boolean flag = false;
        //查询有这个学生，删除成绩表根据学号删除
        scoreDao.deleteScoreBySid(sid);

        //接着删除学生记录，根据学号查询
        studentDao.deleteStudentBySid(sid);
        return false;
    }
}
