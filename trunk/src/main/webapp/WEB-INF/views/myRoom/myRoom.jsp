<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>my Room</title>

<link href="${pageContext.request.contextPath}/resources/css/default1.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/myroom.css" rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.carouFredSel-6.2.1-packed.js"></script>
<script type="text/javascript">
	$(function() {
		$("#upLoadButton,.close").click(function() {
			if ($(".upLoad").css("display") == "block") {
				$(".upLoad:not(:animated)").slideUp("slow");
			} else {
				$(".upLoad").slideDown("slow");
			}
		});
	});
</script>
<script type="text/javascript">
	$(function() {

		$("#glayLayer2").click(function() {
			$(this).hide()
			$("#overLayer2").hide();
			$("#overLayer3").hide();
		});

		$("#setUpButton").click(function() {
			$("#glayLayer2").show();
			$("#overLayer2").fadeIn("Fast");
			return false;
		});
		$("#setUpButton").click(function() {
			$("#glayLayer2").show();
			$("#overLayer2").fadeIn("Fast");
			return false;
		});
		$(".exit").click(function() {
			$("#glayLayer2").hide()
			$("#overLayer2").hide();
		});

		if ($.browser.msie && $.browser.version < 7) {
			$(window).scroll(
					function() {
						$("#glayLayer2").css('top', $(document).scrollTop());
						$("#overLayer2").css(
								'top',
								($(document).scrollTop() + $("#overLayer2").height() / 2)
										+ "px");
					});
		}
	});
</script>


<!----------�� �����̵� �ٿ�---------->
<script type="text/javascript">
	$(function() {
		$("dd").css("display", "none");
		$("dl dt").click(function() {
			if ($("+dd", this).css("display") == "none") {
				$("+dd", this).slideDown("slow");
			} else {
				$("+dd", this).slideUp("slow");
			}
		});
	});
</script>
</head>

<body>

	<div class="myPageWrap">

		<div class="menu">
			<ul>
				<li class="boardMenu"><a class="myPageMenu" id="setUpButton" href="#" OnClick="window.location='setEdit.do'">����</a></li>
				<li class="boardMenu"><a class="myPageMenu" id="upLoadButton" href="#">�����ø���</a></li>
				<li class="boardMenu"><a href = "logout.do" class="boardMenu_1">�α׾ƿ�</a></li>
			</ul>
		</div>


		<div class="upLoad">
			<a href="#" class="close"></a>
			<div class="title2">���� �ø���</div>
			<div class="upLoadSearch">
				<select>
					<option>��ȭ</option>
					<option>����</option>
					<option>����</option>
				</select> <input type="text"> <input type="submit" value="�˻�">
			</div>
			<div class="upLoadCont">
				<table>
					<tr>
						<td>���� ����</td>
						<td>��ǥ</td>
					</tr>
					<tr>
						<td>���� ������</td>
						<td><input type="text" style="width: 500px"></td>
					</tr>
				</table>
				<input type="text" class="upLoadText"><br> <input type="submit"
					class="upLoadStart" value="�ۿø���">
			</div>

		</div>

		<div class="title2">���� �ø� ����Ʈ</div>


		<div class="postingList">
			<dl>
				<dt class="listHead">

					<div class="list1">
						<a href="#" class="listImgLink"><img src="img/07.jpg" class="listImg"></a>
						<div class="detail">
							<table>
								<tr>
									<td class="listTitle1" colspan="2">�̳�� �߼�</td>
								</tr>
								<tr>
									<td class="listTitle">���� ����</td>
									<td class="listDirectorValue">��ǥ��ǥ</td>
								</tr>
								<tr>
									<td class="listTitle">������</td>
									<td class="listActorValue">�̰��� �������Դϴ�.</td>
								</tr>
								<tr>
									<td class="listTitle">���� �ı�</td>
									<td class="listSynopValue">����� �̷�, �̹��̶� �Ҹ��� �ܰ� ������ ħ������ �η��� ��� ���⸦
										�´´�. �� ������ (�� ũ����)�� �ڻ� �����̳� �ٸ����� ������ �Ʒ��̳� ��� ����� ������ ���� ���·� �����ǰ� ������
										�������ڸ��� ������ �´´�. ������ �Ұ����� ���� �Ͼ��. �װ� �ٽ� �� ������ ���� ���۵� �ð��� �ٽ� ��� �ٽ� ������
										�����ϰ� �ǰ� �ٽ� �׾��ٰ� �� �ٽ� ��Ƴ��� ��. �ܰ��ΰ��� �������� ���� �ð��븦 �ݺ��ؼ� �ް� �Ǵ� Ÿ�� ������ ������
										�� ���̴�.</td>
								</tr>
							</table>
							<div class="PostingReply">��� 2��</div>
						</div>

					</div>
				</dt>
				<dd class="listContent">

					<h3>�ڸ�Ʈ</h3>
					<br>
					<div class="commentBox">
						<div class="userPhoto">
							<a href="#" class="userRoom"><img src="img/user1.jpg"></a><br>����
						</div>
						<div class="triangle"></div>
						<div class="rectangle">
							<h3>���� �� ��ȭ �ô�.</h3>
							<h5>2014.06.19</h5>
						</div>
						<a href="#" class="commentDel">����</a>
					</div>
					<div class="clear"></div>
					<div class="commentBox">
						<div class="userPhoto">
							<a href="#" class="userRoom"><img src="img/user1.jpg"></a><br>����
						</div>
						<div class="triangle"></div>
						<div class="rectangle">
							<h3>���� �� ��ȭ �ô�.</h3>
							<h5>2014.06.19</h5>
						</div>
						<a href="#" class="commentDel">����</a>
					</div>
					<div class="clear"></div>
					<a href="#" class="commentMore">������</a>
				</dd>
				<dt class="listHead">

					<div class="list1">
						<a href="#" class="listImgLink"><img src="img/07.jpg" class="listImg"></a>
						<div class="detail">
							<table>
								<tr>
									<td class="listTitle1" colspan="2">�̳�� �߼�</td>
								</tr>
								<tr>
									<td class="listTitle">���� ����</td>
									<td class="listDirectorValue">��ǥ��ǥ</td>
								</tr>
								<tr>
									<td class="listTitle">������</td>
									<td class="listActorValue">�̰��� �������Դϴ�.</td>
								</tr>
								<tr>
									<td class="listTitle">���� �ı�</td>
									<td class="listSynopValue">����� �̷�, �̹��̶� �Ҹ��� �ܰ� ������ ħ������ �η��� ��� ���⸦
										�´´�. �� ������ (�� ũ����)�� �ڻ� �����̳� �ٸ����� ������ �Ʒ��̳� ��� ����� ������ ���� ���·� �����ǰ� ������
										�������ڸ��� ������ �´´�. ������ �Ұ����� ���� �Ͼ��. �װ� �ٽ� �� ������ ���� ���۵� �ð��� �ٽ� ��� �ٽ� ������
										�����ϰ� �ǰ� �ٽ� �׾��ٰ� �� �ٽ� ��Ƴ��� ��. �ܰ��ΰ��� �������� ���� �ð��븦 �ݺ��ؼ� �ް� �Ǵ� Ÿ�� ������ ������
										�� ���̴�.</td>
								</tr>
							</table>
							<div class="PostingReply">��� 2��</div>
						</div>

					</div>
				</dt>
				<dd class="listContent">

					<h3>�ڸ�Ʈ</h3>
					<br>
					<div class="commentBox">
						<div class="userPhoto">
							<a href="#" class="userRoom"><img src="img/user1.jpg"></a><br>����
						</div>
						<div class="triangle"></div>
						<div class="rectangle">
							<h3>���� �� ��ȭ �ô�.</h3>
							<h5>2014.06.19</h5>
						</div>
						<a href="#" class="commentDel">����</a>
					</div>
					<div class="clear"></div>

					<a href="#" class="commentMore">������</a>
				</dd>
			</dl>
		</div>

		<a href="#" class="listMore">������</a>

	</div>



	<!-- <div id='glayLayer2'></div>
	<div id='overLayer2'>

		<a href="#" class="exit"></a>
		<form name=setupFirm method=POST action="setEdit.do">
		<div class="setUp">
			<table>
				<tr>
					<td class="item">�̸�</td>
					<td class="cont"><input type="text" placeholder = 'a'></td>
				</tr>
				<tr>
					<td class="item">�̸���</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">�������</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">�н�����</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">�н����� Ȯ��</td>
					<td class="cont"><input type="text"></td>
				</tr>
				<tr>
					<td class="item">�� ������ ��������</td>
					<td class="cont">��ü���� <input type="radio" name="open" value="��ü����">
						ģ���� ����<input type="radio" name="open" value="ģ���� ����"> �����<input
						type="radio" name="open" value="�����">
					</td>
				</tr>
				<tr>
					<td class="item">�� ������ ��� ���� ����</td>
					<td class="cont">��ü���<input type="radio" name="reply" value="��ü���">
						ģ���� ���<input type="radio" name="reply" value="ģ���� ���"> ������<input
						type="radio" name="reply" value="������">
					</td>
				</tr>
				<tr>
					<td class="item"><input type="submit" value="�����Ϸ�"></td>
					<td class="cont"><input type="submit" value="Ż���ϱ�"></td>
				</tr>
			</table>


		</div>

	</div>


 -->
</body>
</html>
