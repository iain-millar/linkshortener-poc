package com.im.scratchpad;

import com.im.scratchpad.entities.Link;

/**
 * Interface to define methods for link storage mechanisms.
 */
public interface ILinkStorage {

    public Link store(Link link);

    public void update(Link link);

    public Link findByShortCode(String shortCode);

}
