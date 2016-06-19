<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/home/view'/>" class="item" data-content="Accueil"><i class="home link icon large"></i></a>
    <div class="right menu">
        <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                class="sign out link icon"></i></a>
    </div>
</div>

<div class="ui centered" style="margin-top: 64px;padding: 10px;margin-left:50px;margin-right:50px;">

    <div class="row">
        <div class="two wide column">

            <div class="ui raised segment one column grid" style="padding: 20px;">

                <div class="segment column">
                    <div class="ui grid two column">
                        <div class="ui column">
                            <div class="ui icon input">
                                <input id="demandSearchIpt" type="text" placeholder="Recherche...">
                                <i class="search icon"></i>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="ui column">
                    <table id="demandsTable"
                           class="ui compact selectable striped celled table raised segment table-striped table-bordered"
                           cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Etat</th>
                            <th>Date de création</th>
                            <th>Date de Màj</th>
                            <th>Créer par</th>
                            <th>Fournisseur</th>
                            <th>Priorité</th>
                            <th>Type</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="supplierOrderBean" items="${supplierOrderBeen}">
                            <tr>
                                <td>${supplierOrderBean.state}</td>
                                <td>${supplierOrderBean.createdDate}</td>
                                <td>${supplierOrderBean.updatedDate}</td>
                                <td>${supplierOrderBean.createdBy}</td>
                                <td>${supplierOrderBean.personFullName}</td>
                                <td>${supplierOrderBean.priority}</td>
                                <td>${supplierOrderBean.type}</td>
                                <td style="text-align: center;">
                                    <div class="ui basic buttons">
                                        <div class="ui button">Action</div>
                                        <div class="ui combo top right pointing dropdown icon button">
                                            <i class="dropdown icon"></i>
                                            <div class="menu">
                                                <a href="#"
                                                   class="item"><i
                                                        class="edit icon"></i> Modifier</a>
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