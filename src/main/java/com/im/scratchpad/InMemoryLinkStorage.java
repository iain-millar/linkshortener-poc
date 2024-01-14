package com.im.scratchpad;

import com.im.scratchpad.entities.Link;

import java.util.HashMap;

public class InMemoryLinkStorage implements ILinkStorage{

    private static HashMap<String,Link> linksByShortcode = new HashMap<String,Link>();
    private static HashMap<Long,Link> linksById = new HashMap<Long,Link>();

    @Override
    public Link store(Link link) {
        //Set an ID to mimic PK setting in JPA
        link.setId((long) (linksById.size() + 1));
        //Store in hashmap by ID
        linksById.put(link.getId(),link);
        return link;
    }

    @Override
    public void update(Link link) {
        //Assumes existing record which needs updated
        if (link != null && link.getId() != null) {
            linksById.put(link.getId(), link);
            if (link.getShortCode() != null) {
                linksByShortcode.put(link.getShortCode(), link);
            }
        }
    }

    @Override
    public Link findByShortCode(String shortCode) {
        return linksByShortcode.get(shortCode);
    }

    /**
     * Private method to clear all links for test purposes.
     */
    public static void clearAllLinks(){
        linksById.clear();
        linksByShortcode.clear();
    }
}
