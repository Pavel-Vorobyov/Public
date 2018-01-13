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
          <h1>Registration</h1>
          <form method="post" action="index.html">
            <p><input type="text" name="login" value="" placeholder="Enter login"></p>
            <p><input type="password" name="password" value="" placeholder="Enter password"></p>
            <p><input type="password" name="password" value="" placeholder="Confirm password"></p>
    				<p><input type="text" name="login" value="" placeholder="Enter email"></p>
            <p class="submit"><input type="submit" name="commit" value="Register"></p>
          </form>
        </div>
      </section>


    </div>

    <%@ include file="util/footer.jsp"%>

  </div>
</body>
</html>
