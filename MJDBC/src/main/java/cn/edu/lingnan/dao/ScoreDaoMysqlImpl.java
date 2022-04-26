package cn.edu.lingnan.dao;

import cn.edu.lingnan.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
//            System.out.println(flag);//≤‚ ‘


        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.getInstance().close(conn,prep);
        }
        return false;
    }
}
