<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Home</title>
  <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
  <link rel="stylesheet" type="text/css" href="../../css/default.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
  <link rel="stylesheet" type="text/css" href="../../css/common/user-home.css">
  <script type="text/javascript" src="../../js/default.js"></script>

  <fmt:requestEncoding value="UTF-8"/>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local"/>

  <fmt:message key="placeholder.close" var="close"/>
  <fmt:message key="button.update" var="upd"/>

</head>
<body>
  <div align="center">

    <jsp:include page="../util/nav.jsp"/>


    <div class="td-main-content-wrapper">
      <div class="td-main-content-conteiner">
        <div class="td-filters-wrapper">
        <div class="filters">
            <h1>${requestScope.userData.name} ${requestScope.userData.surname} <fmt:message key="title.profile"/>:</h1>
            <div class="horizontal-group">
              <c:choose>
                <c:when test="${sessionScope.user.status eq 0}">
                  <a class="uui-button" href="command?command=student_task_list_page"><fmt:message key="button.task-list"/></a>
                  <a class="uui-button" href="command?command=student_group_page"><fmt:message key="title.group-list"/></a>
                </c:when>
                <c:when test="${sessionScope.user.status eq 1}">
                  <a class="uui-button" href="command?command=training_group_list_page"><fmt:message key="button.group-task-list"/></a>
                </c:when>
                <c:when test="${sessionScope.user.status eq 2}">
                  <a class="uui-button" href="command?command=admin_course_moderation_page"><fmt:message key="button.course-moderation"/></a>
                  <a class="uui-button" href="command?command=admin_group_moderation_page"><fmt:message key="button.group-moderation"/></a>
                  <a class="uui-button" href="command?command=admin_user_moderation_page"><fmt:message key="button.user-moderation"/></a>
                </c:when>
              </c:choose>
             </div>
          </div>
        </div>
          <div class="td-user-profile-wrapper" align="center">
            <div class="user-photo-wrapper">
              <img src="../img/no-photo.jpg" height="360px">
            </div>
            <div class="user-data-wrapper">
              <h1><fmt:message key="title.personal-data"/>:</h1>
              <ul class="uui-item-list">
                <li class="data-name">
                  <span class="user-name-title"><fmt:message key="title.name"/>:</span>
                  <span class="user-name">${requestScope.userData.name}</span>
                </li>
                <li class="data-surname">
                  <span class="user-surname-title"><fmt:message key="title.surname"/>:</span>
                  <span class="user-surname">${requestScope.userData.surname}</span>
                </li>
                <li class="data-email">
                  <span class="user-email-title"><fmt:message key="title.email"/>:</span>
                  <span class="user-email">${sessionScope.user.email}</span>
                </li>
                <li class="data-login">
                  <span class="user-login-title"><fmt:message key="button.login"/>:</span>
                  <span class="user-login">${sessionScope.user.login}</span>
                </li>
                <li class="data-password">
                  <span class="user-password-title"><fmt:message key="title.password"/>:</span>
                  <span class="user-password">${sessionScope.user.password}</span>
                </li>
                <li class="data-creation-time">
                  <span class="user-creation-time-title"><fmt:message key="title.creation-time"/>:</span>
                  <span class="user-creation-time">${requestScope.userData.creationTime}</span>
                </li>
              </ul>
              <a onclick="showUpdateBlock(userDataModify)"><fmt:message key="button.personal-data-modify"/></a>
            </div>
            <div class="user-description-wrapper">
              <h1><fmt:message key="title.user-comment"/>:</h1>
              <span>
                ${sessionScope.userData.description}
              </span>
            </div>
          </dic>
      </div>

      </div>
    </div>

    <div style="display:none" id="userDataModify" class="userDataModify">
      <div class="container">
        <div class="modify">
          <a onclick="showUpdateBlock(userDataModify)" title="${close}" class="close">X</a>
          <h1><fmt:message key="button.personal-data-modidy"/>...</h1>
          <form method="post" action="command">
            <input type="hidden" name="command" value="student_user_data_modify"/>
            <p align="left">
              <fmt:message key="title.enter-name"/>:
              <input style="float:right" id="name" name="name" type="text" value="${requestScope.userData.name}">
            </p>
            <p align="left">
              <fmt:message key="title.enter-surname"/>:
              <input style="float:right" id="surname" name="surname" type="text" value="${requestScope.userData.surname}">
            </p>
            <p align="left">
              <fmt:message key="title.enter-email"/>:
              <input style="float:right" id="email" name="email" type="text" value="${sessionScope.user.email}">
            </p>
            <p align="left">
              <fmt:message key="title.enter-login"/>:
              <input style="float:right" readonly id="login" name="login" type="text" value="${sessionScope.user.login}">
            </p>
            <p align="left">
              <fmt:message key="title.enter-password"/>:
              <input style="float:right" id="password" name="password" type="text" value="${sessionScope.user.password}">
            </p>

            <p class="submit"><input type="submit" name="commit" value="${upd}"></p>
            </ul>
          </form>
        </div>
      </div>
    </div>

    <jsp:include page="../util/footer.jsp"/>


  </div>
</body>
</html>
