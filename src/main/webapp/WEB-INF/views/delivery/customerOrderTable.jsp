<%--
  Created by IntelliJ IDEA.
  User: Wéry Lionel
  Date: 13/09/2016
  Time: 10:58
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

<div class="row">
    <div class="column">
        <table class="ui striped table">
            <thead>
            <tr>
                <th>Date de création</th>
                <th>Crée par</th>
                <th>Dernière màj</th>
                <th>Màj par</th>
                <th>Client</th>
                <th>Statut</th>
                <th>Proirité</th>
                <th>Détail</th>
                <th>Créer Liaison</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customerOrderBean" items="${customerOrderBeen}">
                <tr>
                    <td>${customerOrderBean.createdDate}</td>
                    <td>${customerOrderBean.createdBy}</td>
                    <td>${customerOrderBean.lastModifiedDate}</td>
                    <td>${customerOrderBean.lastModifiedBy}</td>
                    <td>${customerOrderBean.customerCompanyName}</td>
                    <td>${customerOrderBean.state}</td>
                    <td>${customerOrderBean.priority}</td>
                    <td style="text-align: center;">
                        <div class="right menu">
                            <button class="ui button ">
                                   <a href="<c:url value="/CustomerOrderController/getCustomerOrderDetail?customerOrderId=${customerOrderBean.ordersId}"/>"
                                   class="item"><i class="eye icon"></i>Plus d'infos</a>
                            </button>
                            </div>
                    </td>

                    <td style="text-align: center;">
                        <div class="right menu">
                            <button class="ui button ">
                                <a href="<c:url value="/CustomerOrderController/getAddNewDelivery?customerOrderId=${customerOrderBean.ordersId}"/>"
                                   class="item"><i class="add icon"></i>Créer Livraison</a>
                            </button>
                        </div>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
