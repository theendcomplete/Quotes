<!doctype html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Quoter</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>

<script>
    function like(ElementId) {
        var URL = "${createLink(controller: 'quotes', action: 'like')}" + "/" + ElementId;
        console.log(ElementId);
        $.ajax({
            url: URL,
            dataType: "json",
            asnyc: false,
            success: function (resp) {
                console.log(resp);
                console.log("#rating" + ElementId);
                var updateDivId = "#rating" + ElementId
                $(updateDivId).text("rating: " + resp.newRating);
                $("#lastVotesSize").text("Last 5 votes of " + resp.votesTotal);
            }
        });
    }
</script>
<script>
    function dislike(ElementId) {
        var URL = "${createLink(controller: 'quotes', action: 'dislike')}" + "/" + ElementId;
        console.log(ElementId);
        $.ajax({
            url: URL,
            dataType: "json",
            asnyc: false,
            success: function (resp) {
                console.log(resp);
                console.log("#rating" + ElementId);
                var updateDivId = "#rating" + ElementId
                $(updateDivId).text("rating: " + resp.newRating);
                $("#lastVotesSize").text("Last 5 votes of " + resp.votesTotal);
            }
        });
    }
</script>

<div class="col-md-12">
    <div class="row">

        <div id="randomQuote" class="col-md-6">
            <div class="row centered">
                <g:render template="randomQuote" collection="${randomQuote}"/>
            </div>
            <sec:ifLoggedIn>
                <div class="row centered">
                    <g:render template="newQuote"/>
                </div>
            </sec:ifLoggedIn>
            <div class="row">
                <div id="quotelist" class="col-md-12">
                    <g:render template="quoteEntries" collection="${quoteList}"/>
                </div>
            </div>
        </div>

        <div id="login" class="col-md-6 right">

            <g:render var="${votes}" template="login"/>
        </div>
    </div>
</div>

</body>

</html>