<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="menu" class="ui stackable small menu">
    <a href="<c:url value='/HomeController/getHomeView'/>" class="item" data-content="Accueil"><i
            class="home link icon"></i></a>
            <div class="right menu">
            <a href="<c:url value="/j_spring_security_logout"/>" class="item" data-content="Déconnexion"><i
                    class="sign out link icon"></i></a>
        </div>

    </div>
</div>

    <thead>
    <tr>
        <th>Identification</th>
        <th>Etat de livraison</th>
        <th>Satut du camion</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${deliveries}" var="delivery">
        <tr>
            <td> ${delivery.vehicleLabel} </td>
            <td> ${delivery.deliveryState} </td>
            <td> ${delivery.vehicleState} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>