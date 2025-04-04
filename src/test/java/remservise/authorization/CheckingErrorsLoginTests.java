package remservise.authorization;

import core.base.BaseTest;
import core.pages.authorization.LoginPage;
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
    @DisplayName("Проверяем, что под полями Логин и Пароль высвечивается текст 'Обязательное поле'")
    @Tag("Major")
    public void testCheckErrorLogin() {
        loginPage.clickLoginButton()
                .checkErrorLoginMessage()
                .checkErrorPasswordMessage();
    }

    @Test
    @DisplayName("Проверяем, что всплывает уведомление с текстом 'Пользователь не найден!'")
    @Tag("Major")
    public void testCheckErrorUserNotFound() {
        loginPage.login(loginRandom, passwordRandom)
                .checkErrorUserNotFound();
    }

    @Test
    @DisplayName("Проверяем, что всплывает уведомление с текстом 'Некорректный пароль!'")
    @Tag("Major")
    public void testCheckErrorIncorrectPassword() {
        loginPage.login("r.tsapko", passwordRandom)
                .checkErrorIncorrectPassword();
    }
}
