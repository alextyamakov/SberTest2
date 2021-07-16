package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PolicyCoverPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(),'Минимальная')]")
    public WebElement MinimalCover;

    @FindBy(xpath = "//button[contains(text(),'Оформить')]")
    public WebElement sendAppBtn;

    public PolicyCoverPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMinimalCover(String itemName){
        MinimalCover.findElement(By.xpath("//h3[contains(text(),'"+itemName+"')]")).click();
    }

    public void waitSendAppClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")))).click();
    }
}
