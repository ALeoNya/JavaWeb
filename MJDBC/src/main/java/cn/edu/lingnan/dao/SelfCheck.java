package cn.edu.lingnan.dao;

import cn.edu.lingnan.pojo.Self;
import cn.edu.lingnan.util.DBConnection;

import java.sql.*;
import java.util.Vector;

public class SelfCheck implements SelfCheckDao{
//    public Vector<Self> findSelfDataByName(String sname){
//        Vector<Self> vector = new Vector<Self>();
//        ResultSet rs = null;
//        Connection conn = null;
//        Statement stata = null;
//
//        try {
//            conn = DBConnection.getInstance().getConnection();
//            String sql="select student.sid,student.sname,course.tname,course.cid,course.cname,score.score from student,course,score where student.sid = score.sid AND score.cid = course.cid AND student.sname = '%\"+sname+\"%'";
//            stata = conn.createStatement();
//            rs = stata.executeQuery(sql);
//
//            while(rs.next()){
//                Self self = new Self();
//                self.setSid(rs.getString("sid"));
//                self.setSname(rs.getString("sname"));
//                self.setTname(rs.getString("tname"));
//                self.setCid(rs.getString("cid"));
//                self.setCname(rs.getString("cname"));
//                self.setScore(rs.getInt("score"));
//                vector.add(self); //往list中添加查询到的结果
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally{
//            DBConnection.getInstance().close(conn,stata,rs);
//        }
//        return vector;
//    }
public Vector<Self> findSelfDataByName(String sname){
    Vector<Self> vector = new Vector<Self>();
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn = DBConnection.getInstance().getConnection();
//        String sql="select student.sid,student.sname,course.tname,course.cid,course.cname,score.score from student,course,score where student.sid = score.sid AND score.cid = course.cid ";
//        String sql="select student.sid,student.sname,course.tname,course.cid,course.cname,score.score from student,course,score where student.sid = score.sid AND score.cid = course.cid AND student.sname ='admin'";
        String sql="select student.sid,student.sname,course.tname,course.cid,course.cname,score.score from student,course,score where student.sid = score.sid AND score.cid = course.cid AND student.sname like '%"+sname+"%'";

        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery(sql);

        while(rs.next()) {
            Self self = new Self();
            self.setSid(rs.getString("sid"));
            self.setSname(rs.getString("sname"));
            self.setTname(rs.getString("tname"));
            self.setCid(rs.getString("cid"));
            self.setCname(rs.getString("cname"));
            self.setScore(rs.getInt("score"));
            vector.add(self);
        }
    }catch(SQLException e){
        e.printStackTrace();
    }finally{
        DBConnection.getInstance().close(conn,ps,rs);
    }
    return vector;
}
}
