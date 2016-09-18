<%--
  Created by IntelliJ IDEA.
  User: Wéry Lionel
  Date: 25/08/2016
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/HomeController/getHomeView'/>" class="item" data-content="Accueil"><i
            class="home link icon"></i></a>
    <div class="right menu">
        <button class="ui button ">
            <a href="<c:url value="/VehicleController/getAddVehicleForm"/>"/>
            ADD Véhicule
        </button>

        <div class="right menu">
            <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                    class="sign out link icon"></i></a>
        </div>

    </div>
</div>



<table class="ui striped table">
    <div class="ui column grid doubling stackable container">

        <div class="row">
            <div class="ui segment container padded">
                <div class="ui horizontal divider">
                    Gestion des véhicules
                </div>
    <thead>
    <tr>
        <th>Identification</th>
        <th>Satut du camion</th>
        <th>Type de camion</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr>
            <td> ${vehicle.label} </td>
            <td> ${vehicle.vehicleState} </td>
            <td> ${vehicle.vehicleTypeLabel}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>