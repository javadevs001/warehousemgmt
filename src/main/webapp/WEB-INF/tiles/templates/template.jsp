<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="application"/>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="fr">
<head>

    <title><s:message code="title"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <tilesx:useAttribute id="styleNames" name="styleNames" classname="java.util.List" ignore="true"/>
    <c:forEach var="styleName" items="${styleNames}">
        <link type="text/css" href="<c:url value="/resources/css/${styleName}"/>" rel="stylesheet" media="screen"/>
    </c:forEach>

    <link type="text/css" href="<c:url value="/resources/js/semanticui/semantic.min.css"/>" rel="stylesheet"
          media="screen"/>
    <link type="text/css" href="<c:url value="/resources/js/semanticui/datepicker/daterangepicker.min.css"/>"
          rel="stylesheet" media="screen"/>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/s/dt/dt-1.10.10/datatables.min.css"/>

    <script>
        var ctx = '${ctx}';
    </script>

</head>

<body>

<tiles:insertAttribute name="body" defaultValue=""/>
<tilesx:useAttribute id="jsNames" name="jsNames" classname="java.util.List" ignore="true"/>

<script src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/semanticui/semantic.min.js"/>"></script>
<script src="<c:url value="/resources/js/semanticui/datepicker/moment.min.js"/>"></script>
<script src="<c:url value="/resources/js/semanticui/datepicker/daterangepicker.min.js"/>"></script>
<script type="text/javascript" src="//cdn.datatables.net/s/dt/dt-1.10.10/datatables.min.js"></script>

<c:forEach var="js" items="${jsNames}">
    <script src="<c:url value="/resources/js/${js}"/>"></script>
</c:forEach>

<script id="BeneficiaryTemplate" type="x-tmpl-mustache">
         <div class="column">
            <div class="ui card">
                <div class="blurring dimmable image imageDimmerSelector">
                    <div class="ui dimmer">
                        <div class="content">
                            <div class="center">
                                <a href="<c:url value='/beneficiary/form?id={{id}}'/>" class="circular ui icon button" data-content="Modifier">
                                    <i class="icon edit"></i>
                                </a>
                                <a href="<c:url value='/demand/form?beneficiaryId={{id}}'/>" class="circular ui icon button" data-content="Nouvelle demande">
                                    <i class="icon file text"></i>
                                </a>
                                <a href="<c:url value='/beneficiary/info?id={{id}}'/>" class="circular ui icon button" data-content="Info">
                                    <i class="icon eye"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="ui fluid image imageDimmerSelector">
                        <c:if test="{{active}}">
    <a class="ui right corner label">
    <i class="check icon"></i>
    </a>
</c:if>
                        <img src="<c:url value='/resources/image/profile/{{sex}}.png'/>"/>
                    </div>
                </div>
                <div class="content">
                    <a href="<c:url value='/beneficiary/info?id={{id}}'/>" class="header"><c:out value="{{firstName}}"/> <c:out
        value="{{lastName}}"/></a>
                    <div class="meta">
                        <span class="date"><i class="mini icon time"></i> Ajouter en <c:out value="{{year}}"/></span>
                    </div>
                </div>
                <div class="extra content">
                    <a href="<c:url value='/demand/list?beneficiaryId={{id}}'/>">
                        <i class="file text icon"></i>
                        <c:out value="{{demandCountLabel}}"/>
                    </a>
                </div>
            </div>
        </div>

</script>


</body>

</html>