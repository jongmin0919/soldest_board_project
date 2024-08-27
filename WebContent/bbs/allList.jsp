<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
   div {
      width: 800px;
      margin:auto;
      text-align: center;   
   }
   
   table {
      width: 800px;
      border-collapse: collapse;   
   }
   
   td, th {
      border : 1px solid #1e90ff;
      padding: 10px;
   }
   
   thead { 
      background-color: #0078ff;
      color: white;   
   }
      
   th:nth-of-type(1) {
      width:50px;
   }
   
   th:nth-of-type(2) {
      width:300px;
   }
   
   th:nth-of-type(3) {
      width:100px;
   }
   
   th:nth-of-type(4) {
      width:100px;
   }   
   
   th:nth-of-type(5) {
      width:50px;
   }   
   
   h1 {
      color : #0078ff;   
   }
</style>
<title>Insert title here</title>
</head>
<body>
	<div>
		<p> 
			<button onclick = "goTo_InsertPage()">게시글 작성</button>
		</p>
		<h1>BBS 게시판</h1>
		<table>
			<thead>
				<tr> 
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach var="bvo" items = "${list}">
							<tr>
							
								<td>${bvo.b_idx}</td>							
								<td><a href = "/chapter17_bbs/BBSController?cmd=view&b_idx=${bvo.b_idx}">${bvo.title}</a></td>							
								<td>${bvo.writer}</td>							
								<td>${bvo.reg_date}</td>							
								<td>${bvo.hit}</td>							
							</tr>							
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">게시물이 없습니다.</td>							
						</tr>	
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</div>
</body>
<script type="text/javascript" src = "js/bbs.js"></script>
</html>