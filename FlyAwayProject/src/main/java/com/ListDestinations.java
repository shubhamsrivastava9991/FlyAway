package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinationsDao;
import model.Destinations;

/**
 * Servlet implementation class ListDestinations
 */
//@WebServlet("/ListDestinations")
public class ListDestinations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DestinationsDao destinationsDao;
	
	public void init() {
		destinationsDao = new DestinationsDao();
	}      
    public ListDestinations() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List < Destinations > listDestinations = destinationsDao.getAllDestintions();
        request.setAttribute("listDestinations", listDestinations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("destinationlist.jsp");
        dispatcher.forward(request, response);
	}
}