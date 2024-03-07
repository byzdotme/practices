package me.tony.practice.test;

import me.tony.practice.sealeds.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tony.zhuby
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SealedClassTest {

    static Logger log = LoggerFactory.getLogger(SealedClassTest.class);

    Shape shape;

    @BeforeAll
    public void before() {
        shape = new Shape();
    }

    @Test
    void testSwitch() {
        var res = switchShape(shape);
        log.info("shape is {}", res);
        Assertions.assertEquals(res, "unknown");
    }

    String switchShape(Shape shape) {
        return "";
    }
}
