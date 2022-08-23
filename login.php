<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Login</title>
    <link rel="stylesheet" href="st.css"/>
</head>
<body>
<?php
    require('config.php');
    session_start();

    // When form submitted, check and create user session.
    if (isset($_POST['username'])) {
        $username = stripslashes($_REQUEST['username']);    // removes backslashes
        $username = mysqli_real_escape_string($con, $username);
        $password = stripslashes($_REQUEST['password']);
        $password = mysqli_real_escape_string($con, $password);
        // Check user is exist in the database
        $query    = "SELECT * FROM `users` WHERE username='$username'
                     AND password='$password';
        $result = mysqli_query($con, $query) or die(mysql_error());
        $rows = mysqli_num_rows($result);
        if ($rows == 1) {
            $_SESSION['username'] = $username;
            // Redirect to user Receptionist.dashboard page
            header("Location: main.php");
        } else {
            echo "<div class='form'>
                  <h3>Incorrect Username/password.</h3><br/>
                  <p class='link'>Click here to <a href='login.php'>Login</a> again.</p>
                  </div>";
        }
    } else {
?>
    <form method="post" name="login">
            <div id="form_wrapper">
                <div id="form_left">
                    <img src="images/icon.png" alt="computer icon">
                </div>
                <div id="form_right">
                    <h1>Member Login</h1>
                    <div class="input_container">
                        <i class="fas fa-envelope"></i>
                        <input placeholder="Username" type="text" name="username" id="field_email" class='input_field'>
                    </div>
                    <div class="input_container">
                        <i class="fas fa-lock"></i>
                        <input  placeholder="Password" type="password" name="password" id="field_password" class='input_field'>
                    </div>
                    <input type="submit" name="submit" value="Login" id='input_submit' class='input_field'>
                    <span id='create_account'>
                        <a href="register.php">Create your account ➡ </a>
                    </span>
                </div>
            </div>
    </form>
<?php
    }
?>
</body>
</html>