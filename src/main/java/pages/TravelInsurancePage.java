package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage extends BasePage {

    @FindBy(xpath = "//h1[@data-test-id = 'PageTeaserDict_header']")
    public WebElement title;

    @FindBy(xpath = "//a[@data-test-id = 'PageTeaserDict_button']//span[contains(text(),'Оформить онлайн')]")
    public WebElement TravelInsurance;

    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void TravelInsuranceClickable(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//a[@data-test-id = 'PageTeaserDict_button']//span[contains(text(),'Оформить онлайн')]")))).click();
    }
}
