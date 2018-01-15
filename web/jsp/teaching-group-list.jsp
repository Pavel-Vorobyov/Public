<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="content-type" content="text/html">
  <title>Group list</title>
  <link rel="stylesheet" type="text/css" href="../css/reset.css">
  <link rel="stylesheet" type="text/css" href="../css/default.css">
  <link rel="stylesheet" type="text/css" href="../css/training-portal-student.css">
  <link rel="stylesheet" type="text/css" href="../css/teaching-group-list.css">

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
            <h1>Group list</h1>
            <div class="horizontal-group">
              <a class="uui-button" href="#">Group</a>
              <a class="uui-button" href="#">Course</a>
              <a class="uui-button" href="#">Profile</a>
             </div>
          </div>
          <div class="td-group-wrapper">
            <div class="group-header-wrapper">
              <ul class="uui-item-list">
                <li class="item-body-header">
                  <h2 class="name-item">Group name:</h2>
                  <h2 class="region-item">Place:</h2>
                  <h2 class="course-item">Course:</h2>
                  <h2 class="lng-item">Ln:</h2>
                </li>
                <li class="item-body">
                  <a href="#">
                  <span class="group-name" title="Lolli">:dsdfsfadasdasdadadasdasdasdadasdasdadsdadsadadadasdasdasdadsd</span>
                  <span class="group-region" title="Lololol">dsdfsfadasdasdadadasdasdasdadasdasdadsdadsadadadasdasdasdadsd</span>
                  <span class="group-course" title="Lololol">dsdfsfadasdasdadadasdasdasdadasdasdadsdadsadadadasdasdasdadsd</span>
                  <span class="group-lng" title="Kffsdf">dsdfsfadasdasdadadasdasdasdadasdasdadsdadsadadadasdasdasdadsd  </span>
                </a>
                </li>

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
