package cn.edu.lingnan.service;

import cn.edu.lingnan.pojo.Student;

import java.util.List;
import java.util.Vector;

public interface StudentService {
    public Student findStudentByNameAndPassword(String sname,String password);
    public List<Student> findStudentByName(String sname);
    public Vector<Student> findAllStudent();
    public Student findStudentById(String sid);
    public boolean insertStudent(Student student); //����ѧ����¼
    public boolean updateStudent(Student student);//����һλѧ����ȫ����Ϣ��������
    public boolean updateStudentPassword(String sname,String oldPassword,String newPassword);//����һ��ѧ��������
    public boolean deleteStudent(String sid);//ɾ��һ����¼ ��Service��ɾ�� ��ɾ��Score��ļ�¼ ��ɾ��student��ļ�¼
}
