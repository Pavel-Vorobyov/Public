<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="lnTask"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Group</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/training-portal-student.css">
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
            <h1>Group name <--</h1>
            <div class="horizontal-group">
              <a class="uui-button" href="#">Group list</a>
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
                  <h2 class="courseDescription-item">Description:</h2>
                </li>
                <li class="item-body">
                  <a href="#">
                  <span class="tk-task-name" title="Lolli">sss</span>
                  <span class="tk-start-time" title="Lololol">s</span>
                  <span class="tk-deadline" title="Lololol">ss</span>
                  <span class="tk-courseDescription" title="Kffsdf">ss</span>
                </a>
                </li>

                <lnTask:taskLine taskTitle="rr" startTime="rr" deadline="rr" description="rr"/>

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
