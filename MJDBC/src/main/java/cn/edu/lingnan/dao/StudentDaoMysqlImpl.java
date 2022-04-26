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
    //查找成功为true
    public Student findStudentNameAndPassword(String sname,String password){
        Student student = new Student();
        //中间为方法体
        ResultSet rs = null;//将数据库查询返回到结果集中
        Connection conn = null;//我们在原生的JDBC中，每次与数据库操作，都是先获取Connection对象，然后在方法执行完调用close()方法，释放资源。
        PreparedStatement prep = null;//是预编译的,对于批量处理可以大大提高效率. 也叫JDBC存储过程

        try {
            conn = DBConnection.getInstance().getConnection();//连续调用多个成员方法完成JDBC的初始化
            //3.创建sql语句对象(预处理的sql语句对象)
            String sql="select*from student where sname = ? and password = ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1,sname);
            prep.setString(2,password);
            rs = prep.executeQuery();
                                        /*
                                        * 执行查询；要用statement类的executeQuery()方法来下达select指令以查询数据库，
                                        * executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。
                                        * 即语句：ResultSet rs=s.executeQuery(sql);使用预处理则不需要添加sql在括号中
            * */
            //5.处理结果,遍历
                if(rs.next())
                    student.setSid(rs.getString("sid"));
                    student.setSname(rs.getString("sname"));
                    student.setPassword(rs.getString("password"));
                    student.setSuperuser(rs.getInt("superuser"));
                    student.setFlag(rs.getInt("flag"));
                                                                    /*
                                                                    *ResultSet.next()方法,将指针从当前位置下移一行。ResultSet 指针最初位于第一行之前；
                                                                    * 第一次调用 next 方法使第一行成为当前行；第二次调用使第二行成为当前行，依此类推。
                                                                    * 如果新的当前行有效，则返回 true；如果不存在下一行，则返回 false.
                                                                    * if(rs.next()) //rs进行读取一次 判断是否有数据 */
            } catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep,rs);
        }
        return  student;
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
        return  list;
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

    //(6)更新一位学生的全部信息除了主键
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
            String sql="delete from student where sid = ?";
            prep = conn.prepareStatement(sql);

            prep.setString(1,sid);
            if(prep.executeUpdate()==1){
                flag = true;
            }
//            System.out.println(flag);//测试


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }
        return false;
    }




}
