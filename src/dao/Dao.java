package dao;

import java.sql.*;

/**
 * 用于获得数据库的连接
 * Created by ZouKaifa on 2016/10/10.
 */
public class Dao {
    protected Connection con;  //数据库连接对象
    /**
     * 设置数据库连接
     */
    protected void setCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/SCHIT", "root", "960331");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据sql语句及参数获得ResultSet，防注入
     * @param sql sql语句
     * @param params 参数数组
     * @return 结果集
     */
    protected ResultSet getResultSet(String sql, Object... params) {
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                Object pa = params[i];
                if (pa.getClass() == String.class) {
                    ps.setString(i + 1, String.valueOf(pa));
                } else if (pa.getClass() == Long.class) {
                    ps.setLong(i + 1, Long.parseLong(String.valueOf(pa)));
                } else if (pa.getClass() == Integer.class) {
                    ps.setInt(i + 1, Integer.parseInt(String.valueOf(pa)));
                } else if (pa.getClass() == Timestamp.class) {
                    ps.setTimestamp(i + 1, (Timestamp) pa);
                }
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}