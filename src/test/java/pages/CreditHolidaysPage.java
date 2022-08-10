package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class CreditHolidaysPage {

    private final By LINKS_IN_TEXT = By.cssSelector("[data-testid=\"text\"]>[data-testid=\"link\"]");
    private final By ABOUT_MAX_SUM_MODAL = By.cssSelector("[data-testid=\"modal\"]");
    private final By LIST_BUTTON_TO_SELECT_CREDIT = By.cssSelector("[placeholder=\"Выберите из списка\"]");
    private final By DROPDOWN_LIST_ITEM = By.cssSelector(".Wrapper-sc-1vydk7-0.qtifC.Label-sc-1uyl36s-2");
    private final By LOG_IN_BUTTON = By.cssSelector("a[target=\"_blank\"]>[data-testid=\"flexbox\"]");
    private final By TELEPHONE_FOR_COMMUNICATION = By.cssSelector(".styled__ContactsInfo-sc-1oc0793-5 [target=\"_self\"]");

    //проверка url сайта
    private void сheckLinkAddress(String linkAddress){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(linkAddress, currentUrl);
    }

    @Step("Скачивание файла с информацией о необходимых документах")
    public CreditHolidaysPage сheckingTheDownloadOfAFileWithInformationAboutDocuments() throws FileNotFoundException {
        $$(LINKS_IN_TEXT).first().scrollTo().download();
        return this;
    }

    @Step("Проверка появления информации о сумме кредита")
    public CreditHolidaysPage checkingInformationAboutTheAmountOfTheLoan(){
        $$(LINKS_IN_TEXT).last().scrollTo().click();
        $(ABOUT_MAX_SUM_MODAL).shouldBe(Condition.visible);
        return this;
    }

    @Step("Выбираем тип кредита: {0}")
    public CreditHolidaysPage chooseTheTypeOfLoan(String nameTypeOfLoan){
        $(LIST_BUTTON_TO_SELECT_CREDIT).scrollTo().click();
        $$(DROPDOWN_LIST_ITEM).findBy(Condition.text(nameTypeOfLoan)).click();
        return this;
    }

    @Step("Проверяем необходимость авторизации")
    public CreditHolidaysPage checkingTheNeedForAuthorization(String linkAddress){
        $(LOG_IN_BUTTON).click();
        switchTo().window(1);
        сheckLinkAddress(linkAddress);
        return this;
    }

    @Step("Проверяем наличие номера телефона для связи")
    public CreditHolidaysPage checkingForAPhoneNumber(String phoneNumber){
        $(TELEPHONE_FOR_COMMUNICATION).shouldHave(Condition.text(phoneNumber));
        return this;
    }
}
