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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;

@Tag("regress")
public class ParameterizedLoginTest extends BaseTest {
    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static OrdersPage ordersPage = new OrdersPage();;

    @BeforeEach
    public void entry() {
        open("login");
    }

    @CsvSource(value = {
            "r.tsapko,    Noviyparol1234!!,  MAIN_ADMIN",
            "r.tsapkoAK,  sSHzl3fbCI,        CLIENT_ADMIN",
            "r.tsapkoCM,  K5wJ2nfIeT,        CTO_MANAGER"
    })
    @ParameterizedTest
    @Feature("Авторизация")
    @Story("Успешный вход в ЛК от разных ролей")
    @DisplayName("Проверка входа в Remservise")
    @Severity(SeverityLevel.BLOCKER)
    public void testLogin(String username, String password, String role) {
        loginPage
                .login(username, password);
        sideBarComponent
                .checkLoginAndRole(username, role);
        ordersPage
                .checkOrdersTitle();
        sideBarComponent
                .exit();
        loginPage
                .checkOutputHeader();
    }
}
