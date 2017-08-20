<asset:javascript src="jquery.js"/>

<div class="well">
    <div id="quote${it.getId()}" class="well-sm">
        <h2>${it.author}</h2>
        ${it.text}  <br>

        <div id="createdBy" class="text-right">
            created by ${it.user} at <g:formatDate format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/>
        </div>
        rating: ${it.rating}<br>

        <div class="btn-group-sm">
            <button type="submit" class="btn btn-success" value="">+</button>
            <button type="submit" class="btn btn-danger" value="">-</button>
        </div>
    </div>
</div>


