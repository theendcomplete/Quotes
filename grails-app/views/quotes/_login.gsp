<%@ page import="grails.plugin.springsecurity.SpringSecurityService" %>

<div class="login col-md-12">

    <sec:ifLoggedIn>
        <div class="col-md-6">
            <div class="row">Hello, <sec:username/>!</div>

            <div class="row">
                <div id="avatar" class="col-md-12" align="right">
                    <img src="${resource(dir: 'images', file: 'quote-icon.png')}" class="img-thumbnail">
                    <a href="${createLink(controller: 'profile', action: 'index')}">Edit</a>
                </div>
            </div>

            <div class="row">
                <div class="well col-md-12" id="userVotes">
                    <div class="h4" id="lastVotesSize">Last 5 votes: of ${votes[0].user.likes.size()}</div>
                    <g:each var="vote" in="${votes}">
                        <g:if test="${vote.value > 0}">
                            <p class="h4">You liked:</p>

                            <p class="text-success">${vote.quote.text}</p>
                            <hr>
                        </g:if>
                        <g:if test="${vote.value < 0}">
                            <p class="h4">You disliked:</p>

                            <p class="text-danger">${vote.quote.text}</p>
                            <hr>
                        </g:if>

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