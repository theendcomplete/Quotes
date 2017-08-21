package com.theendcomplete.quotes

import org.springframework.security.access.annotation.Secured

class ProfileController {
    def springSecurityService

    def index() {}

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def register() {}

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def createUser() {
        Role registered = new Role(authority: 'ROLE_REGISTERED').save(flush: true)
        User newUser = new User([username: params.username, password: params.password]).save(flush: true)
        UserRole.create(newUser, registered)
        redirect(actionName: 'show')
    }

    def show() {
        User user = springSecurityService.currentUser
        [profile: user]


    }
}
