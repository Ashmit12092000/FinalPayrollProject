<?php
include('config.php');

   $month=$_POST['month'];
   $year=$_POST['year'];
   if($month)
   {
       $sql="SELECT pay_no,emp_id,name,accno,total_pay FROM `payment` WHERE month='$month' AND year='$year';";
       $result=mysqli_query($con,$sql);

   }
?>