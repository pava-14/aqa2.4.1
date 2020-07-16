package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    private final String cardNunber0001 = "5559 0000 0000 0001";
    private final String cardNunber0002 = "5559 0000 0000 0002";

    private DashboardPage openDashboard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode();
        return verificationPage.validVerify(verificationCode);
    }

    @Test
    public void shouldTransferFromCard0001toCard002() {
        DashboardPage page = openDashboard();
        page.updateBalance();
        int currentBalance = page.getBalance("0001");
        int expected = currentBalance + 5000;
        page.moneyTransfer("0001", cardNunber0002, 5000);
        page.updateBalance();
        assertEquals(expected, page.getBalance("0001"));
    }
}
