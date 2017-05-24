<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>主页</title>
<meta charset="UTF-8">

<!-- Bootstrap样式 -->
<link rel="stylesheet" href="/CRM/css/bootstrap.min.css">
<script src="/CRM/js/jquery.min.js" type="text/javascript"></script>
<script src="/CRM/js/bootstrap.min.js" type="text/javascript"></script>
<style>
/* 微调Bootstrap样式 */
.navbar {
	margin-bottom: 0;
	font-size: 12px;
	background-color: #9c6;
	border: none;
	border-radius: 0;
}

.bg-footer {
	padding-top: 20px;
	color: white;
	background-color: #9c6;
}

/* 将页脚固定在页面底部  */
#main {
	padding-bottom: 60px; /* Height of the footer */
}

footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	height: 60px; /* Height of the footer */
}
</style>

<!-- Loading插件 -->
<link href="/CRM/css/waitMe.min.css" rel="stylesheet">
<script src="/CRM/js/waitMe.min.js"></script>
<!-- jQuery分页插件 -->
<link href="/CRM/css/jqpagination.css" rel="stylesheet" type="text/css">
<script src="/CRM/js/jquery.jqpagination.min.js" type="text/javascript"></script>
<script type="text/javascript">
	// 初始化Loading插件
	function runWaitMe(target) {
		$(target).waitMe({

			//none, rotateplane, stretch, orbit, roundBounce, win8, 
			//win8_linear, ios, facebook, rotation, timer, pulse, 
			//progressBar, bouncePulse or img
			effect : 'bounce',

			//place text under the effect (string).
			text : '加载中...',

			//background for container (string).
			bg : '',

			//color for background animation and text (string).
			color : '#9c6',

			//change width for elem animation (string).
			sizeW : '',

			//change height for elem animation (string).
			sizeH : '',

			// url to image
			source : ''

		});
	}

	function onsearch(url, params) {
		// 显示Loading画面
		runWaitMe("#main");
		// 加载第1页到#main
		params.page = 1;
		$("#main").load(url, params, function() {
			// 隐藏Loading
			$("#main").waitMe("hide");
			// 初始化分页插件
			$(".pagination").jqPagination({
				page_string : "第 {current_page} / {max_page} 页",
				// 点击翻页按钮回调
				paged : function(page) {
					// 显示Loading画面
					runWaitMe();
					// 刷新table
					params.page = page;
					$("table").load(url + " thead,tbody", params, function() {
						// 隐藏Loading
						$("#main").waitMe("hide");
					});
				}
			});
		});
	}

	// 为导航按钮绑定点击事件
	$(function() {
		$("#nav a").each(function() {
			var url = $(this).attr("href");
			$(this).click(function() {
				onsearch(url, {});

				$(this).parent("li").addClass("active") // 父li元素添加active属性
				.siblings("li").removeClass("active"); // 父li元素同级的li元素移除active属性

				// 阻止a标签的默认动作
				return false;
			});
		});
	});

	// 模拟点击导航按钮
	$(function() {
		var url = $("#nav li.active a").attr("href");

		onsearch(url, {});
	});
</script>

<!-- Bootstrap弹窗插件 -->
<script src="/CRM/js/bootbox.min.js" type="text/javascript"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<script src="/CRM/js/html5shiv.min.js" type="text/javascript"></script>
<script src="/CRM/js/respond.min.js" type="text/javascript"></script>

</head>
<body>
	<%-- 从Application中取到用户权限 --%>
	<c:set var="userAuthority" value="#application.authority.get(#session.user)" />
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">AIRWXTX</a>
			</div>
			<ul class="nav navbar-nav" id="nav">
				<li class="active"><a href="/CRM/client/searchClientAction">会员管理</a></li>
				<li><a href="/CRM/card/searchCardAction">会员卡管理</a></li>
				<li><a href="/CRM/recode/searchRecodeAction">消费记录</a></li>
				<c:if test="@com.airwxtx.authority.entity.AuthorityNumber@CONTROL_USER in #userAuthority">
					<li><a href="/CRM/user/searchUserAction">用户管理</a></li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">设置<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/CRM/settings/profileAction" target="_blank">用户信息</a></li>
						<li><a href="/CRM/settings/preChangePasswordAction"
							target="_blank">修改密码</a></li>
						<li><a href="/CRM/settings/exitAction">安全退出</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<div id="main"></div>
	<footer class="container-fluid bg-footer text-center">
		<p>
			Copyright &copy; 2016 <a href="http://www.airwxtx.com" target="_blank">airwxtx.com</a>
		</p>
	</footer>
</body>
</html>
