<asset:javascript src="jquery.js"/>

<div id="quote${it.getId()}" class="well">

    <div class="h3">${it.author}</div>

    <div id="quote${it.getId()}text">
        ${it.text}  <br>
    </div>

    <div id="createdBy" class="text-right">
        created by ${it.user} at <g:formatDate format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/>
    </div>

    <div id="rating${it.getId()}">
        rating: ${it.rating}<br>
    </div>

    <div class="btn-group-sm">
        <button type="submit" class="btn btn-success" id="like" onclick="like('${it.getId()}');">+</button>
        <button type="submit" class="btn btn-danger" id="dislike" onclick="dislike('${it.getId()}');">-</button>
    </div>
</div>
%{--<script>--}%
%{--var quoteText = document.getElementById("quote${it.getId()}text");--}%

%{--quoteText.style.cursor = 'pointer';--}%
%{--quoteText.onclick = function () {--}%
%{--$('form[data-update-target]').live('ajax:success', function (evt, data) {--}%
%{--var target = $(this).data('quote${it.getId()}"');--}%
%{--$('#' + target).html(data);--}%
%{--});--}%
%{--}--}%
%{--)--}%
%{--;--}%
%{--</script>--}%

<script>
    var quoteText = document.getElementById("quote${it.getId()}text");
    quoteText.style.cursor = 'pointer';
    quoteText.onclick = function () {
        window.alert("Here will be redirect to quote detail page")
        %{--location.href = "${createLink(controller: 'quotes', action: 'show',id:"${it.getId()}" )}"--}%
    };
</script>


