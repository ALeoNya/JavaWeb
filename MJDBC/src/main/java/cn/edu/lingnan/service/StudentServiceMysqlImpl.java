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

    public StudentServiceMysqlImpl() {
        super();
    }


    @Override
    public Student findStudentByNameAndPassword(String sname, String password) {
        return studentDao.findStudentByNameAndPassword(sname,password);//直接调用
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
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean updateStudentPassword(String sname, String oldPassword, String newPassword) {
        boolean flag =false;
        Student student = studentDao.findStudentByNameAndPassword(sname,oldPassword);//组合式调用
        System.out.println(student.getSid());//测试上一步是否执行
        if(student.getSid()!=null){
            flag = studentDao.updateStudentPassword(student.getSid(),newPassword);
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(String sid) {
        //外键约束 先删除成绩表记录 再删除学生表记录
//        boolean flag = false;
//        if (scoreDao.deleteScoreBySid(sid)){
//            flag = studentDao.deleteStudentBySid(sid);
//        }
//        return flag;

        boolean flag = false;
        scoreDao.deleteScoreBySid(sid);
        flag = studentDao.deleteStudentBySid(sid);
        return flag;
    }



}
