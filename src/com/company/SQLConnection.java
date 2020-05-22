package com.company;

import org.sqlite.JDBC;

import java.sql.*;
import java.sql.Connection;

public class SQLConnection {
    private static final String CON_STR = "jdbc:sqlite:SQLrabbits.db";
    private static SQLConnection instance = null;
    private Singleton singleton=Singleton.getInstance();
    //private Vector vector=new Vector<>();

    public static synchronized SQLConnection getInstance(){
        if (instance == null)
            instance = new SQLConnection();
        return instance;
    }
    private Connection connection;

    private SQLConnection()  {
        try {
            DriverManager.registerDriver(new JDBC());
            this.connection = DriverManager.getConnection(CON_STR);
            Statement statement = this.connection.createStatement();
            statement.executeQuery(
                    "CREATE TABLE IF NOT EXISTS Rabbits (ID INTEGER PRIMARY KEY,"+
                            "BirthTime LONG," +
                            "x INTEGER," +
                            "y INTEGER," +
                            "dirX Double," +
                            "dirY Double );" );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setData(int Type){
        try {
            Statement stat=this.connection.createStatement();
            stat.execute("DELETE FROM Rabbits");
            for(AbstractRabbit rabbit: singleton.GetVector()) {
                PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Rabbits(ID,BirthTime," +
                        "x,y,dirX,dirY)" +
                        "VALUES(?,?,?,?,?,?)" );
                if((Type==0 && rabbit.getID()<0) || (Type==1 && rabbit.getID()>0))
                {
                    continue;
                }
                    statement.setObject(1, rabbit.getID());
                    statement.setObject(2, rabbit.getTimeBirth());
                    statement.setObject(3, rabbit.getX());
                    statement.setObject(4, rabbit.getY());
                    statement.setObject(5, rabbit.getDirX());
                    statement.setObject(6, rabbit.getDirY());
                    statement.execute();
            }

        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }

    public void Data(int Type){
        ResultSet resultSet = null;
        AbstractRabbit rabbit;
        try {
            Statement statement = this.connection.createStatement();
            if(Type==-1) {
                resultSet = statement.executeQuery("Select * " +
                        "FROM Rabbits;" );
                while (resultSet.next()) {
                    if (resultSet.getInt("ID") < 0) {
                        rabbit=new albinoRabbit(resultSet.getInt("x"),resultSet.getInt("y"),resultSet.getLong("BirthTime"),resultSet.getInt("ID"));//но нужны все кролкиAbstractRabbits нельзя
                        rabbit.SetDir(resultSet.getDouble("dirX" ), resultSet.getDouble("dirY" ));
                        singleton.GetVector().add(rabbit);
                        System.out.println(" my Rabbit " + rabbit);
                    }
                    if (resultSet.getInt("ID") > 0) {
                        rabbit=new Rabbits( resultSet.getInt("x"),resultSet.getInt("y"),resultSet.getLong("BirthTime"),resultSet.getInt("ID"));
                        rabbit.SetDir(resultSet.getDouble("dirX" ), resultSet.getDouble("dirY" ));
                        singleton.GetVector().add(rabbit);
                    }
                }
            }
            if(Type>=0){
                resultSet=statement.executeQuery("SELECT *" +
                        "FROM Rabbits " +
                        "WHERE ID>0 or ID<0;");
                while (resultSet.next()) {
                    if(Type==1) {
                        if (resultSet.getInt("ID" ) < 0) {
                            rabbit = new albinoRabbit(resultSet.getInt("x" ), resultSet.getInt("y" ), resultSet.getLong("BirthTime" ), resultSet.getInt("ID" ));//но нужны все кролкиAbstractRabbits нельзя
                            rabbit.SetDir(resultSet.getDouble("dirX" ), resultSet.getDouble("dirY" ));
                            singleton.GetVector().add(rabbit);
                            System.out.println(" my Rabbit " + rabbit);
                        }
                        continue;
                    }
                    if (resultSet.getInt("ID" ) > 0) {
                        rabbit = new Rabbits(resultSet.getInt("x" ), resultSet.getInt("y" ), resultSet.getLong("BirthTime" ), resultSet.getInt("ID" ));
                        rabbit.SetDir(resultSet.getDouble("dirX" ), resultSet.getDouble("dirY" ));
                        singleton.GetVector().add(rabbit);
                        System.out.println(" my Rabbit " + rabbit);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}