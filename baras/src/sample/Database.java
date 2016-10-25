package sample;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class Database {




    private BasicDataSource dataSource;



    public  Database(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mokymai");
        dataSource.setMaxIdle(1);
        dataSource.setInitialSize(1);
        dataSource.setValidationQuery("SELECT 1");
    }


    public void selecViskis() {
        String queary = "SELECT name, kiekis FROM baras1 WHERE id=4";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement();
             ResultSet resultSet = statment.executeQuery(queary)){
            while (resultSet.next()){
                String name = resultSet.getString("name");
               KiekiuSaugykla.viskioKiekis = resultSet.getDouble("kiekis");

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void selecAlus() {
        String queary = "SELECT name, kiekis FROM baras1 WHERE id=1";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement();
             ResultSet resultSet = statment.executeQuery(queary)){
            while (resultSet.next()){
                String name = resultSet.getString("name");
                KiekiuSaugykla.alausKiekis = resultSet.getDouble("kiekis");

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void selecBrendis() {
        String queary = "SELECT name, kiekis FROM baras1 WHERE id=3";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement();
             ResultSet resultSet = statment.executeQuery(queary)){
            while (resultSet.next()){
                String name = resultSet.getString("name");
                KiekiuSaugykla.brendzioKiekis = resultSet.getDouble("kiekis");

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selecCigaretes() {
        String queary = "SELECT name, kiekis FROM baras1 WHERE id=6";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement();
             ResultSet resultSet = statment.executeQuery(queary)){
            while (resultSet.next()){
                String name = resultSet.getString("name");
                KiekiuSaugykla.cigareciuKiekis = resultSet.getInt("kiekis");

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void selecKava() {
        String queary = "SELECT name, kiekis FROM baras1 WHERE id=5";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement();
             ResultSet resultSet = statment.executeQuery(queary)){
            while (resultSet.next()){
                String name = resultSet.getString("name");
                KiekiuSaugykla.kavoKiekis = resultSet.getInt("kiekis");

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void selecZetonus() {
        String queary = "SELECT name, kiekis FROM baras1 WHERE id=7";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement();
             ResultSet resultSet = statment.executeQuery(queary)){
            while (resultSet.next()){
                String name = resultSet.getString("name");
                KiekiuSaugykla.zetonuKiekis = resultSet.getInt("kiekis");

            }


        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

//UPDATE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



    public void updateViskis(double viskis) {
        String query = "UPDATE baras1 SET kiekis='" + viskis + "' WHERE id=4";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement()){
            statment.executeUpdate(query);


        }catch (SQLException e){
            e.printStackTrace();

        }

    }
    public void updateAlus(double alus) {
        String query = "UPDATE baras1 SET kiekis='" + alus + "' WHERE id=1";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement()){
            statment.executeUpdate(query);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateBrendis(double brendis) {
        String query = "UPDATE baras1 SET kiekis='" + brendis+ "' WHERE id=3";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement()){
            statment.executeUpdate(query);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateCigaretes(double cigaretes) {
        String query = "UPDATE baras1 SET kiekis='" + cigaretes+ "' WHERE id=6";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement()){
            statment.executeUpdate(query);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void updateKava(double kava) {
        String query = "UPDATE baras1 SET kiekis='" + kava+ "' WHERE id=5";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement()){
            statment.executeUpdate(query);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateZetonus(double zetonai) {
        String query = "UPDATE baras1 SET kiekis='" + zetonai+ "' WHERE id=7";
        try (Connection connection = dataSource.getConnection();
             Statement statment = connection.createStatement()){
            statment.executeUpdate(query);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
