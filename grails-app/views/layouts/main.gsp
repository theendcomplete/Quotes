<!doctype html>
<html lang="en" class="no-js">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="button-bar" id="navigationBar">
            <a href="${createLink(controller: 'profile', action: 'show')}" class="btn btnNavi"
               role="button">Profile</a>
            <a href="${createLink(controller: 'quotes', action: 'showTop')}" class="btn btnNavi"
               role="button">Top 10</a>
            <a href="${createLink(controller: 'quotes', action: 'flop')}" class="btn btnNavi"
               role="button">Flop 10</a>
            <a href="${createLink(controller: 'quotes', action: 'last')}" class="btn btnNavi"
               role="button">Last</a>
        </div>
    </div>
</div>


<div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
    <ul class="nav navbar-nav navbar-left">

        %{--<g:createLink controller="profile" action="index">--}%
        <g:pageProperty name="page.nav"/>
    </ul>
</div>
</div>
</div>

<g:layoutBody/>

<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>
<style>
.btnNavi:hover {
    background-color: #55515c;
}

</style>
</body>
</html>
