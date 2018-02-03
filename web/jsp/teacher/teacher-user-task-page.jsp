<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tag/Teacher.tld" prefix="lnUserTask"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html">
    <title>User task list</title>
    <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/default.css">
    <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
    <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
    <link rel="stylesheet" type="text/css" href="../../css/teacher/teacher-user-task-page.css">
    <script type="text/javascript" src="../../js/default.js"></script>

</head>
<body>
<div align="center">

    <jsp:include page="../util/nav.jsp"/>


    <div class="td-main-content-wrapper">
        <div class="td-main-content-conteiner">
            <div class="td-filters-wrapper">
                <div class="filters">
                    <h1>${requestScope.groupTitle}:</h1>
                    <div class="horizontal-group">
                        <a class="uui-button" href="command?command=training-group-list-page">Group task list</a>
                        <a class="uui-button" href="command?command=user-home-page">User data</a>
                    </div>
                </div>
            </div>
            <div style="height:20px">
            </div>

            <div class="group-name-wrapper">
                <h1> ${requestScope.taskTitle} </h1>
            </div>

            <div class="td-group-wrapper">
                <div class="group-header-wrapper">
                    <ul class="uui-item-list">
                        <li class="item-body-header">
                            <h2 class="user-name">Student name:</h2>
                            <h2 class="task-creation-time">Start time:</h2>
                            <h2 class="task-deadline">Deadline:</h2>
                            <h2 class="task-estimate">Estimate:</h2>
                            <h2 class="task-status">Status:</h2>
                        </li>

                        <c:forEach var="userTask" items="${requestScope.studentUserTaskList}">

                            <lnUserTask:usTkLn name="${userTask.studentName}" creationTime="${userTask.startTime}"
                                                     deadline="${userTask.deadline}" estimate="${userTask.estimate}"
                                                     status="${userTask.status}" userTaskId="${userTask.userTaskId}"/>

                            <lnUserTask:usTkUpd studentName="${userTask.studentName}" userTaskId="${userTask.userTaskId}"
                                                  groupId="${requestScope.groupId}" taskId="${requestScope.taskId}"
                                                  groupTitle="${requestScope.groupTitle}" taskTitle="${requestScope.taskTitle}"/>

                        </c:forEach>

                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>



<jsp:include page="../util/footer.jsp"/>

</div>
</body>
</html>
