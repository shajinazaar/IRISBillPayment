package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public Properties prop;

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();

        FileInputStream io = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
        prop.load(io);

       // String browserName = System.getProperty("browser"); //To execute paramaterized build in jenkins from maven commands
         // mvn test -Dbrowser=chrome
       String browserName = prop.getProperty("browser");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\shaji.nazar\\IrisSuite\\src\\main\\java\\resources\\chromedriver.exe");

        if(browserName.contains("chrome")){
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver","C:\\Users\\shaji.nazar\\IrisSuite\\src\\main\\java\\resources\\chromedriver.exe");
            if(browserName.contains("headless"))
                options.addArguments("headless");
            driver = new ChromeDriver(options);

        }

        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\shaji.nazar\\IrisSuite\\src\\main\\java\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browserName.equals("IE")) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }


}
