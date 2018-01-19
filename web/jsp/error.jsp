
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html">
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="../css/error.css">
</head>
<body>
    <a href="#taskModify">Открыть модальное окно</a>
    <div id="taskModify" class="taskModify">
      <div class="container">
              <div class="mofidy">
                <a href="#close" title="Закрыть" class="close">X</a>
                <h1>User task modify...</h1>
                <form method="post" action="command">
                  <input type="hidden" name="command" value="teacher-user-task-modify"/>
                  <p><input type="text" name="deadline" required="true" id="deadline" value="" placeholder="Deadline" pattern=""></p>
                  <p><input type="text" name="estimate" required="true" id="estimate" value="" placeholder="Estimate" pattern=""></p>
                  <p><input type="text" name="status" required="true" id="status" value="" placeholder="Status" pattern=""></p>
                  <p class="submit">
                    <input type="submit" name="modify" value="Modify">
                  </p>
                </form>
              </div>
    </div>
  </div>

  <a href="#singIn">Открыть модальное окно</a>
  <div id="singIn" class="singIn">
    <div class="container">
      <div class="login">
        <a href="#close" title="Закрыть" class="close">X</a>
        <h1>Login to your user</h1>
        <form method="post" action="command">
          <input type="hidden" name="command" value="sing-in"/>
          <p><input type="text" name="login" required="true" id="login" value="" placeholder="Enter login" pattern="([\w]{3,16})"
                    placeholder="Вевиде от 3 до 16 символов!"></p>
          <p><input type="password" name="password" required="true" id="password" value="" placeholder="Enter password" pattern="([\w]{7,16})"
                    placeholder="Вевиде от 3 до 16 символов!"></p>
          <p class="submit">
            <input class="sb-register" type="submit" name="register" value="Register">
            <input type="submit" name="commit" value="Log in">
          </p>
        </form>
      </div>
  </div>
</div>

<a href="#singOut">Открыть модальное окно</a>
<div id="singOut" class="singOut">
  <div class="container">
    <div class="register">
      <a href="#close" title="Закрыть" class="close">X</a>
      <h1>Registration</h1>
      <form method="post" action="command">
        <input type="hidden" name="command" value="add-user"/>
        <p><input type="text" name="login" required="true" value="" placeholder="Enter login"></p>
        <p><input type="password" name="password" required="true" value="" placeholder="Enter password"></p>
        <p><input type="password" name="password2" required="true" value="" placeholder="Confirm password"></p>
        <p><input type="text" name="email" required="true" value="" placeholder="Enter email"></p>
        <p class="submit"><input type="submit" name="commit" value="Register"></p>
      </form>
    </div>
</div>
</div>

</body>
</html>
