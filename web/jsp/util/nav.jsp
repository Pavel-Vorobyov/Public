<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="../../js/utill/header.js"></script>

    <fmt:requestEncoding value="UTF-8"/>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local"/>

    <fmt:message key="button.register" var="register"/>
    <fmt:message key="placeholder.close" var="close"/>
    <fmt:message key="button.login" var="logIn"/>
    <fmt:message key="title.enter-login" var="entrLgn"/>
    <fmt:message key="title.enter-password" var="entrPsswrd"/>
    <fmt:message key="title.enter-email" var="entrEml"/>

    <c:if test="${requestScope.statusMessage != null}">
        <div class="statusMessage" id="statusMessage" onclick="showMessage(statusMessage)">
                ${requestScope.statusMessage}
            <br> <fmt:message key="title.tap-to-close-it"/>!
        </div>
    </c:if>

    <div class="td-header-nav-wrap" align="center">
        <div class="td-header-nav">
            <ul class="menu" align="right">

                <li><a href="command?command=home_page"><fmt:message key="button.home"/></a></li>
                <li><a href="command?command=training_portal_page"><fmt:message key="button.training-portal"/></a></li>
                <li id="header-nav-left"><a href=#><fmt:message key="title.language"/></a>
                    <ul class="submenu">
                        <li><a href=# onclick="enLocal()"><fmt:message key="title.english"/></a></li>
                        <li><a href=# onclick="ruLocal()"><fmt:message key="title.russian"/></a></li>
                    </ul>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <li><a href="command?command=training_page" ><fmt:message key="button.training"/></a></li>
                        <li id="header-nav-left"><a href=#>${sessionScope.userData.name} ${sessionScope.userData.surname}</a>
                            <ul class="submenu">
                                <li><a href="command?command=user_home_page"><fmt:message key="title.profile"/></a></li>
                                <li><a href="/command?command=sing_out"><fmt:message key="button.logout"/></a></li>
                            </ul>
                        </li>
                        <li id="header-nav-left"><fmt:message key="title.welcome"/></li>

                    </c:when>
                    <c:otherwise>
                        <li id="header-nav-left"><a href=# onclick="showUpdateBlock(singIn)"><fmt:message key="button.login"/></a></li>
                        <li id="header-nav-left"><a href=# onclick="showUpdateBlock(singOn)"><fmt:message key="button.register"/></a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

        <div id="singIn" class="singIn">
          <div class="container">
            <div class="login">
              <a onclick="showUpdateBlock(singIn)" title="${close}" class="close">X</a>
              <h1><fmt:message key="title.login"/></h1>
              <form method="post" action="command">
                <input type="hidden" name="command" value="sing_in"/>
                <p><input type="text" name="login" required="true" id="login" value=""
                          placeholder="${entrLgn}" pattern="([\w]{3,16})"></p>
                <p><input type="password" name="password" required="true" id="password" value=""
                          placeholder="${entrPsswrd}" pattern="([\w]{7,16})"></p>
                <p class="submit">
                  <input type="submit" name="commit" value="${logIn}">
                </p>
              </form>
            </div>
        </div>
      </div>

        <div id="singOn" class="singOn">
            <div class="container">
                <div class="register">
                    <a onclick="showUpdateBlock(singOn)" title="${close}" class="close">X</a>
                    <h1><fmt:message key="title.registration"/></h1>
                    <form method="post" action="command">
                        <input type="hidden" name="command" value="add_user"/>
                        <p><input type="text" name="login" required="true" value="" placeholder="${entrLgn}"></p>
                        <p><input type="password" name="password" required="true" value="" placeholder="${entrPsswrd}"></p>
                        <p><input type="text" name="email" required="true" value="" placeholder="${entrEml}"></p>
                        <p class="submit">
                            <input type="submit" name="commit" value="${register}">
                        </p>
                    </form>
                </div>
            </div>
        </div>

    </div>
