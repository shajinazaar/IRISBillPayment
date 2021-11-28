package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentCompanyAdditionPage {

    public WebDriver driver;

    By getName = By.id("Name");//Company Name
    By getCode = By.id("CodeVariable"); //Company code
    By getBlockPeriod = By.xpath("//*[@class='FieldArea column2']/span/span/input");
    By getVoidPeriod =By.xpath("//*[@class='FieldArea column4']/span/span/input");
    By SaveBtn = By.id("btnGeneralInfoSave");
    By TransactionTab = By.xpath("//a[@href='#tabsPaymentCompanySetup-5']");

    public PaymentCompanyAdditionPage(WebDriver driver) {
        this.driver=driver;
    }

    public Boolean getCompanyCodeAttribute(){
        Boolean CodeAttribute= Boolean.valueOf(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(getCode)).getAttribute("aria-disabled"));
        return CodeAttribute;
    }


    //To get and click on company type Web Element
    public void getCompanyType() {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("document.getElementsByClassName('k-input').value='1Bill Invoice';");
        String s = (String) j.executeScript("return document.getElementsByClassName('k-input').value");
        WebElement CompanyType= driver.findElement(By.xpath("//*[text()='"+s+"']"));
        j.executeScript("arguments[0].click();",CompanyType);

    }
    // To get Company classification WebELement and click on it
    public void getClassification(){
        JavascriptExecutor j =(JavascriptExecutor) driver;
        j.executeScript("document.getElementsByClassName('k-input').value='Utility Company';");
        String c = (String) j.executeScript("return document.getElementsByClassName('k-input').value");
        WebElement CompanyMode = driver.findElement(By.xpath("//*[text()='"+c+"']"));
        j.executeScript("arguments[0].click();",CompanyMode);
    }

        public void GetBackDatedPeriod(){
            JavascriptExecutor j =(JavascriptExecutor) driver;
            WebElement BackDatedPeriod = driver.findElement(By.id("BackdatedTransactionPeriod"));
            j.executeScript("arguments[0].value='12'", BackDatedPeriod);
        }

    public void GetGracePeriod(){
        JavascriptExecutor j =(JavascriptExecutor) driver;
        WebElement GracePeriod = driver.findElement(By.id("GracePeriod"));
        j.executeScript("arguments[0].value='120'", GracePeriod); // To set the value
     //   String text = (String) jsExecutor.executeScript("return arguments[0].value", userNameTxt);  //To get The value
    }

    public void scrollDown(){
        JavascriptExecutor j =(JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView()",SaveBtn);
        j.executeScript("arguments[0].click();",SaveBtn);
    }

    public WebElement getNameElement(){return driver.findElement(getName);}
    public WebElement getCodeElement(){return driver.findElement(getCode);}
    public WebElement getBlockPeriodElement(){return driver.findElement(getBlockPeriod);}
    public WebElement getVoidPeriodElement(){return driver.findElement(getVoidPeriod);}
    public WebElement getSaveBtn(){return driver.findElement(SaveBtn);}
    public WebElement getTabBtn(){return driver.findElement(TransactionTab);}


}
