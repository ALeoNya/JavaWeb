package cn.edu.lingnan.text;

import cn.edu.lingnan.util.DBConnection;

import java.sql.*;

public class JDBCTest2 {
    //结果集指针移动示例
    public static void main(String[]args){
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            //1.加载驱动
            conn = DBConnection.getInstance().getConnection();
            String sql="insert into studnet into value(?,?,?,?,?)";
            prep = conn.prepareStatement(sql);

            rs = prep.executeQuery();
            System.out.println(rs.isBeforeFirst());
            System.out.println(rs.isFirst());
            rs.absolute(3);
            System.out.println(rs.getString("sname"));
            rs.relative(-2);
            System.out.println(rs.getString("sname"));
            rs.last();
            System.out.println(rs.getRow());
            rs.beforeFirst();
            while(rs.next());
            System.out.println(rs.isAfterLast());

        } catch(SQLException e){
            e.printStackTrace();
        }finally{
                DBConnection.getInstance().close(conn,prep,rs);
        }
    }
}
