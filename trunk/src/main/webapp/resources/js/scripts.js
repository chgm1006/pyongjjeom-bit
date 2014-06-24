jQuery(document)
		.ready(
				function() {

					/*
					 * Tooltips
					 */
					$('.links a.home').tooltip();
					$('.links a.blog').tooltip();

					/*
					 * Form validation
					 */
					$('.register form')
							.submit(
									function() {
										$(this).find("label[for='firstname']").html('First Name');
										$(this).find("label[for='lastname']").html('Last Name');
										$(this).find("label[for='username']").html('Username');
										$(this).find("label[for='email']").html('Email');
										$(this).find("label[for='password']").html('Password');
										// //
										var firstname = $(this).find('input#firstname').val();
										var lastname = $(this).find('input#lastname').val();
										var username = $(this).find('input#username').val();
										var email = $(this).find('input#email').val();
										var password = $(this).find('input#password').val();
										if (firstname == '') {
											$(this)
													.find("label[for='firstname']")
													.append(
															"<span style='display:none' class='red'> - 이름을 입력하세요.</span>");
											$(this).find("label[for='firstname'] span").fadeIn(
													'medium');
											return false;
										}
										if (lastname == '') {
											$(this)
													.find("label[for='lastname']")
													.append(
															"<span style='display:none' class='red'> - 성을 입력하세요.</span>");
											$(this).find("label[for='lastname'] span").fadeIn(
													'medium');
											return false;
										}
										if (username == '') {
											$(this)
													.find("label[for='username']")
													.append(
															"<span style='display:none' class='red'> - 닉네임을 입력하세요.</span>");
											$(this).find("label[for='username'] span").fadeIn(
													'medium');
											return false;
										}
										if (email == '') {
											$(this)
													.find("label[for='email']")
													.append(
															"<span style='display:none' class='red'> - 이메일을 입력하세요.</span>");
											$(this).find("label[for='email'] span").fadeIn('medium');
											return false;
										}
										if (password == '') {
											$(this)
													.find("label[for='password']")
													.append(
															"<span style='display:none' class='red'> - 비밀번호를 입력하세요.</span>");
											$(this).find("label[for='password'] span").fadeIn(
													'medium');
											return false;
										}
									});

				});
