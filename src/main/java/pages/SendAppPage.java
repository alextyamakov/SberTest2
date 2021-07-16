package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendAppPage extends BasePage {

    @FindBy(xpath = "//h2")
    WebElement title;

    @FindBy(xpath = "//input[@id = 'surname_vzr_ins_0']")
    WebElement lastNameIns;

    @FindBy(xpath = "//input[@id = 'name_vzr_ins_0']")
    WebElement firstNameIns;

    @FindBy(xpath = "//input[@id = 'birthDate_vzr_ins_0']")
    WebElement birthDateIns;

    @FindBy(xpath = "//label[contains(text(),'Женский')]")
    WebElement sex;

    @FindBy(xpath = "//input[@id = 'person_lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id = 'person_firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id = 'person_middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@id = 'person_birthDate']")
    WebElement person_birthDate;

    @FindBy(xpath = "//input[@id = 'documentDate']")
    WebElement documentDate;

    @FindBy(xpath = "//input[@id = 'documentIssue']")
    WebElement documentIssue;

    @FindBy(xpath = "//input[@id = 'passportSeries']")
    WebElement passportSeries;

    @FindBy(xpath = "//input[@id = 'passportNumber']")
    WebElement passportNumber;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    public WebElement sendButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(title));
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Фамилия Застрахованного":
                fillField(lastNameIns, value);
                break;
            case  "Имя Застрахованного":
                fillField(firstNameIns, value);
                break;
            case  "Дата рождения Застрахованного":
                fillField(birthDateIns, value);
                break;
            case  "Фамилия Страхователя":
                fillField(lastName, value);
                break;
            case  "Имя Страхователя":
                fillField(firstName, value);
                break;
            case  "Отчество Страхователя":
                fillField(middleName, value);
                break;
            case  "Дата рождения Страхователя":
                fillField(person_birthDate, value);
                break;
            case  "Дата выдачи паспорта":
                fillField(documentDate, value);
                break;
            case  "Кем выдан":
                fillField(documentIssue, value);
                break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumber, value);
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void selectSex (String itemName) {
        sex.findElement(By.xpath("//label[contains(text(),'" + itemName + "')]")).click();
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия Застрахованного":
                return lastNameIns.getAttribute("value");
            case  "Имя Застрахованного":
                return firstNameIns.getAttribute("value");
            case  "Дата рождения Застрахованного":
                return birthDateIns.getAttribute("value");
            case  "Фамилия Страхователя":
                return lastName.getAttribute("value");
            case  "Имя Страхователя":
                return firstName.getAttribute("value");
            case  "Отчество Страхователя":
                return middleName.getAttribute("value");
            case  "Дата рождения Страхователя":
                return person_birthDate.getAttribute("value");
            case  "Дата выдачи паспорта":
                return documentDate.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");
            case  "Серия паспорта":
                return passportSeries.getAttribute("value");
            case  "Номер паспорта":
                return passportNumber.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }


    public void checkFields(String fieldName, String expectedValue){
        String actualValue = getFillField(fieldName);
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, expectedValue),
                actualValue.contains(expectedValue));
    }


    public void checkFieldErrorMessage(String errorMessage){
        String xpath = "//div[@class = 'alert-form alert-form-error']";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

    public void checkFieldPhone(String errorMessage){
        String xpath = "//*[contains(@class,'phone')]/validation-message";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

    public void checkFieldEmail(String errorMessage){
        String xpath = "//*[contains(@name,'email')]/span/validation-message";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

    public void checkFieldRepeatEmail(String errorMessage){
        String xpath = "//*[contains(@name,'repeatEmail')]/span/validation-message";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
}
