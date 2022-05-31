package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.service.StudentService;
import cn.edu.lingnan.service.StudentServiceMysqlImpl;
import org.junit.Test;

public class StudentServiceTest {//DBConnection2.0������
    @Test//(1)��¼
    public void findStudentByNameAndPasswordTest(){
        StudentDao studentDao = new StudentDaoMysqlImpl();//mysqlʵ��
//        StudentDao studentDao = new StudentDaoOracleImpl();//OracleImplʵ��
        System.out.println(studentDao.findStudentByNameAndPassword("admin","admin"));
    }

    @Test//(2)�������ֲ���ok
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

@Test//�����м�¼ok
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

    @Test//(5)���һ����¼ok
    public  void insertStudentTest(){
        StudentDaoMysqlImpl studentDao = new StudentDaoMysqlImpl();
        Student student = new Student();
        student.setSid("s10");
        student.setSname("aaa");
        student.setSuperuser(0);
        student.setPassword("aaa");
        student.setFlag(0);
        System.out.println("�����һ��ѧ����¼");
    }

    @Test//(6)����һλѧ����ȫ����Ϣ��������
    public void updateStudent(){
        StudentDaoMysqlImpl studentDao = new StudentDaoMysqlImpl();
        Student student = new Student();
        student.setSid("s04");
        student.setSname("ddd");
        student.setSuperuser(0);
        student.setPassword("ddd");
        student.setFlag(0);
        System.out.println("��gxһ��ѧ����¼");
    }

    @Test//(7)��ѧ��������
    public void updateStudentPasswordText(){
        StudentService studentService = new StudentServiceMysqlImpl();
        studentService.updateStudentPassword("s10","aa","bbb");

    }

    //(8)ɾ��ѧ����¼
    @Test
    public void deleteStudentBySid(){
        StudentService studentService = new StudentServiceMysqlImpl();
        System.out.println(studentService.deleteStudent("s04"));
    }

}
