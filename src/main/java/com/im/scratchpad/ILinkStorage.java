package com.im.scratchpad;

import com.im.scratchpad.entities.Link;

/**
 * Interface to define methods for link storage mechanisms.
 * Once created, a Link cannot be amended or deleted (to avoid
 * a generated link changing where it goes and avoids accidental
 * shortcode reuse).
 */
public interface ILinkStorage {

    public Link store(Link link);

    void update(Link link);

    public Link findByShortCode(String shortCode);

}
