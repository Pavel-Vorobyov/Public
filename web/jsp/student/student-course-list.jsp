<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="crCard"%>
<%@ taglib uri="/WEB-INF/tag/Student.tld" prefix="lnTask"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Task list</title>
  <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
  <link rel="stylesheet" type="text/css" href="../../css/default.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/course-card.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
  <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
  <link rel="stylesheet" type="text/css" href="../../css/student/student-task-list.css">
  <link rel="stylesheet" type="text/css" href="../../css/common/training-portal.css">
  <script type="text/javascript" src="../../js/default.js"></script>

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
            <h1>${sessionScope.userData.name} ${sessionScope.userData.surname} <fmt:message key="title.course-list"/>:</h1>
            <div class="horizontal-group">
              <a class="uui-button" href="command?command=student_task_list_page"><fmt:message key="button.task-list"/></a>
              <a class="uui-button" href="command?command=student_group_page"><fmt:message key="title.group-list"/></a>
              <a class="uui-button" href="#"><fmt:message key="title.current-courses"/></a>
            </div>
          </div>
        </div>
          <div style="height:20px">
          </div>

        <div class="td-course-wrapper">
          <div class="course-wrapper">
              <c:forEach var="course" items="${requestScope.courseList}">
                <c:choose>
                  <c:when test="${course.status == 0}">
                    <crCard:courseCard cardTitle="${course.title}" location="${course.region}"
                                       status="${availForAply}" buttonName="${started}" courseId="${course.courseId}" onClick="applyForCourse(${course.courseId})"/>
                  </c:when>
                  <c:otherwise>
                    <crCard:courseCard cardTitle="${course.title}" location="${course.region}"
                                       status="${started}" buttonName="${started}" courseId="${course.courseId}" onClick="applyForCourse(${course.courseId})"/>
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
