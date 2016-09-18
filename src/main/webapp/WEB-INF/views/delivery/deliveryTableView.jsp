
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/HomeController/getHomeView'/>" class="item" data-content="Accueil"><i
            class="home link icon"></i></a>
    <div class="right menu">
        <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                class="sign out link icon"></i></a>
    </div>
</div>

<div class="ui horizontal divider hidden"></div>

<div class="ui column grid doubling stackable container">

    <div class="row">
        <div class="ui column grid stackable doubling centered container segment">

            <div class="ui horizontal divider">
                <i class="icon table link"></i>Les livraisons
            </div>

            <div class="row">
                <div class="column">
                    <div class="ui stackable center aligned doubling two column very relaxed grid container">
                        <div class="column">
                            <div class="ui horizontal divider">
                                Recherche
                            </div>
                            <div class="ui">
                                <div class="ui fluid icon input">
                                    <input id="deliverySearch" type="text" placeholder="Recherche rapide ...">
                                    <i class="search icon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="ui vertical divider">
                            Ou
                        </div>
                        <div class="column">
                            <div class="ui horizontal divider">
                                Actions
                            </div>
                            <div class="ui items" style="padding-left: 40px;padding-right: 40px;">
                                <div class="ui item">
                                    <a href="<c:url value="/DeliveryController/getDeliveryForm"/>"
                                       class="ui yellow button fluid"><i class="icon plus link"></i>Ajouter une nouvelle
                                        livraison</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="column">
                    <table id="deliveryTable"
                           class="ui yellow table"
                           cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Identification</th>
                            <th>Camion</th>
                            <th>Etat de livraison</th>
                            <th>Satut du camion</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${deliveries}" var="delivery">
                            <tr>
                                <td> ${delivery.deliveryId} </td>
                                <td> ${delivery.vehicleLabel} </td>
                                <td><s:message code="delivery.${delivery.deliveryState}.label"/></td>
                                <td><s:message code="vehicle.${delivery.vehicleState}.label"/></td>

                                <td style="text-align: center;">
                                    <div class="ui small basic icon buttons">

                                        <a data-content="Modifier"
                                           href="<c:url value="/DeliveryController/getDeliveryForm?deliveryId=${delivery.deliveryId}"/>"
                                           class="ui button"><i class="edit icon"></i></a>

                                        <a data-content="Supprimer"
                                           href="<c:url value="/DeliveryController/deleteDelivery?deliveryId=${delivery.deliveryId}"/>"
                                           class="ui button"><i class="trash icon"></i></a>

                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>