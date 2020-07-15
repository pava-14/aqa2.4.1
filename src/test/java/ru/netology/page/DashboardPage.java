package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
    @FindBy(css = "[data-test-id=dashboard]")
    private SelenideElement heading;

    public DashboardPage() {
        heading.shouldBe(visible);
    }
}
