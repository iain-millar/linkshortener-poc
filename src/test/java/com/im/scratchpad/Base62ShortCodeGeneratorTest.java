package com.im.scratchpad;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base62ShortCodeGeneratorTest {

    //Test roots and resulting codes.
    //Higher Base62 values derived from https://math.tools/calculator/base/10-62
    //and then cross checked at https://jalu.ch/coding/base_converter.php .
    long[] testRoots = new long[] {234,678345};
    String[] testCodes = new String[] {"3m","2qT3"};

    @Test
    public void testGenerateShortCode() {

        for (int i = 0; i < testRoots.length; i++) {
            String generatedShortCode = Base62ShortCodeGenerator.generateShortCode(testRoots[i]);
            String expectedShortCode = testCodes[i];
            assertEquals("Short code incorrect for " + i,expectedShortCode,generatedShortCode);
        }

    }

}
