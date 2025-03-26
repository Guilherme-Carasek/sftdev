package ex02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    private StringUtils testStringUtils;

    @BeforeEach
    void init() {
        testStringUtils = new StringUtils();
    }
}