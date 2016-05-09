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

    <div class="left menu">
        <div class="item">
            <div class="ui fluid icon input" style="width: 500px;">
                <input id="searchUI" type="text" placeholder="Recherche rapide..." autofocus>
                <i class="search icon"></i>
            </div>
        </div>
    </div>

    <div class="right menu">
        <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                class="sign out link icon"></i></a>
    </div>

</div>

<div class="ui three column grid container centered stackable doubling">

    <div class="three wide column">

        <div class="ui segment">
            <div class="ui horizontal divider">
                Actions
            </div>
        </div>

    </div>


    <div class="ten wide column">

        <div class="ui segment">
            <div class="ui horizontal divider">
                Home
            </div>
        </div>

    </div>


    <div class="three wide column">

        <div class="ui segment">
            <div class="ui horizontal divider">
                Filtres
            </div>
        </div>

    </div>

</div>