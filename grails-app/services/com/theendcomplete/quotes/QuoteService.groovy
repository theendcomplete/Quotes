package com.theendcomplete.quotes

import grails.transaction.Transactional

class QuoteException extends RuntimeException {
    String message
    Quote quote
}

@Transactional
class QuoteService {
    def springSecurityService
    Random random = new Random()

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

    Boolean removeQuote(Long id) {
        User user = springSecurityService.currentUser
        Quote removable = Quote.get(id)
        if (removable) {
            if (user == removable.user || user.authorities.any { it.authority == "ROLE_ADMIN" }) {
                removable.delete()
                return true

            } else {
                return false
            }
        } else {
            return false
        }
    }

    Long countRating(Long id) {
        Quote quote = Quote.get(id)
        if (quote) {
            quote.rating = quote.likes.sum({ it.value })
            quote.save()
            return quote.rating
        } else {
            throw new QuoteException(message: "quote id is empty or not found: " + id)
        }
    }

    Long changeRating(Long id, Long value) {
        Quote quote = Quote.get(id)

        if (!value) {
            value = 0
        }
        if (quote) {
            Attitude attitude = new Attitude(value: value)
            quote.addToLikes(attitude)
            if (springSecurityService.currentUser) {
                User user = springSecurityService.currentUser
                user.addToLikes(attitude)
                user.save()
            }
            quote.save()
            def newRating = countRating(id)
            return newRating
        } else {
            throw new QuoteException(message: "quote id is empty or not found: " + id)
        }

    }


    Quote getRandomQuote() {
        def list = Quote.list()
        if (list.size() > 0) {
            int index = random.nextInt(list.size())
            Quote randomQuote = list.get(index)

            if (randomQuote) {
                return randomQuote
            } else {
                return Quote.get(0)
            }
        } else {
            return new Quote(text: "there are no any quotes in database :(", author: "System")
        }
    }
}
