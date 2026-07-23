<%@page import="day0723.WebMemberDomain"%>
<%@page import="day0723.SelectService6"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="generator" content="Astro v5.13.2">
<title>마이페이지</title>

<meta name="theme-color" content="#712cf9">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: #0000001a;
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em #0000001a, inset 0 .125em .5em #00000026
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh
}

.bi {
	vertical-align: -.125em;
	fill: currentColor
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch
}

.btn-bd-primary {
	--bd-violet-bg: #712cf9;
	--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
	--bs-btn-font-weight: 600;
	--bs-btn-color: var(--bs-white);
	--bs-btn-bg: var(--bd-violet-bg);
	--bs-btn-border-color: var(--bd-violet-bg);
	--bs-btn-hover-color: var(--bs-white);
	--bs-btn-hover-bg: #6528e0;
	--bs-btn-hover-border-color: #6528e0;
	--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
	--bs-btn-active-color: var(--bs-btn-hover-color);
	--bs-btn-active-bg: #5a23c8;
	--bs-btn-active-border-color: #5a23c8
}

.bd-mode-toggle {
	z-index: 1500
}

.bd-mode-toggle .bi {
	width: 1em;
	height: 1em
}

.bd-mode-toggle .dropdown-menu .active .bi {
	display: block !important
}

#프로필 디자인
#profileWrap {
	width: 100%;
	min-height: 600px;
	margin-top: 20px;
	background-color: #FF0000
}
</style>

<script type="text/javascript">
$(function() {
	
});//ready
</script>
</head>
<body>
	
	<header data-bs-theme="dark">
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		</nav>
	</header>
	<main>
	<%
	String id = "test3";
	SelectService6 ss = SelectService6.getInstance();
	WebMemberDomain wmd = ss.searchWebMember(id);
	pageContext.setAttribute("userData", wmd);
	%>
		<!-- /.container -->
		<div id="profileWrap" style="margin-top: 50px;">
			<form action="day0723/updateProcess.jsp" method="post" id="mypageForm" name="mypageForm">
				<table style="margin: 0px auto">
					<tr>
						<td>
							<h3>마이페이지- 정보수정</h3>
							<table>
								<tr>
									<td>아이디</td>
									<td>
										<strong><c:out value="${ userData.id }" /></strong>
									</td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td>
										<input type="password" name="password" id="password"/>
									</td>
								</tr>
								<tr>
									<td>비밀번호 확인</td>
									<td>
										<input type="password" name="password2" id="password2"/>
									</td>
								</tr>
								<tr>
									<td>이름</td>
									<td>
										<input type="text" name="name" id="name"  value="${ userData.name }" readonly="readonly">
									</td>
								</tr>
								<tr>
									<td>이메일</td>
									<td>
										<input type="text" name="email" id="email" value="${ userData.email }">
									</td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td>
										<input type="text" name="phone" id="phone" value="${ userData.phone }">
									</td>
								</tr>
								<tr>
									<td>우편번호</td>
									<td>
										<input type="text" name="zipcode" id="zipcode" value="${ userData.zipcode }" style="width: 70px" readonly="readonly"> <input type="button" value="검색" class="btn btn-success btn-sm" />
									</td>
								</tr>
								<tr>
									<td>주소</td>
									<td>
										<input type="text" name="address" id="address" value="${ userData.address }" style="width: 300px" readonly="readonly">
									</td>
								</tr>
								<tr>
									<td>상세주소</td>
									<td>
										<input type="text" name="address2" id="address2" value="${ userData.address2 }" style="width: 300px" />
									</td>
								</tr>
								<tr>
									<td>가입 ip주소</td>
									<td><span id="ip"><c:out value="${ userData.ip }"/></span></td>
								</tr>
								<tr>
									<td>가입일</td>
									<td><span id="inputDate"><fmt:formatDate value="${ userData.inputdate }" pattern="yyyy-MM-dd"/></span></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="submit" value="변경" class="btn btn-warning btn-sm" id="btnUpdate" />
									</td>
								</tr>

							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<!-- FOOTER -->
		<footer class="container">
		</footer>
	</main>
</body>
</html>