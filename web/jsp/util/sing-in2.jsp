<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" href="../css/sing-in.css">
</head>
<body>

  <section class="container">
    <div class="login">
      <h1>Войти в личный кабинет</h1>
      <form method="post" action="index.html">
        <p><input type="text" name="login" value="" placeholder="Логин" pattern="([\w]{3,16})"
                  placeholder="Вевиде от 3 до 16 символов!"></p>
        <p><input type="password" name="password" value="" placeholder="Пароль" pattern="([\w]{8,16})"
                  placeholder="Вевиде от 3 до 16 символов!"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Запомнить меня
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Войти"></p>
      </form>
    </div>
  </section>
</body>
</html>
