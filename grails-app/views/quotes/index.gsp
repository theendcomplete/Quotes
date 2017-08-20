<!doctype html>

<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Quoter</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>
<div id="quotelist" class="col-md-5">
    <g:render template="quoteEntries" collection="${quoteList}"/>
</div>

<div id="login"></div>
</body>
</html>