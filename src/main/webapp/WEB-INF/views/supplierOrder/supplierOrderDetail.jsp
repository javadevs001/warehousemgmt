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
        <div class="ui segment container padded">
            <div class="ui horizontal divider">
                Commande fournisseur
            </div>

            <div class="ui three column grid centered stackable doubling container">

                <div class="column">
                    <div class="ui segment padded center aligned">
                        <div class="ui top attached blue label">Créer le</div>
                        <div class="ui items content">
                            <div class="item">
                                <div class="content">
                                    <div class="header">
                                        <c:out value="${supplierOrder.createdDate}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="column">
                    <div class="ui segment padded center aligned">
                        <div class="ui top attached blue label">Créer par</div>
                        <div class="ui items content">
                            <div class="item">
                                <div class="content">
                                    <div class="header">
                                        <c:out value="${supplierOrder.createdBy}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="column">
                    <div class="ui segment padded center aligned">
                        <div class="ui top attached blue label">Fournisseur</div>
                        <div class="ui items content">
                            <div class="item">
                                <div class="content">
                                    <div class="header">
                                        <c:out value="${supplierOrder.person.companyName}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="column">
                    <div class="ui segment padded center aligned">
                        <div class="ui top attached blue label">Etat</div>
                        <div class="ui items content">
                            <div class="item">
                                <div class="content">
                                    <div class="header">
                                        <c:out value="${supplierOrder.state}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="column">
                    <div class="ui segment padded center aligned">
                        <div class="ui top attached blue label">Priorité</div>
                        <div class="ui items content">
                            <div class="item">
                                <div class="content">
                                    <div class="header">
                                        <c:out value="${supplierOrder.priority}"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>


    <div class="row">
        <div class="ui column grid stackable doubling centered container segment">

            <div class="ui horizontal divider">
                Les lignes de commande fournisseur
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
                                       class="ui blue button fluid">Ajouter une ligne de commande</a>
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
                            <th>Quantity</th>
                            <th>Status</th>
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
                                <td><c:out value='${supplierOrderDetail.state}'/></td>
                                <td style="text-align: center;">
                                    <div class="ui basic buttons">
                                        <div class="ui button">Action</div>
                                        <div class="ui combo top right pointing dropdown icon button">
                                            <i class="dropdown icon"></i>
                                            <div class="menu">
                                                <a href=""
                                                   class="item"><i
                                                        class="edit icon"></i>Modifier</a>
                                                <a data-orderdetailid="${supplierOrderDetail.supplierOrderDetailId}"
                                                   id="changeState" href=""
                                                   class="item"><i
                                                        class="edit icon"></i>Status</a>
                                            </div>
                                        </div>
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


<div id="changeStateModal" class="ui modal">
    <i class="close icon"></i>
    <form:form action="changeOrderDetailState" method="post" commandName="orderDetailStatusBean">
        <div class="header">
            Changer le status du détail commande
        </div>
        <div class="content">
            <div class="description">
                <form:hidden path="orderDetailIdModal"/>
                <form:input path="orderDetailState"/>
            </div>
        </div>
        <div class="actions">
            <div class="ui button">Cancel</div>
            <button type="submit" class="ui button">OK</button>
        </div>
    </form:form>
</div>






