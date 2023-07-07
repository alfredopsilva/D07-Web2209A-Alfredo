<%@ page import="java.util.ArrayList" %>
<%@ page import="com.vehicles.models.Brand" %>
<%@ page import="com.vehicles.models.Vehicle" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    ArrayList<Brand> brands = (ArrayList<Brand>) request.getAttribute("brands");
    ArrayList<Vehicle> vehiclesList = (ArrayList<Vehicle>) session.getAttribute("vehiclesList");
    String showAllVehiclesStatus = (String) session.getAttribute("showAllVehiclesStatus");
%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Brands</title>
</head>
<body>
    <table>
        <%if(vehiclesList != null && showAllVehiclesStatus.equals("true")){%>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Year</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            <%for(Vehicle vehicle : vehiclesList){%>
            <tr>
                <td><%=vehicle.getId()%></td>
                <td><%=vehicle.getModel()%></td>
                <td><%=vehicle.getYear()%></td>
                <td><%=vehicle.getPrice()%></td>
            </tr>
            </tbody>
            <%}%>
        <%}%>
        <%if(vehiclesList != null && showAllVehiclesStatus.equals("false")){%>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Year</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <%for(Vehicle vehicle : vehiclesList){%>
        <tr>
            <td><%=vehicle.getId()%></td>
            <td><%=vehicle.getModel()%></td>
            <td><%=vehicle.getYear()%></td>
            <td><%=vehicle.getPrice()%></td>
        </tr>
        </tbody>
        <%}%>
        <%}%>
        <%if(vehiclesList == null){%>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
            </thead>
            <tbody>
                <%for(Brand brand : brands){%>
                    <tr>
                        <td><%=brand.getId()%></td>
                        <td><a href="vehicles?brandId=<%=brand.getId()%>"><%=brand.getName()%></a></td>
                    </tr>
                <%}%>
            </tbody>
        <%}%>
    </table>
    <a href="vehicles?typeOfList=<%=%>"><%=showAllVehiclesStatus.equals("false") ? "View all vehicles" : "View brands"%></a>
</body>
</html>