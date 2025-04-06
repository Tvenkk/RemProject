package remservise.authorization;

import core.base.BaseTest;
import core.pages.authorization.LoginPage;
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
public class CheckingErrorsLoginTests extends BaseTest {
    private static LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void entry() {
        open("login");
    }

    @Test
    @Feature("Авторизация")
    @Story("Проверка ошибок")
    @DisplayName("Проверяем, что под полями Логин и Пароль высвечивается текст 'Обязательное поле'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckErrorLogin() {
        loginPage.clickLoginButton()
                .checkErrorLoginMessage()
                .checkErrorPasswordMessage();
    }

    @Test
    @Feature("Авторизация")
    @Story("Проверка ошибок")
    @DisplayName("Проверяем, что всплывает уведомление с текстом 'Пользователь не найден!'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckErrorUserNotFound() {
        loginPage.login(loginRandom, passwordRandom)
                .checkErrorUserNotFound();
    }

    @Test
    @Feature("Авторизация")
    @Story("Проверка ошибок")
    @DisplayName("Проверяем, что всплывает уведомление с текстом 'Некорректный пароль!'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckErrorIncorrectPassword() {
        loginPage.login("r.tsapko", passwordRandom)
                .checkErrorIncorrectPassword();
    }
}
