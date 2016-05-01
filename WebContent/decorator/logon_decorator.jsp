<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<script src="http://code.jquery.com/jquery-1.2.3.min.js"></script>
	<title><decorator:title /></title>
	<decorator:head />
</head>
<body>

	<div id="header">
	<!-- ��� -->
		<h1 id="logo">
			<a id="logo_btn" href="/Reviwer/logon/loginForm.do" title="REVIWER">REVIWER</a>
		</h1>
		<span id="main_btn">
			<a class="btn_gnb" href="/Reviwer/search/searchForm.do">
				<span id="btn_search">�˻���ư</span>
			</a>
		</span>
	</div>
	<div id="content">
		<decorator:body />
	</div>
	
	<div id="footer">
	<!-- ǲ�� -->
		<ul id="list_policy">
			<li>
				<a href="#" class="list_link">�̿���</a>
			</li>
			<li>
				<a href="#" class="list_link">����������޹�ħ</a>
			</li>
		</ul>
	</div>
</body>
</html>