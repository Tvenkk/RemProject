package remservise.authorization;

import core.base.BaseTest;
import core.components.SideBarComponent;
import core.pages.authorization.LoginPage;
import core.pages.orders.OrdersPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Tag("regress")
public class LoginTest extends BaseTest {
    private String
            defaultLogin = "r.tsapko",
            defaultPassword = "Noviyparol1234!!";

    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static OrdersPage ordersPage = new OrdersPage();

    @BeforeEach
    public void entry() {
        open("login");
    }

    @Test
    @Feature("Авторизация")
    @Story("Успешный вход в ЛК")
    @DisplayName("Проверка входа в Remservise")
    @Severity(SeverityLevel.BLOCKER)
    public void testLogin() {
        loginPage
                .login(defaultLogin, defaultPassword);
        ordersPage
                .checkOrdersTitle();
        sideBarComponent
                .exit();
        loginPage
                .checkOutputHeader();
    }
}
