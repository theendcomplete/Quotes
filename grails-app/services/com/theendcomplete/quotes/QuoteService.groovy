package com.theendcomplete.quotes

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional

class QuoteException extends RuntimeException {
    String message
    Quote quote
}

@Transactional
class QuoteService {
    SpringSecurityService springSecurityService

    Quote createQuote(String text, String author) {
        User createdUser = springSecurityService.currentUser
        if (createdUser) {
            Quote newQuote = new Quote(text: text, author: author, rating: 0)
            createdUser.addToQuotes(newQuote)
            if (createdUser.save()) {
                return newQuote
            } else {
                throw new QuoteException(message: "Quote is invalid ", quote: newQuote)
            }

        } else {
            throw new QuoteException(message: " Invalid or empty user ")
        }
    }

    Quote updateQuote() {

    }

    Quote removeQuote() {

    }

    void countRating(String id) {
        Quote quote = Quote.get(id)
        if (quote) {
            quote.setRating((long) quote.likes.sum())
        }

    }

}
