<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<tiles:insertAttribute name = "title"/>
</title>
<s:include value="%{#application.WEB_CONTENTS}/components/bootstrap.jsp" />
<s:include value="%{#application.WEB_CONTENTS}/components/font-awesome.jsp" />
<s:include value="%{#application.WEB_CONTENTS}/components/jquery.jsp" />
<tiles:insertAttribute name="headerComponents"/>
</head>
<body>
<s:include value="%{#application.WEB_CONTENTS}/pages/header.jsp"></s:include>
<tiles:insertAttribute name="bodyComponents"/>
<s:include value="%{#application.WEB_CONTENTS}/pages/footer.jsp"></s:include>
</body>
</html>



