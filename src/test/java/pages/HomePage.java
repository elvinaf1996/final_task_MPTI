package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By BUTTONS = By.cssSelector("a[data-testid=\"button\"]>[data-testid=\"flexbox\"]");
    private final By SECTIONS = By.cssSelector(".LinkWrapper-sc-a7l7fm-0.eaxjcO.styled__MenuItem-sc-ip06ne-6");

    @Step("Открываем главную страницу")
    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    @Step("Нажимаем кнопку \"подробнее\"")
    public HomePage goToCreditCardPage(){
        $$(BUTTONS).first().shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        return this;
    }

    @Step("Перейти в раздел: {0}")
    public HomePage goToSection(String nameSection){
        $$(SECTIONS).findBy(Condition.text(nameSection)).shouldBe(Condition.visible, Duration.ofSeconds(15)).click();
        return this;
    }
}

