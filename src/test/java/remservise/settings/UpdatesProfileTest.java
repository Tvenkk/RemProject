package remservise.settings;

import core.base.BaseTest;
import core.components.SideBarComponent;
import core.pages.authorization.LoginPage;
import core.pages.settings.SettingsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static core.utils.RandomData.*;

@Tag("regress")
public class UpdatesProfileTest extends BaseTest {
    private String
            defaultLogin = "r.tsapko",
            defaultPassword = "Noviyparol1234!!",
            name = loginRandom,
            phone = phoneRandom,
            email = emailRandom;

    private static LoginPage loginPage = new LoginPage();
    private static SideBarComponent sideBarComponent = new SideBarComponent();
    private static SettingsPage settingsPage = new SettingsPage();

    @BeforeEach
    public void entry() {
        open("login");
    }

    @Test
    @Feature("Раздел 'Настройки'")
    @Story("Редактирование профиля")
    @DisplayName("Проверяем, что после редактирования полей профиля, значения изменились")
    @Severity(SeverityLevel.CRITICAL)
    public void testUpdatesProfile() {
        loginPage
                .login(defaultLogin, defaultPassword);
        sideBarComponent
                .clickSettingsChapter();
        settingsPage
                .checkTitle()
                .editFields(name, phone, email)
                .enterPassword(defaultPassword)
                .clickSaveButton()
                .checkNoticeSucces()
                .checkValuesInFields(name, phone, email);
    }
}
