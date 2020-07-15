package ru.netology.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.*;

/*
 * cards:
 * first:
 * number: '5559 0000 0000 0001'
 * balance: 10 000 RUB
 * second:
 * number: '5559 0000 0000 0002'
 * balance: 10 000 RUB

1. Перевода с определённой карты на другую карту n'ой суммы
2. Проверки баланса по карте (со страницы списка карт)
 */
public class MoneyTransferTest {
    private void enterAccount() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode);
    }

    /*
    Когда он переводит "5 000" рублей с карты с номером "5559 0000 0000 0002" на свою "1" карту с главной страницы;
     */
    public void shouldTransferFromCard0001toCard002 () {
        ElementsCollection cardList = $$(".list .list__item");
        cardList.get(0).$(WithText("Пополнить")).click();
    }

    /*
    Тогда баланс его "1" карты из списка на главной странице должен стать "15 000" рублей.
     */
    public void shouldCheckBalanceTransferFromCard000 () {

    }
}
