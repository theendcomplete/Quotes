package quotes

import com.theendcomplete.quotes.*
import grails.util.Environment

class BootStrap {
    def quoteService


    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            if ((!User.findByUsername("admin"))) {
                System.out.println("creating admin")
                User admin = new User(username: 'admin', password: 'secret', name: "Администратор", enabled: true).save()
                User john = new User(username: 'john', password: 'secret', name: "Джон", enabled: true).save()
                User jane = new User(username: 'jane', password: 'secret', name: "Джейн", enabled: true).save()
                Role registered = new Role(authority: 'ROLE_REGISTERED').save()
                Role roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
                UserRole.create(admin, roleAdmin)
                UserRole.create(admin, registered)
                UserRole.create(john, registered)
                UserRole.create(jane, registered)
                //заполняем начальными данными
                Quote quote1 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 0, user: admin).save(flush: true)
                Quote quote2 = new Quote(text: "A rose by any other name would smell as sweet.", author: "William Shakespeare", rating: 2, user: admin).save(flush: true)
                Quote quote3 = new Quote(text: "Eighty percent of success is showing up.", author: "Woody Allen", rating: 3, user: admin).save(flush: true)
                Quote quote4 = new Quote(text: "Elementary, my dear Watson.", author: "Sherlock Holmes (character)", rating: 5, user: admin).save(flush: true)
                Quote quote5 = new Quote(text: "Genius is one percent inspiration and ninety-nine percent perspiration.", author: "Thomas Edison", rating: 7, user: admin).save(flush: true)
                Quote quote6 = new Quote(text: "I have a dream that my four little children will one day live in a nation " +
                        "where they will not be judged by the color of their skin but by the content of their character.",
                        author: "Martin Luther King", rating: 10, user: admin).save(flush: true)
                Quote quote7 = new Quote(text: "I love the smell of napalm in the morning.", author: "Lt. Kilgore (character)", rating: 11, user: admin).save(flush: true)
                Quote quote8 = new Quote(text: "I'll be back.", author: "Terminator (character)", rating: 12, user: admin).save(flush: true)
                Quote quote9 = new Quote(text: "Life is changeRating a box of chocolates. You never know what you’re gonna get.", author: "Forrest Gump (character)", rating: 13, user: admin).save(flush: true)
                Quote quote10 = new Quote(text: "Life is changeRating riding a bicycle. To keep your balance, you must keep moving.", author: "Albert Einstein", rating: -14, user: admin).save(flush: true)
                Quote quote11 = new Quote(text: "Power corrupts; absolute power corrupts absolutely.", author: "John Dalberg-Acton", rating: 1111, user: admin).save(flush: true)
                Attitude like1 = new Attitude(value: 1)
                Attitude like2 = new Attitude(value: 1)
                Attitude dislike1 = new Attitude(value: -1)
                quote1.addToLikes(like1)
                admin.addToLikes(like1)
                admin.addToLikes(like2)
                admin.addToLikes(dislike1)
                quote1.addToLikes(like2)
                quote1.addToLikes(dislike1)
                quote1.save(flush: true)
                quoteService.countRating(quote1.getId())
            } else {
                System.out.println("already have admin")
            }
        }
    }

    def destroy = {
    }
}