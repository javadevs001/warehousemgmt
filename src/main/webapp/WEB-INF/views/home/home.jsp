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
                Home
            </div>
            <div class="ui three column grid container stackable doubling centered">
                <div class="row">
                    <div class="column">
                        <div class="ui card">
                            <div class="content">
                                <div class="header">
                                    <i class="icon file text link"></i>
                                    Gestion Fournisseurs
                                </div>
                                <div class="description">
                                    Consulter le Tableau et Ajouter/Modifier les commandes fournisseurs.
                                </div>
                            </div>
                            <div class="ui bottom attached button blue">
                                <i class="eye icon"></i>
                                Voir
                            </div>
                        </div>
                    </div>
                    <div class="column">

                    </div>
                    <div class="column">

                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="one wide column">
    </div>

</div>