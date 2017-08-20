package com.theendcomplete.quotes

import org.grails.web.json.JSONObject
import org.springframework.security.access.annotation.Secured

class QuotesController {
    QuoteService quoteService
    def springSecurityService

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def index() {
//        redirect(action: showTop())

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def showTop() {
        def quoteList = Quote.listOrderByRating([max: 10, order: "desc"])
        def votes
//        Quote randomQuote = quoteService.getRandomQuote()
        if (springSecurityService.currentUser) {
            User user = springSecurityService.currentUser
            votes = user.likes.asList()
        }
        render(view: 'index', model: [quoteList: quoteList, randomQuote: quoteService.getRandomQuote(), user: springSecurityService.currentUser, votes: votes])

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
        Quote quote = Quote.get(params.id as Long)
        render(template: "quoteDet", model: [quote: quote], var: 'showQuote')
//        System.out.println("show action"+params)
//        render {
//            div(id: "show" + "${quote.getId()}", "some text inside the div")
//        }

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def getQuoteRating() {

    }

}
