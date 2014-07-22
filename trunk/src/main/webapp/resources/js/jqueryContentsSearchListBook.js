(function($) {

	
	
	 /************** 알림창 위치설정 *************/
	
	$(document).ready(function(){
		 
		$(window).scroll(
				function() {
					$(".overCompleted").css('top',	($(document).scrollTop() + 300 + "px"));
					$(".overCompleted").css('width','100%');
					$(".overCompleted").css('left',"-20px");
					
				});
	});
	

/**ScrollTop button PLUG-IN -*/
    smoothScroll.init();


/** 모달윈도우 : 도서 상세 */
			$("#glayLayerBook").click(function() {
				$(this).hide()
				$("#overLayerBook").hide();
				$(".pointText2").val("");

			});

			$("#imgWrapBook,#tableTitleLinkBook").click(function() {
				var scrollTest = $(document).scrollTop();
				$("#overLayerBook").css('top',$(document).scrollTop() + 400 + "px");
				
				$("#glayLayerBook").show();
				$("#overLayerBook").fadeIn("Fast");

				return false;
			});
			$(".exit").click(function() {
				$("#glayLayerBook").hide()
				$("#overLayerBook").hide();
			});


			/** Ajax JSoN 도서*/

					$("#imgWrapBook,#tableTitleLinkBook").click(function() {
						
						var test=$(".statusIndex",(this)).html();

						var formData = {
							name : test,
							data : "Hello"
						};

						$
						.ajax({
							type : "post",
							url : "bookContextJson.do",
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

																		var title = data.book.title;

																		var link = data.book.link;
																		var image = data.book.image;
																		var author = data.book.author;
																		var price = data.book.price;
																		var discount = data.book.discount;
																		var publisher = data.book.publisher;
																		var pubdate = data.book.pubdate;
																		var isbn = data.book.isbn;
																		var description = data.book.description;

																		var naverBg = data.whole.grades.naverBg;
																		var yesBg = data.whole.grades.yesBg;
																		var aladinBg = data.whole.grades.aladinBg;
																		var bandiBg = data.whole.grades.bandiBg;
																		var kyoboBg = data.whole.grades.kyoboBg;

																		var avg = data.whole.avg;
																		$(".avgPoint").text(avg);

																		
																		var authorIntroContent = data.whole.contentBookDetail.authorIntroContent;
																		var bookIntroContent = data.whole.contentBookDetail.bookIntroContent;
																		var poster = data.whole.contentBookDetail.poster;


																		$(".bigPoster").attr("src",poster);
																		$(".smallPoster").attr("src",poster);

																		if(poster==null||poster==""){
																			$(".bigPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
																			$(".smallPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
																		}
																		

																		

																		$(".overTableBookTitle").text(title);
																		$(".overTableAuthor").text(author);
																		$(".overTablePublisher").text(publisher);
																		$(".overTablePubdate").text(pubdate);
																		$(".overTablePrice").text(price);


																		$(".overTableNaver").text(naverBg);
																		$(".overTableYes24").text(yesBg);
																		$(".overTableAladin").text(aladinBg);
																		$(".overTableBandi").text(bandiBg);
																		$(".overTableKyobo").text(kyoboBg);

																		$(".overAuthorInfo").text(authorIntroContent);
																		$(".overSynop").text(bookIntroContent);

																		$("#overButtonBookLink").attr("href",link);
																		

																		var commentList = data.whole.commentList;
																		var content = '<div class="clear"></div><h3 class="overContTitle">코멘트</h3>';
																		

																		var list = commentList;
																				
																		for (var i = 0; i < list.length; i++) {
																					content += '<div class="commentBoxLeft">';
																					content += '<div class="userPhoto">';
																					content += '<a href="userRoomLink.do?memCD=' + list[i].memCD + '" class="userRoomLink">';
																					content += '<img src="' + list[i].imgPath + '">';
																					content += '</a></div>';
																					content += '<div class="commentName">' + list[i].memNm + '</div>';
																					content += '</div>';
																					content += '<div class="commentBoxRight">';
																					content += '<img class="StarPointCompleted" src="/pyongjjeom/resources/img/p' + list[i].memGrade + '.png">';
																					content += '<p class="StarPointCompletedP">' + list[i].memGrade + '점</p>';
																					content += '<div class="clear"></div>';
																					
																					content += '<h3 class="userComment">' + list[i].comment + '</h3>';
																					content += '<h5 class="userDate">' + list[i].formatUpdateDate + '</h5>';
																					content += '</div>';
																					content += '<div class="clear"></div>';
																		}
																		content += '<a href="#" class="commentMore">더보기</a>';
																		$(".overCont3").html(content);


																		var totalComment = data.whole.myComment.comment;
																		
																		if((totalComment == null) || (totalComment=="")){
																			$(".myStarPoint2").show("fast");
																			$(".myStarPoint1").hide("fast");
																			$(".pointModifyWrap").hide();
																			$(".pointText2").removeAttr("disabled");

																		}else{
																			var myStarPoint = data.whole.myComment.memGrade;
																			var myComment = data.whole.myComment.comment;
																			$(".pointText2").attr("disabled","disabled");
																			$(".myStarPointCompleted").attr("src","/pyongjjeom/resources/img/p"+myStarPoint+".png");
																			$(".pointText2").attr("value",myComment);
																			$(".myStarPoint1").show("fast");
																			$(".myStarPoint2").hide("fast");
																			$(".pointModifyWrap").show();
																			$(".pointModifyWrap").animate( { left:'710px' }, 500 );
																		}

																		
																		var myPostCD = data.whole.myComment.postCD;

																		$(".myPostCD").text(myPostCD);

																		$('input[name=starGrade]').removeAttr('value');
																		

																		
																	}
																});
													});

	


					/***********Ajax JSoN : 내 평점 올리기 ************/
					$(".pointSubmit2").click(function() {
						
						
						var pointText=$(".pointText2").val();
						var starGrade=$("#starGrade").val();

						var pointTextLength = pointText.length;
					    var maxLength = 100;
					     
					     if((starGrade == null) || (starGrade == "") || (starGrade == 0)){
					    	 $(".overCompletedP").text("별점을 체크해주세요.");
							 $(".overCompleted").show();
							 $(".overCompleted").fadeOut(2000);
							 return false;
					     }
					     if(pointTextLength <= 0 || pointText==" "){
					    	 alert("testsdfsdsdf32423423432");

					    	 $(".overCompletedP").text("한글자이상 적어주세요.");
							 $(".overCompleted").show();
							 $(".overCompleted").fadeOut(2000);
							 return false;
					     }
					     if(pointTextLength > maxLength){
					    	 $(".overCompletedP").text("100자이내로 작성해주세요.");
							 $(".overCompleted").show();
							 $(".overCompleted").fadeOut(2000);
							 return false;
					     }
						
						


						var formData = {
							name : starGrade,
							data : pointText
						};
						
						$.ajax({
							type : "post",
							url : "postingInsertJson.do",
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
									

									$(".pointText2").attr("disabled","disabled");
								
									$(".myStarPointCompleted").attr("src","/pyongjjeom/resources/img/p"+starGrade+".png");
									$(".myStarPoint1").show("fast");
									$(".myStarPoint2").hide("fast");
									$(".pointModifyWrap").show();
									$(".pointModifyWrap").animate( { left:'710px' }, 500 );

									$(".overCompletedP").text("한줄평이 입력되었습니다!!");
									$(".overCompleted").show();
									$(".overCompleted").fadeOut(2000);
									

									
							}
						});
					});

					/***********Ajax JSoN : 내 평점 삭제하기 ************/
					$(".pointDelete2").click(function() {
						var myPostCD=$(".myPostCD").html();

						var formData = {
							name : myPostCD,
							data : "포스트 코드 전달"
						};
						
						$.ajax({
							type : "post",
							url : "postingDeleteJson.do",
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
								
								$(".pointText2").removeAttr("value").removeAttr("disabled");
								$(".myStarPoint2").show("fast");
								$(".myStarPoint1").hide("fast");
								$(".pointModifyWrap").hide();

								
								$(".overCompletedP").text("한줄평이 삭제되었습니다.");
								$(".overCompleted").show();
								$(".overCompleted").fadeOut(2000);
								
								$('input[name=starGrade]').removeAttr('value');

							}
						});
					});
							
					
					/*******************모달 : 내 평점 수정 버튼 클릭시*********************/
					$("a.pointModify2").click(function() {
						$(".pointText2").removeAttr("disabled");
						$(".myStarPoint2").show("fast");
						$(".myStarPoint1").hide("fast");
						$(".pointModifyWrap").animate( { left:'780px' }, 500 );
						
						
					});
					
					/*******************모달 : 내 평점 확인 버튼 클릭시*********************/
					$("a.pointSubmit2").click(function() {
						 
						
					});
					
					
					
					
	
	
	
})(jQuery);