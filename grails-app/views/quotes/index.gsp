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
//        $(document).ready(function () {
//            $('button').click(function () {
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
            }
        });
//            });
//        });
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
                event.cancelBubble
            }
        });
    }
</script>


<div class="row">
    <div id="randomQuote" class="col-md-5 centered">
        <g:render template="randomQuote" collection="${randomQuote}"/>
    </div>
    <sec:ifLoggedIn>
        <div id="login" class="col-md-5 right">
            <g:render template="login" collection="${votes}"/>
        </div>
    </sec:ifLoggedIn>



    <sec:ifNotLoggedIn>
        <div id="login" class="col-md-5 right">
            <g:render template="login"/>
        </div>
    </sec:ifNotLoggedIn>
</div>

<div class="row">

    <div id="quotelist" class="col-md-5">
        <g:render template="quoteEntries" collection="${quoteList}"/>
    </div>

</div>

</body>

</html>