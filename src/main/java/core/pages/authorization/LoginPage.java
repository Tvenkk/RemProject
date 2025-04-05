package core.pages.authorization;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final String
            LOGIN_ERROR_MESSAGE = "Обязательное поле",
            SNAKEBAR_USER_NOT_FOUND = "Пользователь не найден!",
            SNAKEBAR_INCORRECT_PASSWORD = "Некорректный пароль!",
            TITLE_TEXT = "Вход в систему",
            EXIT_TITLE = "Вы вышли из системы";

    // Локаторы формы
    private SelenideElement
            loginField = $("[name='login']"),
            passwordField = $("[name='password']"),
            visiblePasswordToggle = $(".css-1yxmbwk"),
            loginButton = $("[type='submit']"),
            forgotPassword = $(byTagAndText("a", "Забыли пароль ?")),
            registrationButton = $(byTagAndText("a", "Регистрация")),

    // Локаторы ошибок
            errorLogin = $("#login-helper-text"),
            errorPassword = $(byTagAndText("p", "Обязательное поле")),
            errorMessage = $(".SnackbarItem-message"),

    // Локатор заголовка
            titleAuthorization = $(".css-4an0mh");


    @Step("Входим в Remservise с: [{username}] и [{password}]")
    public LoginPage login(String username, String password) {
        loginField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();

        return this;
    }

    @Step("Кликаем на кнопку Войти")
    public LoginPage clickLoginButton() {
        loginButton.shouldHave(visible).click();

        return this;
    }

    // Методы для ошибок
    @Step("Проверяем, что ошибка логина содержит текст 'Обязательное поле'")
    public LoginPage checkErrorLoginMessage() {
        errorLogin.shouldBe(visible).shouldHave(Condition.exactText(LOGIN_ERROR_MESSAGE));

        return this;
    }

    @Step("Проверяем, что ошибка пароля содержит текст 'Обязательное поле'")
    public LoginPage checkErrorPasswordMessage() {
        errorPassword.shouldBe(visible).shouldHave(Condition.exactText(LOGIN_ERROR_MESSAGE));

        return this;
    }

    @Step("Проверяем, что Snakebar содержит текст 'Пользователь не найден!'")
    public LoginPage checkErrorUserNotFound() {
        errorMessage.shouldBe(visible).shouldBe(Condition.exactText(SNAKEBAR_USER_NOT_FOUND));

        return this;
    }

    @Step("Проверяем, что Snakebar содержит текст 'Некорректный пароль!'")
    public LoginPage checkErrorIncorrectPassword() {
        errorMessage.shouldBe(visible).shouldHave(Condition.exactText(SNAKEBAR_INCORRECT_PASSWORD));

        return this;
    }

    // Методы для переходов
    @Step("Кликаем на кнопку Забыли пароль?")
    public void clickForgotPasswordButton() {
        forgotPassword.shouldBe(visible).click();
    }

    @Step("Кликаем на кнопку Регистрация")
    public void clickRegistrationButton() {
        registrationButton.shouldBe(visible).click();
    }

    //
    @Step("Проверяем, что мы вышли из системы")
    public void checkOutputHeader() {
        titleAuthorization.shouldBe(visible).shouldHave(Condition.exactText(EXIT_TITLE));
    }
}
