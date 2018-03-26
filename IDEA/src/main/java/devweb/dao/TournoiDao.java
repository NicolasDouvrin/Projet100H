package devweb.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TournoiDao {

    public DataSource getDatasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("nr84dudlpkazpylz.chr7pe7iynqr.eu-west-1.rds.amazonaws.com");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("d2ecpo8shdq7pdmr");
        dataSource.setUser("wzw4zb6dvsoypc74");
        dataSource.setPassword("su9d7layctq9uwzf");

        return dataSource;
    }

    public void startTournoi(Integer nbPlace, String type) {
        String query = "INSERT INTO tournoi(nbInscrits, nbPlaces, type) VALUES(0, ?, ?)";
        try (Connection connection = getDatasource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nbPlace);
            statement.setString(2, type);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initTournoi(){
        String query = "CREATE VIEW test AS\n" +
                "SELECT idTournoi\n" +
                "FROM tournoi\n" +
                "ORDER BY idTournoi DESC LIMIT 1;" +
                " UPDATE test SET nbInscrits=(select count(email) from membre where inscrit=1 GROUP BY email)";
        try (Connection connection = getDatasource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
