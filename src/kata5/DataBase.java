package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DataBase {
    private String URL;
    private Connection con = null;
    DataBase(String URL) {
        this.URL = URL;
    }

    void open()  {
        try{
            con = DriverManager.getConnection(URL);
            System.out.println("Base de datos abierta...");
        }catch(SQLException sqle){
            System.out.println("ERROR" + sqle.getMessage());
        }
        
    }

    void close() {
        try{
            if(con != null){
                con.close();
                System.out.println("Base de datos cerrada...");
            }
        }catch(SQLException sqle){
            System.out.println("ERROR" + sqle.getMessage());
        }
    }

    void selectPEOPLE() {
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery(SQL);
            System.out.println("ID \t NAME \t APELLIDOS \t DEPARTAMENTO ");
            while(res.next()){
                System.out.print(res.getInt("ID")+ "\t");
                System.out.print(res.getString("NAME")+ "\t");
                System.out.print(res.getString("APELLIDOS")+ "\t");
                System.out.println(res.getString("DEPARTAMENTO")+ "\t");
            }
        }catch(SQLException sqle){
            System.out.println("ERROR" + sqle.getMessage());
        }
    }

    void insertPEOPLE(People people) {
        String SQL = "INSERT INTO PEOPLE(NAME,APELLIDOS,DEPARTAMENTO) VALUES(?, ?, ?)";
        try{
            PreparedStatement preState = con.prepareStatement(SQL);
            preState.setString(1, people.getName());
            preState.setString(2, people.getApellidos());
            preState.setString(3, people.getDepartment());
            preState.executeUpdate();
        }catch(SQLException sqle){
            System.out.println("ERROR" + sqle.getMessage());
        }
    }
}
