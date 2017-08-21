package com.theendcomplete.quotes

import org.springframework.security.access.annotation.Secured

class ProfileController {

    def index() {}

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def register() {}

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def createUser() {}
}
