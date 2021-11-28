package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LicensePage {

   public WebDriver driver;

    By AddLicense = By.cssSelector("[title='Add']");
    By UploadLicense = By.xpath("//input[@id='LicenseFile']");
    By UploadBtn = By.id("btnUpload");
    By SaveBtn = By.id("btnSave");

    public LicensePage(WebDriver driver){ this.driver=driver; }

    public WebElement getAddLicenseElement(){return driver.findElement(AddLicense);}
    public WebElement getUploadLicense(){ return driver.findElement(UploadLicense);}
    public WebElement getUploadBtn(){return driver.findElement(UploadBtn);}
    public WebElement getSaveBtn() {return driver.findElement(SaveBtn);}

}
