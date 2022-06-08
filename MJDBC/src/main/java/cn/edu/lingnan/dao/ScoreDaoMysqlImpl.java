package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Score;
import cn.edu.lingnan.util.DBConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ScoreDaoMysqlImpl implements ScoreDao{
    @Override
    public boolean deleteScoreBySid(String sid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="delete from score where sid = ?";
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
        return flag;
    }

    //通过学号sid删除成绩表的学生记录
//    @Override
//    public boolean deleteScoreBySid(String sid) {
//        boolean flag = false;
//        Connection conn = null;
//        PreparedStatement prep = null;
//        try {
//            //1.加载驱动程序
//            //2.建立数据库连接
//            conn = DBConnection.getInstance().getConnection();
//            String sql = "delete from score where sid=?";
//            //4.执行SQL语句
//            prep = conn.prepareStatement(sql);
//            prep.setString(1,sid);
//            //5.获取结果集
//            int i = prep.executeUpdate();
//            if(i>0){
//                flag = true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DBConnection.getInstance().close(conn,prep);
//        }
//        return flag;
//    }

    @Override
    public boolean deleteScoreBySidAndCid(String sid, String cid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            //删除分数表中的多条记录
            String sql = "delete from score where sid=? and cid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,sid);
            prep.setString(2,cid);
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

    @Override
    public boolean deleteScoreByCid(String cid) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            //删除分数表中的多条记录
            String sql = "delete from score where cid=?";
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

    @Override
    public List<Score> selectScoreBySid(String sid) {
        List<Score> list = new LinkedList<Score>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;

        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "select * from score where sid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,sid);
            //5.获取结果集
            rs = prep.executeQuery(sql);
            while(rs.next()){
                Score score = new Score();
                score.setSid(rs.getString("sid"));
                score.setCid(rs.getString("cname"));
                score.setScore(rs.getInt("score"));
                list.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().close(conn,prep,rs);
        }
        return list;
    }

    @Override
    public Score selectScoreBySidAndCid(String sid, String cid) {
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        Score score = new Score();
        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "select * from score where sid=? and cid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,sid);
            prep.setString(2,cid);
            //5.获取结果集
            rs = prep.executeQuery(sql);
            while(rs.next()){
                score.setSid(rs.getString("sid"));
                score.setCid(rs.getString("cname"));
                score.setScore(rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.getInstance().close(conn,prep,rs);
        }
        return score;
    }

    @Override
    public boolean insertScore(Score score) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            //删除分数表中的多条记录
            String sql = "insert into score values(?,?,'1000') ";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(1,score.getSid());
            prep.setString(2,score.getCid());
//            prep.setInt(3,score.getScore());
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

    //更新工资
    @Override
    public boolean updateScore(Score score) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            //1.加载驱动程序
            //2.建立数据库连接
            conn = DBConnection.getInstance().getConnection();
            //3.创建SQL语句
            String sql = "update score set cid=?,score=? where sid=?";
            //4.执行SQL语句
            prep = conn.prepareStatement(sql);
            prep.setString(3,score.getSid());
            prep.setString(1, score.getCid());
            prep.setInt(2, score.getScore());
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
    @Override
    public Vector<Score> findAllScore(){
        Vector<Score> vector = new Vector<Score>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stata = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="select*from score";
            stata = conn.createStatement();
            rs = stata.executeQuery(sql);

            while(rs.next()){
                Score score = new Score();
                score.setSid(rs.getString("sid"));
                score.setCid(rs.getString("cid"));
                score.setScore(Integer.parseInt(rs.getString("score")));
                vector.add(score);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,stata,rs);
        }
        return vector;
    }

}
