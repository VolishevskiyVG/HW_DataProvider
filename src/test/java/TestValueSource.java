import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestValueSource {
    @BeforeAll
    static void setUp() {
        open("https://store.steampowered.com/");
        $$(".pulldown_desktop").find(text("Новое и примечательное")).click();

    }


    @ValueSource(strings = {
            "Лидеры продаж",
            "Самые популярные",
            "Популярные новинки",
            "Специальные предложения",
            "Недавно обновлённые ",
            "Популярные будущие продукты"})

    @ParameterizedTest(name = "Отображение поля \"{0}\" в каталоге Новое и примечательное")
    @Tag("Critical")
    void steamMenuNewTest(String arg) {
        $$(".popup_menu_item").find(text(arg)).shouldHave(text(arg));
    }


}
