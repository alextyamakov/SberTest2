package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProgramsPage extends BasePage {

    @FindBy(xpath = "//*[@class='page-header']/*")
    public WebElement title;

    @FindBy(xpath = "//h3[contains(text(),'Страхование для путешественников')]")
    public WebElement TravelInsurance;

    public AllProgramsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectTravelInsurance(String itemName){
        TravelInsurance.findElement(By.xpath("//h3[contains(text(),'"+itemName+"')]")).click();
    }
}
