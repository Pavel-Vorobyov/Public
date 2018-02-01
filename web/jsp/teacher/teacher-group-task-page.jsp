<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="ln"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html">
    <title>Task list</title>
    <link rel="stylesheet" type="text/css" href="../../css/util/reset.css">
    <link rel="stylesheet" type="text/css" href="../../css/default.css">
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
                        <a class="uui-button" href="command?command=user-home-page">User data</a>
                    </div>
                </div>
            </div>
            <div style="height:20px">
            </div>

            <c:forEach var="teacherGroupTask" items="${requestScope.teacherGroupTaskList}">
                <div class="group-name-wrapper">
                    <h1> ${teacherGroupTask.groupTitle} </h1>
                    <div class="group-task">
                        <a onclick="showUpdateBlock(createTask${teacherGroupTask.groupId})">Create task</a>
                    </div>
                </div>

                <div id="createTask${teacherGroupTask.groupId}" class="createTask">
                    <div class="container">
                        <div class="creation">
                            <a onclick="showUpdateBlock(createTask${teacherGroupTask.groupId})" title="Close" class="close">X</a>
                            <h1>Creation task for group...</h1>
                            <form method="post" action="command">
                                <input type="hidden" name="command" value="teacher-create-task"/>
                                <input type="hidden" name="group-id" value="${teacherGroupTask.groupId}"/>
                                <p><input type="text" name="title" required id="title" value=""
                                          pattern="^.{1,44}$" placeholder="Enter task title">
                                    <input type="date" name="deadline" required="true" id="deadline" value=""
                                           placeholder="Time when a task should be done"></p>
                                <p><textarea required maxlength="1000" rows="9" cols="34" name="description"
                                             id="description" placeholder="Enter task description"></textarea></p>
                                <p class="submit">
                                    <input type="submit" name="modify" value="Create task">
                                </p>
                            </form>
                        </div>
                    </div>
                </div>

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
                                    <a href="command?command=teacher-user-task-page&taskId=${task.taskId}&groupId=${teacherGroupTask.groupId}&groupTitle=${teacherGroupTask.groupTitle}&taskTitle=${task.title}">
                                        <span class="tk-task-title">${task.title}</span>
                                        <span class="tk-task-creation-time">${task.creationTime}</span>
                                        <span class="tk-task-deadline">${task.deadline}</span>
                                        <span class="tk-task-comment">${task.description}</span>
                                    </a>
                                    <a class="task-modify">
                                        <span class="tk-modify-button" onclick="showUpdateBlock(updateTask${task.taskId})">Modify</span>
                                    </a>
                                </li>

                                <div id="updateTask${task.taskId}" class="createTask">
                                    <div class="container">
                                        <div class="creation">
                                            <a onclick="showUpdateBlock(updateTask${task.taskId})" title="Close" class="close">X</a>
                                            <h1>Creation task for group...</h1>
                                            <form method="post" action="command">
                                                <input type="hidden" name="command" value="teacher-update-task"/>
                                                <input type="hidden" name="task-id" value="${task.taskId}"/>
                                                <p><input type="text" name="title" required id="title" value="${task.title}"
                                                          pattern="^.{1,44}$" placeholder="Enter task title">
                                                    <input type="date" name="deadline" required="true" id="deadline" value=""
                                                           placeholder="Time when a task should be done"></p>
                                                <p><textarea required maxlength="1000" rows="9" cols="34" name="description"
                                                             id="description" placeholder="Enter task description">${task.description}</textarea></p>
                                                <p class="submit">
                                                    <input type="submit" name="modify" value="Update task">
                                                </p>
                                            </form>
                                        </div>
                                    </div>
                                </div>

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
