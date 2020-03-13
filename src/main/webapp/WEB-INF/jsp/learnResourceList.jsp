<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center;margin:0 auto;width: 1000px; ">
        <h1>学习资源大奉送，爱我就关注嘟嘟公众号：嘟爷java超神学堂（javaLearn）</h1>
        <table width="100%" border="1" cellspacing="1" cellpadding="0">
            <tr>
                <td>作者</td>
                <td>教程名称</td>
                <td>地址</td>
            </tr>
            <!-- 这里使用JSTL标签库。jsp文件不能直接打开（会有错误），需要依靠Tomcat动态解析 -->
            <c:forEach var="learn" items="${learnList}">
                <tr>
                    <td>${learn.author}</td>
                    <td>${learn.title}</td>
                    <td><a href="${learn.url}" target="_blank">点我</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
