<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/Admin.tld" prefix="usLine"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Group list</title>
  <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
  <link rel="stylesheet" type="text/css" href="../../css/default.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
  <link rel="stylesheet" type="text/css" href="../../css/admin/admin-user-moderation.css">
  <script type="text/javascript" src="../../js/default.js"></script>
  <script type="text/javascript" src="../../js/admin/admin-user-moderation.js"></script>

</head>
<body>
  <div align="center">

    <jsp:include page="../util/nav.jsp"/>


    <div class="td-main-content-wrapper">
      <div class="td-main-content-conteiner">
        <div class="td-filters-wrapper">
        <div class="filters">
            <h1>${sessionScope.userData.name} ${sessionScope.userData.surname} admin page:</h1>
            <div class="horizontal-group">
              <a class="uui-button" href="command?command=admin-course-moderation-page">Course moderation</a>
              <a class="uui-button" href="command?command=admin-group-moderation-page">Group moderation</a>
              <a class="uui-button" href="#">User moderation</a>
              <a class="uui-button" href="command?command=user-home-page">User data</a>
            </div>
          </div>
        </div>
          <div style="height:20px">
          </div>

          <div class="group-name-wrapper">
            <h1> Group list </h1>
            <div class="form-filter">
              <form name="userFilter" action="#">
                <div class="select-group">
                    <select name="filterUserStatus" onchange="handleSubmit()">
                      <c:choose>
                        <c:when test="${requestScope.filterUserStatus eq 1}">
                          <option value="0">Student</option>
                          <option selected value="1">Teacher</option>
                          <option value="2">Admin</option>
                        </c:when>
                        <c:when test="${requestScope.filterUserStatus eq 2}">
                          <option value="0">Student</option>
                          <option value="1">Teacher</option>
                          <option selected value="2">Admin</option>
                        </c:when>
                        <c:otherwise>
                          <option selected value="0">Student</option>
                          <option value="1">Teacher</option>
                          <option value="2">Admin</option>
                        </c:otherwise>
                      </c:choose>
                    </select>
                </div>
              </form>
             </div>
          </div>
          <div class="td-course-wrapper">
            <div class="course-wrapper">

                  <ul class="uui-item-list">
                    <li class="item-body-header">
                      <h2 class="user-name">Name:</h2>
                      <h2 class="user-surname">Surname:</h2>
                      <h2 class="user-creation-time">Creation time:</h2>
                      <h2 class="user-email">Email:</h2>
                      <h2 class="user-status">Status:</h2>
                    </li>


                    <c:forEach var="userForAdmin" items="${requestScope.userForAdminList}">
                      <usLine:userLine userId="${userForAdmin.userId}" userStatus="${userForAdmin.status}" userName="${userForAdmin.name}" userSurname="${userForAdmin.surname}"
                                       userCreationTime="${userForAdmin.creationTime}" userEmail="${userForAdmin.email}"/>


                      <div style="display: none;" id="userUpdateBlock${userForAdmin.userId}" class="courseModify">
                        <div class="container">
                          <div class="modify">
                            <a onclick="showUpdateBlock(userUpdateBlock${userForAdmin.userId})" title="Close" class="close">X</a>
                            <h1>User updating...</h1>
                            <form name="userUpdate" method="post" action="command">
                              <input type="hidden" name="command" value="update-user">
                              <input type="hidden" name="filterUserStatus" value="${requestScope.filterUserStatus}">
                              <input type="hidden" name="userId" value="${userForAdmin.userId}">
                              <p align="l1eft">
                                Enter name:
                                <input style="float:right" id="name" name="name" type="text" value="${userForAdmin.name}">
                              </p>
                              <p align="left">
                                Enter surname:
                                <input style="float:right" id="surname" name="surname" type="text" value="${userForAdmin.surname}">
                              </p>
                              <p align="left">
                                Enter email:
                                <input style="float:right" id="email" name="email" type="text" value="${userForAdmin.email}">
                              </p>
                              <p align="left">
                                Enter status:
                                <select style="float:right" name="userStatus">
                                  <option selected value="0">Student</option>
                                  <option value="1">Teacher</option>
                                  <option value="2">Admin</option>
                                </select>
                              </p>
                              <p class="submit">
                                <input type="submit" name="commit" value="Update">
                              </p>
                            </form>
                          </div>
                        </div>
                      </div>


                    </c:forEach>

                  </ul>
            </div>
        </div>

      </div>

      </div>
    </div>

    <jsp:include page="../util/footer.jsp"/>


  </div>
</body>
</html>
