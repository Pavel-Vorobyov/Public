<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local"/>

<div class="td-header-nav-wrap" align="center">
    <div class="td-header-nav">
        <input type="checkbox" name="Menu" id="btn-nav" />
        <label for="btn-nav">Menu</label>
        <ul align="right">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li><a href="command?command=home-page"><fmt:message key="button.home"/></a></li>
                    <li><a href="command?command=training-portal-page"><fmt:message key="button.training-portal"/></a></li>
                    <li><a href="command?command=training-page" ><fmt:message key="button.training"/></a></li>
                    <li id="header-nav-left"><a href="/command?command=sing-out"><fmt:message key="button.logout"/></a></li>
                    <li id="header-nav-left"><fmt:message key="title.welcome"/> ${sessionScope.userData.name} ${sessionScope.userData.surname}</li>
                </c:when>
                <c:otherwise>
                    <li><a href="command?command=home-page"><fmt:message key="button.home"/></a></li>
                    <li><a href="command?command=training-portal-page"><fmt:message key="button.training-portal"/></a></li>
                    <li id="header-nav-left"><a href="#singIn"><fmt:message key="button.login"/></a></li>
                    <li id="header-nav-left"><a href="#singOn"><fmt:message key="button.register"/></a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>

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
              <a href="#singOn" class="sb-register">Register</a>
              <input type="submit" name="commit" value="Log in">
            </p>
          </form>
        </div>
    </div>
  </div>

    <div id="singOn" class="singOn">
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
                    <p class="submit">
                        <a href="#singIn" class="sb-register">Login</a>
                        <input type="submit" name="commit" value="Register">
                    </p>
                </form>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="../../js/util/nav.js"></script>
    <c:choose>
        <c:when test="${requestScope.statusMessage != null}">
            <div class="statusMessage" id="statusMessage" onclick="showMessage(statusMessage)">
                    ${requestScope.statusMessage}
                <br> Tap to close it!
            </div>
        </c:when>
    </c:choose>

</div>
