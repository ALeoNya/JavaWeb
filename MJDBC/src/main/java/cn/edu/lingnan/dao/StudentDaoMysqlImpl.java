package cn.edu.lingnan.dao;

//import jdk.internal.access.JavaIOFileDescriptorAccess;

import cn.edu.lingnan.pojo.Student;
import cn.edu.lingnan.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StudentDaoMysqlImpl implements StudentDao{
    public boolean findStudentByNameAndPassword;

    //(1)laoding(��¼����):username,password
    //���ҳɹ�Ϊtrue
    public Student findStudentNameAndPassword(String sname,String password){
        Student student = new Student();
        //�м�Ϊ������
        ResultSet rs = null;//�����ݿ��ѯ���ص��������
        Connection conn = null;//������ԭ����JDBC�У�ÿ�������ݿ�����������Ȼ�ȡConnection����Ȼ���ڷ���ִ�������close()�������ͷ���Դ��
        PreparedStatement prep = null;//��Ԥ�����,���������������Դ�����Ч��. Ҳ��JDBC�洢����

        try {
            conn = DBConnection.getInstance().getConnection();//�������ö����Ա�������JDBC�ĳ�ʼ��
            //3.����sql������(Ԥ������sql������)
            String sql="select*from student where sname = ? and password = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1,sname);
            prep.setString(2,password);
            rs = prep.executeQuery();
                                        /*
                                        * ִ�в�ѯ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ⣬
                                        * executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ�á�
                                        * ����䣺ResultSet rs=s.executeQuery(sql);ʹ��Ԥ��������Ҫ����sql��������
            * */
            //5.�������,����
                if(rs.next())
                    student.setSid(rs.getString("sid"));
                    student.setSname(rs.getString("sname"));
                    student.setPassword(rs.getString("password"));
                    student.setSuperuser(rs.getInt("superuser"));
                    student.setFlag(rs.getInt("flag"));
                                                                    /*
                                                                    *ResultSet.next()����,��ָ��ӵ�ǰλ������һ�С�ResultSet ָ�����λ�ڵ�һ��֮ǰ��
                                                                    * ��һ�ε��� next ����ʹ��һ�г�Ϊ��ǰ�У��ڶ��ε���ʹ�ڶ��г�Ϊ��ǰ�У��������ơ�
                                                                    * ����µĵ�ǰ����Ч���򷵻� true�������������һ�У��򷵻� false.
                                                                    * if(rs.next()) //rs���ж�ȡһ�� �ж��Ƿ������� */
            } catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep,rs);
        }
        return  student;
    }

    //(2)����������ѧ��(ģ����ѯ)
    public List<Student> findStudentByName(String sname){
        //ģ����ѯlik

        List<Student> list = new ArrayList<Student>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stata = null;

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            //��һ���ĵط�
            conn = DBConnection.getInstance().getConnection();
            String sql="select*from student where sname like '%"+sname+"%'";
//            System.out.println("[Debug]sql:"+sql);
            stata = conn.createStatement();
            rs = stata.executeQuery(sql);
            //5.�������,����(��һ���ĵط�)

            while(rs.next()){
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSname(rs.getString("sname"));
                s.setPassword(rs.getString("password"));
                s.setSuperuser(rs.getInt("superuser"));
                s.setFlag(rs.getInt("flag"));
                list.add(s); //��list�����Ӳ�ѯ���Ľ��
            }
                                                            /*while��������ѭ������� ���仰˵ ����"���������ﻹ��ֵ" û����ֹͣѭ�� ���һ����JSP����ʾ��
                                                            * while(rs.next()) //���� ��rsȫ�����ж�ȡ*/
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,stata,rs);
        }
        return  list;
    }

    //(3)��ѯ����ѧ����¼(DJDBCģ��)
    public Vector<Student> findAllStudent(){
        Vector<Student> vector = new Vector<Student>();


        ResultSet rs = null;
        Connection conn = null;
        Statement stata = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="select*from student";
            stata = conn.createStatement();
            rs = stata.executeQuery(sql);

            while(rs.next()){
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSname(rs.getString("sname"));
                s.setPassword(rs.getString("password"));
                s.setSuperuser(rs.getInt("superuser"));
                s.setFlag(rs.getInt("flag"));
                vector.add(s);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,stata,rs);
        }
        return vector;
    }

    //(4)��ID��ѯ
     public Student findStudentById(String sid){
         Student s = new Student();
         ResultSet rs = null;
         Connection conn = null;
         PreparedStatement prep = null;

         try {
             conn = DBConnection.getInstance().getConnection();
             String sql="select*from student where sid = ?";
             prep = conn.prepareStatement(sql);
             prep.setString(1,sid);
             rs = prep.executeQuery();

             if(rs.next())
                 s.setSid(rs.getString("sid"));
                 s.setSname(rs.getString("sname"));
                 s.setPassword(rs.getString("password"));
                 s.setSuperuser(rs.getInt("superuser"));
                 s.setFlag(rs.getInt("flag"));
         } catch(SQLException e){
             e.printStackTrace();
         }finally{
             DBConnection.getInstance().close(conn,prep,rs);
         }
         return s;


     }

    //(5)����һ��ѧ����¼��ע��ʹ��
    public int insertStudent(Student student){
        int flag=0;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="insert into student values(?,?,?,?,?)";
            prep = conn.prepareStatement(sql);


            prep.setString(1, student.getSid());
            prep.setString(2, student.getSname());
            prep.setString(3, student.getPassword());
            prep.setInt(4, student.getSuperuser());
            prep.setInt(5, student.getFlag());
            prep.executeQuery();
            flag = prep.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }
        return flag;
    }

    //(6)����һλѧ����ȫ����Ϣ��������
    public boolean updateStudent(Student student){
        boolean flag=false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="update student set sname=?,password=?,spueruser=?,flag=?where sid=?";
            prep = conn.prepareStatement(sql);

            prep.setString(1, student.getSname());
            prep.setString(2, student.getPassword());
            prep.setInt(3, student.getSuperuser());
            prep.setInt(4, student.getFlag());
            prep.setString(5, student.getSid());

            prep.executeQuery();
            flag = prep.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }
        return flag;
    }

    //(7)��ѧ��������
    public boolean updateStudentPassword(String sid,String newPassword) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="update student set password=?where sid=?";
            prep = conn.prepareStatement(sql);

            prep.setString(1,sid);
            prep.setString(2,newPassword);
            if(prep.executeUpdate()==1){
                flag = true;
            }
//            System.out.println(flag);//����


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }

        return flag;
    }

    //(8)ɾ��ѧ����¼
    public boolean deleteStudentBySid(String sid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="delete from student where sid = ?";
            prep = conn.prepareStatement(sql);

            prep.setString(1,sid);
            if(prep.executeUpdate()==1){
                flag = true;
            }
//            System.out.println(flag);//����


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }
        return false;
    }




}