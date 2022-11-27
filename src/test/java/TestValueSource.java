import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestValueSource extends TestBase {

    @ValueSource(strings = {"Телевизор", "Компьютер", "Телефон", "Приставка"})

    @ParameterizedTest(name = "Проверка поисковой строки на сайте Мвидео ")
    @Tag("Critical")
    void mvideoTest(String arg) {
        $(".input__field").setValue(arg).pressEnter();
        //$(".tabs").shouldHave(text("Телевизоры"));
        // $("[name=minPrice]").setValue("7000");
        // $("[name=maxPrice]").setValue("10000");
    }


}
