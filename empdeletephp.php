<?php
       include('config.php');
       $sql="SELECT * FROM department;";
       $result=mysqli_query($con,$sql);     
   
        $sql="DELETE FROM `employee` WHERE Employee_id='$empid';";

        if($con->query($sql)===TRUE)
        {
            echo "successfully inserted into database";
        }
        else{
            echo "somthing is wrong";
        }
?>