<?php
 session_start();
 require('config.php');
 if(isset($_POST['username']) and isset($_POST['password'])){
     $username=$_POST['username'];
     $password=$_POST['password'];
     
     $query="SELECT * FROM users WHERE username='$username' and password='$password'";
     
     $result=mysqli_query($con,$query) or die(mysqli_error($con));
     
     $count=mysqli_num_rows($result);
     
     if($count==1)
     {
         $_SESSION['username']=$username;
         echo"You have logged in successfully";
         
         header("location: home.php");
     }
     else{
         $fmsg="Invalid username or password";
         echo"<br>Invalid username or password";
     } 
 }
?>