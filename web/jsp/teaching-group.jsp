<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="lnTask"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Group</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/teaching-group.css">

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
            <h1>${requestScope.workGroup.title}</h1>
            <div class="horizontal-group">
              <a class="uui-button" href="command?command=training-group-list-page">Group list</a>
              <a class="uui-button" href="#">Course list</a>
              <a class="uui-button" href="#">Profile</a>
             </div>
          </div>
          <div class="td-group-wrapper">
            <div class="group-header-wrapper">
              <ul class="uui-item-list">
                <li class="item-body-header">
                  <h2 class="task-item">Task name:</h2>
                  <h2 class="start-time-item">Start time:</h2>
                  <h2 class="deadline-item">Deadline:</h2>
                  <h2 class="description-ite">Description:</h2>
                </li>

                <c:forEach var="groupTask" items="${requestScope.groupTaskList}">
                  <lnTask:taskLine taskHerf="${groupTask.taskHerf}" taskTitle="${groupTask.title}"
                                   startTime="${groupTask.creationTime}" deadline="${groupTask.deadline}" description="${groupTask.description}"/>
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
