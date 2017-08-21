package com.theendcomplete.quotes

import org.springframework.security.access.annotation.Secured

class ProfileController {
    def springSecurityService

    def index() {}

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def register() {}

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def createUser() {}

    def show() {
        User user = springSecurityService.currentUser
//        render(view: 'show', model: [user: user])
        [profile: user]


    }
}
