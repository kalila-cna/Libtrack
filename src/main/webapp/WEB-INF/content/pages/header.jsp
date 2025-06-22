<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles/header.css">
</head>
<body>
	<header class="site-header">
		<div class="site-identity">
			<h1>
				<img src="<%=request.getContextPath()%>/images/logo.webp" /> <a
					href="home">LibTrack</a>
			</h1>
		</div>
		<nav class="site-navigation">
			<ul class="nav">
				<li><a href="home">Home</a></li>
				<li><a href="about">About</a></li>
				<s:if test="#signup">
					<li><a href="signup">Sign Up</a></li>
				</s:if>
			</ul>
		</nav>
	</header>
</body>
</html>