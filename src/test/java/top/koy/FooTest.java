package top.koy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

    @Test
    void testBar() {
        Assertions.assertDoesNotThrow(() -> System.out.println("bar"));
    }

}