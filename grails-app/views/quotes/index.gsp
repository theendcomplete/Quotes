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
//            data: {id: ElementId},
            success: function (resp) {
                console.log(resp);
                console.log("#rating" + ElementId);
                var updateDivId = "#rating" + ElementId
//                window.alert("" + resp.newRating)
                $(updateDivId).text("rating: " + resp.newRating);
//                document.getElementById(updateDivId).innerHTML =
//                    resp.newRating;
//                $(toUpdate).val(resp.newRating);
//                $("quote" + id).();
            }
        });
//            });
//        });
    }
</script>
<script>
    function dislike(ElementId) {
//        $(document).ready(function () {
//            $('button').click(function () {
        var URL = "${createLink(controller: 'quotes', action: 'dislike')}" + "/" + ElementId;
        console.log(ElementId);
        $.ajax({

            url: URL,
            dataType: "json",
            asnyc: false,
//            data: {id: ElementId},
            success: function (resp) {
                console.log(resp);
                console.log("#rating" + ElementId);
                var updateDivId = "#rating" + ElementId
//                window.alert("" + resp.newRating)
                $(updateDivId).text("rating: " + resp.newRating);
//                document.getElementById(updateDivId).innerHTML =
//                    resp.newRating;
//                $(toUpdate).val(resp.newRating);
//                $("quote" + id).();
            }
        });
//            });
//        });
    }
</script>


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