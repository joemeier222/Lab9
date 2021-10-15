package tarleton.lab9;

import edu.tarleton.database.Connection;
import edu.tarleton.database.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Joe Meier
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception{
        Properties prop = new Properties();
        try (FileInputStream in = new FileInputStream("src/main/resources/db.properties")){
            prop.load(in);
            try (Connection con = new Connection(prop.getProperty("URL"),prop.getProperty("username"),
                    prop.getProperty("password"))){
                try (Statement st = con.createStatement()){
                    st.executeQuery("select * from Car");
                }
            }
        }
    }
}
