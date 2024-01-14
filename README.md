# linkshortener-poc

A project to be used for building a link shortener mechanism. 

Expectation is that LinkShortener.java would be used by an additional API or UI level. 

Short URLs would be of the form linkshortener.com/tf46d or linkshortener.com/?c=5tdgy depending on preferences or underlying frameworks. 

Shortcodes for URLs are base62 to get the maximum number of codes out of valid URL characters (Base64's use of + and / would have proved a problem).

A factory is in place for storage options. Currently hardcoded to an in memory solution but a stub JPA solution is present with partially fleshed out methods and comments. This could be finalised once a deployment framework decided on. 

Validation is in place for any user specified fields and exceptions are thrown to identify specific error conditions. 
