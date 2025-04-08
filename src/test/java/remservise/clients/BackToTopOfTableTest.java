package remservise.clients;

import core.base.BaseTest;
import core.components.SideBarComponent;
import core.pages.authorization.LoginPage;
import core.pages.clients.ClientsPage;
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
public class BackToTopOfTableTest extends BaseTest {
    private String
            defaultLogin = "r.tsapko",
            defaultPassword = "Noviyparol1234!!";

    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static ClientsPage clientsPage = new ClientsPage();

    @BeforeEach
    public void entry() {
        open("login");
    }

    @Test
    @Feature("Раздел 'Клиенты'")
    @Story("Возврат наверх")
    @DisplayName("Проверяем, что при нажатии на кнопку возврата, возвращаемся в начало таблицы")
    @Severity(SeverityLevel.NORMAL)
    public void testBackToTopOfTable() {
        loginPage
                .login(defaultLogin, defaultPassword);
        sideBarComponent
                .clickClientsChapter();
        clientsPage
                .checkTableHeader()
                .scrollToPaginationButton()
                .goingBackUp()
                .checkVisibleUpButton()
                .checkTableHeader();
    }
}
