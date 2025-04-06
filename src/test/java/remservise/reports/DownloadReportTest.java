package remservise.reports;

import core.base.BaseTest;
import core.components.SideBarComponent;
import core.pages.authorization.LoginPage;
import core.pages.reports.ReportsPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

@Tag("regress")
public class DownloadReportTest extends BaseTest {
    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static ReportsPage reportsPage = new ReportsPage();

    @BeforeEach
    public void entry() {
        open("login");
    }

    @Disabled("Кнопка для скачивания отчета не имеет атрибут 'href'")
    @Test
    @DisplayName("Проверка скачивания отчета формат xls")
    public void testDownloadReport() throws Exception {
        loginPage.login("r.tsapko", "Noviyparol1234!!");
        sideBarComponent.clickReportsChapter();
        reportsPage.downloadTheReports();
        System.out.println("");
    }
}
