package cn.edu.lingnan.text;

import cn.edu.lingnan.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest3 {
    //ͨ��������ɽ�����־û�����
    public static void main(String[]args){
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement prep = null;
///ResultSet.TYPE_SCCROLL_INSENIVE.ResultSet.CONCUR_UPDATABLE)
        try {
            conn = DBConnection.getInstance().getConnection();
            String sql="select * from student";
            prep = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = prep.executeQuery();

            //���Ӳ���
            rs.moveToInsertRow();
            rs.updateString("sid","s09");
            rs.updateString("sname","ccc");
            rs.updateString("password","ccc");
            rs.updateInt("supreuser",0);
            rs.updateInt("flag",0);
            rs.insertRow();
            //���²���
            rs.last();
            rs.updateString("sname","ttt");
            rs.updateRow();
            //ɾ������
            rs.last();
            rs.deleteRow();




        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep,rs);
        }
    }
}
