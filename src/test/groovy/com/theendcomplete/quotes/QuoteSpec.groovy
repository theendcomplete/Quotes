package com.theendcomplete.quotes

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Quote)
class QuoteSpec extends Specification {

    def setup() {

    }

    def cleanup() {
    }

    void "quote rating"() {
        User admin = new User(username: 'admin', password: 'secret', name: "Администратор", enabled: true).save()
        //заполняем тестовыми данными
        Quote quote1 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 0, user: admin).save()
        Attitude like1 = new Attitude(value: 1)
        Attitude like2 = new Attitude(value: 1)
        Attitude dislike1 = new Attitude(value: -1)
        quote1.addToLikes(like1)
        quote1.addToLikes(like2)
        quote1.addToLikes(dislike1)
        quote1.save()
        quote1.countRating()

//        println(quote1.countRating())
        expect:
        assert quote1.getRating(), 1


    }
}
