<?php
  include('config.php');
   
if (isset($_GET['del'])) {
	$id = $_GET['del'];
    $sqll="DELETE FROM department WHERE Depart_id=$id;";
	$check=mysqli_query($con, $sqll);
	if($check)
    {echo"Done dana Done";
    header('location: department.php');
    }
    else{
        echo"Failed";
    }
    
	
}

  


?>