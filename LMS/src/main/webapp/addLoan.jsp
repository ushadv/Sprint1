<!DOCTYPE html>
<html>
<head>
    <title>Add Loan</title>
</head>
<body>
    <h2>Add New Loan</h2>
    <form action="AddLoanServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Amount: <input type="number" name="amount" required><br>
        Duration (months): <input type="number" name="duration" required><br>
        <input type="submit" value="Add Loan">
    </form>
</body>
</html>
