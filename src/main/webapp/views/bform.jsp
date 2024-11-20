
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Balance Form</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        h1 .fas {
            margin-right: 10px;
        }
        h1 {
            color: #2c3e50;
            margin-top: 20px;
        }
        h3 {
            color: #34495e;
            margin-bottom: 20px;
        }
        .navbar {
            background-color: #2980b9;
            padding: 10px 0;
            text-align: center;
        }
        .navbar a {
            color: #ecf0f1;
            text-decoration: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        .navbar a:hover {
            background-color: #3498db;
        }
    </style>
</head>
<body>
    <h1><i class="fas fa-university"></i></h1>
    <h1>SDFC BANK</h1>
    <h3>EXTRAORDINARY SERVICES</h3>
    <div class="navbar">
        <a href="/">Home</a>
        <a href="/newAc">New Account</a>
        <a href="/balance">Balance</a>
        <a href="/dp">Deposit</a>
        <a href="/wdw">Withdraw</a>
        <a href="/tf">Transfer</a>
        <a href="/closeAc">Close A/C</a>
        <a href="/ab">About Us</a>
    </div>
    <h1>BALANCE FORM</h1>
    <form action="/viewBalance" method="post">
        Account Number:<input type="number" name="acNo" required><p></p>
        Name:<input type="text" name="name" required><p></p>
        Password:<input type="password" name="psw" required><p></p>
        <input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="Clear">
    </form>
</body>
</html>
