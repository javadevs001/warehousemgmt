<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%--
  Created by IntelliJ IDEA.
  User: Wéry Lionel
  Date: 20/08/2016
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/HomeController/getHomeView'/>" class="item" data-content="Accueil"><i
            class="home link icon"></i></a>
    <button class="ui button">
        <a href="<c:url value="/HomeDeliveryController/getHomeDeliveryView"/>"/>
        Retour à l'acceuill
    </button>
    <div class="right menu">
        <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                class="sign out link icon"></i></a>
    </div>
</div>

<div class="ui horizontal divider hidden"></div>

<form:form commandName="vehicleBean" action="SaveNewVehicle" class="ui form" method="POST">

    <div class="ui centered container segment padded">

        <div class="ui horizontal divider">
            Ajouter un nouveau vehicule
        </div>

        <s:hasBindErrors name="vehicleBean">
            <div class="ui warning visible message">
                <p><i class="small warning icon"></i><s:message code="common.form.global.message"/>.</p>
            </div>
        </s:hasBindErrors>

        <div class="ui segment">

            <div class="two fields">

                <div class="two fields">
                    <s:bind path="label">
                        <div class="field  ${status.error ? 'error' : ''}">
                            <label>Véhicule</label>
                            <form:input path="label" type="text" placeholder="label"/>
                            <c:if test="${status.error}">
                                <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                            </c:if>
                        </div>
                    </s:bind>

                    <s:bind path="vehicleTypeId">
                        <div class="field ${status.error ? 'error' : ''}">
                            <label class="label">Type Véhicule</label>
                            <div class="ui selection dropdown">
                                <form:input type="hidden" path="vehicleTypeId"/>
                                <i class="dropdown icon"></i>
                                <div class="default text">Type de Vehicule</div>
                                <div class="menu">
                                    <c:forEach items="${vehicleTypeList}" var="vehicleType">
                                        <div class="item" data-value="${vehicleType.vehicleTypeId}">
                                                ${vehicleType.label}
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <c:if test="${status.error}">
                                <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                            </c:if>
                        </div>
                    </s:bind>
                </div>

            </div>

            <div class="ui segment" style="text-align: center;">
                <div class="ui buttons aligned right">
                    <a href="#"
                       type="reset" class="ui button"><s:message code="button.back.message"/></a>
                    <div class="or" data-text="ou"></div>
                    <button type="submit" class="ui blue button"><s:message code="button.submit.message"/></button>
                </div>
            </div>
        </div>
    </div>
</form:form>
