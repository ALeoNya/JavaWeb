package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Vector;

public interface StudentDao {
    public Student findStudentByNameAndPassword(String sname,String password);
    public List<Student> findStudentByName(String sname);
    public Vector<Student> findAllStudent();
    public Student findStudentById(String sid);
    public boolean insertStudent(Student student); //新增学生记录，成功为1，失败为0
    public boolean updateStudent(Student student);//更新一位学生的全部信息除了主键
    public boolean updateStudentPassword(String sname,String newPassword);//更新一个学生的密码
    public boolean deleteStudentBySid(String sid);
}
