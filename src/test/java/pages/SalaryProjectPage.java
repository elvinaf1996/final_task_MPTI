package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SalaryProjectPage {

    //поля ввода
    private final By COMPANY_INPUT_FIELD = By.cssSelector("div.zp-ank-area-inp>#name_org");
    private final By ACTIVITY_INPUT_FIELD = By.cssSelector("div.zp-ank-area-inp>#compSphera");
    private final By CITY_INPUT_FIELD = By.cssSelector("div.zp-ank-area-inp>#wRegion");
    private final By COUNT_OF_EMPLOYEES_INPUT_FIELD = By.cssSelector("div.zp-ank-area-inp>[name=\"wPopulation\"]");
    private final By CONTACT_PERSON_INPUT_FIELD = By.cssSelector("div.zp-ank-area-inp>#name_kont");
    private final By CONTACT_PHONE_NUMBER_INPUT_FIELD = By.cssSelector("div.zp-ank-area-inp>#tel_kont ");
    private final By EMAIL_INPUT_FIELD = By.cssSelector("div.zp-ank-area-inp>#elp_kont");
    //подсказки
    private final By COMPANY_PROMPT = By.cssSelector("div.zp-ank-area-inp>#name_org-error");
    private final By ACTIVITY_PROMPT = By.cssSelector("div.zp-ank-area-inp>#compSphera-error");
    private final By CITY_PROMPT = By.cssSelector("div.zp-ank-area-inp>#wRegion-error");
    private final By COUNT_OF_EMPLOYEES_PROMPT = By.cssSelector("div.zp-ank-area-inp>#wPopulation-error");
    private final By CONTACT_PERSON_PROMPT = By.cssSelector("div.zp-ank-area-inp>#name_kont-error");
    private final By CONTACT_PHONE_NUMBER_PROMPT = By.cssSelector("div.zp-ank-area-inp>#tel_kont-error");
    private final By  EMAIL_PROMPT = By.cssSelector("div.zp-ank-area-inp#elp_kont-error>");

    private final By VERIFY_PHONE = By.cssSelector(".mts2-section-form__heading_small");
    private final By SEND_BUTTON = By.cssSelector("button#check-phone");

    @Step("Вводим название компании: {0}")
    public SalaryProjectPage enterCompanyName(String nameCompany){
        $(COMPANY_INPUT_FIELD).scrollTo().setValue(nameCompany);
        return this;
    }

    @Step("Вводим сферу деятельности: {0}")
    public SalaryProjectPage enterActivity(String nameSphere){
        $(ACTIVITY_INPUT_FIELD).scrollTo().setValue(nameSphere);
        return this;
    }

    @Step("Вводим название города/регион: {0}")
    public SalaryProjectPage enterCity(String nameCity){
        $(CITY_INPUT_FIELD).scrollTo().setValue(nameCity);
        return this;
    }

    @Step("Вводим количество сотрудников: {0}")
    public SalaryProjectPage enterCountOfEmployees(String countOfEmployees){
        $(COUNT_OF_EMPLOYEES_INPUT_FIELD).scrollTo().clear();
        $(COUNT_OF_EMPLOYEES_INPUT_FIELD).setValue(countOfEmployees);
        return this;
    }

    @Step("Вводим контактное лицо: {0}")
    public SalaryProjectPage enterContactPerson(String name){
        $(CONTACT_PERSON_INPUT_FIELD).scrollTo().setValue(name);
        return this;
    }

    @Step("Вводим контактный телефон: {0}")
    public SalaryProjectPage enterContactPhoneNumber(String phoneNumber){
        $(CONTACT_PHONE_NUMBER_INPUT_FIELD).scrollTo().setValue(phoneNumber);
        return this;
    }

    @Step("Вводим электронную почту: {0}")
    public SalaryProjectPage enterEmail(String email){
        $(EMAIL_INPUT_FIELD).scrollTo().setValue(email);
        return this;
    }

    @Step("Проверяем наличие подсказки на поле \"Название компании / ФИО ИП\": {0}")
    public SalaryProjectPage checkCompanyNameHint(String hint){
        $(COMPANY_PROMPT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем наличие подсказки на поле \"Сфера деятельности\": {0}")
    public SalaryProjectPage checkActivityHint(String hint){
        $(ACTIVITY_PROMPT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем наличие подсказки на поле \"Город / регион\": {0}")
    public SalaryProjectPage checkCityHint(String hint){
        $(CITY_PROMPT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем наличие подсказки на поле \"Кол-во сотрудников\": {0}")
    public SalaryProjectPage checkCountOfEmployeesHint(String hint){
        $(COUNT_OF_EMPLOYEES_PROMPT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем наличие подсказки на поле \"Контактное лицо\": {0}")
    public SalaryProjectPage checkContactPersonHint(String hint){
        $(CONTACT_PERSON_PROMPT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем наличие подсказки на поле \"Контактный телефон\": {0}")
    public SalaryProjectPage checkContactPhoneNumberHint(String hint){
        $(CONTACT_PHONE_NUMBER_PROMPT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверяем наличие подсказки на поле \"Электронная почта\": {0}")
    public SalaryProjectPage checkEmailHint(String hint){
        $(EMAIL_PROMPT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить необходимость подтвердить телефон")
    public SalaryProjectPage checkTheNeedToVerifyThePhone(String verifyPhoneText){
        $(VERIFY_PHONE).shouldHave(Condition.text(verifyPhoneText));
        return this;
    }

    @Step("Отправить заявку")
    public SalaryProjectPage submitAnApplication(){
        $(SEND_BUTTON).click();
        return this;
    }
}
