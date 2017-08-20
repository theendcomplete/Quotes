package com.theendcomplete.quotes

class Attitude {
    Long value
    Date dateCreated
    Date lastUpdated
    static constraints = {
        value(nullable: true)
    }
    static belongsTo = [User, Quote]
}
