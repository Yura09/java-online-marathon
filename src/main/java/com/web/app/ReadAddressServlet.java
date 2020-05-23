package com.web.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addresses/read")
public class ReadAddressServlet extends HttpServlet {
    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String address = addressBook.read(firstName, lastName);
        if (address == null) {
            //  response.setStatus(404);
            response.sendError(404, "Person with name '" + firstName + " " + lastName + "' not found");
        } else {
            request.setAttribute("first-name", firstName);
            request.setAttribute("last-name", lastName);
            request.setAttribute("address", address);
            request.getRequestDispatcher("/WEB-INF/read-address.jsp").forward(request, response);
        }
    }
}
