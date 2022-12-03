import java.sql.*;
import java.util.ArrayList;

public class Connector {
    public final static String connectionString = "jdbc:mysql://localhost:3306/book";
    public final static String user = "root";
    public final static String pwd = "";
    private Connection conn;

    private static Connector instance;

    public static Connector getInstance() throws Exception{
        if(instance == null){
            instance = new Connector();
        }
        return  instance;
    }

    private Connector() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(connectionString, user, pwd);
    }

    private Statement getStatement() throws Exception{
        return this.conn.createStatement();
    }

    public ResultSet query(String sql) throws Exception{
        return this.getStatement().executeQuery(sql);
    }

    public boolean execute(String sql) throws Exception{
        return this.getStatement().executeUpdate(sql) > 0;
    }
    private PreparedStatement getPreparedStatement(String sql) throws Exception{
        return this.conn.prepareStatement(sql);
    }



    public boolean execute(String sql, ArrayList parameters) throws Exception {
        sql(sql, parameters);
        PreparedStatement stt = null;
        return stt.executeUpdate() > 0;
    }

    private void sql(String sql, ArrayList parameters) throws Exception {
        PreparedStatement stt = this.getPreparedStatement(sql);
        for (int i = 0; i < parameters.size(); i++) {
            if (parameters.get(i) instanceof String) {
                stt.setString(i + 1, (String) parameters.get(i));
            } else if (parameters.get(i) instanceof Integer) {
                stt.setInt(i + 1, (int) parameters.get(i));
            } else if (parameters.get(i) instanceof Double) {
                stt.setDouble(i + 1, (double) parameters.get(i));
            }
        }
    }
}
