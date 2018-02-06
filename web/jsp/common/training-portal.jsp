<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="crCard"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Training portal</title>
  <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
  <link rel="stylesheet" type="text/css" href="../../css/default.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
  <link rel="stylesheet" type="text/css" href="../../css/common/training-portal.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/course-card.css">
  <script type="text/javascript" src="../../js/default.js"></script>
  <script type="text/javascript" src="../../js/common/training-portal.js"></script>

  <fmt:requestEncoding value="UTF-8"/>
  <fmt:setLocale value="${sessionScope.local}"/>
  <fmt:setBundle basename="local"/>

  <fmt:message key="title.available-for-apply" var="availForAply"/>
  <fmt:message key="title.started" var="started"/>
  <fmt:message key="title.apply" var="apply"/>

</head>
<body>
<div align="center">

  <jsp:include page="../util/nav.jsp"/>


  <div class="td-main-content-wrapper">
    <div class="td-main-content-conteiner">
      <div class="td-filters-wrapper">
        <div class="filters">
          <h1><fmt:message key="title.course-list"/></h1>
          <div class="horizontal-group">
            <c:choose>
              <c:when test="${requestScope.courseStatus eq 1}">
                <a class="uui-button" onclick="changeCourseStatus(0)"><fmt:message key="title.planing"/></a>
                <a class="uui-button"><fmt:message key="title.started"/></a>
              </c:when>
              <c:otherwise>
                <a class="uui-button"><fmt:message key="title.planing"/></a>
                <a class="uui-button" onclick="changeCourseStatus(1)"><fmt:message key="title.started"/></a>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
      <div style="height:20px">
      </div>

      <div class="group-name-wrapper">
        <div class="form-filter">
          <form name="courseFilter">
            <input type="hidden" name="courseStatus" value="${requestScope.courseStatus}">

            <div class="select-group">
              <select id="course-region" name="courseRegion" onchange="handleSubmit()">
                <c:choose>
                  <c:when test="${requestScope.courseRegion eq 'Gomel, Belarus'}">
                    <option value="All"><fmt:message key="option.all"/></option>
                    <option value="Minsk, Belarus"><fmt:message key="option.minsk-belarus"/></option>
                    <option value="Brest, Belarus"><fmt:message key="option.brest-belarus"/></option>
                    <option selected value="Gomel, Belarus"><fmt:message key="option.gomel-belarus"/></option>
                  </c:when>
                  <c:when test="${requestScope.courseRegion eq 'Minsk, Belarus'}">
                    <option value="All"><fmt:message key="option.all"/></option>
                    <option selected value="Minsk, Belarus"><fmt:message key="option.minsk-belarus"/></option>
                    <option value="Brest, Belarus"><fmt:message key="option.brest-belarus"/></option>
                    <option value="Gomel, Belarus"><fmt:message key="option.gomel-belarus"/></option>
                  </c:when>
                  <c:when test="${requestScope.courseRegion eq 'Brest, Belarus'}">
                    <option value="All"><fmt:message key="option.all"/></option>
                    <option value="Minsk, Belarus"><fmt:message key="option.minsk-belarus"/></option>
                    <option selected value="Brest, Belarus"><fmt:message key="option.brest-belarus"/></option>
                    <option value="Gomel, Belarus"><fmt:message key="option.gomel-belarus"/></option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="All"><fmt:message key="option.all"/></option>
                    <option value="Minsk, Belarus"><fmt:message key="option.minsk-belarus"/></option>
                    <option value="Brest, Belarus"><fmt:message key="option.brest-belarus"/></option>
                    <option value="Gomel, Belarus"><fmt:message key="option.gomel-belarus"/></option>
                  </c:otherwise>
                </c:choose>
              </select>
            </div>
            <div class="select-group">
              <select id="course-type" name="courseType" onchange="handleSubmit()">
                <c:choose>
                  <c:when test="${requestScope.courseType eq 'Testing'}">
                    <option value="All"><fmt:message key="option.all"/></option>
                    <option value="Java"><fmt:message key="option.java"/></option>
                    <option value="PHP"><fmt:message key="option.php"/></option>
                    <option selected value="Testing"><fmt:message key="option.testing"/></option>
                  </c:when>
                  <c:when test="${requestScope.courseType eq 'Java'}">
                    <option value="All"><fmt:message key="option.all"/></option>
                    <option selected value="Java"><fmt:message key="option.java"/></option>
                    <option value="PHP"><fmt:message key="option.php"/></option>
                    <option value="Testing"><fmt:message key="option.testing"/></option>
                  </c:when>
                  <c:when test="${requestScope.courseType eq 'PHP'}">
                    <option value="All"><fmt:message key="option.all"/></option>
                    <option value="Java"><fmt:message key="option.java"/></option>
                    <option selected value="PHP"><fmt:message key="option.php"/></option>
                    <option value="Testing"><fmt:message key="option.testing"/></option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="All"><fmt:message key="option.all"/></option>
                    <option value="Java"><fmt:message key="option.java"/></option>
                    <option value="PHP"><fmt:message key="option.php"/></option>
                    <option value="Testing"><fmt:message key="option.testing"/></option>
                  </c:otherwise>
                </c:choose>
              </select>
            </div>
          </form>
        </div>
      </div>
      <div class="td-course-wrapper">
        <div class="course-wrapper">
          <c:forEach var="course" items="${requestScope.courseList}">
            <c:choose>
              <c:when test="${course.status == 0}">
                <crCard:courseCard cardTitle="${course.title}" location="${course.region}"
                                   status="${availForAply}" buttonName="${apply}" courseId="${course.courseId}" onClick="applyForCourse(${course.courseId})"/>
              </c:when>
              <c:otherwise>
                <crCard:courseCard cardTitle="${course.title}" location="${course.region}"
                                   status="${started}" buttonName="${apply}" courseId="${course.courseId}" onClick="applyForCourse(${course.courseId})"/>
              </c:otherwise>
            </c:choose>

          </c:forEach>
        </div>
      </div>

    </div>

  </div>
</div>

<jsp:include page="../util/footer.jsp"/>


</div>
</body>
</html>
