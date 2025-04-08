package core.pages.settings;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SettingsPage {
    private final String
            TITLE_TEXT = "Ваш профиль",
            SNAKEBAR_SUCCESSFUL_PRESERVATION = "Сохранение профиля";

    private SelenideElement
            profileTab = $(byTagAndText("p", "Профиль")),
            title = $(".css-zq6grw"),
            nameField = $("[data-input='name']"),
            phoneField = $("[data-input='phone']"),
            emailField = $("[name='email']"),
            passwordField = $("[data-input='password']"),
            saveButton = $(byTagAndText("button", "Сохранить")),
            notice = $(".css-hped4j");


    @Step("Кликаем на вкладку 'Профиль'")
    public SettingsPage clickProfileTab() {
        profileTab.shouldBe(visible).click();

        return this;
    }

    @Step("Проверяем заголовок страницы")
    public SettingsPage checkTitle() {
        title.shouldBe(visible).shouldHave(Condition.exactText(TITLE_TEXT));
        sleep(2000);

        return this;
    }

    @Step("Редактируем поле ФИО")
    public SettingsPage editNameField(String name) {
        // Не работает метод clear()
        nameField.sendKeys(Keys.CONTROL + "A");
        nameField.sendKeys(Keys.BACK_SPACE);
        nameField.shouldBe(visible).setValue(name);

        return this;
    }

    @Step("Редактируем поле Телефон")
    public SettingsPage editPhoneField(String phone) {
        // Не работает метод clear()
        phoneField.sendKeys(Keys.CONTROL + "A");
        phoneField.sendKeys(Keys.BACK_SPACE);
        phoneField.shouldBe(visible).setValue(phone);

        return this;
    }

    @Step("Редактируем поле Email")
    public SettingsPage editEmailField(String email) {
        // Не работает метод clear()
        emailField.sendKeys(Keys.CONTROL + "A");
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.shouldBe(visible).setValue(email);

        return this;
    }

    @Step("Вводим пароль в поле")
    public SettingsPage enterPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);

        return this;
    }

    @Step("Нажимаем на кнопку Сохранить")
    public SettingsPage clickSaveButton() {
        saveButton.shouldBe(visible).click();

        return this;
    }

    @Step("Проверяем, что после сохранение высвечивается уведомление")
    public SettingsPage checkNoticeSucces() {
        notice.shouldBe(visible).shouldHave(Condition.exactText(SNAKEBAR_SUCCESSFUL_PRESERVATION));
        sleep(2000);

        return this;
    }

    @Step("Проверяем новые значения в полях")
    public SettingsPage checkValuesInFields(String name, String phone, String email) {
        nameField.shouldBe(visible);
        SelenideElement nameFieldValue = $(String.format("[value='%s']", name));
        nameFieldValue.shouldHave(Condition.exactValue(name));
        phoneField.shouldBe(visible);
        SelenideElement phoneFieldValue = $(String.format("[value='%s']", phone));
        phoneFieldValue.shouldHave(Condition.exactValue(phone));
        emailField.shouldBe(visible);
        SelenideElement emailFieldValue = $(String.format("[value='%s']", email));
        emailFieldValue.shouldHave(Condition.exactValue(email));

        return this;
    }
}
