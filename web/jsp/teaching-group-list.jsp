<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="ln"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Group list</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/training-group-list.css">

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
            <h1>Group list</h1>
            <div class="horizontal-group">
              <a class="uui-button" href="#">Course list</a>
              <a class="uui-button" href="#">Profile</a>
             </div>
          </div>
          <div class="td-group-wrapper">
            <div class="group-header-wrapper">
              <ul class="uui-item-list">
                <li class="item-body-header">
                  <h2 class="name-item">Group name:</h2>
                  <h2 class="region-item">Place:</h2>
                  <h2 class="course-item">Course:</h2>
                  <h2 class="description-item">Description:</h2>
                </li>

                <c:forEach var="teachingGroup" items="${requestScope.teachingGroupList}">
                  <ln:groupLine groupHerf="${teachingGroup.groupHerf}" groupTitle="${teachingGroup.workGroupTitle}" courseLocation="${teachingGroup.courseRegion}"
                                     courseCourse="${teachingGroup.courseTitle}" courseDescription="${teachingGroup.courseDescription}"/>
                </c:forEach>

              </ul>
            </div>
            <div class="td-group-conteiner">

          </div>
        </div>
      </div>
    </div>

    <jsp:include page="util/footer.jsp"/>


  </div>
</body>
</html>
