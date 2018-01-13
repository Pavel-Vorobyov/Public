<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Welcome page!</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/sing-up.css">
</head>
<body>
  <div align="center">

    <div class="td-header-nav-wrap" align="center">
      <div class="td-header-nav">
        <input type="checkbox" name="Menu" id="btn-nav" />
        <label for="btn-nav">Menu</label>
        <ul align="right">
          <li><a href="#">Home</a></li>
          <li><a href="#">Training Portal</a></li>
          <li><a href="#">News</a></li>
          <li><a href="#">About</a></li>
          <li id="header-nav-left"><a href="#">Login</a></li>
          <li id="header-nav-left"><a href="#">Register</a></li>
        </ul>
      </div>
    </div>

    <div class="td-main-content-banner" align="right">

      <jsp:include page="sing-up.jsp"></jsp:include>

    </div>

    <div class="td-footer">

    </div>

  </div>
</body>
</html>
