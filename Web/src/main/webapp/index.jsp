<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Админка</title>
</head>
<body>
<p>Привет админушка!</p>
<p>Что ты хочешь сделать?</p>
<form method="post" action="/admin">
<pre>
<label for="name">NAME</label>      <input type="text" name="name" id="name" required="required">
<label for="login">LOGIN</label>     <input type="text" name="login" id="login" required="required">
<label for="password">PASSWORD</label>  <input type="text" name="password" id="password" required="required">

<input type="submit" name="add" value="add">
</pre>
</form>
<form method="get" action="/showAll">
    <input type="submit" name="showAll" value="showAll">
</form>
</body>
</html>