<%@ page import="grails.plugin.springsecurity.SpringSecurityService" %>

<div class="login col-md-12">

<sec:ifLoggedIn>
    <div class="col-md-6">
        <div class="row">Hello, <sec:username/>!</div>

        <div class="row">
            <div id="avatar" class="col-md-12" align="right">
                <img src="${resource(dir: 'images', file: 'quote-icon.png')}" class="img-thumbnail">
                <a href="${createLink(controller: 'profile', action: 'show')}">Edit</a>
            </div>
        </div>

        <div class="row">
            <div class="well col-md-12" id="userVotes">
                <div class="h4" id="lastVotesSize">Last 5 votes of ${votesTotal}</div>
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
    <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform" autocomplete="off">
    <p>
        <label for="username"><g:message code='springSecurity.login.username.label'/>:</label>
        <input type="text" class="text_" name="username" id="username"/>
    </p>

    <p>
        <label for="password"><g:message code='springSecurity.login.password.label'/>:</label>
        <input type="password" class="text_" name="password" id="password"/>
    </p>

    <p id="remember_me_holder">
        <input type="checkbox" class="chk" name="remember-me" id="remember_me"/>
        <label for="remember_me"><g:message code='springSecurity.login.remember.me.label'/></label>
    </p>

    <p>
        <input type="submit" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
    </p>
    </form>



%{--<form name="banner-login" method="POST" action="${resource('file': 'j_spring_security_check')}">--}%
%{--<form name="banner-login" action="/login/authenticate" method="POST" id="loginForm" class="cssform"--}%
%{--autocomplete="off">--}%
%{--<ul>--}%
%{--<li>--}%
%{--<label for="j_username">Username:</label>--}%
%{--<g:textField name="j_username"/>--}%
%{--</li>--}%
%{--<li>--}%
%{--<label for="j_password">Password:</label>--}%
%{--<g:passwordField name="j_password"/>--}%
%{--</li>--}%
%{--</ul>--}%

%{--<div class="button-panel">--}%
%{--<g:submitButton name="banner-login-button" value="Log in"/>--}%
%{--</div>--}%
%{--</form>--}%

%{--<div class="row">--}%
%{--<a href="${createLink(controller: 'profile', action: 'register')}">Create account</a>--}%
%{--</div>--}%
%{--</div>--}%
</sec:ifNotLoggedIn>
</div>