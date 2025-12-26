package genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFileUtil {
    /**
     * reads custom test data from properties file
     * @param key
     * @return
     * @throws IOException
     */
    public String readPropFile(String key) throws IOException {
        FileInputStream fis= new FileInputStream(IPathConstants.filepath);
        Properties prop= new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }
}
