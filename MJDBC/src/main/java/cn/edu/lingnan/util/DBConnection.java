package cn.edu.lingnan.util;

import java.sql.*;
import java.util.Map;

//工具类：数据库链接
public class DBConnection {
    //v1.0
//    public static Connection getConnection(){
//        Connection conn = null;
//
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection
//                    ("jdbc:mysql://localhost:3306/school", "root","136601cccp");
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("mysql的jar驱动下载失败");
//            e.printStackTrace();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return conn;
//    }

//    //v2.0
//    private static String dirver = "com.mysql.cj.jdbc.Driver";//mysql6以及之后的版本需要更新到新版驱动，对应的Driver是"com.mysql.cj.jdbc.Driver"
////    private String url = "jdbc:mysql://localhost:3306/school?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
//    private String url = "jdbc:mysql://localhost:3306/school?serverTimezone=Asia/Shanghai&useSSL=false";
//    private String user = "root";
//    private String password = "136601";
//    private static DBConnection dbConnection = null;
//    private Connection conn = null;
//
//    public DBConnection() {
//        try {
//            Class.forName(dirver);
//        } catch (ClassNotFoundException e) {
//            System.out.println("mysql的jar驱动下载失败");
//            e.printStackTrace();
//        }
//    }
//    public static DBConnection getInstance(){
//        if(dbConnection==null)
//            dbConnection = new DBConnection();
//        return dbConnection;
//    }
//
//    public Connection getConnection(){
//        try {
//
//            conn = DriverManager.getConnection
//                    (url,user,password);
//
//        } catch(SQLException e) {
//            e.printStackTrace();
//        }
//
//        return conn;
//    }
//
//
//    //关闭类
//    public void close(Connection conn, Statement state, ResultSet rs){
//        try{//关闭驱动释放内存(是靠可否单判断在conn==null条件下就关闭)
//            if(rs!= null)
//                rs.close();
//            if(state!=null)
//                state.close();
//            if(conn!=null)
//                conn.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    //方法名一样参数不一样是重载
//    public void close(Connection conn, PreparedStatement prep, ResultSet rs){
//        try{//关闭驱动释放内存(是靠可否单判断在conn==null条件下就关闭)
//            if(rs!= null)
//                rs.close();
//            if(prep!=null)
//                prep.close();
//            if(conn!=null)
//                conn.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void close(Connection conn, PreparedStatement prep){
//        try{//关闭驱动释放内存(是靠可否单判断在conn==null条件下就关闭)
//            if(prep!=null)
//                prep.close();
//            if(conn!=null)
//                conn.close();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

    //v3.0
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String xsdName="database.conf.xsd";
    private static String xmlName="database.conf.xml";
    private Connection conn = null;
    private static DBConnection dbConnection = null;


    static {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String xsdPath=basePath+xsdName;
        String xmlPath= basePath+xmlName;
        if(XmlValidate.validate(xsdPath,xmlPath)){
            Map<String,String> map = XmlParser.parse(xmlPath);
            driver = map.get("driver");
            url = map.get("url");
            user = map.get("user");
            password = map.get("password");
        }
    }
    private DBConnection() {
        try {
            //1注册驱动程序
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("mysql的jar驱动下载失败");
            e.printStackTrace();
        }
    }
    public static DBConnection getInstance(){
        System.out.println("test");
        if(dbConnection==null){
            dbConnection = new DBConnection();
        }
        System.out.println("test2");
        return dbConnection;
    }

    public Connection getConnection(){
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    //关闭类
    public void close(Connection conn, Statement state, ResultSet rs){
        try{//关闭驱动释放内存(是靠可否单判断在conn==null条件下就关闭)
            if(rs!= null)
                rs.close();
            if(state!=null)
                state.close();
            if(conn!=null)
                conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //方法名一样参数不一样是重载
    public void close(Connection conn, PreparedStatement prep, ResultSet rs){
        try{//关闭驱动释放内存(是靠可否单判断在conn==null条件下就关闭)
            if(rs!= null)
                rs.close();
            if(prep!=null)
                prep.close();
            if(conn!=null)
                conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void close(Connection conn, PreparedStatement prep){
        try{//关闭驱动释放内存(是靠可否单判断在conn==null条件下就关闭)
            if(prep!=null)
                prep.close();
            if(conn!=null)
                conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
