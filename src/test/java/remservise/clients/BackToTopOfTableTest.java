package remservise.clients;

import com.codeborne.selenide.Configuration;
import core.components.SideBarComponent;
import core.pages.authorization.LoginPage;
import core.pages.clients.ClientsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class BackToTopOfTableTest {
    private String
            defaultLogin = "r.tsapko",
            defaultPassword = "Noviyparol1234!!";

    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static ClientsPage clientsPage = new ClientsPage();

    @BeforeEach
    public void entry() {
        open("https://test-remservice.aqsi.ru/login");
        Configuration.timeout = 17000;
    }

    @Test
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
