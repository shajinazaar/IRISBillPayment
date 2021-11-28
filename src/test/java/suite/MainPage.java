package suite;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.PaymentCompanyConfigurationPage;
import resources.Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class MainPage extends Base {

    public WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException {
        driver= initializeDriver();
    }

    @Test
    public void MainPageNavigation() throws IOException, InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        LoginPage lp = new LoginPage(driver);
        lp.getUserName().sendKeys("admin");
        lp.getPassword().sendKeys("tpstps_2");
        lp.getLogin().click();
        PaymentCompanyConfigurationPage pcc = new PaymentCompanyConfigurationPage(driver);
        PaymentCompanyAdditionPage pca = pcc.GetPaymentCompanyAdditionPage();
        if(pca.getCompanyCodeAttribute() == Boolean.valueOf("false")){  //Checking value that Company code text box "aria-disabled" attribute value is false then fill out all the values
            pca.getCompanyType();
            pca.getNameElement().sendKeys("Test Biller");
            pca.getCodeElement().click();
            pca.getCodeElement().sendKeys("173123");  //Setting company code 6 digits value
            pca.getClassification();
            pca.GetBackDatedPeriod();
            pca.GetGracePeriod();
            pca.getBlockPeriodElement().sendKeys("10");
            pca.getVoidPeriodElement().sendKeys("360");
            pca.scrollDown() //Click on save button
            pca.getTabBtn().click();
        }
        else{
            pca.getTabBtn().click(); // Click on Transaction menu
        }

    }
//A test to upload license in a test suite
    @Test
    public void AddingLicenseTest() throws IOException{
        driver.get(prop.getProperty("url"));
        LoginPage lp = new LoginPage(driver);
        lp.getUserName().sendKeys("admin");
        lp.getPassword().sendKeys("tpstps_2");
        lp.getLogin().click();
        PaymentCompanyConfigurationPage pcc = new PaymentCompanyConfigurationPage(driver);
        ConfigurationPage cfg = pcc.GetConfigurationPage();
        /* PaymentCompanyConfigurationPage will call the GetConfiguration method and will return the
        Configuration object */
        LicensePage lcp = cfg.GetLicensePage();
        lcp.getAddLicenseElement().click();
        lcp.getUploadLicense().sendKeys("C:\\Users\\shaji.nazar\\Desktop\\IN173123.txt");
        lcp.getUploadBtn().click();
        lcp.getSaveBtn().click();


    }





}
