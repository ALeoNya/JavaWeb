package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Vector;

public class StudentDaoOracleImpl implements StudentDao {
    @Override
    public Student findStudentNameAndPassword(String sname, String password) {
        return null;
    }

    @Override
    public List<Student> findStudentByName(String sname) {
        return null;
    }

    @Override
    public Vector<Student> findAllStudent() {
        return null;
    }

    @Override
    public Student findStudentById(String sid) {
        return null;
    }

    @Override
    public int insertStudent(Student student) {
        return 0;
    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }

    @Override
    public boolean updateStudentPassword(String sname, String newPassword) {
        return false;
    }

    @Override
    public boolean deleteStudentBySid(String sid) {
        return false;
    }
}
