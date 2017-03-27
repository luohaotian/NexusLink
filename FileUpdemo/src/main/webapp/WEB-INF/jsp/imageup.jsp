<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>

<meta charset="UTF-8">
<title>图片上传</title>

</head>
<body>
<form action="/files" method="post" encType="multipart/form-data">
	<!--注意accept属性不要写成*/*,会卡成翔，根据需求写对应的mime，别偷懒-->
	<input type="file" name="files" multiple="multiple" accept="image/jpg,image/jpeg,image/png" />
	<!--和文件一起提交别的参数-->
	<input type="hidden" name="dir" value="avatar" />
</form>

</body>
</html>