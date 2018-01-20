
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" http-equiv="content-type" content="text/html">
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="../css/error.css">
      <script type="text/javascript">
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
  <body onload="initUpdateBlock(taskModify)">
    <a onclick="showUpdateBlock(taskModify)">taskModify</a>
    <div id="taskModify" class="taskModify">
      <div class="container">
              <div class="mofidy">
                <a onclick="showUpdateBlock(taskModify)" title="Закрыть" class="close">X</a>
                <h1>User task modify...</h1>
                <form method="post" action="command">
                  <input type="hidden" name="command" value="teacher-user-task-modify"/>
                  <p><input type="text" name="deadline" required="true" id="deadline" value="" placeholder="Deadline" pattern=""></p>
                  <p><input type="text" name="estimate" required="true" id="estimate" value="" placeholder="Estimate" pattern=""></p>
                  <p><input type="text" name="status" required="true" id="status" value="" placeholder="Status" pattern=""></p>
                  <p class="submit">
                    <input type="submit" name="modify" value="Modify">
                  </p>
                </form>
              </div>
    </div>
  </div>
</body>

<a href="#studentTaskUpdate">StudentTaskUpdate</a>
<div id="studentTaskUpdate" class="studentTaskUpdate">
    <div class="container">
      <div class="taskUpdate">
        <a href="#close" title="Закрыть" class="close">X</a>
        <h1>Registration</h1>
        <form method="post" action="command">
          <input type="hidden" name="command" value="add-user"/>
          <p>
            Enter estimate:
            <input style="float:right" type="number" min="0" max="10">
            </p>
          <p>
            Enter deadline:
            <input type="date" style="float:right" name="deadline" id="deadline" value=""
            placeholder="Time when a task should be done">
          </p>
          <p>
            Select task status:
            <select name="taskStatus" style="float:right">
              <option selected value="3">Revision</option>
              <option value="1">Complite</option>
            </select>
          </p>
          <p>
            <textarea maxlength="1000" rows="12" cols="45" name="taskDescription" id="taskDescription"></textarea>
          </p>
          <p class="submit"><input type="submit" name="commit" value="Update"></p>
        </form>
      </div>
  </div>
</div>

</body>
</html>
