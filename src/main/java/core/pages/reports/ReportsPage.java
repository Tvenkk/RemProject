package core.pages.reports;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.xlstest.XLS;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReportsPage {

    private SelenideElement
            reportDownloadButton = $(".css-108snh2");

    // Кнопка не имеет атрибут href
    @Step("Нажимаем на кнопку Отчет 'Все ремонты по контрольным точкам' ")
    public void downloadTheReports() throws Exception{
        File download = reportDownloadButton.shouldBe(visible).download();
        XLS xls = new XLS(download);
    }
}
