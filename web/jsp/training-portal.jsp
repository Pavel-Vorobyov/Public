<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="crCard"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Training list</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/training-portal.css">
  <link rel="stylesheet" type="text/css" href="../css/course-card.css">

  <script type="text/javascript">
    var links = [];
      links['tests'] = 'questions.php/?id=5';
      links['tests2'] = 'questions.php/?id=8';
    </script>

</head>
<body>
  <div align="center">

    <jsp:include page="util/nav.jsp"/>


    <div class="td-main-content-wrapper">
      <div class="td-main-content-conteiner">
        <div class="filters">
            <h1>Training list</h1>
            <div class="horizontal-group">
              <c:choose>
                <c:when test="${sessionScope.courseStatus == 2}">
                  <a class="uui-button" href="#">All</a>
                  <a class="uui-button" href="command?command=training-portal-page&courseStatus=0">Planing</a>
                  <a class="uui-button" href="command?command=training-portal-page&courseStatus=1">Started</a>
                </c:when>
                <c:when test="${sessionScope.courseStatus == 1}">
                  <a class="uui-button" href="command?command=training-portal-page&courseStatus=2">All</a>
                  <a class="uui-button" href="command?command=training-portal-page&courseStatus=0">Planing</a>
                  <a class="uui-button" href="#">Started</a>
                </c:when>
                <c:when test="${sessionScope.courseStatus == 0}">
                  <a class="uui-button" href="command?command=training-portal-page&courseStatus=2">All</a>
                  <a class="uui-button" href="#">Planing</a>
                  <a class="uui-button" href="command?command=training-portal-page&courseStatus=1">Started</a>
                </c:when>
              </c:choose>
             </div>
            <div class="form-filter">
              <form name="form-filter" action="#">
                <div class="select-group" style="padding-right: 130px;">
                  <select form="form-filter" onchange="if (this.value) top.location.href=links[this.value];">
                  	<option value="0">All</option>
                  	<option value="#">Minsk, Belaruss</option>
                  	<option value="#">Brest, Belsrus</option>
                  	<option value="#">Gomel, Belarus</option>
                  </select>
                </div>
                <div class="select-group">
                    <select form="form-filter" onchange="if (this.value) top.location.href=links[this.value];">
                    	<option value="0">All</option>
                    	<option value="#">Java</option>
                    	<option value="#">PHP</option>
                    	<option value="#">Testing</option>
                    </select>
                </div>
              </form>
             </div>
          </div>
          <div class="course-list-wrapper">
            <div class="course-list-conteiner">

              <c:forEach var="course" items="${sessionScope.courseList}">
                <c:choose>
                  <c:when test="${course.status == 0}">
                    <crCard:courseCard cardTitle="${course.title}" location="${course.region}"
                                       status="Avalible fo apply" buttonName="Apply"/>
                  </c:when>
                  <c:otherwise>
                    <crCard:courseCard cardTitle="${course.title}" location="${course.region}"
                                       status="Started" buttonName="Apply"/>
                  </c:otherwise>
                </c:choose>
            </c:forEach>

          </div>
        </div>
      </div>
    </div>

    <jsp:include page="util/footer.jsp"/>


  </div>
</body>
</html>
