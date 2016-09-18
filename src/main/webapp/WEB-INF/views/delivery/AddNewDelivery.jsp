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

<form:form action="saveDelivery" method="post" commandName="deliveryBean" class="ui form">

    <form:hidden path="deliveryId"/>

    <div class="ui centered container segment padded">

        <div class="ui horizontal divider">
                ${not empty deliveryBean.deliveryId ? "Modifier " : "Nouvelle "}
            Livraison
        </div>

        <s:hasBindErrors name="deliveryBean">
            <div class="ui warning visible message">
                <p><i class="small warning icon"></i><s:message code="common.form.global.message"/>.</p>
            </div>
        </s:hasBindErrors>

        <div class="ui segment">

            <div class="three fields">
                <s:bind path="deliveryState">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Etat de livraison *</label>
                        <div class="ui selection dropdown">
                            <form:input type="hidden" path="deliveryState"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">Etat de livraison</div>
                            <div class="menu">
                                <div class="item" data-value="READY_TO_DELIVER">
                                    <s:message code="delivery.READY_TO_DELIVER.label"/>
                                </div>
                                <div class="item" data-value="IN_DELIVERING">
                                    <s:message code="delivery.IN_DELIVERING.label"/>
                                </div>
                                <div class="item" data-value="DELIVERED">
                                    <s:message code="delivery.DELIVERED.label"/>
                                </div>
                            </div>
                        </div>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

                <s:bind path="orderId">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">La commande à livrer</label>
                        <div class="ui selection dropdown">
                            <form:input type="hidden" path="orderId"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">La commande à livrer</div>
                            <div class="menu">
                                <c:forEach items="${orders}" var="order">
                                    <div class="item" data-value="${order.ordersId}">
                                            ${order.ordersId}
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

                <s:bind path="vehicleId">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Camion</label>
                        <div class="ui selection dropdown">
                            <form:input type="hidden" path="vehicleId"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">Camion</div>
                            <div class="menu">
                                <c:forEach items="${vehicles}" var="vehicle">
                                    <div class="item" data-value="${vehicle.vehicleId}">
                                            ${vehicle.label}
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

            <div class="two fields">
                <s:bind path="paletteId">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Type de palette *</label>
                        <div class="ui selection dropdown">
                            <form:input type="hidden" path="paletteId"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">Type de palette</div>
                            <div class="menu">
                                <c:forEach items="${palettes}" var="palette">
                                    <div class="item" data-value="${palette.paletteId}">
                                            ${palette.type}
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

                <s:bind path="paletteCount">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">La quantité de palette *</label>
                        <form:input path="paletteCount" placeholder="Quantité de palette"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

            </div>

        </div>

        <div class="ui segment" style="text-align: center;">
            <div class="ui buttons aligned right">
                <a href="<c:url value="/DeliveryController/deliveryTableView"/>" class="ui button"><s:message
                        code="button.back.message"/></a>
                <div class="or" data-text="ou"></div>
                <button type="submit" class="ui blue button"><s:message code="button.submit.message"/></button>
            </div>
        </div>

    </div>
</form:form>