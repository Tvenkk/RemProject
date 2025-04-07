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

@Tag("regress")
public class PasswordResetTest extends BaseTest {
    private String defaultEmail = "r.tsapko@aqsi.ru";
    private static ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @BeforeEach
    public void entry() {
        open("restore");
    }

    @Test
    @Feature("Восстановление пароля")
    @Story("Успешная отправка письма о восстановлении пароля на почту")
    @DisplayName("Проверяем, что письмо о восстановлении пароля было отправлено на почту")
    @Severity(SeverityLevel.BLOCKER)
    public void testPasswordReset() {
        forgotPasswordPage
                .checkTitleForm()
                .passwordReset(defaultEmail)
                .checkSuccessfullySentMessage();
    }
}
