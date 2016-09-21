<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/HomeController/getHomeView'/>" class="item"><i class="home link icon"></i></a>
    <div class="right menu">
        <a href="#" class="item" data-content="Déconnexion"><i class="sign out link icon"></i></a>
    </div>
</div>

<div class="ui horizontal divider hidden"></div>
<div class="ui horizontal divider hidden"></div>

<form:form action="supplierOrderDetailCheck" commandName="supplierOrderDetailBean" method="post" class="ui form">

    <form:hidden path="supplierOrderDetailId"/>

    <div class="ui centered container segment padded">

        <div class="ui horizontal divider">
            Vérification de la ligne de commande N° ${supplierOrderDetailBean.supplierOrderDetailId}
        </div>

        <s:hasBindErrors name="supplierOrderDetailBean">
            <div class="ui warning visible message">
                <p><i class="small warning icon"></i><s:message code="common.form.global.message"/>.</p>
            </div>
        </s:hasBindErrors>

        <div class="ui segment">

            <div class="two fields">

                <s:bind path="state">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Statut *</label>
                        <div class="ui selection dropdown">
                            <form:input type="hidden" path="state"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">Statut</div>
                            <div class="menu">
                                <div class="item" data-value="DELIVERED">
                                    <s:message code="orders.state.DELIVERED.label"/>
                                </div>
                                <div class="item" data-value="PARTIALLY_DELIVERED">
                                    <s:message code="orders.state.PARTIALLY_DELIVERED.label"/>
                                </div>
                            </div>
                        </div>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

                <s:bind path="quantityReceived">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Quantité reçu *</label>
                        <form:input path="quantityReceived" type="text" placeholder="La quantité reçu *"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

            </div>

            <s:bind path="comments">
                <div class="field ${status.error ? 'error' : ''}">
                    <label class="label">Observations</label>
                    <form:textarea path="comments" type="text" rows="5" placeholder="Observations"/>
                    <c:if test="${status.error}">
                        <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                    </c:if>
                </div>
            </s:bind>

        </div>

        <div class="ui segment" style="text-align: center;">
            <div class="ui buttons aligned right">
                <a href="<c:url value="/SupplierOrderController/getSupplierOrderDetail?supplierOrderId=${supplierOrderDetailBean.supplierOrderId}"/>"
                   class="ui button"><s:message code="button.back.message"/></a>
                <div class="or" data-text="ou"></div>
                <button type="submit" class="ui blue button"><s:message code="button.submit.message"/></button>
            </div>
        </div>

    </div>


</form:form>