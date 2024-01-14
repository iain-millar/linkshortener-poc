package com.im.scratchpad;

import com.im.scratchpad.entities.Link;
import com.im.scratchpad.utils.Base62Helper;

import java.net.URL;

/**
 * Class to be used by an API endpoint or web to:
 * - shorten a URL provided by a client
 * - access an original URL for provided short code
 */
public class LinkShortener {

    public static Link shorten(String originalURL) throws ValidationException {
        //Validate provided URL
        if (originalURL == null || !isValidURL(originalURL)) {
            throw new ValidationException("Provided URL is not valid for shortening");
        }
        //Store link with no code (as PK to base code on not yet known)
        Link newLink = new Link(originalURL);
        ILinkStorage linkStorage = LinkStorageFactory.getLinkStorage();
        newLink = linkStorage.store(newLink);
        //Generate shortcode from Link PK
        String shortCode = Base62ShortCodeGenerator.generateShortCode(newLink.getId());
        newLink.setShortCode(shortCode);
        //Update link in storage now that shortcode is set
        linkStorage.update(newLink);
        //Return stored link
        return newLink;
    }

    public static Link access(String shortCode) throws NoLinkFoundException, ValidationException {
        //Validate code matches expected format (Base62)
        if (shortCode == null || !Base62Helper.isValidBase62(shortCode)) {
            throw new ValidationException("Provided short code is invalid");
        }
        //Retrieve Link by shortcode and return
        ILinkStorage linkStorage = LinkStorageFactory.getLinkStorage();
        Link foundLink = linkStorage.findByShortCode(shortCode);
        if (foundLink == null) {
            throw new NoLinkFoundException("No link found for provided short code");
        }
        return foundLink;
    }

    private static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
