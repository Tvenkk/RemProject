package remservise.passwordreset;

import core.base.BaseTest;
import core.pages.authorization.ForgotPasswordPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static core.utils.RandomData.emailRandom;
import static core.utils.RandomData.loginRandom;

public class PasswordResetErrorCheckingTests extends BaseTest {
    private String email = emailRandom;
    private static ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @BeforeEach
    public void entry() {
        open("restore");
    }

    @Test
    public void testIncorrectEmailErrorChecking() {
        forgotPasswordPage.passwordReset(loginRandom)
                .checkIncorrectEmail();
    }

    @Test
    public void testDisplayCheckRequiredField() {
        forgotPasswordPage.clickSendButton()
                .checkRequiredField();
    }

    @Test
    public void testUserWithThisEmailNotFound() {
        forgotPasswordPage.passwordReset(email)
                .checkUserNotFoundError(email);
    }
}
