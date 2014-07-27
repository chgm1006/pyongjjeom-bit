jQuery(document)
		.ready(
				function() {
					$("form")
							.submit(
									function() {
										$(this).find("label[for='email']").html('이메일');
										$(this).find("label[for='password']").html('비밀번호');

										var email = $(this).find('input#email').val();
										var password = $(this).find('input#passwd').val();
										var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

										if (email == '') {
											$(this).find("label[for='email']").append(
													"<span style='display:none' class='red'> - 이메일을 입력하세요.</span>");
											$(this).find("label[for='email'] span").fadeIn('medium');
											$("#email").focus();
											return false;
										} else if (!regEmail.test(email)) {
											$(this).find("label[for='email']").append(
													"<span style='display:none' class='red'> - 이메일 형식에 맞지 않습니다..</span>");
											$(this).find("label[for='email'] span").fadeIn('medium');
											$("#email").focus();
											return false;
										}
										if (password == '') {
											$(this).find("label[for='password']").append(
													"<span style='display:none' class='red'> - 비밀번호를 입력하세요.</span>");
											$(this).find("label[for='password'] span").fadeIn('medium');
											$("#passwd").focus();
											return false;
										}

									});

				});