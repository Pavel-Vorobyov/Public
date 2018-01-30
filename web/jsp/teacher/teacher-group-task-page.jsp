
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html">
    <title>Task list</title>
    <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/default.css">
    <link rel="stylesheet" type="text/css" href="../../css/student/student-task-list.css">

</head>
<body>
<div align="center">

    <jsp:include page="../util/nav.jsp"/>


    <div class="td-main-content-wrapper">
        <div class="td-main-content-conteiner">
            <div class="td-filters-wrapper">
                <div class="filters">
                    <h1>Name Name task list:</h1>
                    <div class="horizontal-group">
                        <a class="uui-button" href="#">Task list</a>
                        <a class="uui-button" href="command?command=student-group-page">Group list</a>
                        <a class="uui-button" href="command?command=student-home-page">Home</a>
                    </div>
                </div>
            </div>
            <div style="height:20px">
            </div>

            <c:forEach var="studentUserTask" items="${requestScope.studentUserTaskList}">
                <div class="group-name-wrapper">
                    <h1> ${studentUserTask.workGroupTitle} </h1>
                </div>
                <div class="td-group-wrapper">
                    <div class="group-header-wrapper">
                        <ul class="uui-item-list">
                            <li class="item-body-header">
                                <h2 class="task-title">Task title:</h2>
                                <h2 class="task-creation-time">Creation time:</h2>
                                <h2 class="task-deadline">Deadline:</h2>
                                <h2 class="task-estimate">Estimate:</h2>
                                <h2 class="task-status">Status:</h2>
                                <h2 class="task-comment">Comment:</h2>
                            </li>

                            <c:forEach var="userTask" items="${studentUserTask.userTaskList}">
                                <lnTask:studentTaskLine href="#" taskTitle="${userTask.taskTitle}" taskCreationTime="${userTask.creationTime}"
                                                        deadline="${userTask.deadline}" comment="${userTask.comment}"
                                                        estimate="${userTask.estimate}" status="${userTask.status}"/>
                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<jsp:include page="../util/footer.jsp"/>

</div>
</body>
</html>
