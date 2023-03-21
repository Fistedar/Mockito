import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class LocalizationServiceTest {

    LocalizationServiceImpl sut = new LocalizationServiceImpl();


@ParameterizedTest
@MethodSource("source")
    public void localeTest(Country country,String expected){
       String result = sut.locale(country);

    Assertions.assertEquals(expected,result);
}
public static Stream<Arguments> source(){
    return Stream.of(
            Arguments.of(RUSSIA,"Добро пожаловать"),
            Arguments.of(USA,"Welcome")
    );
}
}
