<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="crCard"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Training portal</title>
  <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
  <link rel="stylesheet" type="text/css" href="../../css/default.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
  <link rel="stylesheet" type="text/css" href="../../css/common/training-portal.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/course-card.css">
  <script type="text/javascript" src="../../js/common/training-portal.js"></script>

</head>
<body>
<div align="center">

  <jsp:include page="../util/nav.jsp"/>


  <div class="td-main-content-wrapper">
    <div class="td-main-content-conteiner">
      <div class="td-filters-wrapper">
        <div class="filters">
          <h1>Training portal </h1>
          <div class="horizontal-group">
            <c:choose>
              <c:when test="${requestScope.courseStatus eq 1}">
                <a class="uui-button" onclick="changeCourseStatus(0)">Planing</a>
                <a class="uui-button">Started</a>
              </c:when>
              <c:otherwise>
                <a class="uui-button">Planing</a>
                <a class="uui-button" onclick="changeCourseStatus(1)">Started</a>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
      <div style="height:20px">
      </div>

      <div class="group-name-wrapper">
        <h1> course list </h1>
        <div class="form-filter">
          <form name="courseFilter">
            <input type="hidden" name="courseStatus" value="${requestScope.courseStatus}">

            <div class="select-group">
              <select id="course-region" name="courseRegion" onchange="handleSubmit()">
                <c:choose>
                  <c:when test="${requestScope.courseRegion eq 'Gomel, Belarus'}">
                    <option value="All">All</option>
                    <option value="Minsk, Belarus">Minsk, Belarus</option>
                    <option value="Brest, Belarus">Brest, Belarus</option>
                    <option selected value="Gomel, Belarus">Gomel, Belarus</option>
                  </c:when>
                  <c:when test="${requestScope.courseRegion eq 'Minsk, Belarus'}">
                    <option value="All">All</option>
                    <option selected value="Minsk, Belarus">Minsk, Belarus</option>
                    <option value="Brest, Belarus">Brest, Belarus</option>
                    <option value="Gomel, Belarus">Gomel, Belarus</option>
                  </c:when>
                  <c:when test="${requestScope.courseRegion eq 'Brest, Belarus'}">
                    <option value="All">All</option>
                    <option value="Minsk, Belarus">Minsk, Belarus</option>
                    <option selected value="Brest, Belarus">Brest, Belarus</option>
                    <option value="Gomel, Belarus">Gomel, Belarus</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="All">All</option>
                    <option value="Minsk, Belarus">Minsk, Belarus</option>
                    <option value="Brest, Belarus">Brest, Belarus</option>
                    <option value="Gomel, Belarus">Gomel, Belarus</option>
                  </c:otherwise>
                </c:choose>
              </select>
            </div>
            <div class="select-group">
              <select id="course-type" name="courseType" onchange="handleSubmit()">
                <c:choose>
                  <c:when test="${requestScope.courseType eq 'Testing'}">
                    <option value="All">All</option>
                    <option value="Java">Java</option>
                    <option value="PHP">PHP</option>
                    <option selected value="Testing">Testing</option>
                  </c:when>
                  <c:when test="${requestScope.courseType eq 'Java'}">
                    <option value="All">All</option>
                    <option selected value="Java">Java</option>
                    <option value="PHP">PHP</option>
                    <option value="Testing">Testing</option>
                  </c:when>
                  <c:when test="${requestScope.courseType eq 'PHP'}">
                    <option value="All">All</option>
                    <option value="Java">Java</option>
                    <option selected value="PHP">PHP</option>
                    <option value="Testing">Testing</option>
                  </c:when>
                  <c:otherwise>
                    <option selected value="All">All</option>
                    <option value="Java">Java</option>
                    <option value="PHP">PHP</option>
                    <option value="Testing">Testing</option>
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
                                   status="Avalible fo apply" buttonName="Apply" href="#" courseId="${course.courseId}"/>
              </c:when>
              <c:otherwise>
                <crCard:courseCard cardTitle="${course.title}" location="${course.region}"
                                   status="Started" buttonName="Apply" href="#" courseId="${course.courseId}"/>
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
