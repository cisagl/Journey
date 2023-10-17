import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/company";
    public static final String DB_USER = "****"; // USERNAME
    public static final String DB_PASSWORD = "****"; // PASWORD

    public static void main(String[] args) throws SQLException {
        Connection connect = null;
        String sql = "SELECT * FROM employees";
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connect.setAutoCommit(false);
            PreparedStatement pr = connect.prepareStatement("INSERT INTO employees (emp_name, emp_position, emp_salary) VALUES (?,?,?)");
            pr.setString(1, "Ahmet Öztürk");
            pr.setString(2, "Pazarlama Müdürü");
            pr.setInt(3, 20000);
            pr.executeUpdate();

            pr.setString(1, "Mehmet Kalın");
            pr.setString(2, "CEO");
            pr.setInt(3, 50000);
            pr.executeUpdate();

            pr.setString(1, "Ali Veli");
            pr.setString(2, "Asistan");
            pr.setInt(3, 10000);
            pr.executeUpdate();

            pr.setString(1, "Ezgi Saz");
            pr.setString(2, "COO");
            pr.setInt(3, 45000);
            pr.executeUpdate();

            pr.setString(1, "Demet İşler");
            pr.setString(2, "İnsan Kaynakları Müdürü");
            pr.setInt(3, 25000);
            pr.executeUpdate();


            ResultSet data = pr.executeQuery(sql);
            while (data.next()){
                System.out.println("Çalışan ID: " + data.getInt("emp_id"));
                System.out.println("Adı: " + data.getString("emp_name"));
                System.out.println("Pozisyonu: " + data.getString("emp_position"));
                System.out.println("Maaşı: " + data.getInt("emp_salary"));
                System.out.println("========================================================");
            }
            connect.commit();
            data.close();
            connect.close();
            pr.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
