package remservise.reports;

import core.base.BaseTest;
import core.components.SideBarComponent;
import core.pages.authorization.LoginPage;
import core.pages.reports.ReportsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

@Tag("regress")
public class DownloadReportTest extends BaseTest {
    private String
            defaultLogin = "r.tsapko",
            defaultPassword = "Noviyparol1234!!";

    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static ReportsPage reportsPage = new ReportsPage();

    @BeforeEach
    public void entry() {
        open("login");
    }

    @Disabled("Кнопка для скачивания отчета не имеет атрибут 'href'")
    @Test
    @Feature("Раздел 'Отчеты'")
    @Story("Скачивание отчета")
    @DisplayName("Проверка скачивания отчета")
    public void testDownloadReport() throws Exception {
        loginPage
                .login(defaultLogin, defaultPassword);
        sideBarComponent
                .clickReportsChapter();
        reportsPage
                .downloadTheReports();
        System.out.println("");
    }
}
