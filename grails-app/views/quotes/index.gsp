<!doctype html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Quoter</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<div class="row">
    <div id="randomQuote" class="col-md-5 centered">
        <g:render template="randomQuote" collection="${randomQuote}"/>
    </div>

    <div id="login" class="col-md-4 right">
        here will be login
    </div>
</div>

<div class="row">

    <div id="quotelist" class="col-md-5">
        <g:render template="quoteEntries" collection="${quoteList}"/>
    </div>

</div>

</body>
</html>