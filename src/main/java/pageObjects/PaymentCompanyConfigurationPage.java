package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentCompanyConfigurationPage {

   public WebDriver driver;
    //div[@class='genericToolbar']/a[2]
    By AddCompanyBtn = By.xpath("//div[@class='genericToolbar']/a[2]");
    By dashboard = By.xpath("//div[@class='newui_LeftNav']/div[1]");
    By configuration = By.xpath("//a[@href='/IRIS/Configuration/System']");

    public PaymentCompanyConfigurationPage(WebDriver driver) { this.driver=driver;}

   // public WebElement AddPaymentCompany() {return driver.findElement(AddCompanyBtn);}

    public PaymentCompanyAdditionPage GetPaymentCompanyAdditionPage() throws Error {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.elementToBeClickable(AddCompanyBtn));
        driver.findElement(AddCompanyBtn).click();
        PaymentCompanyAdditionPage pca = new PaymentCompanyAdditionPage(driver);
        return pca;
    }


    //Redirecting to configuration menu or Configuration Page by clicking to "dashboard" then "configuration" menu
    public ConfigurationPage GetConfigurationPage(){
        driver.findElement(dashboard).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(configuration));
        driver.findElement(configuration).click();
        ConfigurationPage cfg = new ConfigurationPage(driver);
        return cfg;
    }



}
