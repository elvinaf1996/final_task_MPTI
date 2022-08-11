package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class InvestmentsPage {

    private final By INSTRUCTION_TEXT = By.cssSelector("[class=\"apps__text\"]");
    private final By HYPER_LINK = By.cssSelector(".apps__text a");
    private final By LINK_TO_DOWNLOAD_INFORMATION_ABOUT_RATE = By.cssSelector("[class=\"documents-product__list\"]>a");
    private final By VK_ICON = By.cssSelector(".styled__TopDesktopFooter-sc-11zgo51-1 [aria-label=\"Vk\"]");
    private final By TELEGRAM_ICON = By.cssSelector(".styled__TopDesktopFooter-sc-11zgo51-1 [aria-label=\"Telegram\"]");
    private final By CLASSMATES_ICON = By.cssSelector(".styled__TopDesktopFooter-sc-11zgo51-1 [aria-label=\"Ok\"]");
    private final By ELEMENT_LIST_ITEM = By.cssSelector("li.accordion__item");
    private final By DROPDOWN_BOXES_WITH_TEXT = By.cssSelector("div.accordion__answer");

    //проверка url сайта
    private void checkLinkAddress(String linkAddress){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(linkAddress, currentUrl);
    }

    @Step("Скачивание файла инструкции")
    public InvestmentsPage downloadInstructionsChecking(String instructionText,
                                                String hyperlinkInstructions) throws FileNotFoundException {
        $(INSTRUCTION_TEXT).scrollTo().shouldHave(Condition.text(instructionText + " " + hyperlinkInstructions));
        $(HYPER_LINK).download();
        return this;
    }

    @Step("Скачивание файла с информацией о тарифе")
    public InvestmentsPage downloadInformationAboutRateChecking() throws FileNotFoundException {
        $(LINK_TO_DOWNLOAD_INFORMATION_ABOUT_RATE).scrollTo().download();
        return this;
    }

    @Step("Переход на сайт вк: {0}")
    public InvestmentsPage goToWebsiteVk(String linkAddress){
        $(VK_ICON).scrollTo().click();
        switchTo().window(1);
        checkLinkAddress(linkAddress);
        return this;
    }

    @Step("Переход в телеграмм: {0}")
    public InvestmentsPage goToWebsiteTelegram(String linkAddress){
        $(TELEGRAM_ICON).scrollTo().click();
        switchTo().window(1);
        checkLinkAddress(linkAddress);
        return this;
    }

    @Step("Переход в одноклассники: {0}")
    public InvestmentsPage goToWebsiteСlassmates(String linkAdress){
        $(CLASSMATES_ICON).scrollTo().click();
        switchTo().window(1);
        checkLinkAddress(linkAdress);
        return this;
    }

    @Step("Проверяем, что каждый выпадающий список открывается и непустой (содержит текст)")
    public InvestmentsPage checkingTheOperationOfTheDropdownList(){
        for(SelenideElement selenideElement : $$(ELEMENT_LIST_ITEM)){
            selenideElement.scrollTo().click();
            selenideElement.$(DROPDOWN_BOXES_WITH_TEXT)
                    .shouldNotHave(Condition.empty)
                    .shouldHave(Condition.attribute("style", "display: block;"));
        }
        return this;
    }
}
