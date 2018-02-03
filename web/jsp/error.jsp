
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html">
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="../css/error.css">
      <script type="text/javascript">
        function initUpdateBlock(blockId){
            blockId.style.display = "none";
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
<%--<body>--%>
    <%--<a onclick="showUpdateBlock(courseModify)">taskModify</a>--%>
    <%--<div style="display: none" id="courseModify" class="courseModify">--%>
      <%--<div class="container">--%>
              <%--<div class="modify">--%>
                <%--<a onclick="showUpdateBlock(courseModify)" title="Закрыть" class="close">X</a>--%>
                <%--<h1>Course creating...</h1>--%>
                <%--<form method="post" action="command">--%>
                  <%--<input type="hidden" name="command" value="admin-course-create"/>--%>
                  <%--<p align="left">--%>
                    <%--<input required style="" name="title" type="text" placeholder="Enter course title">--%>
                    <%--</p>--%>
                  <%--<p align="left">--%>
                    <%--<textarea required rows="12" cols="45" placeholder="Enter course description"></textarea>--%>
                    <%--<div class="select-conteiner">--%>
                      <%--<select style="" required>--%>
                        <%--<option selected value="0">Available</option>--%>
                        <%--<option value="1">Not available</option>--%>
                      <%--</select>--%>
                      <%--<select style="" required>--%>
                        <%--<option value="Java">Java</option>--%>
                        <%--<option value="PHP">PHP</option>--%>
                        <%--<option value="Testing">Testing</option>--%>
                      <%--</select>--%>
                      <%--<select style="" required>--%>
                        <%--<option selected value="Minsk, Belarus">Minsk, Belarus</option>--%>
                        <%--<option value="Brest, Belarus">Brest, Belarus</option>--%>
                        <%--<option value="Gomel, Belarus">Gomel, Belarus</option>--%>
                      <%--</select>--%>
                      <%--<input name="estimate" type="text" placeholder="Teacher id">--%>
                      <%--<input name="commit" type="submit" value="Create">--%>
                    <%--</div>--%>
                  <%--</p>--%>
                  <%--</ul>--%>
                <%--</form>--%>
              <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
<%--</body>--%>



<div style="display: block" id="courseModify" class="courseModify">
  <div class="container">
    <div class="modify">
      <a onclick="showUpdateBlock(courseModify)" title="Закрыть" class="close">X</a>
      <h1>Mail box</h1>
      <form method="post" action="command">
        <input type="hidden" name="command" value="admin-course-create"/>

        <div align="left">
          <textarea class="mail-context" cols="50"></textarea>
          <div class="mail-conteiner">
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>
            <a class="mail-link">
              <span class="mail-link-text">adasdadasdasdasdadadsadasdasdasdadasdadasadads</span>
            </a>

          </div>
        </div>
      </form>
    </div>
  </div>
</div>

</html>


<li class="item-body">
  <a href="#">
    <span class="tk-group-title">sssssssssssssssssssssssssssssssssssssssssssssssssssssssss</span>
    <span class="tk-group-type">sssssssssssssssssssssssssssssssssssssssssssssssssssssss</span>
    <span class="tk-group-region">sssssssssssssssssssssssssssssssssssssssssssssssssssssssn:</span>
    <span class="tk-group-status">Grsssssssssssssssssssssssssssssssssssssssssssssssssssssssoup status:</span>
  </a>
  <a onclick="showUpdateBlock(groupUpdateBlock1)" style="text-align: center;">
    <span class="tk-group-modify">Modify</span>
  </a>
</li>

<li class="item-body">
  <a>
    <span class="tk-user-name"></span>
    <span class="tk-user-surname"></span>
    <span class="tk-user-creation-time"></span>
    <span class="tk-user-email"></span>
    <span class="tk-user-status"></span>
  </a>
  <a onclick="showUpdateBlock(userCreateBlock)" style="text-align: center;">
    <span class="tk-group-modify">Modify</span>
  </a>
</li>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="gpLine"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tag/CourseCard.tld" prefix="ln"%>

<li class="item-body">
  <a >
    <span class="tk-student-name">${task.title}</span>
    <span class="tk-task-creation-time">${task.creationTime}</span>
    <span class="tk-task-deadline">${task.deadline}</span>
    <span class="tk-task-estimate">${task.description}</span>
    <span class="tk-task-status">${task.description}</span>
  </a>
</li>

