<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
   div{
      width: 800px;
      margin: auto;
   }
   h2{
      text-align: center;
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
      width: 15%;
   }
   input[type='text'], input[type='password']{
      width: 80%;
   }
   textarea{
      resize: none;
   }
   #btn{
      text-align: center;
   }
   .readonly{
      background-color: lightgray;
   }
</style>
<script type="text/javascript" src = 'js/bbs.js'></script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>BBS 게시글 작성</h2>
		<form method="post" enctype = "multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>
							작성자
						</th>
						<td>
							<input type = "text" name = "writer">
						</td>
					</tr>
					<tr>
						<th>
							제목
						</th>
						<td>
							<input type = "text" name = "title">
						</td>
					</tr>
					<tr>
						<th>
							비밀번호
						</th>
						<td>
							<input type = "password" name = "pw">
						</td>
					</tr>
					<tr>
						<th>
							첨부 파일
						</th>
						<td>
							<input type = "file" name = "filename">
						</td>
					</tr>
					<tr>
						<th>
							내용
						</th>
						<td>
							<textarea rows="10" cols="80" name = "content" placeholder = "내용을 입력하세요."></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" id = "btn">
							<input type = "button" value = "게시글 저장" onclick="insert(this.form)">
							<input type = "reset" value = "초기화"> &nbsp;&nbsp;
							<input type = "button" value = "목록으로 이동" onclick="view_all()">
							<input type = "hidden" name="cmd" value="insertBBS"> 
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>
