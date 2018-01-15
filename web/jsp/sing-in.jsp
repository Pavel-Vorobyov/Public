<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Welcome page!</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/sing-up-in.css">
</head>
<body>
  <div align="center">

    <%@ include file="util/nav.jsp"%>

    <div class="td-main-content-wrapper">

      <section class="container">
        <div class="login">
          <h1>Login to your user</h1>
          <form method="post" action="command">
            <input type="hidden" name="command" value="sing-in"/>
            <p><input type="text" name="login" id="login" value="" placeholder="Enter login" pattern="([\w]{3,16})"
                      placeholder="Вевиде от 3 до 16 символов!"></p>
            <p><input type="password" name="password" id="password" value="" placeholder="Enter password" pattern="([\w]{8,16})"
                      placeholder="Вевиде от 3 до 16 символов!"></p>
            <p class="submit">
              <input class="sb-register" type="submit" name="register" value="Register">
              <input type="submit" name="commit" value="Log in">
            </p>
          </form>
        </div>
      </section>


    </div>

    <%@ include file="util/footer.jsp"%>

  </div>
</body>
</html>
