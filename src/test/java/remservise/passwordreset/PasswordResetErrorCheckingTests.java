package remservise.passwordreset;

import core.base.BaseTest;
import core.pages.authorization.ForgotPasswordPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static core.utils.RandomData.emailRandom;
import static core.utils.RandomData.loginRandom;

@Tag("regress")
public class PasswordResetErrorCheckingTests extends BaseTest {
    private String email = emailRandom;
    private static ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @BeforeEach
    public void entry() {
        open("restore");
    }

    @Test
    @Feature("Восстановление пароля")
    @Story("Отображение ошибок")
    @DisplayName("Проверяем, что под полем E-mail высвечивается текст 'Не корректный e-mail !'")
    @Severity(SeverityLevel.CRITICAL)
    public void testIncorrectEmailErrorChecking() {
        forgotPasswordPage
                .passwordReset(loginRandom)
                .checkIncorrectEmail();
    }

    @Test
    @Feature("Восстановление пароля")
    @Story("Отображение ошибок")
    @DisplayName("Проверяем, что под полем E-mail высвечивается текст 'Обязательное поле'")
    @Severity(SeverityLevel.CRITICAL)
    public void testDisplayCheckRequiredField() {
        forgotPasswordPage
                .clickSendButton()
                .checkRequiredField();
    }

    @Test
    @Feature("Восстановление пароля")
    @Story("Отображение ошибок")
    @DisplayName("Проверяем, что пользователь с введенным email не найден")
    @Severity(SeverityLevel.CRITICAL)
    public void testUserWithThisEmailNotFound() {
        forgotPasswordPage
                .passwordReset(email)
                .checkUserNotFoundError(email);
    }
}
