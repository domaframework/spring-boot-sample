package sample.city;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CityControllerTest {
    @Value("${local.server.port}")
    int port;
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void test() throws Exception {
        {
            // Select
            List<City> cities = restTemplate.exchange("http://localhost:" + port, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<City>>() {
            }).getBody();
            assertThat(cities.size(), is(3));
            assertThat(cities.get(0).id, is(1));
            assertThat(cities.get(0).name, is("Tokyo"));
            assertThat(cities.get(1).id, is(2));
            assertThat(cities.get(1).name, is("New York"));
            assertThat(cities.get(2).id, is(3));
            assertThat(cities.get(2).name, is("London"));
        }

        {
            // Update
            List<City> cities = restTemplate.exchange("http://localhost:" + port + "/update?name=Kyoto", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<City>>() {
            }).getBody();
            assertThat(cities.size(), is(3));
            assertThat(cities.get(0).id, is(1));
            assertThat(cities.get(0).name, is("Kyoto"));
            assertThat(cities.get(1).id, is(2));
            assertThat(cities.get(1).name, is("New York"));
            assertThat(cities.get(2).id, is(3));
            assertThat(cities.get(2).name, is("London"));
        }
    }
}