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

<form:form action="saveSupplierOrderDetail" method="post" commandName="supplierOrderDetailBean" class="ui form">

    <form:hidden path="supplierOrderId"/>
    <form:hidden path="supplierOrderDetailId"/>
    <form:hidden path="updateCase"/>

    <div class="ui centered container segment padded">

        <div class="ui horizontal divider">
                ${supplierOrderDetailBean.updateCase ? 'Modifier' : 'Nouvelle' } ligne de commande pour fournisseur
        </div>

        <s:hasBindErrors name="supplierOrderDetailBean">
            <div class="ui warning visible message">
                <p><i class="small warning icon"></i><s:message code="common.form.global.message"/>.</p>
            </div>
        </s:hasBindErrors>

        <div class="ui segment">

            <div class="two fields">

                <s:bind path="article">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Article</label>
                        <div class="ui selection dropdown ${supplierOrderDetailBean.updateCase ? 'disabled' : ''}">
                            <form:input type="hidden" path="article"/>
                            <i class="dropdown icon"></i>
                            <div class="default text">Article *</div>
                            <div class="menu">
                                <c:forEach items="${articles}" var="article">
                                    <div class="item" data-value="${article.articleId}">
                                            ${article.label}
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

                <s:bind path="quantity">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">Quantité *</label>
                        <form:input path="quantity" type="text" placeholder="La quantité"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>

            </div>

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