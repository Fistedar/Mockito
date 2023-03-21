import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class GeoServiceTest {
    GeoServiceImpl sut = new GeoServiceImpl();

    @ParameterizedTest
    @MethodSource("source")
    public void byIpTest(String ip, Country expected){
        if(sut.byIp(ip) == null){
            Country result = null;
            Assertions.assertEquals(expected,result);
        }else {
            Country result = sut.byIp(ip).getCountry();
            Assertions.assertEquals(expected,result);
        }
    }
    public static Stream<Arguments> source(){
       return Stream.of(
                Arguments.of("127.0.0.1",null),
                Arguments.of("172.0.32.11",RUSSIA),
                Arguments.of("96.44.183.149",USA),
                Arguments.of("172.12.24.99",RUSSIA),
                Arguments.of("96.11.1444.19",USA),
                Arguments.of("1123441",null));
    }

    @Test
    public void byCoordinates(){
        double a = 5.55;
        double b = 1.11;

        Assertions.assertThrows(RuntimeException.class,()->sut.byCoordinates(a,b));
    }
}
