<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<input type="button"
		onclick="javascript:beginGrabing('${pageContext.request.contextPath }');"
		value="开始抓取网站数据" />
	<a href="${pageContext.request.contextPath }/dispatcher/beginningGrab">开始抓取页面</a>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function beginGrabing(basePath) {
			/*var ajaxConfig = {
				url : basePath + "/dispatcher/beginningGrab",
				type : "POST",
				dataType : "JSON",
				data : null,
				success : function(data) {
					if (data == "success") {
						alert("request success");
					}
				},
				error : function() {
					alert("request error");
				},
			};*/
			$.ajax({
				url : basePath + "/dispatcher/beginningGrab",
				type : "POST",
				dataType : "text",
				data : null,
				success : function(data) {
					if (data == "success") {
						alert("开始抓取网络数据");
					}
				},
				error : function() {
					alert("请求出错!");
				},
			});
		}
	</script>
</body>
</html>