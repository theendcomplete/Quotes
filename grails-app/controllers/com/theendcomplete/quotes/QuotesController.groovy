package com.theendcomplete.quotes

import org.springframework.security.access.annotation.Secured

class QuotesController {
    QuoteService quoteService

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def index() {
//        redirect(action: showTop())

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def showTop() {
        def quoteList = Quote.listOrderByRating([max: 10, order: "desc"])
//        Quote randomQuote = quoteService.getRandomQuote()
        render(view: 'index', model: [quoteList: quoteList, randomQuote: quoteService.getRandomQuote()])

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def Flop() {
        def quoteList = Quote.listOrderByRating([max: 10, order: "asc"])
        render(view: 'index', model: [quoteList: quoteList, randomQuote: quoteService.getRandomQuote()])
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def last() {
        def quoteList = Quote.listOrderByDateCreated([max: 10, order: "asc"])
        render(view: 'index', model: [quoteList: quoteList, randomQuote: quoteService.getRandomQuote()])
    }


    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def like() {


    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def dislike() {

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def show() {
        System.out.println(params)

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def getQuoteRating() {

    }

}
