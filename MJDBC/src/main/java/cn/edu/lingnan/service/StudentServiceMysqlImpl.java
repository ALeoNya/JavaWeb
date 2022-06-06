package cn.edu.lingnan.service;

import cn.edu.lingnan.dao.*;
import cn.edu.lingnan.pojo.Self;
import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Vector;

public class StudentServiceMysqlImpl implements StudentService {
    //ҵ���߼���
    StudentDao studentDao = new StudentDaoMysqlImpl();
    ScoreDao scoreDao = new ScoreDaoMysqlImpl();
    SelfCheckDao selfCheckDao = new SelfCheck();

    public StudentServiceMysqlImpl() {
        super();
    }


    @Override
    public Student findStudentByNameAndPassword(String sname, String password) {
        return studentDao.findStudentByNameAndPassword(sname,password);//ֱ�ӵ���
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
    public boolean insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean updateStudentPassword(String sname, String oldPassword, String newPassword) {
        boolean flag =false;
        Student student = studentDao.findStudentByNameAndPassword(sname,oldPassword);//���ʽ����
        System.out.println(student.getSid());//������һ���Ƿ�ִ��
        if(student.getSid()!=null){
            flag = studentDao.updateStudentPassword(student.getSid(),newPassword);
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(String sid) {
        //���Լ�� ��ɾ���ɼ����¼ ��ɾ��ѧ�����¼
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

    @Override
    public List<Self> findSelfDataByName(String sname) {
        return selfCheckDao.findSelfDataByName(sname);
    }
}
