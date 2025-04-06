package remservise.passwordreset;

import core.base.BaseTest;
import core.pages.authorization.ForgotPasswordPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Tag("regress")
public class PasswordResetTest extends BaseTest {
    private static ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @BeforeEach
    public void entry() {
        open("restore");
    }

    @Test
    @DisplayName("Проверяем, что письмо о восстановлении пароля было отправлено на почту")
    @Severity(SeverityLevel.BLOCKER)
    public void testPasswordReset() {
        forgotPasswordPage.checkTitleForm()
                .passwordReset("r.tsapko@aqsi.ru")
                .checkSuccessfullySentMessage();
    }
}
