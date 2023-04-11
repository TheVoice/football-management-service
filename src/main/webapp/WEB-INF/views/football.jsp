<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Football Teams</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Team
</h1>
<form:form action="/team/add" modelAttribute="team">
<table>
	<c:if test="${!empty team.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td>
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Team Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="acronym">
				<spring:message text="Team Acronym"/>
			</form:label>
		</td>
		<td>
			<form:input path="acronym" />
		</td>
	</tr>
	<tr>
    	<td>
    		<form:label path="budget">
    			<spring:message text="Budget"/>
    		</form:label>
    	</td>
    	<td>
    		<form:input path="budget" />
    	</td>
    </tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message text="Save"/>" />
		</td>
	</tr>
</table>
</form:form>
<br>
<h2>Teams List</h2>
<c:if test="${!empty teams}">
	<table class="tg">
	<tr>
		<th width="80">Team ID</th>
		<th width="120">Team Name</th>
		<th width="120">Team Acronym</th>
		<th width="80">Budget</th>
		<th width="200">Players</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${teams}" var="team">
		<tr>
			<td>${team.id}</td>
			<td>${team.name}</td>
			<td>${team.acronym}</td>
			<td>${team.budget}</td>
			<td>
			    <c:forEach items="${team.players}" var="player">
			        ${player.name}<br>
			    </c:forEach>
			</td>
			<td><a href="<c:url value='/team/edit/${team.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/team/remove/${team.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<h1>
	Add a Player
</h1>

<form:form action="/player/add" modelAttribute="player">
<table>
	<c:if test="${!empty player.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td>
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="position">
				<spring:message text="Position"/>
			</form:label>
		</td>
		<td>
			<form:input path="position" />
		</td>
	</tr>
	<tr>
	    <td>
	        <form:label path="team">
	            <spring:message text="Team"/>
	        </form:label>
	    </td>
	    <td>
	        <form:select path="team.id">
	            <form:option value=""/>
	            <form:options items="${teams}" itemValue="id" itemLabel="name"/>
	        </form:select>
	    </td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message text="Save"/>" />
		</td>
	</tr>
</table>
</form:form>
<br>
<h2>Players List</h2>
<c:if test="${!empty players}">
	<table class="tg">
	<tr>
		<th width="80">Player ID</th>
		<th width="120">Player Name</th>
		<th width="120">Position</th>
		<th width="120">Team</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${players}" var="player">
		<tr>
			<td>${player.id}</td>
			<td>${player.name}</td>
			<td>${player.position}</td>
			<td>${player.team.name}</td>
			<td><a href="<c:url value='/player/edit/${player.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/player/remove/${player.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>