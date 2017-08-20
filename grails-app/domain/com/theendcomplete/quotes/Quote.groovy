package com.theendcomplete.quotes

class Quote {
    private String text
    private long rating
    private Date dateCreated
    private Date lastUpdated
    private String author
    static constraints = {
        text(nullable: false)
        author(nullable: false)
        rating(nullable: false)
        user(nullable: false)
    }
    static belongsTo = [user: User]
    static hasMany = [likes: Attitude, dislikes: Dislike]


     long getRating() {
            return this.rating
    }

}
