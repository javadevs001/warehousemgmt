<%--
  Created by IntelliJ IDEA.
  User: Wéry Lionel
  Date: 13/09/2016
  Time: 15:15
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
                                <th>Date de création</th>
                                <th>Crée par</th>
                                <th>Dernière màj</th>
                                <th>Màj par</th>
                                <th>Client</th>
                                <th>Statut</th>
                                <th>Proirité</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                    <td>${customerOrder.createdDate}</td>
                                    <td>${customerOrder.createdBy}</td>
                                    <td>${customerOrder.lastModifiedDate}</td>
                                    <td>${customerOrder.lastModifiedBy}</td>
                                    <td>${customerOrder.person.companyName}</td>
                                    <td>${customerOrder.state}</td>
                                    <td>${customerOrder.priority}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
            </div>

            <div class="row">
                <div class="ui column grid stackable doubling centered container segment">

                    <div class="ui horizontal divider">
                        Les lignes de commande client
                    </div>
                    <div class="row">
                        <div class="column">
                            <table id="customerOrderDetailTable"
                                   class="ui blue table"
                                   cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>Article's'</th>
                                    <th>Quantitée</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="CustomerOrderDetail" items="${customerArticles}">
                                    <tr>
                                        <td><c:out value='${customerArticles.articleLabel}'/></td><%--c'est ici que je n'arrive pas à afficher--%>
                                        <td><c:out value='${customerArticles.quantity}'/></td><%--c'est ici que je n'arrive pas à afficher--%>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>