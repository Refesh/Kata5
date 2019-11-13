package kata5;

public class Kata6 {

    public static void main(String[] args) {
        String URL = "jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata6\\DB_SQLITE\\Miercoles.db";
        DataBase db = new DataBase(URL);
        
        
        db.open();
        
        
        People people = new People("Fernando", "Marcelo", "Piloto");
        db.insertPEOPLE(people);
        db.selectPEOPLE();
        
        db.close();
    }
    
}
