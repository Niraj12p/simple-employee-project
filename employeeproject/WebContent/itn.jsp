<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="theLocale" value="${not empty param.theLocale?param.theLocale:pageContext.request.locale }" scope="session" />
<fmt:setLocale value="${theLocale }" />
<fmt:setBundle basename="org.niraj.intn.mylabels" />
<html>
<body>
<a href="itn.jsp?theLocale=en_US">English(US)</a>

<a href="itn.jsp?theLocale=es_ES">Spanish(ES)</a>

<a href="itn.jsp?theLocale=de_DE">German(DE)</a>
<hr>
<fmt:message key="label.greeting" /> <br /> <br />
<fmt:message key="label.firstname" /> <br /> 
<fmt:message key="label.lastname" /> <br /> 
<fmt:message key="label.welcome" /> <br /> 
<hr>
Selected locale:${theLocale}
</body>
</html>