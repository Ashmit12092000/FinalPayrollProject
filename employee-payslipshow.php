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
<!DOCTYPE html>
<html lang="en">
<title>Employee Data</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/font.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="vendor/venobox/venobox.css" rel="stylesheet">
  <link href="vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="css/style.css" rel="stylesheet">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
    
    table {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

    td,th {
  border: 1px solid #ddd;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
<body>

<!-- Sidebar/menu -->

<!-- Top menu on small screens -->
<header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center">

      <div class="logo mr-auto">
        <h1 class="text-light"><a href="index.html"><span>Payroll Management System</span></a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="images/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li><a href="home.php">Home</a></li>
          <li><a href="department.php">Department</a></li>
          <li class="active"><a href="employee.php">Employee</a></li>
          <li><a href="employee-payment.php">Payment Salary</a></li>
          <li><a href="employee-payslip.php">Payslip</a></li>
          <li><a href="employee-setsalary.php">Set salary</a></li>
          <li><a href="employee-payhistory.php">payment history</a></li>
          <li><a href="logout.php">Logout</a></li>
        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
  <div class="w3-main" style="margin-left:290px;margin-right:-10px;margin-top: 100px;margin-bottom: 0px">

  <!-- Header -->
   <div class="w3-container">
      <h4>Employee Data</h4>
       <table>
           <tr><th>Payment no</th>
               <th>Employee id</th>
               <th>Name</th>
               <th>Bank account no</th>
               <th>Total salary</th>
               
           <?php while($row=mysqli_fetch_array($result)) {?>
           <tr>
               <td><?php echo $row['pay_no']; ?></td>
               <td><?php echo $row['emp_id']; ?></td>
               <td><?php echo $row['name']; ?></td>
               <td><?php echo $row['accno']; ?></td>
               <td><?php echo $row['total_pay']; ?></td>
               </tr>
           <?php } ?>
       </table>
       
       
      </div>
      
          
  </div>




<script>
// Script to open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>

</body>
</html>
