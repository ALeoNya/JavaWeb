package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Vector;

public interface StudentDao {
    public Student findStudentByNameAndPassword(String sname,String password);
    public List<Student> findStudentByName(String sname);
    public Vector<Student> findAllStudent();
    public Student findStudentById(String sid);
    public boolean insertStudent(Student student); //����ѧ����¼���ɹ�Ϊ1��ʧ��Ϊ0
    public boolean updateStudent(Student student);//����һλѧ����ȫ����Ϣ��������
    public boolean updateStudentPassword(String sname,String newPassword);//����һ��ѧ��������
    public boolean deleteStudentBySid(String sid);
}
