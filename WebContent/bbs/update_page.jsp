<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   div{
      width: 800px;
      margin: auto;
   }
   table{
      width: 100%;
      text-align: left;
      border-collapse: collapse;
   } 
   td,th{
      border: 1px solid #1e90ff;
      padding: 10px;
   }
   th{
      background-color: #0078ff;
      color: #fff;
      text-align: center;
   }
   #btn, h1{
      text-align: center;
   }
</style>
</head>
<body>
   <div>
      <h1>${bvo.b_idx }번 게시글 수정</h1>
      <form method="post" enctype="multipart/form-data">
         <table>
            <tbody>
               <tr>
                  <th>작성자</th>
                  <td>${bvo.writer }<input type="hidden" name="writer" value="${bvo.writer }"></td>
               </tr>
               <tr>
                  <th>제목</th>
                  <td><input type="text" name="title" value="${bvo.title}" size="80"></td>
               </tr>
               <tr>
                  <th>비밀번호</th>
                  <td><input type="password" name="pw" size="80"></td>
               </tr>
               <tr>
                  <th>첨부파일</th>
                  <td>
                     <input type="file" name="filename">
                     <c:choose>
                        <c:when test="${bvo.filename eq null }">
                           [ 기존 첨부 파일 : 없음 ]
                        </c:when>
                        <c:otherwise>
                           [ 기존 첨부 파일 : ${bvo.filename } ]
                           <input type="hidden" name="oldFile" value="${bvo.filename }">
                        </c:otherwise>
                     </c:choose>
                  </td>
               </tr>
               <tr>
                  <th>내용</th>
                  <td>
                     <textarea rows="10" cols="80" name="content">${bvo.content }</textarea>
                  </td>
               </tr>
               <tr>
                  <td colspan="2" id="btn">
                     <input type="button" value="게시글 수정" onclick="update(this.form, '${bvo.pw}')">&nbsp;&nbsp;
                     <input type="reset" value="다시 작성">&nbsp;&nbsp;
                     <input type="button" value="목록으로 이동" onclick="viewAll()">
                     <input type="hidden" name="cmd" value="update">
                     <input type="hidden" name="b_idx" value="${bvo.b_idx}">
                  </td>
               </tr>
            </tbody>
         </table>
      </form>
   </div>
</body>
<script type="text/javascript" src="js/bbs.js"></script>
</html>
