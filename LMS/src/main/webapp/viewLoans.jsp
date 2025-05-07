package com.loan;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ViewLoansServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get list of all loans from backend
        List<Loan> loanList = AllOperations.getAllLoans();  // You should have this method

        // Set the list in request scope
        request.setAttribute("loans", loanList);

        // Forward to viewLoans.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewLoans.jsp");
        dispatcher.forward(request, response);
    }
    
    <%@ page import="java.util.List" %>
<%@ page import="com.loan.Loan" %>

<html>
<head>
    <title>Loan Records</title>
</head>
<body>
    <h2>All Loans</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Amount</th>
            <th>Duration</th>
        </tr>

        <%
            List<Loan> loans = (List<Loan>) request.getAttribute("loans");
            if (loans != null) {
                for (Loan l : loans) {
        %>
        <tr>
            <td><%= l.getId() %></td>
            <td><%= l.getName() %></td>
            <td><%= l.getAmount() %></td>
            <td><%= l.getDuration() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="4">No loans found.</td></tr>
        <% } %>
    </table>
</body>
</html>
    
}
