<!doctype html>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>Please create your account</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
</head>

<body>

<form class="form-horizontal" action="createUser">
    <fieldset>

        <!-- Form Name -->
        <legend>Account creation</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Your login:</label>

            <div class="col-md-4">
                <input id="login" name="login" type="text" placeholder="ex. TheRoadWarrior or Jane"
                       class="form-control input-md" required="">
                <span class="help-block">It will be used as a your username</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">Your password</label>

            <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="type it here"
                       class="form-control input-md" required="">
                <span class="help-block">please, remember it!</span>
            </div>
        </div>
        <button class="btn-primary" role="button"></button>
    </fieldset>
</form>