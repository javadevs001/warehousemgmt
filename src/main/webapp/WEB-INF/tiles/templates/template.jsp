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


<div id="deleteOrderModal" class="ui basic modal">
    <i class="close icon"></i>
    <div class="header">
        Supprimer une commande
    </div>
    <div class="image content">
        <div class="image">
            <i class="checkmark icon"></i>
        </div>
        <div class="description">
            <p>Êtes-vous sûr de vouloir supprimer cette commande ?</p>
        </div>
    </div>
    <div class="actions">
        <div class="two fluid ui inverted buttons">
            <div class="ui red basic cancel inverted button">
                <i class="remove icon"></i>
                Non
            </div>
            <div class="ui green basic ok inverted button">
                <i class="checkmark icon"></i>
                Oui
            </div>
        </div>
    </div>
</div>


</body>

</html>