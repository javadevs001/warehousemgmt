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
                Liste des fournisseurs
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
                                    <input id="supplierSearch" type="text" placeholder="Recherche rapide ...">
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
                                    <a href="<c:url value="/SupplierController/getAddSupplierForm"/>"
                                       class="ui teal button fluid">Ajouter un nouveau fournisseur</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="column">
                    <table id="supplierTable"
                           class="ui teal table"
                           cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>personId</th>
                            <th>companyName</th>
                            <th>email</th>
                            <th>phone</th>
                            <th>fax</th>
                            <th>addressCity</th>
                            <th>addressPostCode</th>
                            <th>addressStreet</th>
                            <th>addressNumber</th>
                            <th>addressBox</th>
                            <th>tva</th>
                            <th>personType</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="supplierBean" items="${supplierBeen}">
                            <tr>
                                <td>${supplierBean.personId }</td>
                                <td>${supplierBean.companyName}</td>
                                <td>${supplierBean.email}</td>
                                <td>${supplierBean.phone}</td>
                                <td>${supplierBean.fax}</td>
                                <td>${supplierBean.addressCity}</td>
                                <td>${supplierBean.addressPostCode}</td>
                                <td>${supplierBean.addressStreet}</td>
                                <td>${supplierBean.addressNumber}</td>
                                <td>${supplierBean.addressBox}</td>
                                <td>${supplierBean.tva}</td>
                                <td><s:message code="person.${supplierBean.personType}.label"/></td>
                                <td style="text-align: center;">
                                    <div class="ui small basic icon buttons">

                                        <a data-content="Détails"
                                           href="<c:url value="/SupplierController/getSupplierDetail?personId=${supplierBean.personId}"/>"
                                           class="ui button"><i class="eye icon"></i></a>

                                        <a data-content="Supprimer"
                                           href="<c:url value="/SupplierController/deleteSupplier?personId=${supplierBean.personId}"/>"
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
