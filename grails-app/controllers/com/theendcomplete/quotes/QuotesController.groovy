package com.theendcomplete.quotes

import org.grails.web.json.JSONObject
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
        System.out.println("liked" + params.id)
        Long newRating = quoteService.changeRating(params.id as Long, 1l)
        JSONObject jsonObject = new JSONObject()
        jsonObject.put("newRating", newRating)
        render(jsonObject)
//        render newRating as JSON

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def dislike() {
        System.out.println("disliked" + params.id)
        Long newRating = quoteService.changeRating(params.id as Long, -1l)
        JSONObject jsonObject = new JSONObject()
        jsonObject.put("newRating", newRating)
        render(jsonObject)
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def show() {
        System.out.println(params)

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def getQuoteRating() {

    }

}
