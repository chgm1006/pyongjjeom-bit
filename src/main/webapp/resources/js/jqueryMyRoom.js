(function($) {
	

		
	 /************** 알림창 위치설정 *************/
	
	$(document).ready(function(){
		 
		$(window).scroll(	function() {
					$(".overCompleted").css('top',	($(document).scrollTop() + 300 + "px"));
					$(".overCompleted").css('width','100%');
					$(".overCompleted").css('left',"-20px");
					
				});
	});

    

	
	
	
	/************** 회원CD 갖고오기 *************/

	var memberMemCD = $(".memberMemCD").html();
	var userMemCD = $(".userMemCD").html();
 

	
	
	 /************** 평점 포인트에 "점" 넣기 *************/

	$(".myStarPointP").append(" 점");
	
	
	 /************** 아코디언 *************/

	$(function() {
		$("dd").css("display", "none");
		$("dl dt").click(function() {
			if ($("+dd", this).css("display") == "none") {
				$("dd").slideUp("fast");
				$("+dd", this).slideDown("fast");
				    
			} else {
				$("+dd", this).slideUp("fast");
			}
		});
	});

/************** 클릭한 포스팅의 댓글 갖고 오기*************/
			$(".listHead").click(function() {

				var postCD=$("#postCD",(this)).html();

				var formData = {
					name : postCD,
					data : "Hello"
				};
				
				$.ajax({
					type : "post",
					url : "myRoomJson.do",
					// 				data : formData,
	 				async : false,
					data : JSON.stringify(formData),
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					beforeSend : function() {
						console.log(formData);
					},
					error : function(e) {
						console.log(e.responseText);
					},
					success : function(data) {

						var replyList = data.replyList;

						var content = '<h3 class="overContTitle">댓글</h3>';
						
						for (var i = 0; i < replyList.length; i++) {
									content += '<div class="commentBoxLeft">';
									content += '<div class="userPhoto">';
									content += '<a href="userRoomLink.do?memCD=' + replyList[i].memCD + '" class="userRoomLink">';
									content += '<img src="' + replyList[i].imgPath + '">';
									content += '</a></div>';
									content += '<div class="commentName">' + replyList[i].memNm + '</div>';

									content += '</div>';
									content += '<div class="commentBoxRight">';
									content += '<div class="clear"></div>';
									content += '<h3 class="userComment">' + replyList[i].reply + '</h3>';
									content += '<h5 class="userDate">' + replyList[i].formatUpdateDate + '</h5>';
									
									content += '</div>';
									
									if(memberMemCD==userMemCD || memberMemCD==replyList[i].memCD){
										content += '<a class="replyDeleteBtn">삭제</a>';
									};
									content += '<p class="replyCD">' + replyList[i].replyCD + '</p>';
									content += '<strong class="replyPostCD">' + postCD + '</strong>';

									content += '<div class="clear"></div>';
						}
						
						$(".overCont3Reply").html(content);
						
						/***********Ajax JSoN : 댓글 삭제 함수 ************/

						
							$(".replyDeleteBtn").click(function() {
								
								var replyCD=$("~p", this).html();

								var replyPostCD=$("~strong", this).html();
								


								var formData = {
									name : replyCD,
									data : replyPostCD
								};
								
								$.ajax({
									type : "post",
									url : "replyDeleteJson.do",
									// 				data : formData,
					 				async : false,
									data : JSON.stringify(formData),
									contentType : "application/json; charset=utf-8",
									dataType : "json",
									beforeSend : function() {
										console.log(formData);
									},
									error : function(e) {
										console.log(e.responseText);
									},
									success : function(data) {
										
										
											$(".overCompletedP").text("댓글이 삭제되었습니다!!");
											$(".overCompleted").show();
											$(".overCompleted").fadeOut(3000);
											
											var replyList = data.replyList;
											
											var content = '<h3 class="overContTitle">댓글</h3>';
													
											for (var i = 0; i < replyList.length; i++) {
														content += '<div class="commentBoxLeft">';
														content += '<div class="userPhoto">';
														content += '<a href="userRoomLink.do?memCD=' + replyList[i].memCD + '" class="userRoomLink">';
														content += '<img src="' + replyList[i].imgPath + '">';
														content += '</a></div>';
														content += '<div class="commentName">' + replyList[i].memNm + '</div>';
														content += '</div>';
														content += '<div class="commentBoxRight">';
														content += '<div class="clear"></div>';
														
														content += '<h3 class="userComment">' + replyList[i].reply + '</h3>';
														content += '<h5 class="userDate">' + replyList[i].formatUpdateDate + '</h5>';
														content += '</div>';
														if(memberMemCD==userMemCD || memberMemCD==replyList[i].memCD){
															content += '<a class="replyDeleteBtn">삭제</a>';
														};
														content += '<p class="replyCD">' + replyList[i].replyCD + '</p>';
														content += '<strong class="replyPostCD">' + postCD + '</strong>';

														content += '<div class="clear"></div>';

											}
											
											$(".overCont3Reply").html(content);
											
											
											/***********Ajax JSoN : 댓글 삭제 함수 ************/

											
											$(".replyDeleteBtn").click(function() {
												
												var replyCD=$("~p", this).html();

												var replyPostCD=$("~strong", this).html();
												


												var formData = {
													name : replyCD,
													data : replyPostCD
												};
												
												$.ajax({
													type : "post",
													url : "replyDeleteJson.do",
													// 				data : formData,
									 				async : false,
													data : JSON.stringify(formData),
													contentType : "application/json; charset=utf-8",
													dataType : "json",
													beforeSend : function() {
														console.log(formData);
													},
													error : function(e) {
														console.log(e.responseText);
													},
													success : function(data) {
														
														
															$(".overCompletedP").text("댓글이 삭제되었습니다!!");
															$(".overCompleted").show();
															$(".overCompleted").fadeOut(3000);
															
															var replyList = data.replyList;
															
															var content = '<h3 class="overContTitle">댓글</h3>';
																	
															for (var i = 0; i < replyList.length; i++) {
																		content += '<div class="commentBoxLeft">';
																		content += '<div class="userPhoto">';
																		content += '<a href="userRoomLink.do?memCD=' + replyList[i].memCD + '" class="userRoomLink">';
																		content += '<img src="' + replyList[i].imgPath + '">';
																		content += '</a></div>';
																		content += '<div class="commentName">' + replyList[i].memNm + '</div>';
																		content += '</div>';
																		content += '<div class="commentBoxRight">';
																		content += '<div class="clear"></div>';
																		
																		content += '<h3 class="userComment">' + replyList[i].reply + '</h3>';
																		content += '<h5 class="userDate">' + replyList[i].formatUpdateDate + '</h5>';
																		content += '</div>';
																		if(memberMemCD==userMemCD || memberMemCD==replyList[i].memCD){
																			content += '<a class="replyDeleteBtn">삭제</a>';
																		};
																		content += '<p class="replyCD">' + replyList[i].replyCD + '</p>';
																		content += '<strong class="replyPostCD">' + postCD + '</strong>';

																		content += '<div class="clear"></div>';

															}
															
															$(".overCont3Reply").html(content);
															
															
															/***********Ajax JSoN : 댓글 삭제 함수 ************/

															
															$(".replyDeleteBtn").click(function() {
																
																var replyCD=$("~p", this).html();

																var replyPostCD=$("~strong", this).html();
																


																var formData = {
																	name : replyCD,
																	data : replyPostCD
																};
																
																$.ajax({
																	type : "post",
																	url : "replyDeleteJson.do",
																	// 				data : formData,
													 				async : false,
																	data : JSON.stringify(formData),
																	contentType : "application/json; charset=utf-8",
																	dataType : "json",
																	beforeSend : function() {
																		console.log(formData);
																	},
																	error : function(e) {
																		console.log(e.responseText);
																	},
																	success : function(data) {
																		
																		
																			$(".overCompletedP").text("댓글이 삭제되었습니다!!");
																			$(".overCompleted").show();
																			$(".overCompleted").fadeOut(3000);
																			
																			var replyList = data.replyList;
																			
																			var content = '<h3 class="overContTitle">댓글</h3>';
																					
																			for (var i = 0; i < replyList.length; i++) {
																						content += '<div class="commentBoxLeft">';
																						content += '<div class="userPhoto">';
																						content += '<a href="userRoomLink.do?memCD=' + replyList[i].memCD + '" class="userRoomLink">';
																						content += '<img src="' + replyList[i].imgPath + '">';
																						content += '</a></div>';
																						content += '<div class="commentName">' + replyList[i].memNm + '</div>';
																						content += '</div>';
																						content += '<div class="commentBoxRight">';
																						content += '<div class="clear"></div>';
																						
																						content += '<h3 class="userComment">' + replyList[i].reply + '</h3>';
																						content += '<h5 class="userDate">' + replyList[i].formatUpdateDate + '</h5>';
																						content += '</div>';
																						if(memberMemCD==userMemCD || memberMemCD==replyList[i].memCD){
																							content += '<a class="replyDeleteBtn">삭제</a>';
																						};
																						content += '<p class="replyCD">' + replyList[i].replyCD + '</p>';
																						content += '<strong class="replyPostCD">' + postCD + '</strong>';

																						content += '<div class="clear"></div>';

																			}
																			
																			$(".overCont3Reply").html(content);
																			

																	}
																});
															});
															

													}
												});
											});
											

									}
								});
							});
							
						
						
						

						
					}//success End
				});
			});
	
/***********Ajax JSoN : 댓글 올리기 ************/
			$(".replyUpload").click(function() {
				
				
				var postCD=$("~p", this).html();
				var pointText=$("+textarea", this).val();

				var pointTextLength = pointText.length;
			    var maxLength = 20;
			     
			     if(pointTextLength <= 0 || pointText==" "){
			    	 $(".overCompletedP").text("한글자이상 적어주세요.");
			    	 
			    	 
					 $(".overCompleted").show();
					 $(".overCompleted").fadeOut(3000);
					 return false;
			     }
			     if(pointTextLength > maxLength){
			    	 $(".overCompletedP").text("20자이내로 작성해주세요.");
					 $(".overCompleted").show();
					 $(".overCompleted").fadeOut(3000);
					 return false;
			     }


				var formData = {
					name : postCD,
					data : pointText
				};
				
				$.ajax({
					type : "post",
					url : "replyInsertJson.do",
					// 				data : formData,
	 				async : false,
					data : JSON.stringify(formData),
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					beforeSend : function() {
						console.log(formData);
					},
					error : function(e) {
						console.log(e.responseText);
					},
					success : function(data) {
						
						    $("textarea").val("");

							$(".overCompletedP").text("댓글이 입력되었습니다!!");
							$(".overCompleted").show();
							$(".overCompleted").fadeOut(3000);
							
							var replyList = data.replyList;
							
							var content = '<h3 class="overContTitle">댓글</h3>';
									
							for (var i = 0; i < replyList.length; i++) {
										content += '<div class="commentBoxLeft">';
										content += '<div class="userPhoto">';
										content += '<a href="userRoomLink.do?memCD=' + replyList[i].memCD + '" class="userRoomLink">';
										content += '<img src="' + replyList[i].imgPath + '">';
										content += '</a></div>';
										content += '<div class="commentName">' + replyList[i].memNm + '</div>';
										content += '</div>';
										content += '<div class="commentBoxRight">';
										content += '<div class="clear"></div>';
										
										content += '<h3 class="userComment">' + replyList[i].reply + '</h3>';
										content += '<h5 class="userDate">' + replyList[i].formatUpdateDate + '</h5>';
										content += '</div>';
										if(memberMemCD==userMemCD || memberMemCD==replyList[i].memCD){
											content += '<a class="replyDeleteBtn">삭제</a>';
										};
										content += '<p class="replyCD">' + replyList[i].replyCD + '</p>';
										content += '<strong class="replyPostCD">' + postCD + '</strong>';

										content += '<div class="clear"></div>';

							}
							
							$(".overCont3Reply").html(content);
							
							$.deleteInfinite();

					}
				});
			});
			
		
	
/***********모달윈도우 내 로그인창**************/
		$(".notLogin").click(function(){
			$(".loginHidden2").attr("display","block");
		});
/************별표*************/
		// simple jRating call
		$(".basic").jRating({
			onClick : function(element, rate) {
				$(".starPoint").text(rate);
				memGrade = rate;
				$('input[name=memGrade]').attr('value', memGrade);
			}
		});

		
		
		// simple jRating call
		$(".basic").jRating({
			onClick : function(element, rate) {
				alert(rate);
				memGrade = rate;
				$('input[name=memGrade]').attr('value', memGrade);
			}
		});
		
		
		
		
/**********************ScrollTop button PLUG-IN******************/
    smoothScroll.init();
			

    
    
    
    
    
    

})(jQuery);