package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;
import pages.SalaryProjectPage;

@DisplayName("Проверка работы формы заказа зарплатного проекта")
public class SalaryProjectTest extends BaseTest {

    //данные для ввода
    private String nameSection = "Зарплатный проект";
    private String nameOrg = "ИП Тест";
    private String compSphere = "тестовая";
    private String city = "Тест";
    private String countOfEmployees = "10";
    private String correctContactPerson = "Тестов Тест";
    private String incorrectContactPerson = "test123";
    private String correctTelephone = "9999999999";
    private String notFullTelephone = "999";
    private String correctEmail = "test@test.ru";
    private String notFullEmail = "test@";
    //подсказки
    private String nameOrgHint = "Укажите название компании";
    private String compSphereHint = "Укажите сферу деятельности";
    private String cityHint = "Введите название города";
    private String countOfEmployeesHint = "Введите количество сотрудников";
    private String contactPersonHint = "Укажите контактное лицо";
    private String telephoneHint = "Укажите номер телефона";
    private String emailHint = "Укажите адрес электронной почты";

    private String verifyPhoneText = "Подтвердите телефон";

    @DisplayName("Проверка наличия подсказок при отправлении пустых полей")
    @Test
    public void checkHintsWhenSendingEmptyFieldsTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(nameSection);
        SalaryProjectPage salaryProjectPage = new SalaryProjectPage();
        salaryProjectPage.enterCountOfEmployees("")
                .submitAnApplication()
                .checkCompanyNameHint(nameOrgHint)
                .checkActivityHint(compSphereHint)
                .checkCityHint(cityHint)
                .checkCountOfEmployeesHint(countOfEmployeesHint)
                .checkContactPersonHint(contactPersonHint)
                .checkContactPhoneNumberHint(telephoneHint);
    }

    @DisplayName("Есть подсказка при написании контактного лица не кириллицей")
    @Test
    public void checkHinWithNonCyrillicContactPersonTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(nameSection);
        SalaryProjectPage salaryProjectPage = new SalaryProjectPage();
        salaryProjectPage.enterContactPerson(incorrectContactPerson)
                .submitAnApplication()
                .checkContactPersonHint(contactPersonHint);
    }

    @DisplayName("Проверка возможности отправить заявку без e-mail")
    @Test
    public void checkThePossibilityToSendAnApplicationWithoutEmailTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(nameSection);
        SalaryProjectPage salaryProjectPage = new SalaryProjectPage();
        salaryProjectPage.enterCompanyName(nameOrg)
                .enterActivity(compSphere)
                .enterCity(city)
                .enterCountOfEmployees("10")
                .enterContactPerson(correctContactPerson)
                .enterContactPhoneNumber(correctTelephone)
                .submitAnApplication()
                .checkTheNeedToVerifyThePhone(verifyPhoneText);
    }

    @DisplayName("Невозможность отправить заявку с некорректным телефоном")
    @Test
    public void checkSendApplicationWithIncorrectPhoneNumberTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(nameSection);
        SalaryProjectPage salaryProjectPage = new SalaryProjectPage();
        salaryProjectPage.enterCompanyName(nameOrg)
                .enterActivity(compSphere)
                .enterCity(city)
                .enterCountOfEmployees("10")
                .enterContactPerson(correctContactPerson)
                .enterContactPhoneNumber(notFullTelephone)
                .enterEmail(correctEmail)
                .submitAnApplication()
                .checkContactPhoneNumberHint(telephoneHint);
    }

}