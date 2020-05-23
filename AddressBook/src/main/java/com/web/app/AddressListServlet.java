package com.web.app;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addresses/list")
public class AddressListServlet extends HttpServlet {
    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/address-list.jsp");
        String sortBy = request.getParameter("sort");
        if (sortBy != null) {

            addressBook.sortedBy(SortOrder.valueOf(sortBy.toUpperCase()));
        }
        request.setAttribute("addresses", addressBook);
        requestDispatcher.forward(request, response);
    }
}
