
  <section class="container">
    <div class="login">
      <h1>Регистрация</h1>
      <form method="post" action="index.html">
        <p><input type="text" name="login" value="" placeholder="Логин" pattern="([\w]{8,16})"
                  placeholder="Вевиде от 3 до 16 символов!"></p>
        <p><input type="password" name="password" value="" placeholder="Пароль" pattern="([\w]{8,16})"
                  placeholder="Вевиде от 3 до 16 символов!"></p>
				<p><input type="text" name="email" value="" placeholder="Email" pattern="(\w+@[a-zA-Z_]+?\.[ru|com|ua|by|org]{2,6})"
                          placeholder="Вевиде Email вида ****@***.(ru|com|ua|by|org)"></p>
        <p class="submit"><input type="submit" name="commit" value="Зарегистрироваться"></p>
      </form>
    </div>
  </section>

