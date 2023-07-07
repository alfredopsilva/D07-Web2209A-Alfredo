package com.vehicles.controllers;

import com.vehicles.models.Brand;
import com.vehicles.models.Vehicle;
import com.vehicles.repositories.BrandRepository;
import com.vehicles.repositories.VehicleRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "VehicleController", urlPatterns = {"","/vehicles"})
public class VehicleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BrandRepository brandRepository = new BrandRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        HttpSession session = request.getSession(true);

        String typeOfList = (String) request.getParameter("typeOfList");
        String brandId = (String)request.getParameter("brandId");
        String showAllVehicles = (String) request.getParameter("getAllVehicles");

        if(showAllVehicles == null)
        {
            showAllVehicles = "false";
        }
        session.setAttribute("showAllVehiclesStatus", showAllVehicles);

        try
        {
            ArrayList<Brand> brands = brandRepository.getBrands();
            request.setAttribute("brands",brands);

            if(brandId != null)
            {
                int brand = Integer.parseInt(brandId);
                showAllVehicles = "false";
                session.setAttribute("vehiclesList",vehicleRepository.getVehiclesByBrand(brand));
                session.setAttribute("vehiclesList",null);
            }

            if(showAllVehicles != null && showAllVehicles.equals("true"))
            {
                brandId = null;
                session.setAttribute("vehiclesList",vehicleRepository.getVehicles());
            }

            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);

        }
        catch (ClassNotFoundException | SQLException e )
        {
            throw new ServletException(e);
        }
        catch (NumberFormatException e)
        {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }
}
