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
                Liste des articles
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
                                    <input id="articleSearch" type="text" placeholder="Recherche rapide ...">
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
                                    <a href="<c:url value="/ArticleController/getAddArticleForm"/>"
                                       class="ui teal button fluid">Ajouter un nouvel article</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="column">
                    <table id="articleTable"
                           class="ui teal table"
                           cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>articleId</th>
                            <th>label</th>
                            <th>description</th>
                            <th>buyingUnitPrice</th>
                            <th>sellingUnitPrice</th>
                            <th>packageQuantity</th>
                            <th>threshold</th>
                            <th>quantity</th>
                            <th>depth</th>
                            <th>width</th>
                            <th>height</th>
                            <th>volume</th>
                            <th>weight</th>
                            <th>person</th>
                            <th>box</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="articleBean" items="${articleBeen}">
                            <tr>
                                <td>${articleBean.articleId}</td>
                                <td>${articleBean.label}</td>
                                <td>${articleBean.description}</td>
                                <td>${articleBean.buyingUnitPrice}</td>
                                <td>${articleBean.sellingUnitPrice}</td>
                                <td>${articleBean.packageQuantity}</td>
                                <td>${articleBean.threshold}</td>
                                <td>${articleBean.quantity}</td>
                                <td>${articleBean.depth}</td>
                                <td>${articleBean.width}</td>
                                <td>${articleBean.height}</td>
                                <td>${articleBean.volume}</td>
                                <td>${articleBean.weight}</td>
                                <td>${articleBean.personName}</td>
                                <td>${articleBean.boxLabel}</td>

                                <td style="text-align: center;">
                                    <div class="ui small basic icon buttons">

                                        <a data-content="Détails"
                                           href="<c:url value="/ArticleController/getArticleDetail?articleId=${articleBean.articleId}"/>"
                                           class="ui button"><i class="eye icon"></i></a>

                                        <a data-content="Supprimer"
                                           href="<c:url value="/ArticleController/deleteArticle?articleId=${articleBean.articleId}"/>"
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
