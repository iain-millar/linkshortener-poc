package com.im.scratchpad;

import com.im.scratchpad.entities.Link;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test class to test LinkShortener logic.
 */

public class LinkShortenerTest {

    private static final String url1 = "http://www.bbc.co.uk";
    private static final String url2 = "https://www.google.co.uk";

    @Before
    public void before(){
        //Use helper method to clear all links so tests which assume
        //codes/IDs start at 1 will work.
        InMemoryLinkStorage.clearAllLinks();
    }

    @Test
    public void testShorten() {
        try {
            Link link1 = LinkShortener.shorten(url1);
            //This is first code stored so code will be 1
            assertEquals("Short code value not as expected","1",link1.getShortCode());
            Link link2 = LinkShortener.shorten(url2);
            //This is first code stored so code will be 2
            assertEquals("Short code value not as expected","2",link2.getShortCode());
        } catch (ValidationException e) {
            fail("Unexpected exception occurred" + e.getMessage());
        }
    }

    @Test
    public void testShorten_invalidURL() {
        String invalidURL = "1234notvalid";
        boolean exceptionCaught = false;
        try {
            Link link = LinkShortener.shorten(invalidURL);
            //This is first code stored so code will be 1
            assertEquals("Short code value not as expected","1",link.getShortCode());
        } catch (ValidationException e) {
            exceptionCaught = true;
        }
        if (!exceptionCaught) {
            fail("Exception not thrown when expected");
        }
    }

    @Test
    public void testRetrieve() {
        //Use testShorten to store some links
        testShorten();
        try {
            Link link1 = LinkShortener.access("1");
            assertEquals("",url1,link1.getOriginalLink());
            Link link2 = LinkShortener.access("2");
            assertEquals("",url2,link2.getOriginalLink());
        } catch (Exception e) {
            fail("Unexpected exception occurred" + e.getMessage());
        }
    }

    public void testRetrieve_invalidShortCode() {
        String invalidShortcode = "+/£";
        boolean correctExceptionCaught = false;
        try {
            Link link = LinkShortener.access(invalidShortcode);
        } catch (ValidationException e) {
            correctExceptionCaught = true;
        } catch (NoLinkFoundException e) {
            fail("Incorrect exception occurred" + e.getMessage());
        }
        if (!correctExceptionCaught) {
            fail("Exception not thrown when expected");
        }
    }

    @Test
    public void testRetrieve_unknownShortCode() {
        String unknownShortcode = "123dvtyRESDF241a";
        boolean correctExceptionCaught = false;
        try {
            Link link = LinkShortener.access(unknownShortcode);
        } catch (NoLinkFoundException e) {
            correctExceptionCaught = true;
        } catch (ValidationException e) {
            fail("Incorrect exception occurred" + e.getMessage());
        }
        if (!correctExceptionCaught) {
            fail("Exception not thrown when expected");
        }
    }

}
