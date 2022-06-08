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

    //(1)laoding(登录方法):username,password
    public Student findStudentByNameAndPassword(String sname,String password){
        Student student = new Student();
        ResultSet rs = null;//将数据库查询返回到结果集中
        Connection conn = null;//我们在原生的JDBC中，每次与数据库操作，都是先获取Connection对象，然后在方法执行完调用close()方法，释放资源。
        PreparedStatement prep = null;//是预编译的,对于批量处理可以大大提高效率. 也叫JDBC存储过程

        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            //4.执行SQL语句
            prep = conn.prepareStatement("select * from student where sname=? and password=?");
            prep.setString(1,sname);
            prep.setString(2,password);
            //5.获取结果集
            rs = prep.executeQuery();
            if(rs.next()){
                student.setSname(rs.getString("sname"));
                student.setSid(rs.getString("sid"));
                student.setPassword(rs.getString("password"));
                student.setFlag(rs.getInt("flag"));
                student.setSuperuser(rs.getInt("superuser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().close(conn,prep,rs);
        }
        return student;
    }


    //(2)按姓名查找学生(模糊查询)
    public List<Student> findStudentByName(String sname){
        //模糊查询lik

        List<Student> list = new ArrayList<Student>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stata = null;

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            //不一样的地方
            conn = DBConnection.getInstance().getConnection();
            String sql="select*from student where sname like '%"+sname+"%'";
//            System.out.println("[Debug]sql:"+sql);
            stata = conn.createStatement();
            rs = stata.executeQuery(sql);
            //5.处理结果,遍历(不一样的地方)

            while(rs.next()){
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSname(rs.getString("sname"));
                s.setPassword(rs.getString("password"));
                s.setSuperuser(rs.getInt("superuser"));
                s.setFlag(rs.getInt("flag"));
                list.add(s); //往list中添加查询到的结果
            }
                                                            /*while是用来做循环输出的 换句话说 就是"如果结果集里还有值" 没有则停止循环 这个一般在JSP做显示用
                                                            * while(rs.next()) //就是 将rs全部进行读取*/
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,stata,rs);
        }
        return list;
    }



    //(3)查询所有学生记录(DJDBC模板)
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

    //(4)按ID查询
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

    //(5)新增一条学生记录，注册使用
//    public int insertStudent(Student student){
//        int flag=0;
//        Connection conn = null;
//        PreparedStatement prep = null;
//
//        try {
//            conn = DBConnection.getInstance().getConnection();
//            String sql="insert into student values(?,?,?,?,?)";
//            prep = conn.prepareStatement(sql);
//
//
//            prep.setString(1, student.getSid());
//            prep.setString(2, student.getSname());
//            prep.setString(3, student.getPassword());
//            prep.setInt(4, student.getSuperuser());
//            prep.setInt(5, student.getFlag());
//            prep.executeQuery();
//            flag = prep.executeUpdate();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally{
//            DBConnection.getInstance().close(conn,prep);
//        }
//        return flag;
//    }
    @Override
    public boolean insertStudent(Student student) {
        Connection conn = null;
        PreparedStatement prep = null;
        boolean flag = false;

        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "insert into student values(?,?,?,?,?)";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,student.getSid());
            prep.setString(2,student.getSname());
            prep.setString(3,student.getPassword());
            prep.setInt(4,student.getSuperuser());
            prep.setInt(5,student.getFlag());
            //5.更新结果集
            int i = prep.executeUpdate();
            if(i>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().close(conn,prep);
        }
        return flag;
    }
    

    //(6)更新一位学生的全部信息除了主键
//    @Override
//    public boolean updateStudent(Student student){
//        boolean flag=false;
//        Connection conn = null;
//        PreparedStatement prep = null;
//
//        try {
//            conn = DBConnection.getInstance().getConnection();
//            String sql="update student set sname=?,password=?,superuser=?,flag=?where sid=?";
//            prep = conn.prepareStatement(sql);
//
//            prep.setString(1, student.getSname());
//            prep.setString(2, student.getPassword());
//            prep.setInt(3, student.getSuperuser());
//            prep.setInt(4, student.getFlag());
//            prep.setString(5, student.getSid());
//
//            prep.executeQuery();
//            flag = prep.execute();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally{
//            DBConnection.getInstance().close(conn,prep);
//        }
//        return flag;
//    }
    @Override
    public boolean updateStudent(Student student) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "update student set sname=?,password=?,superuser=?,flag=? where sid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,student.getSname());
            prep.setString(2,student.getPassword());
            prep.setInt(3,student.getSuperuser());
            prep.setInt(4,student.getFlag());
            prep.setString(5,student.getSid());
            //5.获取结果集
            int i = prep.executeUpdate();
            if(i>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().close(conn,prep);
        }
        return flag;
    }



    //(7)改学生的密码
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
//            System.out.println(flag);//测试


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }

        return flag;
    }

    //(8)删除学生记录
    public boolean deleteStudentBySid(String sid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="delete from student where sid =?";
            prep = conn.prepareStatement(sql);

            prep.setString(1,sid);
            if(prep.executeUpdate()==1){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }
        return false;
    }


//@Override
//public boolean deleteStudentBySid(String sid) {
//    boolean flag = false;
//    Connection conn = null;
//    PreparedStatement prep = null;
//    try {
//        //1.加载驱动程序
//        //2.建立数据库连接
//        conn = DBConnection.getInstance().getConnection();
//        //3.创建SQL语句
//        String sql = "delete from student where sid=?";
//        //4.执行SQL语句
//        prep = conn.prepareStatement(sql);
//        prep.setString(1,sid);
//        //5.获取结果集
//        int i = prep.executeUpdate();
//        if(i>0){
//            flag = true;
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }finally {
//        DBConnection.getInstance().close(conn,prep);
//    }
//    return flag;
//}
    //(9)找回学生密码
public Vector<Student> findPass(String sname, String sid){
    Vector<Student> vector = new Vector<Student>();
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = DBConnection.getInstance().getConnection();
        String sql="select psssword from student where sname = ? AND sid = ?";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery(sql);
        while(rs.next()) {
            Student student = new Student();
            student.setPassword(rs.getString("password"));
            vector.add(student);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }finally{
        DBConnection.getInstance().close(conn,ps,rs);
    }
    return vector;
}




}
