<%@page pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<!--
	Rococo Class 2015 - Slim3 and Ajax Exercise
	author: peter.guisadio  
	INSTRUCTIONS:
		- Follow the TODO comments in the jQuery code located at war/js/tweet.js.
		- Follow the TODO comments found in src/sample.controller.twitter/UpdateController.java
	GOALS:
		- Use ajax to delete and update tweets.
		- (optional) validate(for update only) and display errors for updating and deleting tweets.
 -->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>twitter Index</title>
		<link rel="stylesheet" type="text/css" href="/css/global.css" />
	</head>
	<body>
		<p>What are you doing?</p>
		<textarea id="txtContent" name="content"></textarea><br />
		<div id="errorDisplay"></div>
		<button id="btnTweet">Tweet</button>
		<h4>Posts</h4>
		<div id="tweetList">
		</div>
		<c:forEach var="e" items="${tweetList}">
			<hr />
			<div class="tweetRow">
				<textarea name="content" class="content">${f:h(e.content)}</textarea> ${f:h(e.createdDate)}
				<input type="hidden" class="id" name="id" value="${f:h(e.id)}"/>
				<input type="hidden" class="createdDate" name="createdDate" value="${f:h(e.createdDate)}"/>
				<button class="btnUpdate">Save</button>
				<button class="btnDelete">Delete</button>
				<div class="updateErrorDisplay"></div>
			</div>
		</c:forEach>
	</body>
	<script type="text/javascript" src="/js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="/js/tweet.js"></script>
</html>