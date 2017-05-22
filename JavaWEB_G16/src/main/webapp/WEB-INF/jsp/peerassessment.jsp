<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PeerAssessment</title>
         <link rel="stylesheet" type="text/css" href="http://users.hogent.be/~530534jp/style.css">
    </head>
    <body>
        <h1>PeerAssessment</h1>
       <form:form method="POST" action="save.htm" modelAttribute="wrapper">
           
                <div id="oneven">
               <p><h3>enthousiasme en participatie: </h3>
                <c:forEach items="${wrapper.assessments}" var="peer" varStatus="status">
                    <p>${peer.forCoursemember.name}</p>
                    <form:radiobuttons path="assessments[${status.index}].answers[0].answer" items="${answers}"/><br/>
                </c:forEach>           
            </p>
              </div>
              <div id="even">
            <p><h3>ideeën aanbrengen: </h3>
                <c:forEach items="${wrapper.assessments}" var="peer" varStatus="status">
                    <p>${peer.forCoursemember.name}</p>
                    <form:radiobuttons path="assessments[${status.index}].answers[1].answer" items="${answers}"/><br/>
                </c:forEach>              
            </p>
              </div>
              <div id="oneven">
            <p><h3>inhouden correct en duidelijk kunnen uitleggen:</h3>
                <c:forEach items="${wrapper.assessments}" var="peer" varStatus="status">
                    <p>${peer.forCoursemember.name}</p>
                    <form:radiobuttons path="assessments[${status.index}].answers[2].answer" items="${answers}"/><br/>
                </c:forEach>        
            </p>
              </div>
              <div id="even">
            <p><h3>groep organiseren en sturen:</h3>
                <c:forEach items="${wrapper.assessments}" var="peer" varStatus="status">
                    <p>${peer.forCoursemember.name}</p>
                   <form:radiobuttons path="assessments[${status.index}].answers[3].answer" items="${answers}"/><br/>
                </c:forEach>        
            </p>
              </div>
              <div id="oneven">
            <p>><h3>precisie en nauwkeurigheid:</h3>
                <c:forEach items="${wrapper.assessments}" var="peer" varStatus="status">
                    <p>${peer.forCoursemember.name}</p>
                    <form:radiobuttons path="assessments[${status.index}].answers[4].answer" items="${answers}"/><br/>
                </c:forEach>        
            </p>
              </div>
              <div id="even">
            <p><h3>afspraken respecteren:</h3>
                <c:forEach items="${wrapper.assessments}" var="peer" varStatus="status">
                    <p>${peer.forCoursemember.name}</p>
                    <form:radiobuttons path="assessments[${status.index}].answers[5].answer" items="${answers}"/><br/>
                </c:forEach>        
            </p>
              </div>
            
            <p>
                <input type="submit" value="save"/>           
            </p>
            <p>
                <input type="submit" value="confirm" />           
            </p>

        </form:form>
    </body>
</html>
