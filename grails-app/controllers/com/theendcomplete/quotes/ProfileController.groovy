package com.theendcomplete.quotes

import org.springframework.security.access.annotation.Secured

class ProfileController {
    def springSecurityService

    def index() {
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def register() {
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def createUser() {
        User newUser = new User([username: params.login, password: params.passwordinput, name: params.login, enabled: true]).save(flush: true)
        Role registered = Role.findByAuthority('ROLE_REGISTERED')
        UserRole.create(newUser, registered, true)
        flash.message = "Succesfully created user with login " + params.login + "!"
        redirect(controller: "quotes", action: "showTop")
    }

    def show() {
        User user = springSecurityService.currentUser
        def userQuotes = Quote.findAllByUser(user, [order: "desc", sort: "dateCreated"])
        def votes = Attitude.findAllByUser(user, [order: "desc", sort: "dateCreated"])
        [profile: user, userQuotes: userQuotes, votes: votes]
    }
}
