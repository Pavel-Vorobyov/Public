<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Welcome page!</title>
  <link rel="stylesheet" type="text/css" href="css/util/reset.css">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <script type="text/javascript" src="js/index.js"></script>
  <script type="text/javascript">
      function showMessage(blockId) {
          if (blockId.style.display == "none")
          {
              blockId.style.display = "block";
          }
          else
          {
              blockId.style.display = "none";
          }
      }
  </script>
  <div id="local" data-item="${sessionScope.local}"></div>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local.local" var="loc"/>
  <fmt:message bundle="${loc}" key="button.home" var="home"/>
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

    <c:choose>
      <c:when test="${requestScope.loginSuccess eq 'false'}">
        <div class="statusMessage" id="statusMessage" onclick="showMessage(statusMessage)">
            ${requestScope.statusMessage}
          <br> Tap to close it!
        </div>
      </c:when>
    </c:choose>

    <jsp:include page="jsp/util/footer.jsp"></jsp:include>

  </div>
</body>
</html>
