<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Welcome page!</title>
  <link rel="stylesheet" type="text/css" href="css/util/reset.css">
  <link rel="stylesheet" type="text/css" href="../../css/default.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <script type="text/javascript" src="js/default.js"></script>

  <fmt:requestEncoding value="UTF-8"/>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local"/>

</head>
<body>

  <div align="center">

    <jsp:include page="jsp/util/nav.jsp"></jsp:include>

  <video autoplay loop muted preload class="td-bg-video" id="bgVideo">
    <source src="background/background-banner-move.mov"></source>
  </video>
  <img class="td-bg-img" alt="BgVidio" src="background/background_img_600px.png">

  <div class="td-main-content-banner" align="right">
    <div class="td-main-content-banner-span">
      <br><br><br>
      When you think it's too late, <br>the truth is, it's still early...<br><br>
      Try it yourself<br> and become successful! <br>
    </div>
  </div>

    <jsp:include page="jsp/util/footer.jsp"></jsp:include>

  </div>
</body>
</html>
