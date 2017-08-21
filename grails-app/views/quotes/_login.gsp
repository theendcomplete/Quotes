<%@ page import="grails.plugin.springsecurity.SpringSecurityService" %>

<div class="login">

    <sec:ifLoggedIn>
        <div class="col-md-6">
            <div class="row">Hello, <sec:username/>!</div>

            <div class="row">
                <div id="avatar" class="col-md-12" align="right">
                    %{--<img src="/assets/images/quote-icon.png" class="img-fluid">--}%
                    <img src="${resource(dir: 'images', file: 'quote-icon.png')}" class="img-thumbnail">
                    <a href="${createLink(controller: 'profile', action: 'index')}">Edit</a>
                </div>
            </div>

            <div class="row">
                <div class="well col-md-12" id="userVotes">
                    <div class="h5">Last votes: ${votes.size()}</div>
                    <g:each in="${votes}">
                        <p>${it.value as java.lang.String}</p>

                        <p>${it.quote.text}</p>
                    </g:each>
                </div>
            </div>
        </div>
    </sec:ifLoggedIn>

    <sec:ifNotLoggedIn>
        <div class="col-md-6">
            <form name="banner-login" method="POST" action="${resource('file': 'j_spring_security_check')}">
                <ul>
                    <li>
                        <label for="j_username">Username:</label>
                        <g:textField name="j_username"/>
                    </li>
                    <li>
                        <label for="j_password">Password:</label>
                        <g:passwordField name="j_password"/>
                    </li>
                </ul>

                <div class="button-panel">
                    <g:submitButton name="banner-login-button" value="Log in"/>
                </div>
            </form>

            <div class="row">
                <a href="${createLink(controller: 'profile', action: 'register')}">Create account</a>
            </div>
        </div>
    </sec:ifNotLoggedIn>
</div>