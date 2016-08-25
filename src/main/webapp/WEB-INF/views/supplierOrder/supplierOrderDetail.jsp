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
        <div class="ui segment container padded">

            <div class="ui small basic icon buttons">
                <a data-content="Vérification"
                   class="ui button checkSupplierOrderSelector"><i class="check icon"></i></a>
            </div>

            <div class="ui horizontal divider">
                <i class="icon info"></i>Détails de la commande fournisseur N° ${supplierOrder.ordersId}
            </div>

            <div class="ui three column grid centered stackable doubling container">


                <div class="twelve wide tablet eight wide computer column">
                    <table class="ui definition table teal">
                        <tbody>
                        <tr>
                            <td>Créer le</td>
                            <td><c:out value="${supplierOrder.createdDate}"/></td>
                        </tr>
                        <tr>
                            <td>Créer par</td>
                            <td>
                                <c:out value="${supplierOrder.createdBy}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Fournisseur</td>
                            <td>
                                <c:out value="${supplierOrder.supplierCompanyName}"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div class="twelve wide tablet eight wide computer column">
                    <table class="ui definition table teal">
                        <tbody>
                        <tr>
                            <td>Etat</td>
                            <td><s:message code="orders.state.${supplierOrder.state}.label"/></td>
                        </tr>
                        <tr>
                            <td>Priorité</td>
                            <td>
                                <s:message code="orders.priority.${supplierOrder.priority}.label"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>
    </div>


    <div class="row">
        <div class="ui column grid stackable doubling centered container segment">

            <div class="ui horizontal divider">
                <i class="icon table link"></i>Les lignes de la commande
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
                                    <input id="supplierOrderDetailTableSearch" type="text"
                                           placeholder="Recherche rapide ...">
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
                                    <a href="<c:url value="/SupplierOrderController/getSupplierOrderDetailForm?supplierOrdersId=${supplierOrder.ordersId}"/>"
                                       class="ui blue button fluid"><i class="icon plus link"></i>Ajouter une ligne de
                                        commande</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="column">
                    <table id="supplierOrderDetailTable"
                           class="ui blue table"
                           cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Date de création</th>
                            <th>Crée par</th>
                            <th>Date de mise à jour</th>
                            <th>Màj par</th>
                            <th>Article</th>
                            <th>Quantité</th>
                            <th>État</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="supplierOrderDetail" items="${supplierOrderDetails}">
                            <tr>
                                <td><c:out value='${supplierOrderDetail.createdDate}'/></td>
                                <td><c:out value='${supplierOrderDetail.createdBy}'/></td>
                                <td><c:out value='${supplierOrderDetail.updatedDate}'/></td>
                                <td><c:out value='${supplierOrderDetail.updatedBy}'/></td>
                                <td><c:out value='${supplierOrderDetail.articleLabel}'/></td>
                                <td><c:out value='${supplierOrderDetail.quantity}'/></td>
                                <td><s:message code="ordersDetail.state.${supplierOrderDetail.state}.label"/></td>
                                <td style="text-align: center;">
                                    <div class="ui small basic icon buttons">

                                        <a data-content="Modifier"
                                           href="<c:url value="/SupplierOrderController/getSupplierOrderDetailForm?supplierOrdersId=${supplierOrderDetail.supplierOrderId}&supplierOrderDetailId=${supplierOrderDetail.supplierOrderDetailId}"/>"
                                           class="ui button ${supplierOrderDetail.state == 'DELIVERED' ? 'disabled' : ''}"><i
                                                class="edit icon"></i></a>

                                        <a data-content="Supprimer"
                                           data-orderdetailid="${supplierOrderDetail.supplierOrderDetailId}"
                                           class="ui button deleteOrderDetailModalSelector"><i
                                                class="trash icon"></i></a>

                                        <a data-content="Vérification"
                                           href="<c:url value="/SupplierOrderController/getSupplierOrderDetailCheckForm?orderDetailId=${supplierOrderDetail.supplierOrderDetailId}"/>"
                                           class="ui button"><i
                                                class="check icon"></i></a>
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


<div id="deleteOrderDetailModal" class="ui basic modal">
    <i class="close icon"></i>
    <div class="header">
        Supprimer une ligne de commande
    </div>
    <div class="image content">
        <div class="image">
            <i class="checkmark icon"></i>
        </div>
        <div class="description">
            <p>Êtes-vous sûr de vouloir supprimer ce détail de commande?</p>
        </div>
    </div>
    <div class="actions">
        <div class="two fluid ui inverted buttons">
            <div class="ui red basic cancel inverted button">
                <i class="remove icon"></i>
                Non
            </div>
            <div class="ui green basic ok inverted button">
                <i class="checkmark icon"></i>
                Oui
            </div>
        </div>
    </div>
</div>

<div id="checkOrderModal" class="ui basic modal">
    <i class="close icon"></i>
    <div class="header">
        Vérification de la commande
    </div>
    <div class="image content">
        <div class="image">
            <i class="checkmark icon"></i>
        </div>
        <div class="description">
            <form:form id="checkSupplierOrder" action="checkSupplierOrder" method="post"
                       commandName="checkSupplierOrderBean" class="ui form">
                <form:hidden path="ordersId"/>
                <div class="field">
                    <label class="label" style="color:white;">Statut *</label>
                    <form:select path="state" class="ui dropdown fluid" id="select">
                        <form:option value="DELIVERED">Livré</form:option>
                        <form:option value="PARTIALLY_DELIVERED">Livré partiellement</form:option>
                    </form:select>
                </div>

            </form:form>
        </div>
    </div>
    <div class="actions">
        <div class="two fluid ui inverted buttons">
            <div class="ui red basic cancel inverted button">
                <i class="remove icon"></i>
                Non
            </div>
            <div class="ui green basic ok inverted button">
                <i class="checkmark icon"></i>
                Oui
            </div>
        </div>
    </div>
</div>



