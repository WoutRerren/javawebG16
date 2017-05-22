<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Welkom</title>
        <link rel="stylesheet" type="text/css" href="http://users.hogent.be/~530534jp/style.css">
    </head>
    <body id="welcome">
        <div id="wrapper">
            <div id="menubar">${message}</div>
        <div id="gebruiker">Welkom, ${username}</div>
        <div id="groep">Groep : ${gbgroup}
            <h1>Cursists :</h1>
        ${coursemembers}
        </div>
        <c:url var="logoutUrl" value="/logout"/>
        <c:choose>
            <c:when test="${ingediend == 1}">
                <button id="peer" href="<c:url value="peerassesment.htm"/>">Bekijk peerassessment</button>
            </c:when>
            <c:otherwise>
                <button id="peer" href="<c:url value="peerassesment.htm"/>">+ Dien assessment in</button>
            </c:otherwise>
        </c:choose>
        <form action="${logoutUrl}" method="post">
            <input id="logoutbutton" type="submit" value="Log out" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>            
        </form>

        
            
        </div>
        
    </body>
</html>