package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.CreditHolidaysPage;
import pages.HomePage;

import java.io.FileNotFoundException;

@DisplayName("Поверка страницы: Кредитные каникулы")
public class CreditHolidaysTest extends BaseTest {

    private String sectionNameFromShooter = "Кредитные каникулы";
    private String creditForGoods = "Кредит на товар";
    private String nonPurposeLoan = "Нецелевой потребительский кредит";
    private String creditCard = "Кредитная карта";
    private String mortgage = "Ипотека";
    private String carLoan = "Автокредит";
    private String authorizationLink = "https://sso.mtsbank.ru/login/mtsmoney/auth/";
    private String phoneNumber = "8 800 250 05 20";

    @DisplayName("Скачивание файла с информацией о необходимых документах")
    @Test
    public void downloadingAFileWithInformationAboutTheRequiredDocumentTest() throws FileNotFoundException {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(sectionNameFromShooter);
        CreditHolidaysPage creditHolidaysPage = new CreditHolidaysPage();
        creditHolidaysPage.сheckingTheDownloadOfAFileWithInformationAboutDocuments();
    }

    @DisplayName("Появление информации о сумме кредита")
    @Test
    public void informationAboutTheAmountOfTheLoanTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(sectionNameFromShooter);
        CreditHolidaysPage creditHolidaysPage = new CreditHolidaysPage();
        creditHolidaysPage.checkingInformationAboutTheAmountOfTheLoan();
    }

    @DisplayName("Заявка на подключение программы: \"Кредит на товар\"")
    @Test
    public void applicationForConnectingTheProgramCreditForGoodsTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(sectionNameFromShooter);
        CreditHolidaysPage creditHolidaysPage = new CreditHolidaysPage();
        creditHolidaysPage.chooseTheTypeOfLoan(creditForGoods)
                .checkingTheNeedForAuthorization(authorizationLink);
    }

    @DisplayName("Заявка на подключение программы: \"Нецелевой потребительский кредит\"")
    @Test
    public void applicationForConnectingTheProgramNonPurposeLoanTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(sectionNameFromShooter);
        CreditHolidaysPage creditHolidaysPage = new CreditHolidaysPage();
        creditHolidaysPage.chooseTheTypeOfLoan(nonPurposeLoan)
                .checkingTheNeedForAuthorization(authorizationLink);;
    }

    @DisplayName("Заявка на подключение программы: \"Кредитная карта\"")
    @Test
    public void applicationForConnectingTheProgramCreditCardTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(sectionNameFromShooter);
        CreditHolidaysPage creditHolidaysPage = new CreditHolidaysPage();
        creditHolidaysPage.chooseTheTypeOfLoan(creditCard)
                .checkingForAPhoneNumber(phoneNumber);
    }

    @DisplayName("Заявка на подключение программы: \"Ипотека\"")
    @Test
    public void applicationForConnectingTheProgramMortgageTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(sectionNameFromShooter);
        CreditHolidaysPage creditHolidaysPage = new CreditHolidaysPage();
        creditHolidaysPage.chooseTheTypeOfLoan(mortgage)
                .checkingForAPhoneNumber(phoneNumber);
    }

    @DisplayName("Заявка на подключение программы: \"Автокредит\"")
    @Test
    public void applicationForConnectingTheProgramCarLoanTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToFooterSections(sectionNameFromShooter);
        CreditHolidaysPage creditHolidaysPage = new CreditHolidaysPage();
        creditHolidaysPage.chooseTheTypeOfLoan(carLoan)
                .checkingForAPhoneNumber(phoneNumber);
    }
}
