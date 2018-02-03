<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/Teacher.tld" prefix="tr"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html">
    <title>Task list</title>
    <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/default.css">
    <link rel="stylesheet" type="text/css" href="../../css/util/header.css">
    <link rel="stylesheet" type="text/css" href="../../css/util/footer.css">
    <link rel="stylesheet" type="text/css" href="../../css/teacher/teacher-group-task-page.css">
    <script type="text/javascript" src="../../js/default.js"></script>

</head>
<body>
<div align="center">

    <jsp:include page="../util/nav.jsp"/>


    <div class="td-main-content-wrapper">
        <div class="td-main-content-conteiner">
            <div class="td-filters-wrapper">
                <div class="filters">
                    <h1>Group task list:</h1>
                    <div class="horizontal-group">
                        <a class="uui-button" href="#">Group task list</a>
                        <a class="uui-button" href="command?command=user_home_page">User data</a>
                    </div>
                </div>
            </div>
            <div style="height:20px">
            </div>

            <c:forEach var="teacherGroupTask" items="${requestScope.teacherGroupTaskList}">
                <div class="group-name-wrapper">
                    <h1> ${teacherGroupTask.groupTitle} </h1>
                    <div class="group-task">
                        <a onclick="showUpdateBlock(createTask)">Create task</a>
                    </div>
                </div>

                <tr:gpTkUpd groupId="${teacherGroupTask.groupId}" blockTitle="Creation task for group..." helpTaskTitle="Enter task title"
                            helpTaskDescription="Enter task description" submitButtonTitle="Create task" helpButtonClose="Close"/>

                <div class="td-group-wrapper">
                    <div class="group-header-wrapper">
                        <ul class="uui-item-list">
                            <li class="item-body-header">
                                <h2 class="task-title">Task title:</h2>
                                <h2 class="task-creation-time">Creation time:</h2>
                                <h2 class="task-deadline">Deadline:</h2>
                                <h2 class="task-comment">Description:</h2>
                            </li>

                            <c:forEach var="task" items="${teacherGroupTask.taskList}">
                                <li class="item-body">
                                    <a href="command?command=teacher_user_task_page&taskId=${task.taskId}&groupId=${teacherGroupTask.groupId}&groupTitle=${teacherGroupTask.groupTitle}&taskTitle=${task.title}">
                                        <span class="tk-task-title">${task.title}</span>
                                        <span class="tk-task-creation-time">${task.creationTime}</span>
                                        <span class="tk-task-deadline">${task.deadline}</span>
                                        <span class="tk-task-comment">${task.description}</span>
                                    </a>
                                    <a class="task-modify">
                                        <span class="tk-modify-button" onclick="showUpdateBlock(updateTask${task.taskId})">Modify</span>
                                    </a>
                                </li>

                                <tr:gpTkUpd taskId="${task.taskId}" helpTaskTitle="Enter task title" helpTaskDescription="Enter task description" helpButtonClose="Close"
                                            submitButtonTitle="Update task" blockTitle="Creation task for group...1"
                                            taskTitle="${task.title}" taskDescription="${task.description}"/>

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
