package quotes

import com.theendcomplete.quotes.*
import grails.util.Environment

class BootStrap {
    def haveChanges = 0;

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            if ((!User.findByUsername("admin")) || (haveChanges == 1)) {
                System.out.println("creating admin")
                User admin = new User(username: 'admin', password: 'secret', name: "Администратор", enabled: true).save()
                User john = new User(username: 'john', password: 'secret', name: "Джон", enabled: true).save()
                User jane = new User(username: 'jane', password: 'secret', name: "Джейн", enabled: true).save()
                Role registered = new Role(authority: 'ROLE_REGISTERED').save()
                Role roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
//                SecRole manager = new SecRole(authority: 'ROLE_MANAGER').save()
                UserRole.create(admin, roleAdmin)
                UserRole.create(admin, registered)
                UserRole.create(john, registered)
                UserRole.create(jane, registered)
                //заполняем тестовыми данными
                Quote quote1 = new Quote(text: "there is no knowledge that is not power", author: "Shao Khan", rating: 0, user: admin).save()
                Attitude like1 = new Attitude(value: 1)
                Attitude like2 = new Attitude(value: 1)
                Attitude dislike1 = new Attitude(value: -1)
                quote1.addToLikes(like1)
                quote1.addToLikes(like2)
                quote1.addToLikes(dislike1)
                println(quote1.countRating())

                //Создаем тестовый список


            } else {
                System.out.println("already have admin")
            }


        }
    }

    def destroy = {
    }
}