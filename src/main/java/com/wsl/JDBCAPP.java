package com.wsl;

import java.sql.*;

public class JDBCAPP {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载JDBC驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //创建数据库的连接
        String url = "jdbc:mysql://192.168.117.129:3306/xdclass_db?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "111111";
        Connection connection = DriverManager.getConnection(url, username, password);
        //创建preparedStatement
        String sql = "select * from video";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //执⾏SQL语句
        ResultSet resultSet = preparedStatement.executeQuery();
        //处理结果集
        while (resultSet.next()) {
            System.out.println("视频标题:"+resultSet.getString("title"));
        }
        //关闭JDBC对象资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
