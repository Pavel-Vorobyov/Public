
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
<body>
    <a onclick="showUpdateBlock(courseModify)">taskModify</a>
    <div onload="initUpdateBlock(courseModify)" id="courseModify" class="courseModify">
      <div class="container">
              <div class="modify">
                <a onclick="showUpdateBlock(courseModify)" title="Закрыть" class="close">X</a>
                <h1>Course creating...</h1>
                <form method="post" action="command">
                  <input type="hidden" name="command" value="admin-course-create"/>
                  <p align="left">
                    <input required style="" name="title" type="text" placeholder="Enter course title">
                    </p>
                  <p align="left">
                    <textarea required rows="12" cols="45" placeholder="Enter course description">
                    </textarea>
                    <div class="select-conteiner">
                      <select style="" required>
                        <option selected value="0">Available</option>
                        <option value="1">Not available</option>
                      </select>
                      <select style="" required>
                        <option value="Java">Java</option>
                        <option value="PHP">PHP</option>
                        <option value="Testing">Testing</option>
                      </select>
                      <select style="" required>
                        <option selected value="Minsk, Belarus">Minsk, Belarus</option>
                        <option value="Brest, Belarus">Brest, Belarus</option>
                        <option value="Gomel, Belarus">Gomel, Belarus</option>
                      </select>
                      <input name="estimate" type="text" placeholder="Teacher id">
                      <input name="commit" type="submit" value="Create">
                    </div>
                  </p>
                  </ul>
                </form>
              </div>
    </div>
  </div>

</body>
</html>
