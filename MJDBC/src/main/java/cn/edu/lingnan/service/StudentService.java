package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.pojo.Self;
import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Vector;

public interface StudentService {
    public Student findStudentByNameAndPassword(String sname,String password);
    public List<Student> findStudentByName(String sname);
    public Vector<Student> findAllStudent();
    public Vector<Course> findAllCourse();
    public Vector<Score> findAllScore();

    public Student findStudentById(String sid);
    public boolean insertStudent(Student student); //新增学生记录
    public boolean insertCourse(Course course);
    public boolean insertScore(Score score);
    public boolean updateStudent(Student student);//更新一位学生的全部信息除了主键
    public boolean updateStudentPassword(String sname,String oldPassword,String newPassword);//更新一个学生的密码
    public boolean deleteStudent(String sid);//删除一条记录 在Service层删除 先删除Score表的记录 在删除student表的记录
    public List<Self> findSelfDataByName(String sname);
    public Vector<Student> findPass(String sname,String sid);
    public boolean updateCourse(Course course);
    public boolean updateScore(Score score);
}
