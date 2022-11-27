import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestMethodSource{
    @BeforeAll
    static void setUp() {
    open("https://www.wildberries.ru/catalog/bytovaya-tehnika");}
    static Stream<Arguments> wildberriesBytovaya(){
        return Stream.of(
                Arguments.of("Климатическая техника", List.of("Категория", "Срок доставки", "Бренд", "Продавец", "Цена, ₽", "Скидка", "Цвет")),
                Arguments.of("Садовая техника", List.of("Категория", "Срок доставки", "Бренд", "Продавец", "Цена, ₽", "Скидка", "Цвет"))
        );
    }


    @MethodSource
    @ParameterizedTest(name = "Отображение списка фильтров {1} " + ", на странице где распложена {0}")
    @Tag("Critical")
    void wildberriesBytovaya(String appliances,List<String> filter) {
        $$(".menu-catalog").find(text(appliances)).click();
        $$(".filter__name").filter(visible).shouldHave(CollectionCondition.texts(filter));

    }
}