<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/Teacher.tld" prefix="tr"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <fmt:requestEncoding value="UTF-8"/>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local"/>

    <fmt:message key="button.create-task" var="createTsk"/>
    <fmt:message key="placeholder.close" var="close"/>
    <fmt:message key="placeholder.enter-task-description" var="entTskDesc"/>
    <fmt:message key="placeholder.enter-task-title" var="entTskTtle"/>
    <fmt:message key="title.creation-task-for-group" var="crtTskFrGrp"/>
    <fmt:message key="title.updating-group-task" var="updGpTsk"/>
    <fmt:message key="button.update-task" var="btnUpd"/>

</head>
<body>
<div align="center">

    <jsp:include page="../util/nav.jsp"/>


    <div class="td-main-content-wrapper">
        <div class="td-main-content-conteiner">
            <div class="td-filters-wrapper">
                <div class="filters">
                    <h1><fmt:message key="button.group-task-list"/>:</h1>
                    <div class="horizontal-group">
                        <a class="uui-button" href="#"><fmt:message key="button.group-task-list"/></a>
                    </div>
                </div>
            </div>
            <div style="height:20px">
            </div>

            <c:forEach var="teacherGroupTask" items="${requestScope.teacherGroupTaskList}">
                <div class="group-name-wrapper">
                    <h1> ${teacherGroupTask.groupTitle} </h1>
                    <div class="group-task">
                        <a onclick="showUpdateBlock(createTask)"><fmt:message key="button.create-task"/></a>
                    </div>
                </div>

                <tr:gpTkUpd groupId="${teacherGroupTask.groupId}" blockTitle="${crtTskFrGrp}..." helpTaskTitle="${entTskTtle}"
                            helpTaskDescription="${entTskDesc}" submitButtonTitle="${createTsk}" helpButtonClose="${close}"/>

                <div class="td-group-wrapper">
                    <div class="group-header-wrapper">
                        <ul class="uui-item-list">
                            <li class="item-body-header">
                                <h2 class="task-title"><fmt:message key="title.task-title"/>:</h2>
                                <h2 class="task-creation-time"><fmt:message key="title.creation-time"/>:</h2>
                                <h2 class="task-deadline"><fmt:message key="title.deadline"/>:</h2>
                                <h2 class="task-comment"><fmt:message key="title.description"/>:</h2>
                            </li>

                            <c:forEach var="task" items="${teacherGroupTask.taskList}">
                                <li class="item-body">
                                    <a href="command?command=teacher_user_task_page&taskId=${task.taskId}&groupId=${teacherGroupTask.groupId}&groupTitle=${teacherGroupTask.groupTitle}&taskTitle=${task.title}">
                                        <span class="tk-task-title">${task.title}</span>
                                        <span class="tk-task-creation-time">${task.creationTime}</span>
                                        <span class="tk-task-deadline">${task.deadline}</span>
                                        <span class="tk-task-comment">${task.description}</span>
                                    </a>
                                    <a class="task-modify" href="#" onclick="showUpdateBlock(updateTask${task.taskId})">
                                        <span class="tk-modify-button"><fmt:message key="button.modify"/></span>
                                    </a>
                                </li>

                                <tr:gpTkUpd taskId="${task.taskId}" helpTaskTitle="${entTskTtle}" helpTaskDescription="${entTskDesc}" helpButtonClose="${close}"
                                            submitButtonTitle="${btnUpd}" blockTitle="${updGpTsk}..."
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
