package pages;

import com.codeborne.selenide.Condition;
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

    private void сheckLinkAddress(String linkAdress){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(linkAdress, currentUrl);
    }

    @Step("Скачивание файла инструкции")
    public InvestmentsPage downloadInstructionsChecking(String instructionText,
                                                String hyperlinkInstructions) throws FileNotFoundException {
        $(INSTRUCTION_TEXT).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo()
                .shouldHave(Condition.text(instructionText + " " + hyperlinkInstructions));
        $(HYPER_LINK).download();
        return this;
    }

    @Step("Скачивание файла  информацией о тарифе")
    public InvestmentsPage downloadInformationAboutRateChecking() throws FileNotFoundException {
        $(LINK_TO_DOWNLOAD_INFORMATION_ABOUT_RATE).scrollTo().download();
        return this;
    }

    @Step("Переход на сайт вк")
    public InvestmentsPage goToWebsiteVk(String linkAdress){
        $(VK_ICON).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo().click();
        switchTo().window(1);
        сheckLinkAddress(linkAdress);
        return this;
    }

    @Step("Переход в телеграмм")
    public InvestmentsPage goToWebsiteTelegram(String linkAdress){
        $(TELEGRAM_ICON).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo().click();
        switchTo().window(1);
        сheckLinkAddress(linkAdress);
        return this;
    }

    @Step("Переход в одноклассники")
    public InvestmentsPage goToWebsiteСlassmates(String linkAdress){
        $(CLASSMATES_ICON).shouldBe(Condition.visible, Duration.ofSeconds(10)).scrollTo().click();
        switchTo().window(1);
        сheckLinkAddress(linkAdress);
        return this;
    }

}
