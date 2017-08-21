package com.theendcomplete.quotes

class Attitude {
    Long value
    Date dateCreated
    Date lastUpdated
    User user
    Quote quote
    static constraints = {
        value(nullable: true)
        user(nullable: true)
        quote(nullable: true)
    }
    static belongsTo = [User, Quote]
}
