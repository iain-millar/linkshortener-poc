package com.im.scratchpad;

import com.im.scratchpad.entities.Link;

/**
 * Stub class for a JPA/db link storage class.
 *
 * Current version contains comments regarding intended
 * coding if running with a proper DB and relevant libraries
 * for entities and JPA.
 */

public class JPALinkStorage implements ILinkStorage{

    @Override
    public Link store(Link link) {
        //TODO - JPA persist to be used here
        return link;
    }

    @Override
    public void update(Link link) {
        //TODO - JPA merge to be used here
    }

    @Override
    public Link findByShortCode(String shortCode) {
        //TODO - Customer query to find by shortcode.
        //Use prepared statement code like below to limit sql injection:
        //String findString = "select Link where shortCode = ?";
        //PreparedStatement findLinkQuery = con.prepareStatement(findLinkQuery);
        return new Link("dummy");
    }
}
