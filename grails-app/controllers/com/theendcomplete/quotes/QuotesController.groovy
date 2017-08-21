package com.theendcomplete.quotes

import org.grails.web.json.JSONObject
import org.springframework.security.access.annotation.Secured

class QuotesController {
    QuoteService quoteService
    def springSecurityService

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def index() {

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def showTop() {
        def quoteList = Quote.listOrderByRating([max: 10, order: "desc"])
        def votes
        def model
        if (springSecurityService.currentUser) {
            User user = springSecurityService.currentUser
            votes = Attitude.findAllByUser(user, [max: 5, order: "desc", sort: "dateCreated"])
            model = [quoteList: quoteList, randomQuote: quoteService.getRandomQuote(),
                     user     : springSecurityService.currentUser, votes: votes, votesTotal: user.likes.size()]
        } else {
            model = [quoteList: quoteList, randomQuote: quoteService.getRandomQuote()]
        }

        render(view: 'index', model: model)


    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def Flop() {
        def quoteList = Quote.listOrderByRating([max: 10, order: "asc"])
        def votes
        def model
        if (springSecurityService.currentUser) {
            User user = springSecurityService.currentUser
            votes = Attitude.findAllByUser(user, [max: 5, order: "desc", sort: "dateCreated"])
            model = [quoteList: quoteList, randomQuote: quoteService.getRandomQuote(),
                     user     : springSecurityService.currentUser, votes: votes, votesTotal: user.likes.size()]
        } else {
            model = [quoteList: quoteList, randomQuote: quoteService.getRandomQuote()]
        }

        render(view: 'index', model: model)
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def last() {
        def quoteList = Quote.listOrderByDateCreated([max: 10, order: "asc"])
        def votes
        def model
        if (springSecurityService.currentUser) {
            User user = springSecurityService.currentUser
            votes = Attitude.findAllByUser(user, [max: 5, order: "desc", sort: "dateCreated"])
            model = [quoteList: quoteList, randomQuote: quoteService.getRandomQuote(),
                     user     : springSecurityService.currentUser, votes: votes, votesTotal: user.likes.size()]
        } else {
            model = [quoteList: quoteList, randomQuote: quoteService.getRandomQuote()]
        }

        render(view: 'index', model: model)
    }


    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def like() {
        Long newRating = quoteService.changeRating(params.id as Long, 1l)
        JSONObject jsonObject = new JSONObject()
        jsonObject.put("newRating", newRating)
        if (springSecurityService.currentUser) {
            User user = springSecurityService.currentUser
            def votes = Attitude.findAllByUser(user, [max: 5, order: "desc", sort: "dateCreated"])
            jsonObject.put("votes", votes)
            jsonObject.put("votesTotal", user.likes.size())
        }
        render(jsonObject)

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def dislike() {
        Long newRating = quoteService.changeRating(params.id as Long, -1l)
        JSONObject jsonObject = new JSONObject()
        jsonObject.put("newRating", newRating)
        if (springSecurityService.currentUser) {
            User user = springSecurityService.currentUser
            def votes = Attitude.findAllByUser(user, [max: 5, order: "desc", sort: "dateCreated"])
            jsonObject.put("votes", votes)
            jsonObject.put("votesTotal", user.likes.size())
        }
        render(jsonObject)
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def show() {
        Quote quote = Quote.get(params.id as Long)
        render(template: "quoteDet", model: [quote: quote], var: 'showQuote')
        System.out.println("show action" + params)
        render {
            div(id: "show" + "${quote.getId()}", "some text inside the div")
        }

    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def getQuoteRating() {

    }

    def createQuote() {
        if (params.quoteText && params.quoteAuthor) {
            quoteService.createQuote(params.quoteAuthor, params.quoteText)
            redirect(action: "showTop")

        } else {
            redirect(action: "showTop")
        }
    }

}
