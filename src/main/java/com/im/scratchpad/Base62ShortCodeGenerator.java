package com.im.scratchpad;

import com.im.scratchpad.utils.Base62Helper;

import java.util.Base64;

/**
 * Class with method to generate a new shortcode for a root number.
 *
 * Shortcodes are Base62 encoding of a number in order to maximise
 * the unique codes which can be store in minimum characters (while still
 * being driven by a root number and being URL friendly).
 */
public class Base62ShortCodeGenerator {

    public static String generateShortCode(long root) {

        // Convert the long to Base62 string
        return Base62Helper.encode(root);

    }

}
