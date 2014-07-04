<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- <form name=setupFirm method=POST action="setEdit.do">
		<div class="setUp">
			<table>
				<tr>
					<td class="item">이름</td>
					<td class="cont"><input type="text" placeholder = 'a'></td>
				</tr>
				<tr>
					<td class="item">이메일</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">생년월일</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">패스워드</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">패스워드 확인</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">내 포스팅 공개여부</td>
					<td class="cont">전체공개 <input type="radio" name="open" value="전체공개">
						친구만 공개<input type="radio" name="open" value="친구만 공개"> 비공개<input
						type="radio" name="open" value="비공개">
					</td>
				</tr>
				<tr>
					<td class="item">내 포스팅 댓글 참여 범위</td>
					<td class="cont">전체허용<input type="radio" name="reply" value="전체허용">
						친구만 허용<input type="radio" name="reply" value="친구만 허용"> 허용안함<input
						type="radio" name="reply" value="허용안함">
					</td>
				</tr>
				<tr>
					<td class="item"><input type="submit" value="수정완료"></td>
					<td class="cont"><input type="submit" value="탈퇴하기"></td>
				</tr>
			</table>
			</div>
			</form> -->



${member }

	<form name=setupFirm method=POST action="upDateMySet.do">
		
			<table>
			
				<tr>
					<td class="item">이름</td>
					<td class="cont"><input type="text" id="memNm" name="memNm" value = "${member.memNm}"></td>
				</tr>
				<tr>
					<td class="item">이메일</td>
					<td class="cont"><input type="text" id="email" name="email" value = "${member.email}"></td>
				</tr>
				<tr>
					<td class="item">생년월일</td>
					<td class="cont"><input type="text" id="birth" name="birth" value = "${member.birth}"></td>
				</tr>
				<tr>
					<td class="item">패스워드</td>
					<td class="cont"><input type="text" id="passwd" name="passwd" value=""></td>
				</tr>
				<tr>
					<td class="item">패스워드 확인</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">내 포스팅 공개여부</td>
					<td class="cont">전체공개 <input type="radio" name="open" value="전체공개">
						친구만 공개<input type="radio" name="open" value="친구만 공개"> 비공개<input
						type="radio" name="open" value="비공개">
					</td>
				</tr>
				<tr>
					<td class="item">내 포스팅 댓글 참여 범위</td>
					<td class="cont">전체허용<input type="radio" name="reply" value="전체허용">
						친구만 허용<input type="radio" name="reply" value="친구만 허용"> 허용안함<input
						type="radio" name="reply" value="허용안함">
					</td>
				</tr>
				<tr>
					<td class="item"><input type="submit" value="수정완료"></td>
					<td class="cont"><input type="submit" value="탈퇴하기"></td>
				</tr>
			</table>
</form>

</body>
</html>