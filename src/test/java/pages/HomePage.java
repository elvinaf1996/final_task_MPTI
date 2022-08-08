package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static tests.BaseTest.cfg;

public class HomePage {

    private final By BUTTONS = By.cssSelector("a[data-testid=\"button\"]>[data-testid=\"flexbox\"]");

    @Step("Открываем главную страницу")
    public HomePage openPage() {
        open(cfg.baseUrl());
        return this;
    }

    @Step("Нажимаем кнопку \"подробнее\"")
    public HomePage goToCreditCardPage(){
        $$(BUTTONS).first().shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        return this;
    }
}

