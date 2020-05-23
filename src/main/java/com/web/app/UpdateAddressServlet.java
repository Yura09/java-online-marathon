package com.web.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addresses/update")
public class UpdateAddressServlet extends HttpServlet {
    private AddressBook addressBook;
    private String firstName;
    private String lastName;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        addressBook.update(firstName, lastName, request.getParameter("address"));
        response.sendRedirect("/addresses/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        firstName = request.getParameter("first-name");
        lastName = request.getParameter("last-name");
        String address = addressBook.read(firstName, lastName);
        if (address == null) {
            response.sendError(404, "Person with name '" + firstName + " " + lastName + "' not found");
        } else {
            request.setAttribute("first-name", firstName);
            request.setAttribute("last-name", lastName);
            request.setAttribute("address", address);
            request.getRequestDispatcher("/WEB-INF/update-address.jsp").forward(request, response);
        }
    }
}
