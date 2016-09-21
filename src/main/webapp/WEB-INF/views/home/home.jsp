<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="menu" class="ui stackable small menu">

    <div class="item">
        <img src="${ctx}/resources/image/logo/logo.png">
    </div>


    <div class="right menu">
        <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                class="sign out link icon"></i></a>
    </div>

</div>

<div class="ui three column grid container centered stackable doubling">

    <div class="one wide column">
    </div>


    <div class="fourteen wide column">
        <div class="ui segment">
            <div class="ui horizontal divider">
                Accueil
            </div>
            <div class="ui hidden divider horizontal"></div>
            <div class="ui three column grid container stackable doubling centered">
                    <div class="column">
                        <div class="ui card">
                            <div class="content">
                                <div class="header">
                                    <i class="icon file text link"></i>
                                    Gestion des commandes Fournisseur
                                </div>
                                <div class="description">
                                    Consulter, ajouter et modifier les commandes fournisseur.
                                </div>
                            </div>
                            <a href="<c:url value="/SupplierOrderController/getSupplierOrdersTable"/>"
                               class="ui bottom attached button blue">
                                <i class="eye icon"></i>
                                Consulter
                            </a>
                        </div>
                    </div>
            </div>
            <div class="ui hidden divider horizontal"></div>
        </div>
    </div>


    <div class="one wide column">
    </div>

</div>