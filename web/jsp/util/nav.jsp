<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="td-header-nav-wrap" align="center">
    <div class="td-header-nav">
        <input type="checkbox" name="Menu" id="btn-nav" />
        <label for="btn-nav">Menu</label>
        <ul align="right">
            <c:choose>
                <c:when test="${session != null}">
                    <li><a href="#">Home</a></li>
                    <li><a href="jsp/training-portal-student.jsp">Training Portal</a></li>
                    <li><a href="#">News</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#" >Lolllol</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="#">Home</a></li>
                    <li><a href="jsp/training-portal-student.jsp">Training Portal</a></li>
                    <li><a href="#">News</a></li>
                    <li><a href="#">About</a></li>
                    <li id="header-nav-left"><a href="jsp/sing-in.jsp">Login</a></li>
                    <li id="header-nav-left"><a href="jsp/sing-up.jsp">Register</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
