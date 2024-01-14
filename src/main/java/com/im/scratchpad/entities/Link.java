package com.im.scratchpad.entities;

import java.util.Objects;

/**
 * Class to represent a shortened link.
 */
public class Link {

    private String originalLink;

    private String shortCode;

    private Long id;

    public Link(String originalLink) {
        this.originalLink = originalLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(originalLink, link.originalLink) && Objects.equals(shortCode, link.shortCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalLink, shortCode);
    }

}
