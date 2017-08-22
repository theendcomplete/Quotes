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
        <div class="col-md-12" id="votesAndLikes">
            <div class="col-md-8" id="userQuotes">
                <div class="h4">Your quotes:${profile.quotes.size()}</div>
                <g:each var="quote" in="${userQuotes}">
                    <hr>

                    <div class="h3">${quote.author}</div>

                    <div id="quote${quote.getId()}text">
                        ${quote.text}  <br>
                    </div>

                    <div id="createdBy" class="text-right">
                        created by "${quote.user}" at <g:formatDate format="dd-MM-yyyy HH:mm"
                                                                    date="${quote.dateCreated}"/>
                    </div>

                    <div id="rating${quote.getId()}">
                        <div class="h3"></div>rating: ${quote.rating}<br>
                    </div>

                %{--<div class="btn-group-sm">--}%
                %{--<button type="submit" class="btn btn-success" id="like"--}%
                %{--onclick="like('${it.getId()}');">+</button>--}%
                %{--<button type="submit" class="btn btn-danger" id="dislike"--}%
                %{--onclick="dislike('${it.getId()}');">-</button>--}%
                %{--</div>--}%
                    <hr>
                </g:each>
                <div class="pagination">
                    <g:paginate controller="profile" action="show" total="${profile.quotes.size()}" max="8"/>
                </div>
            </div>

            <div class="col-md-4" id="userVotes">
                <div class="h4">Your votes:${profile.likes.size()}</div>
                <g:each var="vote" in="${votes}">
                    <hr>
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
                <div class="pagination">
                    <g:paginate controller="profile" action="show" total="${profile.likes.size()}" max="8"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>