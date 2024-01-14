package com.im.scratchpad;

/**
 * Factory class to instantiate a chosen link storage
 * implementation based on a property files setting.
 *
 * TODO: drive from a property file value and classOf etc
 * to instantiate the required instance.
 */
public class LinkStorageFactory {

    public static ILinkStorage getLinkStorage() {

        return new InMemoryLinkStorage();

    }

}
