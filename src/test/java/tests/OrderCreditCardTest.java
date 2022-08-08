package tests;

import io.qameta.allure.Description;
import org.junit.Test;
import pages.CreditCardPage;
import pages.HomePage;


public class OrderCreditCardTest extends BaseTest {

    private String correctFullName = "Тестов Тест Тестович";
    private String notFullName = "Тест";
    private String fullNameInEnglish = "Testov Test Testovich";
    private String dateOfBirthday = "09.12.1996";
    private String correctPhoneNumber = "9199199999";
    private String incorrectPhoneNumber = "919919";
    private String correctEmail = "test@test.ru";
    private String incorrectEmail = "test@test";
    private String fullNameHint = "Введите ФИО полностью";
    private String fullNameHintEnglishWords = "Используйте только кириллицу";
    private String dateOfBirthdayHint = "Обязательное поле";
    private String mobilePhoneHint = "Введите верный номер телефона";
    private String emailHint = "Введите верный электронный адрес";
    private String consentToTheProcessingOfPersonalDataHint = "Установите этот флажок";

    @Test
    @Description("Проверка наличия подсказки при написании неполного имени")
    public void chooseHaveHintWithNotFullName(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage
                .addFullName(notFullName)
                .sendDataForCardOrder()
                .checkFullNameHint(fullNameHint);
    }

    @Test
    @Description("Проверка наличия подсказки при написании имени латинскими буквами")
    public void chooseHaveHintWithNameNotCyrillic(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage
                .addFullName(fullNameInEnglish)
                .sendDataForCardOrder()
                .checkFullNameHint(fullNameHintEnglishWords);
    }

    @Test
    @Description("Проверка наличия подсказки при написании неполного номера телефона")
    public void chooseHaveHintWithNotFullMobilePhone(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage
                .addMobilePhone(incorrectPhoneNumber)
                .sendDataForCardOrder()
                .checkMobilePhoneHint(mobilePhoneHint);
    }

    @Test
    @Description("Проверка наличия подсказки при вводе некорректном email")
    public void chooseHaveHintWithIncorrectEmail(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage
                .addEmail(incorrectEmail)
                .sendDataForCardOrder()
                .checkEmailHint(emailHint);
    }

    @Test
    @Description("Проверка наличия подсказки при отсутствии даты рождения")
    public void chooseHaveHintWithoutDateOfBirthday(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage
                .addFullName(correctFullName)
                .addMobilePhone(correctPhoneNumber)
                .addEmail(correctEmail)
                .sendDataForCardOrder()
                .checkDateOfBirthdayHint(dateOfBirthdayHint);
    }

    @Test
    @Description("Проверка наличия согласия на обработку ПД")
    public void chooseHaveHintConsentToTheProcessingOfPersonalData(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage.deleteСonsentToTheProcessingOfPersonalData()
                .checkСonsentToTheProcessingOfPersonalDataHint(consentToTheProcessingOfPersonalDataHint);
    }

}
