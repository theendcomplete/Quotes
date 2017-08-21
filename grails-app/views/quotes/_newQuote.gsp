<form class="form-horizontal" role="form" method="post" action="/quotes/createQuote">
    <fieldset>
        <!-- change col-sm-N to reflect how you would like your column spacing (http://getbootstrap.com/css/#forms-control-sizes) -->
        <!-- Form Name -->
        <legend>Add a Quote</legend>

        <!-- Text input http://getbootstrap.com/css/#forms -->
        <div class="row">
            <div class="form-group">
                <label for="quoteAuthor" class="control-label col-sm-2">Author</label>

                <div class="col-sm-8">
                    <input type="text" class="form-control" id="quoteAuthor" name="quoteAuthor"
                           placeholder="ex., John Rambo" required="">

                    <p class="help-block">the author of the quote</p>
                </div>
            </div>
            <!-- Textarea http://getbootstrap.com/css/#textarea -->
            <div class="form-group">
                <label class="control-label col-sm-2" for="quoteText">Quote</label>

                <div class="col-sm-8">
                    <textarea class="form-control" id="quoteText" name="quoteText" rows="2"
                              required="" placeholder="To survive a war, you gotta become war."></textarea>

                    <p class="help-block">the quote itself</p>
                </div>
            </div>
        </div>

        <div class="row">
            <!-- Button http://getbootstrap.com/css/#buttons -->
            <div class="form-group">
                <label class="control-label col-sm-2" for="submit"></label>

                <div class="text-center col-sm-8">
                    <button type="submit" id="submit" name="submit" class="btn btn-primary"
                            aria-label="">submit</button>

                </div>
            </div>
        </div>
    </fieldset>
</form>
