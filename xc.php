
<html lang="en">
    <head>
        <!--Required meta tags-->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--Bootstrap CSS-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title img src="bank.jfif" alt="bank logo" width="10" height="8">
            Genuine Bank
        </title>
        <style>
	.container {
    display: flex;
    padding-top: 200;
    padding-left: 200;

}
        </style>
    </head>

    <body>
        <!--Image and Text-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="bank.jfif" alt="bank logo" width="37" height="30" class="d-inline-block align-top">
                    GENUINE BANK
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle Navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">
                                Home
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="history.php">
                                Transaction History
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    
         <div class="container">
            <div class="card" style="width:18rem;">
            <img src="customers.png" class="card-img-top" alt="Customers">
            <div class="card-body">
                <a href="usertable.php" class="btn btn-primary">
                    View All Customers
                </a>
            </div>
        </div>

        <div class="card" style="width:18rem;">
            <img src="transact.png" class="card-img-top" alt="Transfer Money">
            <div class="card-body">
                <a href="transact.php" class="btn btn-primary">
                    Transfer Money
                </a>
            </div>
        </div>

        <div class="card" style="width:18rem;">
            <img src="history.png" class="card-img-top" alt="Transaction History">
            <div class="card-body">
                <a href="history.php" class="btn btn-primary">
                    Transaction History
                </a>
            </div>
        
    
</div>
</div>
        <footer class="footer">
            &copy; All Rights Reserved by Genuine Bank
        </footer>
    </body>
</html>