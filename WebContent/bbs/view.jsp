<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   div {
      width: 800px;
      margin: auto;
      text-align: center;
   }
   table {
      width: 800px;
      text-align: left;
      border-collapse: collapse;      
   }
   
   td,th {
      border : 1px solid #1e90ff;
      padding: 10px;   
   }
   
   th {
      width: 130px;
      text-align: center;
      background-color: #0078ff;
      color: white;
   }
   #btn {
   text-align: center;
   }
   
   h1 {
      color : #0078ff;   
   }
   textarea {
      resize: none;
   }
   img{
      width: 15px;
      cursor: pointer;
   }
</style>
</head>
<body>
   <div>
      <h1>${bvo.b_idx }번 게시글</h1>
      <form method="post">
         <table class="bbs">
            <tbody>
               <tr>
                  <th>작성자</th>
                  <td>${bvo.writer }</td>
                  <th>IP</th>
                  <td>${bvo.ip }</td>
               </tr>
               <tr>
	              <th>비밀번호</th>
				  <td colspan="3"><input type="password" name = "pw" id = "user_pw"></td>               
               </tr>
               <tr>
                  <th>제목</th>
                  <td colspan="3">${bvo.title }</td>
               </tr>
               <tr>
                  <th>첨부파일</th>
                  <td colspan="3">
                     <c:choose>
                        <c:when test="${bvo.filename eq null }">
                           첨부파일 없음
                        </c:when>
                        <c:otherwise>
                           <a id="download" href="${bvo.filename }">${bvo.filename }</a>
                        </c:otherwise>
                     </c:choose>
                  </td>
               </tr>
               <tr>
                  <th>내용</th>
                  <td colspan="3">${bvo.content}</td>
               </tr>
               <tr>
                  <td colspan="4" id="btn">
                     <input type="button" value="게시글 수정하기" onclick="updateBBS('${bvo.pw }')">&nbsp;&nbsp;
                     <input type="button" value="게시글 삭제하기" onclick="removeBBS('${bvo.b_idx }' ,'${bvo.pw }')">&nbsp;&nbsp;
                     <input type="button" value="목록으로 이동" onclick="view_all()">
                  </td>
               </tr>
            </tbody>
         </table>
      </form>
      
      <br/><hr/><br/>
   </div>
</body>
<script type="text/javascript" src="js/bbs.js"></script>
<script type="text/javascript" src="js/download.js"></script>
</html>