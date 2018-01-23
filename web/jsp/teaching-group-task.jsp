<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="lnUserTask"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Task</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/teaching-group-task.css">

  <script type="text/javascript">
    var links = [];
      links['tests'] = 'questions.php/?id=5';
      links['tests2'] = 'questions.php/?id=8';

    var blockUpdateIdCount = 0;
    function getBlockUpdateId() {
        return blockUpdateIdCount++;
    }

    function initUpdateBlock(taskModify){
        taskModify.style.display = "none";
    }
    function showUpdateBlock(blockId) {
        if (blockId.style.display == "none")
        {
            blockId.style.display = "block";
        }
        else
        {
            blockId.style.display = "none";
        }
    }
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
              <a class="uui-button" href="command?command=training-group-page&group-id=${requestScope.workGroup.workGroupId}">Group task</a>
              <a class="uui-button" href="#">Profile</a>
             </div>
          </div>
          <div class="td-group-wrapper">
            <div class="group-header-wrapper">
              <ul class="uui-item-list">
                <li class="item-body-header">
                  <h2 class="task-item">Student name:</h2>
                  <h2 class="start-time-item">Start time:</h2>
                  <h2 class="deadline-item">Deadline:</h2>
                  <h2 class="estimate-item">Estimate:</h2>
                  <h2 class="status-item">Status:</h2>
                </li>
                <c:forEach var="userTask" items="${requestScope.teachingUserTask}">
                  <lnUserTask:userTaskLine name="${userTask.studentName}" creationTime="${userTask.startTime}"
                                           deadline="${userTask.deadline}" estimate="${userTask.estimate}" status="${userTask.status}" blockUpdateId="studentTaskUpdate${userTask.userTaskId}"/>
                  <lnUserTask:usTaskUpd studentName="${userTask.studentName}" userTaskId="${userTask.userTaskId}"
                                        updateBlockId="studentTaskUpdate${userTask.userTaskId}" groupId="${userTask.groupId}" taskId="${userTask.taskId}"/>
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
