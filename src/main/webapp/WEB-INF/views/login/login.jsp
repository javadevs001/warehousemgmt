<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="ui horizontal divider hidden"></div>
<div class="ui horizontal divider hidden"></div>

<div class="ui column centered grid container element">
    <form action="<c:url value='/j_spring_security_check'/>" method="post">
        <!--SEMANTIC UI CARD-->
        <div class="ui card">

            <!--SAMPLE IMAGE-->
            <div class="image">
                <img src="${ctx}/resources/image/logo/logo.png">
            </div>

            <!--THE CONTENT OF THE UI CARD-->
            <div class="content">
                <!--THE HEADER-->
                <a class="ui grey header">WareHouseMGMT</a>

                <!-- DIVIDER-->
                <div class="ui divider"></div>

                <!--ERROR MESSAGE-->
                <c:if test="${error}">
                    <div class="ui error visible message">
                        <p><i class="small warning icon"></i>Adresse électronique ou mot de passe incorrect(e).</p>
                    </div>
                </c:if>

                <!--LOGOUT MESSAGE-->
                <c:if test="${logout}">
                    <div class="ui warning visible message">
                        <p><i class="small warning icon"></i>Vous avez été déconnecté.</p>
                    </div>
                </c:if>

                <!--unauthorizedMsg MESSAGE-->
                <c:if test="${unauthorized}">
                    <div class="ui warning visible message">
                        <p><i class="small warning icon"></i>Vous n'avez pas l'autorisation d'accéder à cette
                            application.</p>
                    </div>
                </c:if>

                <!-- CARD CORE CONTENT -->
                <div class="description">
                    <div class="ui form">

                        <!--FIELD -->
                        <div class="field">
                            <input type="text" name="login" placeholder="Nom d'utilisateur">
                        </div>

                        <!--ANOTHER FIELD-->
                        <div class="field">
                            <input type="password" name="password" placeholder="Mot de passe">
                        </div>

                    </div>
                </div>
            </div>

            <!--THE EXTRA CONTENT-->
            <div class="extra content">
                <button type="submit" class="ui blue button">Se connecter</button>
            </div>
        </div>
    </form>
</div>



