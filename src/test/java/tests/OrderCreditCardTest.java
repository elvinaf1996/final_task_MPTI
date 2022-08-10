package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.CreditCardPage;
import pages.HomePage;

@DisplayName("Проверка работы формы заказа кредитной карты")
public class OrderCreditCardTest extends BaseTest {

    private String correctFullName = "Тестов Тест Тестович";
    private String notFullName = "Тест";
    private String fullNameInEnglish = "Testov Test Testovich";
    private String correctDateOfBirthday = "09.12.1996";
    private String incorrectDateOfBirthday = "09.12";
    private String correctPhoneNumber = "999 999-99-99";
    private String incorrectPhoneNumber = "919919";
    private String correctEmail = "test@test.ru";
    private String incorrectEmail = "test@test";
    private String fullNameHint = "Введите ФИО полностью";
    private String fullNameHintEnglishWords = "Используйте только кириллицу";
    private String dateOfBirthdayHint = "Обязательное поле";
    private String mobilePhoneHint = "Введите верный номер телефона";
    private String emailHint = "Введите верный электронный адрес";
    private String consentToTheProcessingOfPersonalDataHint = "Установите этот флажок";
    private String hintOfNeedToConfirmTheNumber = "Подтвердите номер телефона";
    private String sendMessageText = "Код подтверждения отправлен на номер";

    @Test
    @DisplayName("Наличие подсказки при написании неполного имени")
    public void haveHintWithNotFullNameTest(){

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
    @DisplayName("Наличие подсказки при написании имени латинскими буквами")
    public void haveHintWithNameNotCyrillicTest(){

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
    @DisplayName("Наличия подсказки при написании неполного номера телефона")
    public void haveHintWithNotFullMobilePhoneTest(){

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
    @DisplayName("Наличия подсказки при вводе некорректного email")
    public void haveHintWithIncorrectEmailTest(){

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
    @DisplayName("Наличие подсказки при неполной дате рождения")
    public void haveHintWithoutDateOfBirthdayTest(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage
                .addBirthdayDate(incorrectDateOfBirthday)
                .sendDataForCardOrder()
                .checkDateOfBirthdayHint(dateOfBirthdayHint);
    }

    @Test
    @DisplayName("Наличие подсказки на обязательное поле: согласие на обработку ПД")
    public void haveHintConsentToTheProcessingOfPersonalDataTest(){

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage.deleteСonsentToTheProcessingOfPersonalData()
                .sendDataForCardOrder()
                .checkСonsentToTheProcessingOfPersonalDataHint(consentToTheProcessingOfPersonalDataHint);
    }

    @Test
    @DisplayName("Запрос кода из смс при отправки корректных данных")
    public void requestCodeFromSmsWithCorrectDataTest() {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToCreditCardPage();

        CreditCardPage creditCardPage = new CreditCardPage();
        creditCardPage.addEmail(correctEmail)
                .addMobilePhone(correctPhoneNumber)
                .addFullName(correctFullName)
                .addBirthdayDate(correctDateOfBirthday)
                .sendDataForCardOrder()
                .checkHintOfNeedToConfirmTheNumber(hintOfNeedToConfirmTheNumber, sendMessageText, correctPhoneNumber);
    }
}
