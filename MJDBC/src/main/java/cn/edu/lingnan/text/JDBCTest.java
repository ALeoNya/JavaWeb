package cn.edu.lingnan.text;

import cn.edu.lingnan.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
    //批处理操作
    public static void main(String[] args) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = DBConnection.getInstance().getConnection();
            String sql = "s=insert into student() values(?,?,?,?,?)";
            prep = conn.prepareStatement(sql);

            prep.setString(1, "s05");
            prep.setString(1, "aaa");
            prep.setString(2, "aaa");
            prep.setInt(4, 0);
            prep.setInt(5, 0);
            prep.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.getInstance().close(conn, prep, rs);
        }
    }
}
