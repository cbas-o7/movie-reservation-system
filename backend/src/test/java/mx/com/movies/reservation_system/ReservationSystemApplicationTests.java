package mx.com.movies.reservation_system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;


@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ReservationSystemApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void select1() {
        String sqlQuery = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sqlQuery, Integer.class);

        assertEquals(1, result);
    }

}
