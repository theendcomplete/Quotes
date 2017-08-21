package com.theendcomplete.quotes

class Quote {
    String text
    long rating
    Date dateCreated
    Date lastUpdated
    String author
    static constraints = {
        text(nullable: false)
        author(nullable: false)
        rating(nullable: false)
        user(nullable: false)
    }
    static belongsTo = [user: User]
    static hasMany = [likes: Attitude]
}
