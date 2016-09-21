<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/HomeController/getHomeView'/>" class="item"><i class="home link icon"></i></a>
    <div class="right menu">
        <a href="#" class="item" data-content="Déconnexion"><i class="sign out link icon"></i></a>
    </div>
</div>

<div class="ui horizontal divider hidden"></div>
<div class="ui horizontal divider hidden"></div>

<form:form action="saveSupplierOrder" method="post" commandName="supplierOrderBean" class="ui form">

    <form:hidden path="updateCase"/>
    <form:hidden path="ordersId"/>

    <div class="ui centered container segment padded">

        <c:choose>
            <c:when test="${supplierOrderBean.updateCase}">
                <div class="ui horizontal divider">
                    Modifier la commande fournisseur N°${supplierOrderBean.ordersId}
                </div>
            </c:when>
            <c:otherwise>
                <div class="ui horizontal divider">
                    Nouvelle commande pour fournisseur
                </div>
            </c:otherwise>
        </c:choose>


        <s:hasBindErrors name="supplierOrderBean">
            <div class="ui warning visible message">
                <p><i class="small warning icon"></i><s:message code="common.form.global.message"/>.</p>
            </div>
        </s:hasBindErrors>

        <div class="ui segment">


            <s:bind path="personId">
                <div class="field ${status.error ? 'error' : ''}">
                    <label class="label">Fournisseur *</label>
                    <div class="ui selection dropdown ${supplierOrderBean.updateCase ? 'disabled' : ''}">
                        <form:input type="hidden" path="personId"/>
                        <i class="dropdown icon"></i>
                        <div class="default text">Fournisseur</div>
                        <div class="menu">
                            <c:forEach items="${persons}" var="person">
                                <div class="item" data-value="${person.personId}">
                                        ${person.companyName}
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <c:if test="${status.error}">
                        <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                    </c:if>
                </div>
            </s:bind>

            <div class="two fields">
                <s:bind path="priority">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Priorité *</label>
                        <div class="ui selection dropdown">
                            <form:input type="hidden" path="priority"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">Priorité</div>
                            <div class="menu">
                                <c:forEach items="${priorities}" var="priority">
                                    <div class="item" data-value="${priority}">
                                        <s:message code="orders.priority.${priority}.label"/>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

                <s:bind path="state">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Statut *</label>
                        <div class="ui selection dropdown">
                            <form:input type="hidden" path="state"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">Statut</div>
                            <div class="menu">
                                <div class="item" data-value="TO_TREAT">
                                    <s:message code="orders.state.TO_TREAT.label"/>
                                </div>
                                <div class="item" data-value="PENDING">
                                    <s:message code="orders.state.PENDING.label"/>
                                </div>
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
                <a href="<c:url value="/SupplierOrderController/getSupplierOrdersTable"/>" class="ui button"><s:message
                        code="button.back.message"/></a>
                <div class="or" data-text="ou"></div>
                <button type="submit" class="ui blue button"><s:message code="button.submit.message"/></button>
            </div>
        </div>

    </div>
</form:form>