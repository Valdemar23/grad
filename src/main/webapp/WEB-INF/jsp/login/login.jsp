<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:spring="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"></link>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"></link>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <form role="form">
        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label">Login</label>
            <div class="col-sm-10">
                <input type="text" class="form-control input-xs" id="userName" name="userName" value="${user.userName}" placeholder="Input username"></input>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control input-xs" id="password" name="password" value="${user.password}" placeholder="Input password"></input>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Login</button>
    </form>
</div>
</body>
</html>