package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditCardPage {

    private final By FIELD_FOR_FULL_NAME = By.cssSelector("[placeholder=\"Иванов Иван Иванович\"]");
    private final By FIELD_FOR_DATE_OF_BIRTHDAY = By.cssSelector("[placeholder=\"дд.мм.гггг\"]");
    private final By FIELD_FOR_MOBILE_PHONE = By.cssSelector("[placeholder=\"+7 000 000-00-00\"]");
    private final By FIELD_FOR_EMAIL = By.cssSelector("[placeholder=\"mail@example.ru\"]");
    private final By FULL_NAME_HINT = By.cssSelector(".GridCell-sc-14ygre9-0.hPXRpS>[data-testid=\"text\"]");
    private final By DATE_OF_BIRTHDAY_HINT = By.cssSelector(".GridCell-sc-14ygre9-0.hPXRpO>[data-testid=\"text\"]");
    private final By PHONE_AND_EMAIL_HINTS = By.cssSelector(".GridCell-sc-14ygre9-0.hPXRpQ>[data-testid=\"text\"]");
    private final By CHECKBOX_CONSENT_PD = By.cssSelector(".Label-sc-cb89gg-4.hJMxLJ>div[type=\"checkbox\"]");
    private final By SEND_DATA_BUTTON = By.cssSelector("button[tabindex=\"0\"]:not(.styled__BannerButton-rdx1hz-0)>div[data-testid=\"flexbox\"]");
    private final By CONSENT_PERSONAL_DATE_HINT = By.cssSelector(".GridCell-sc-14ygre9-0.jfxywB>[data-testid=\"text\"]");


    @Step("Вводим ФИО")
    public CreditCardPage addFullName(String name){
        $(FIELD_FOR_FULL_NAME).shouldBe(Condition.visible).scrollTo().sendKeys(name);
        return this;
    }

    @Step("Вводим дату рождения")
    public CreditCardPage addBirthdayDate(String date){
        $(FIELD_FOR_DATE_OF_BIRTHDAY).shouldBe(Condition.visible).scrollTo().sendKeys(date);
        return this;
    }

    @Step("Вводим номер телефона")
    public CreditCardPage addMobilePhone(String numberOfPhone){
        $(FIELD_FOR_MOBILE_PHONE).shouldBe(Condition.visible).scrollTo().sendKeys(numberOfPhone);
        return this;
    }

    @Step("Вводим e-mail")
    public CreditCardPage addEmail(String email){
        $(FIELD_FOR_EMAIL).shouldBe(Condition.visible).scrollTo().sendKeys(email);
        return this;
    }

    @Step("Убираем согласие на обработку ПД")
    public CreditCardPage deleteСonsentToTheProcessingOfPersonalData(){
        $(CHECKBOX_CONSENT_PD).scrollTo().click();
        return this;
    }

    @Step("Нажимаем кнопку \"Далее\"")
    public CreditCardPage sendDataForCardOrder(){
        $(SEND_DATA_BUTTON).click();
        return this;
    }

    @Step("Проверяем корректную подсказку к ФИО")
    public CreditCardPage checkFullNameHint(String fullNameHint){
        $(FULL_NAME_HINT).shouldHave(Condition.text(fullNameHint));
        return this;
    }

    @Step("Проверяем корректную подсказку к дате рождения")
    public CreditCardPage checkDateOfBirthdayHint(String dateOfBirthdayHint){
        $(DATE_OF_BIRTHDAY_HINT).shouldHave(Condition.text(dateOfBirthdayHint));
        return this;
    }

    @Step("Проверяем корректную подсказку к номеру телефона")
    public CreditCardPage checkMobilePhoneHint(String mobilePhoneHint){
        $$(PHONE_AND_EMAIL_HINTS).first().shouldHave(Condition.text(mobilePhoneHint));
        return this;
    }

    @Step("Проверяем корректную подсказку к e-mail")
    public CreditCardPage checkEmailHint(String emailHint){
        $$(PHONE_AND_EMAIL_HINTS).last().shouldHave(Condition.text(emailHint));
        return this;
    }

    @Step("Проверяем подсказку при отсутствии согласия на обработку ПД")
    public CreditCardPage checkСonsentToTheProcessingOfPersonalDataHint(String consentToTheProcessingOfPersonalDataHint){
        $(CONSENT_PERSONAL_DATE_HINT).shouldHave(Condition.text(consentToTheProcessingOfPersonalDataHint));
        return this;
    }

}
