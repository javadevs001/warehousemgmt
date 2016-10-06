<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div id="menu" class="ui stackable sm
all menu">
    <a href="<c:url value='/HomeController/getHomeView'/>" class="item"><i class="home link icon"></i></a>
    <div class="right menu">
        <a href="#" class="item" data-content="Déconnexion"><i class="sign out link icon"></i></a>
    </div>
</div>

<div class="ui horizontal divider hidden"></div>
<div class="ui horizontal divider hidden"></div>

<form:form action="saveSupplier" method="post" commandName="supplierBean" class="ui form">

    <div class="ui centered container segment padded">

        <div class="ui horizontal divider">
                ${not empty supplierBean.personId ? "Modifier " : "Nouveaux "}
            fournisseur
        </div>

        <s:hasBindErrors name="supplierBean">
            <div class="ui warning visible message">
                <p><i class="small warning icon"></i><s:message code="common.form.global.message"/>.</p>
            </div>
        </s:hasBindErrors>

        <div class="ui segment">
                <form:hidden path="personId"/>
                <form:hidden path="personType"/>
                <s:bind path="companyName">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">companyName</label>
                        <form:input path="companyName" type="text" placeholder="companyName"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="email">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">email</label>
                        <form:input path="email" type="text" placeholder="email"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="phone">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">phone</label>
                        <form:input path="phone" type="text" placeholder="phone"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="fax">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">fax</label>
                        <form:input path="fax" type="text" placeholder="fax"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="addressCity">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">addressCity</label>
                        <form:input path="addressCity" type="text" placeholder="addressCity"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="addressPostCode">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">addressPostCode</label>
                        <form:input path="addressPostCode" type="text" placeholder="addressPostCode"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="addressStreet">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">addressStreet</label>
                        <form:input path="addressStreet" type="text" placeholder="addressStreet"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="addressNumber">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">addressNumber</label>
                        <form:input path="addressNumber" type="text" placeholder="addressNumber"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="addressBox">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">addressBox</label>
                        <form:input path="addressBox" type="text" placeholder="addressBox"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="tva">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">tva</label>
                        <form:input path="tva" type="text" placeholder="tva"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
        </div>

        <div class="ui segment" style="text-align: center;">
            <div class="ui buttons aligned right">
                <a href="<c:url value="/SupplierController/getSupplierTable"/>"
                   class="ui button"><s:message code="button.back.message"/></a>
                <div class="or" data-text="ou"></div>
                <button type="submit" class="ui blue button"><s:message code="button.submit.message"/></button>
            </div>
        </div>

    </div>
</form:form>

