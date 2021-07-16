import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertTrue;

public class MyRefactoringTest extends BaseTest {


    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuCookie("Закрыть");
        mainPage.selectMenuInsuranceItem("Страхование");
        mainPage.selectMenuAllPrograms("Все страховые программы");

        AllProgramsPage allProgramsPage = new AllProgramsPage(driver);
        allProgramsPage.selectTravelInsurance("Страхование путешественников");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        String actualTitle = travelInsurancePage.title.getText();
        String expectedTitle = "Страхование путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        travelInsurancePage.TravelInsuranceClickable();

        PolicyCoverPage policyCoverPage = new PolicyCoverPage(driver);
        policyCoverPage.selectMinimalCover("Минимальная");
        policyCoverPage.waitSendAppClickable();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Фамилия Застрахованного", "Иванов");
        sendAppPage.fillField("Имя Застрахованного", "Иван");
        sendAppPage.fillField("Дата рождения Застрахованного", "12.10.1990");
        sendAppPage.selectSex("Женский");
        sendAppPage.fillField("Фамилия Страхователя", "Иванов");
        sendAppPage.fillField("Имя Страхователя", "Иван");
        sendAppPage.fillField("Отчество Страхователя", "Иванович");
        sendAppPage.fillField("Дата рождения Страхователя", "12.10.1990");
        sendAppPage.fillField("Дата выдачи паспорта", "12.10.2010");
        sendAppPage.fillField("Кем выдан", "МВД");
        sendAppPage.fillField("Серия паспорта", "7856");
        sendAppPage.fillField("Номер паспорта", "564856");

        sendAppPage.checkFields("Фамилия Застрахованного","Иванов");
        sendAppPage.checkFields("Имя Застрахованного","Иван");
        sendAppPage.checkFields("Дата рождения Застрахованного","12.10.1990");
        sendAppPage.checkFields("Фамилия Страхователя","Иванов");
        sendAppPage.checkFields("Имя Страхователя","Иван");
        sendAppPage.checkFields("Отчество Страхователя","Иванович");
        sendAppPage.checkFields("Дата рождения Страхователя","12.10.1990");
        sendAppPage.checkFields("Дата выдачи паспорта","12.10.2010");
        sendAppPage.checkFields("Кем выдан","МВД");
        sendAppPage.checkFields("Серия паспорта","7856");
        sendAppPage.checkFields("Номер паспорта","564856");

        sendAppPage.sendButton.click();
        sendAppPage.checkFieldErrorMessage("При заполнении данных произошла ошибка");
        sendAppPage.checkFieldPhone("Поле не заполнено.");
        sendAppPage.checkFieldEmail("Поле не заполнено.");
        sendAppPage.checkFieldRepeatEmail("Поле не заполнено.");

    }
}