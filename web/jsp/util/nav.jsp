<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="td-header-nav-wrap" align="center">
    <div class="td-header-nav">
        <input type="checkbox" name="Menu" id="btn-nav" />
        <label for="btn-nav">Menu</label>
        <ul align="right">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li><a href="command?command=home-page">Home</a></li>
                    <li><a href="command?command=training-portal-page">Training Portal</a></li>
                    <li><a href="command?command=news-page">News</a></li>
                    <li><a href="command?command=about-page">About</a></li>
                    <li><a href="command?command=training-page" >Training...</a></li>
                    <li id="header-nav-left"><a href="/command?command=sing-out">Sing out</a></li>
                    <li id="header-nav-left">Hello, ${sessionScope.userData.name} ${sessionScope.userData.surname} </li>
                </c:when>
                <c:otherwise>
                    <li><a href="command?command=home-page">Home</a></li>
                    <li><a href="command?command=training-portal-page">Training Portal</a></li>
                    <li><a href="command?command=news-page">News</a></li>
                    <li><a href="command?command=about-page">About</a></li>
                    <li id="header-nav-left"><a href="/command?command=sing-in-page">Login</a></li>
                    <li id="header-nav-left"><a href="/command?command=sing-up-page">Register</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
