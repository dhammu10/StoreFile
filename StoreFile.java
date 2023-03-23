import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StoreFile {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproject","userid","password");

            PreparedStatement preparedStatement = con.prepareStatement("insert into imgtable values(?,?)");
            String file = System.getProperty("user.dir");
            file = file+"//src//Main.java";

            File f = new File(file);

            FileReader fr = new FileReader(f);
            preparedStatement.setString(1,"file");
            preparedStatement.setCharacterStream(2,fr,(int)f.length());
            int i = preparedStatement.executeUpdate();
            System.out.println(i+" Record affected");
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
