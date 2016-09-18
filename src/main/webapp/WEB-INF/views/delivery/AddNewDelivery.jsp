<%--
  Created by IntelliJ IDEA.
  User: Wéry Lionel
  Date: 18/09/2016
  Time: 16:45
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

        <div class="right menu">
            <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                    class="sign out link icon"></i></a>
        </div>

    </div>
</div>

<div class="ui horizontal divider hidden"></div>



<div class="row">
    <div class="ui column grid doubling stackable container">
        <div class="ui segment container padded">
            <div class="ui horizontal divider">
                Commande client
            </div>
            <div class="row">
                <div class="column">

                    <table class="ui striped table">
                        <thead>
                        <tr>
                            <th>Numéro de commande</th>
                            <th>Client</th>
                            <th>Proirité</th>
                            <th>Type de palette</th>
                            <th>Nombre de palette</th>
                            <th>Camion</th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${customerOrder.ordersId}</td>
                            <td>${customerOrder.person.companyName}</td>
                            <td>${customerOrder.priority}</td>
                            <td style="text-align: center;">
                                <div class="ui basic buttons">
                                    <div class="ui button">Action</div>
                                    <div class="ui combo top right pointing dropdown icon button">
                                        <i class="dropdown icon"></i>
                                        <div class="menu">
                                            <a href="#" class="item"><i class="edit icon"></i>Attribuer un type de palette</a>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td>

                            </td>
                            <label class="label">Camion</label>
                            <div class="ui selection dropdown">
                                <form:input type="hidden" path="vehicle"/>
                                <i class="dropdown icon"></i>
                                <div class="default text">Article</div>
                                <div class="menu">
                                    <div class="menu">
                                        <a href="#" class="item"><i class="edit icon"></i>Attribuer un camion</a>
                                    </div>
                                    <c:forEach items="${vehicles}" var="vehicle">
                                        <div class="item" data-value="${vehicle.vehicleId}">
                                                ${vehicle.label}
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>