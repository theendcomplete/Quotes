package com.theendcomplete.quotes

import grails.test.mixin.TestFor
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Quote)
class QuoteSpec extends Specification {
    @Autowired
    QuoteService quoteService
    Long id

    def setup() {
        User admin = new User(username: 'test', password: 'secret', name: "Администратор", enabled: true).save(flash: true)
        admin.validate()
        //заполняем тестовыми данными
        Quote quote1 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 0, user: admin)
        Attitude like1 = new Attitude(value: 1)
        Attitude like2 = new Attitude(value: 1)
        Attitude dislike1 = new Attitude(value: -1)
        quote1.addToLikes(like1)
        quote1.addToLikes(like2)
        quote1.addToLikes(dislike1)
        quote1.save(flush: true)
        id = quote1.getId()


    }

    def cleanup() {
    }

    void "quote rating"() {
        given:
        setup()

//        println(quote1.countRating())
        expect:
        assert quoteService.countRating(id) == 1


    }
}
