package me.tony.practice.java17.test;

import me.tony.practice.java17.sealeds.RegularTriangle;
import me.tony.practice.java17.sealeds.Shape;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(res).isEqualTo("unknown");
    }

    String switchShape(Shape shape) {
        return "";
    }
}
