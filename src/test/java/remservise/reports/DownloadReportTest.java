package remservise.reports;

import core.base.BaseTest;
import core.components.SideBarComponent;
import core.pages.authorization.LoginPage;
import core.pages.reports.ReportsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DownloadReportTest extends BaseTest {

    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static ReportsPage reportsPage = new ReportsPage();

    @BeforeEach
    @DisplayName("Открываем страницу авторизации")
    public void setuo() {
        open("login");
    }

    @Disabled("Кнопка не имеют атрибут 'href'")
    @Test
    @DisplayName("Проверка скачивания отчета формат xls")
    public void testDownloadReport() throws Exception {
        loginPage.login("r.tsapko", "Noviyparol1234!!");
        sideBarComponent.clickReportsChapter();
        reportsPage.downloadTheReports();
        System.out.println("");
    }
}
