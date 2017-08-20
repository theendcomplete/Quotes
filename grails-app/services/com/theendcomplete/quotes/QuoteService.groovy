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
//        User createdUser = new User(username: 'john', password: 'secret', name: "Джон", enabled: true).save(flus: true)
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


    void countRating(Long id) {
        Quote quote = Quote.get(id)
        if (quote) {
            quote.rating = (Long) quote.likes.value.sum()
            quote.save()
        } else {
            throw new QuoteException(message: "quote id is empty or not found: " + id)
        }

    }

    void like(Long id, Long value) {
        Quote quote = Quote.get(id)
//        value = 1
        if (quote) {
            Attitude attitude = new Attitude(value: value)
            quote.addToLikes(Attitude)
            quote.save()
        } else {
            throw new QuoteException(message: "quote id is empty or not found: " + id)
        }

    }


}
