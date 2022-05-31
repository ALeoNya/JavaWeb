package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentService;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;
import org.junit.Test;

public class StudentServiceTest {//DBConnection2.0读不到
    @Test//(1)登录
    public void findStudentByNameAndPasswordTest(){
        StudentDao studentDao = new StudentDaoMysqlImpl();//mysql实现
//        StudentDao studentDao = new StudentDaoOracleImpl();//OracleImpl实现
        System.out.println(studentDao.findStudentByNameAndPassword("admin","admin"));
    }

    @Test//(2)根据名字查找ok
    public void findStudentByNameTest(){
        StudentDaoMysqlImpl studentDao = new StudentDaoMysqlImpl();
        for(Student student:studentDao.findStudentByName("admin")){
            System.out.println(student.toString());
        }

//        List<Student> list =  studentDao.findStudentByName("zhang");
//        for(Student student : list){
//            System.out.println(student.toString());
//        }
    }

@Test//找所有记录ok
    public void findAllStudentText(){
        StudentDaoMysqlImpl studentDao = new StudentDaoMysqlImpl();
        for(Student student:studentDao.findAllStudent()){
            System.out.println(student.toString());
        }
    }

    @Test//(4)id-ok
    public void findStudentById(){
        StudentDao studentDao = new StudentDaoMysqlImpl();
        System.out.println(studentDao.findStudentById("s00").toString());
    }

    @Test//(5)添加一条记录ok
    public  void insertStudentTest(){
        StudentDaoMysqlImpl studentDao = new StudentDaoMysqlImpl();
        Student student = new Student();
        student.setSid("s10");
        student.setSname("aaa");
        student.setSuperuser(0);
        student.setPassword("aaa");
        student.setFlag(0);
        System.out.println("已添加一条学生记录");
    }

    @Test//(6)更新一位学生的全部信息除了主键
    public void updateStudent(){
        StudentDaoMysqlImpl studentDao = new StudentDaoMysqlImpl();
        Student student = new Student();
        student.setSid("s04");
        student.setSname("ddd");
        student.setSuperuser(0);
        student.setPassword("ddd");
        student.setFlag(0);
        System.out.println("已gx一条学生记录");
    }

    @Test//(7)改学生的密码
    public void updateStudentPasswordText(){
        StudentService studentService = new StudentServiceMysqlImpl();
        studentService.updateStudentPassword("s10","aa","bbb");

    }

    //(8)删除学生记录
    @Test
    public void deleteStudentBySid(){
        StudentService studentService = new StudentServiceMysqlImpl();
        System.out.println(studentService.deleteStudent("s04"));
    }

}
