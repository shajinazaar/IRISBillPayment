package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

     By username = By.xpath("//input[@id='UserName']");

     By password = By.xpath("//input[@id='Password']");

     By loginBtn = By.xpath("//*[@id='btn_Submit']");


    public LoginPage(WebDriver driver) {this.driver=driver; }

    public WebElement getUserName() { return driver.findElement(username);}

    public WebElement getPassword(){return driver.findElement(password);}

    public WebElement getLogin() {return driver.findElement(loginBtn);}


}
