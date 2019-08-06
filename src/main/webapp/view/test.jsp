<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form accept-charset="UTF-8"
<c:if test = "${!isLast}">
	action="/next"
</c:if>
<c:if test = "${isLast}">
action="/finish"
</c:if>
method="POST" >
<input name = "id" hidden = "true" value = "${id}"/>
<input name = "name" hidden = "true" value = "${name}"/>
<c:forEach items="${quests}" var="quest">
    <div align="center">
        <h2> ${quest.q_text} </h2>
         <input name = "q_id" hidden = "true" value = "${quest.q_id}"/>
          <c:forEach items="${quest.answers}" var="answer">
          	<input checked="checked" name="a_id" type="radio" value="${answer.a_id}" />${answer.a_text}<br/>
            <input name = "score" hidden = "true" value = "${answer.a_score}"/>
          </c:forEach>
    </div>
</c:forEach>
<c:if test = "${!isLast}">
	<button type="submit" value="Accept">Accept</button>
</c:if>
<c:if test = "${isLast}">
<button type="submit" value="Finish the test">Finish the test</button>
</c:if>
</form>

<form accept-charset="UTF-8" action="/test" method="POST" >
<input name = "id" hidden = "true" value = "${id - 1}"/>
<input name = "name" hidden = "true" value = "${name}"/>
<button type="submit" value="Previous"
<c:if test = "${isFirst}">
disabled="disabled"
</c:if>>Previous</button>
</form>

<form accept-charset="UTF-8" action="/test" method="POST" >
<input name = "id" hidden = "true" value = "${id +1}"/>
<input name = "name" hidden = "true" value = "${name}"/>
<button type="submit" value="Next"
<c:if test = "${isLast}">
disabled="disabled"
</c:if>>Next</button>
</form>
</body>
</html>