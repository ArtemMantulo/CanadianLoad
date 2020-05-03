package Utils;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class ConfigProvider {

    private static Properties prop = new Properties();

    @SneakyThrows
    public static String getProperty(final String propertyName) {
        InputStream inputStream = ConfigProvider.class.getClassLoader().getResourceAsStream("CanadianLoadBoard.properties");
        prop.load(inputStream);
        return prop.getProperty(propertyName);
    }
}
