package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.HomePage;
import pages.InvestmentsPage;

import java.io.FileNotFoundException;

@DisplayName("Проверка страницы \"Инвестиции\"")
public class InvestmentsPageTest extends BaseTest{

    private String nameSection = "Инвестиции";
    private String instructionText = "Инструкция";
    private String hyperlinkInstructions = "как это сделать";
    private String vkLinkAdress = "https://vk.com/mtsbankru";
    private String telegramLinkAdress = "https://t.me/mts_bank_official";
    private String classmatesLinkAdress = "https://ok.ru/group/54564585799926/";

    @Test
    @DisplayName("Скачивание файла инструкции")
    public void downloadInstructionsTest() throws FileNotFoundException {

        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToSection(nameSection);

        InvestmentsPage investmentsPage = new InvestmentsPage();
        investmentsPage.downloadInstructionsChecking(instructionText, hyperlinkInstructions);

    }

    @Test
    @DisplayName("Скачивание информации о тарифе")
    public void downloadInformationAboutRateTest() throws FileNotFoundException {
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToSection(nameSection);
        InvestmentsPage investmentsPage = new InvestmentsPage();
        investmentsPage.downloadInformationAboutRateChecking();

    }

    @Test
    @DisplayName("Открытие страницы ВК по нажатию на иконку")
    public void openVKLinkTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToSection(nameSection);
        InvestmentsPage investmentsPage = new InvestmentsPage();
        investmentsPage.goToWebsiteVk(vkLinkAdress);
    }

    @Test
    @DisplayName("Открытие страницы телеграмма по нажатию на иконку")
    public void openTelegramLinkTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToSection(nameSection);
        InvestmentsPage investmentsPage = new InvestmentsPage();
        investmentsPage.goToWebsiteTelegram(telegramLinkAdress);
    }

    @Test
    @DisplayName("Открытие страницы одноклассников по нажатию на иконку")
    public void openClassmatesLinkTest(){
        HomePage homePage = new HomePage();
        homePage.openPage()
                .goToSection(nameSection);
        InvestmentsPage investmentsPage = new InvestmentsPage();
        investmentsPage.goToWebsiteСlassmates(classmatesLinkAdress);
    }

}
