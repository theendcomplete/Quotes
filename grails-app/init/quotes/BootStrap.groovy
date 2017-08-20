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
                //заполняем тестовыми данными
                Quote quote1 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 0, user: admin).save(flush: true)
                Quote quote2 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 2, user: admin).save(flush: true)
                Quote quote3 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 3, user: admin).save(flush: true)
                Quote quote4 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 5, user: admin).save(flush: true)
                Quote quote5 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 7, user: admin).save(flush: true)
                Quote quote6 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 10, user: admin).save(flush: true)
                Quote quote7 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 11, user: admin).save(flush: true)
                Quote quote8 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 12, user: admin).save(flush: true)
                Quote quote9 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 13, user: admin).save(flush: true)
                Quote quote10 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 14, user: admin).save(flush: true)
                Quote quote11 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 1111, user: admin).save(flush: true)
                Attitude like1 = new Attitude(value: 1)
                Attitude like2 = new Attitude(value: 1)
                Attitude dislike1 = new Attitude(value: -1)
                quote1.addToLikes(like1)
                quote1.addToLikes(like2)
                quote1.addToLikes(dislike1)
                quote1.save(flush: true)
                quoteService.countRating(quote1.getId())
                println(quote1.rating())
                //Создаем тестовый список


            } else {
                System.out.println("already have admin")
            }


        }
    }

    def destroy = {
    }
}