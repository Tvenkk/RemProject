package remservise.authorization;

import core.base.BaseTest;
import core.pages.authorization.LoginPage;
import core.pages.orders.OrdersPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {
    private static LoginPage loginPage = new LoginPage();
    private static OrdersPage ordersPage;

    @BeforeEach
    public void entry() {
        open("login");
    }

    @Test
    @DisplayName("Проверка входа в Remservise")
    @Tag("Blocker")
    public void testLogin() {
        loginPage.login("r.tsapko", "Noviyparol1234!!");
        ordersPage = new OrdersPage();
        ordersPage.checkOrdersTitle();
    }
}
