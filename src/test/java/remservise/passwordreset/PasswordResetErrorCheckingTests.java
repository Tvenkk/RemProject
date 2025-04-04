package remservise.passwordreset;

import core.base.BaseTest;
import core.pages.authorization.ForgotPasswordPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
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
    @Severity(SeverityLevel.NORMAL)
    public void testIncorrectEmailErrorChecking() {
        forgotPasswordPage.passwordReset(loginRandom)
                .checkIncorrectEmail();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testDisplayCheckRequiredField() {
        forgotPasswordPage.clickSendButton()
                .checkRequiredField();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testUserWithThisEmailNotFound() {
        forgotPasswordPage.passwordReset(email)
                .checkUserNotFoundError(email);
    }
}
