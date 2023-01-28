import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class _29_readWrite {

    // VIDEO # 41

    public static void main(String[] args) throws IOException {


        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/test/resources/properties/testdata.properties");
        properties.load(inputStream);

        // READ
        System.out.println(properties.getProperty("browserType"));
        System.out.println(properties.getProperty("url"));

        // WRITE
        FileOutputStream outputStream = new FileOutputStream("src/test/resources/properties/testdata.properties");

        properties.setProperty("testData", "eirueirueirueirureirueieirueir");
        properties.store(outputStream, "This is test comment added from readWrite Class");
    }

}
