<asset:javascript src="jquery.js"/>

<div class="well">
    <div id="quote${it.getId()}" class="well-sm">

        <h2>${it.author}</h2>

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
            <button type="submit" class="btn btn-success" id="like" onclick="like(${it.getId()});">+</button>
            <button type="submit" class="btn btn-danger" id="dislike" onclick="dislike(${it.getId()});">-</button>
        </div>
    </div>
</div>
<script>
    var quoteText = document.getElementById("quote${it.getId()}text");

    quoteText.style.cursor = 'pointer';
    quoteText.onclick = function () {
        location.href = "${createLink(controller: 'quotes', action: 'show',id:"${it.getId()}" )}"
    };
</script>

%{--<script>--}%
%{--function like(id) {--}%
%{--$(document).ready(function () {--}%
%{--$('button').click(function () {--}%
%{--var URL = "${createLink(controller: 'quotes', action: 'like',id:"${it.getId()}" )}";--}%

%{--$.ajax({--}%
%{--url: URL,--}%
%{--data: {id: ${it.getId()}},--}%
%{--success: function (resp) {--}%
%{--console.log(resp);--}%
%{--//                        window.alert(resp.rating)--}%
%{--//                        $("#rating").HTML.data(resp.rating);--}%
%{--$("quote${it.getId()}").html(resp.rating);--}%
%{--}--}%
%{--});--}%
%{--});--}%
%{--});--}%
%{--}--}%
%{--</script>--}%

