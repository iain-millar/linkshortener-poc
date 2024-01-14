package com.im.scratchpad.utils;

import com.im.scratchpad.Base62ShortCodeGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base62HelperTest {

    //Test longs and resulting Base62 values.
    //Higher Base62 values derived from https://math.tools/calculator/base/10-62
    //and then cross checked at https://jalu.ch/coding/base_converter.php .

    long[] testLong = new long[] {1,2,35,61,62,63,234,678345};
    String[] testBase62 = new String[] {"1","2","Z","z","10","11","3m","2qT3"};

    @Test
    public void testEncode() {

        for (int i = 0; i < testLong.length; i++) {
            String generatedBase62 = Base62Helper.encode(testLong[i]);
            String expectedBase62 = testBase62[i];
            assertEquals("Base62 incorrect for test " + i,expectedBase62,generatedBase62);
        }

    }

}
