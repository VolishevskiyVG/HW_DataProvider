import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TestCsvSource extends TestBase{

    @CsvSource({
            "Телевизор, Пульты для телевизора ",
            "Ноутбуки, Сумки для ноутбуков ",
            "Телефон, Чехлы для телефонов "
    })

    @ParameterizedTest(name = "Проверка отображения сопутствующего товара {1} " + ", при поиске основного товара {0}")
    @Tag("Critical")
    void mvideoSearchTest(String searchAppliances, String expectAppliances) {
        $(".input__field").setValue(searchAppliances).pressEnter();
        $(".tabs").shouldHave(text(expectAppliances));

    }
}
