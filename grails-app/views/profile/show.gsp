<%@ page import="grails.plugin.springsecurity.SpringSecurityService" %>
%{--<%@ page import="com.theendcomplete.quotes.User" %>--}%
<!doctype html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Quoter</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<div class="col-md-8">
    <div class="row">Hello, ${profile.toString()}!</div>

    <div class="row">
        <div id="avatar" class="col-md-2" align="right">
            <img src="${resource(dir: 'images', file: 'quote-icon.png')}" class="img-thumbnail">
            <a href="${createLink(controller: 'profile', action: 'index')}">Edit</a>
        </div>
    </div>

    <div class="row">
        <div class="well col-md-12" id="userVotes">
            <div class="h4" id="lastVotesSize">Last 5 votes of ${profile.likes.size()}</div>
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
</body>
</html>