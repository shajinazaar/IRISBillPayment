package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigurationPage {

    public WebDriver driver;

    By licensing = By.cssSelector("a[href='/IRIS/Configuration/Licensing']");

    public ConfigurationPage(WebDriver driver) {this.driver=driver;  }

  //  public WebElement getLicenseElement() {return driver.findElement(licensing);}

    public LicensePage GetLicensePage(){
        driver.findElement(licensing).click();
        LicensePage lcp = new LicensePage(driver);
        return lcp;
    }

}
