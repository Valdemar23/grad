<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: natad
  Date: 18.05.2016
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <script src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous">
    </script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="/static/grade-list.css">
    <link rel="stylesheet" href="/static/general.css">
</head>
<body class="container">

<!-- Trigger the modal with a button -->
<div class="create-button">
<button type="button" class="btn btn-primary col-xs-2" data-toggle="modal" data-target="#addGradeModal">Add treaty</button>
</div>
<p class="text-center text-success col-offset-xs-12 bg-success flash-message">${message}</p>
<!-- addGradeModal -->
<div id="addGradeModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h1>Add treaty</h1>
            </div>
            <div class="modal-body">
                <form action="/treaty/create" method="post" class="">
                    <div class="form-group">
                        <label for="user-treaty">Username</label>
                        <select class="form-control" treaty="userId" id="user-treaty" required>
                            <option selected disabled></option>
                            <c:forEach var="user" items="${users}">
                            <option value="${user.userId}">${user.userName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="treaty">Treaty</label>
                        <input type="text" class="form-control" treaty="treaty" value="${treaty.treaty}" id="treaty" required>
                    </div>

                    <!--<div class="form-group">
                        <label for="comment">Comment</label>
                        <input type="text" class="form-control" treaty="comment" value="${grade.comment}" id="comment" >
                    </div>-->
                    <div class="form-group">
                        <input type="hidden" class="form-control" treaty="userId" value="${user.userId}">
                    </div>
                    <button type="submit" class="btn btn-primary col-xs-12">Add</button>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<table class="table table-striped text-center all-items">
    <tr>
        <th class="col-xs-2 text-center">Username:</th>
        <th class="col-xs-1 text-center">Treaty:</th>
        <th class="col-xs-2 text-center">Date:</th>
        <th class="col-xs-1 text-center">Edit</th>
        <th class="col-xs-1 text-center">Delete</th>
    </tr>

    <c:forEach items="${treaty}" var="treaty">
    <tr>
        <td>${treaty.user.userName}</td>
        <td>${treaty.treaty}</td>
        <td>${treaty.date}</td>
        <td><a href="/treaty/edit/${treaty.id}"><i class="glyphicon glyphicon-pencil" style="color: #d9b144;"></i></a></td>
        <td>
            <form action="/treaty/delete" method="post">
                <input type="hidden" treaty="id" value="${treaty.id}">
            <button type="submit" style="height: 0; border: 0; padding: 0;"><i class="glyphicon glyphicon-remove" style="color: #d90000;"></i></button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
