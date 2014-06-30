jQuery(document)
		.ready(

				function() {
					$("#birth").datepicker(
							{
								dateFormat : 'yymmdd',
								prevText : '이전 달',
								changeYear : true,
								changeMonth : true,
								nextText : '다음달',
								yearRange : '-100y',
								monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
										'8월', '9월', '10월', '11월', '12월' ],
								dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
								dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
								showMonthAfterYear : true,
								showAnim : "slide", // 애니메이션을 적용한다.
								yearSuffix : '년',
								showAnim : 'slideDown',
							});

					$('.links a.home').tooltip();
					$('.links a.blog').tooltip();

					/*
					 * Form validation
					 */
					$('.register form')
							.submit(
									function() {
										$(this).find("label[for='email']").html('Email');
										$(this).find("label[for='name']").html('Name');
										$(this).find("label[for='birth']").html('Birth');
										$(this).find("label[for='password']").html('Password');
										$(this).find("label[for='password_check']").html('Password_check');
										// //
										var email = $(this).find('input#email').val();
										var name = $(this).find('input#name').val();
										var birth = $(this).find('input#birth').val();
										var password = $(this).find('input#password').val();
										var password_check = $(this).find('input#password_check').val();
										// 이메일 유효성 검사
										var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
										
										if (email == '') {
											$(this)
													.find("label[for='email']")
													.append(
															"<span style='display:none' class='red'> - 이메일을 입력하세요.</span>");
											$(this).find("label[for='email'] span").fadeIn('medium');
											return false;
										}else if(!regEmail.test(email)){
											$(this)
											.find("label[for='email']")
											.append(
													"<span style='display:none' class='red'> - 이메일 형식에 맞지 않습니다..</span>");
									$(this).find("label[for='email'] span").fadeIn('medium');
									return false;
										}
										if (name == '') {
											$(this)
													.find("label[for='name']")
													.append(
															"<span style='display:none' class='red'> - 이름을 입력하세요.</span>");
											$(this).find("label[for='name'] span").fadeIn('medium');
											return false;
										}

										if (birth == '') {
											$(this)
													.find("label[for='birth']")
													.append(
															"<span style='display:none' class='red'> - 생일입력.</span>");
											$(this).find("label[for='birth'] span").fadeIn('medium');
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
										if (password_check == '') {
											$(this)
													.find("label[for='password_check']")
													.append(
															"<span style='display:none' class='red'> - 비밀번호를 입력하세요.</span>");
											$(this).find("label[for='password_check'] span").fadeIn(
													'medium');
											return false;
										} else if (password_check != password) {
											$(this)
													.find("label[for='password_check']")
													.append(
															"<span style='display:none' class='red'> - 비밀번호가 틀립니다.</span>");
											$(this).find("label[for='password_check'] span").fadeIn(
													'medium');
											return false;
										}
									});

				});
