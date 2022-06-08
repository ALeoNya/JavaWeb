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
//            System.out.println(flag);//����


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }
        return flag;
    }

    //ͨ��ѧ��sidɾ���ɼ����ѧ����¼
//    @Override
//    public boolean deleteScoreBySid(String sid) {
//        boolean flag = false;
//        Connection conn = null;
//        PreparedStatement prep = null;
//        try {
//            //1.������������
//            //2.�������ݿ�����
//            conn = DBConnection.getInstance().getConnection();
//            String sql = "delete from score where sid=?";
//            //4.ִ��SQL���
//            prep = conn.prepareStatement(sql);
//            prep.setString(1,sid);
//            //5.��ȡ�����
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
            //1.������������
            //2.�������ݿ�����
            conn = DBConnection.getInstance().getConnection();
            //3.����SQL���
            //ɾ���������еĶ�����¼
            String sql = "delete from score where sid=? and cid=?";
            //4.ִ��SQL���
            prep = conn.prepareStatement(sql);
            prep.setString(1,sid);
            prep.setString(2,cid);
            //5.��ȡ�����
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
            //1.������������
            //2.�������ݿ�����
            conn = DBConnection.getInstance().getConnection();
            //3.����SQL���
            //ɾ���������еĶ�����¼
            String sql = "delete from score where cid=?";
            //4.ִ��SQL���
            prep = conn.prepareStatement(sql);
            prep.setString(1,cid);
            //5.��ȡ�����
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
            //1.������������
            //2.�������ݿ�����
            conn = DBConnection.getInstance().getConnection();
            //3.����SQL���
            String sql = "select * from score where sid=?";
            //4.ִ��SQL���
            prep = conn.prepareStatement(sql);
            prep.setString(1,sid);
            //5.��ȡ�����
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
            //1.������������
            //2.�������ݿ�����
            conn = DBConnection.getInstance().getConnection();
            //3.����SQL���
            String sql = "select * from score where sid=? and cid=?";
            //4.ִ��SQL���
            prep = conn.prepareStatement(sql);
            prep.setString(1,sid);
            prep.setString(2,cid);
            //5.��ȡ�����
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
            //1.������������
            //2.�������ݿ�����
            conn = DBConnection.getInstance().getConnection();
            //3.����SQL���
            //ɾ���������еĶ�����¼
            String sql = "insert into score values(?,?,'1000') ";
            //4.ִ��SQL���
            prep = conn.prepareStatement(sql);
            prep.setString(1,score.getSid());
            prep.setString(2,score.getCid());
//            prep.setInt(3,score.getScore());
            //5.��ȡ�����
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

    //���¹���
    @Override
    public boolean updateScore(Score score) {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            //1.������������
            //2.�������ݿ�����
            conn = DBConnection.getInstance().getConnection();
            //3.����SQL���
            String sql = "update score set cid=?,score=? where sid=?";
            //4.ִ��SQL���
            prep = conn.prepareStatement(sql);
            prep.setString(3,score.getSid());
            prep.setString(1, score.getCid());
            prep.setInt(2, score.getScore());
            //5.��ȡ�����
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

    //(3)��ѯ����ְλ��¼
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
