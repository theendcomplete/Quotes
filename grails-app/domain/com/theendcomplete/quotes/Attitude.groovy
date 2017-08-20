package com.theendcomplete.quotes

class Attitude {
    double value
    static constraints = {
        value(nullable: true)
    }
    static belongsTo = [User, Quote]
}
