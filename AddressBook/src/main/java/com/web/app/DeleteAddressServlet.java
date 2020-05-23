package com.web.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addresses/delete")
public class DeleteAddressServlet extends HttpServlet {
    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        addressBook.delete(firstName, lastName);
        response.sendRedirect("/addresses/list");
    }
}
