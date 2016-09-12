<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/SupplierOrderController/getSupplierOrdersTable'/>" class="item"
       data-content="Listes des commandes"><i
            class="arrow left link icon"></i></a>
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
                <i class="icon table link"></i>Historique des synchronisations.
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
                                    <input id="supplierOrderSynchroSearch" type="text"
                                           placeholder="Recherche rapide ...">
                                    <i class="search icon"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="column">
                    <table id="supplierOrdersSynchroTable"
                           class="ui teal table"
                           cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Date de la synchronisation</th>
                            <th>Référence de la commande</th>
                            <th>Référence de la ligne de commande</th>
                            <th>Fusionné ?</th>
                            <th>Nouvelle Quantité</th>
                            <th>Ancienne quantité</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="supplierOrderBean" items="${supplierOrderSynchroBeanList}">
                            <tr>
                                <td>${supplierOrderBean.synchroDateTime}</td>
                                <td>${supplierOrderBean.ordersId}</td>
                                <td>${supplierOrderBean.orderDetailId}</td>
                                <td>${supplierOrderBean.merged ? 'Oui' : 'Non'}</td>
                                <td>${supplierOrderBean.supplierCompanyName}</td>
                                <td>${supplierOrderBean.quantity}</td>
                                <td>${supplierOrderBean.oldQuantity}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
