package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Course;
import cn.edu.lingnan.util.DBConnection;

import java.sql.*;
import java.util.Vector;

public class CourseDaoImpl implements CourseDao {

    @Override
    public Course selectCourseByCid(String cid) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement prep = null;
        Course course = new Course();
        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "select from course where cid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,cid);
            //5.获取结果集
            rs = prep.executeQuery();
            while (rs.next()){
                course.setCid(rs.getString("cid"));
                course.setCname(rs.getString("cname"));
                course.setTname(rs.getString("tname"));
                course.setFlag(rs.getInt("flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().close(conn,prep);
        }
        return course;
    }

    @Override
    public boolean insertCourse(Course course) {
        Connection conn = null;
        PreparedStatement prep = null;
        boolean flag = false;

        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "insert into course values(?,'unknow','unknow','1')";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,course.getCid());
//            prep.setString(2,course.getCname());
//            prep.setString(3,course.getTname());
//            prep.setInt(4,course.getFlag());
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

    @Override
    public boolean deleteCourseByCid(String cid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            //删除分数表中的多条记录
            String sql = "delete from course where cid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,cid);
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

    //更新职位表
    @Override
    public boolean updateCourse(Course course) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "update course set cname=?,tname=? where cid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);

            prep.setString(1,course.getCname());
            prep.setString(2,course.getTname());
            prep.setString(3,course.getCid());
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

    //(3)查询所有职位记录
    public Vector<Course> findAllCourse(){
        Vector<Course> vector = new Vector<Course>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stata = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="select*from course";
            stata = conn.createStatement();
            rs = stata.executeQuery(sql);

            while(rs.next()){
                Course course = new Course();
                course.setCid(rs.getString("cid"));
                course.setCname(rs.getString("cname"));
                course.setTname(rs.getString("tname"));
                course.setFlag(rs.getInt("flag"));
                vector.add(course);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,stata,rs);
        }
        return vector;
    }

}
