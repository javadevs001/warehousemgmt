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

<form:form action="saveArticle" method="post" commandName="articleBean" class="ui form">

    <div class="ui centered container segment padded">

        <div class="ui horizontal divider">
                ${not empty articleBean.articleId ? "Modifier " : "Nouvel "}
            article
        </div>

        <s:hasBindErrors name="articleBean">
            <div class="ui warning visible message">
                <p><i class="small warning icon"></i><s:message code="common.form.global.message"/>.</p>
            </div>
        </s:hasBindErrors>

        <div class="ui segment">
                <form:hidden path="articleId"/>
                <form:hidden path="personId"/>
                <form:hidden path="boxId"/>
                <form:hidden path="volume"/>
                <s:bind path="label">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">label</label>
                        <form:input path="label" type="text" placeholder="label"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="description">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">description</label>
                        <form:input path="description" type="text" placeholder="description"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="buyingUnitPrice">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">buyingUnitPrice</label>
                        <form:input path="buyingUnitPrice" type="text" placeholder="buyingUnitPrice"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="sellingUnitPrice">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">sellingUnitPrice</label>
                        <form:input path="sellingUnitPrice" type="text" placeholder="sellingUnitPrice"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="packageQuantity">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">packageQuantity</label>
                        <form:input path="packageQuantity" type="text" placeholder="packageQuantity"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="threshold">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">threshold</label>
                        <form:input path="threshold" type="text" placeholder="threshold"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="quantity">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">quantity</label>
                        <form:input path="quantity" type="text" placeholder="quantity"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="depth">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">depth</label>
                        <form:input path="depth" type="text" placeholder="depth"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="width">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">width</label>
                        <form:input path="width" type="text" placeholder="width"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="height">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">height</label>
                        <form:input path="height" type="text" placeholder="height"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
                <s:bind path="weight">
                    <div class="field ${status.error ? 'error' : ''}">
                        <label class="label">weight</label>
                        <form:input path="weight" type="text" placeholder="weight"/>
                        <c:if test="${status.error}">
                            <div class="ui basic red pointing prompt label transition visible">${status.errorMessage}</div>
                        </c:if>
                    </div>
                </s:bind>
        </div>

        <div class="ui segment" style="text-align: center;">
            <div class="ui buttons aligned right">
                <a href="<c:url value="/ArticleController/getArticleTable"/>"
                   class="ui button"><s:message code="button.back.message"/></a>
                <div class="or" data-text="ou"></div>
                <button type="submit" class="ui blue button"><s:message code="button.submit.message"/></button>
            </div>
        </div>

    </div>
</form:form>

