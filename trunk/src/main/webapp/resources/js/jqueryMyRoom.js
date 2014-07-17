(function($) {
	
	
	$(".myStarPointP").append(" 점");

	

/**************상세 슬라이드 다운*************/
			$("dd").css("display", "none");
			$("dl dt").click(function() {
				if ($("+dd", this).css("display") == "none") {
					$("+dd", this).slideDown("slow");
				} else {
					$("+dd", this).slideUp("slow");
				}
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
			
	/*******************Ajax JSoN 내 평점 상세 페이지*********************/
		$(".listHead").click(function() {
			var test=$(".postCD",(this)).html();

			var formData = {
				name : test,
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
					
					var commentList = data.whole.commentList;
					var content = '<br><h3 class="overContTitle">댓글</h3>';
					

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
					
					var myComment = data.whole.myComment.comment;
					$(".pointText").attr("value",myComment);
					if(myComment == null){
						$(".pointText").removeAttr("disabled");
					}else{
						$(".pointText").attr("disabled","disabled");
					}
					
					var myStarPoint = data.whole.myComment.memGrade;
					$(".starPoint").text(myStarPoint);
					if(myStarPoint == null){
						$(".myStarPoint2").show("fast");
						$(".myStarPoint1").hide("fast");
						$(".pointModifyWrap").hide();

					}else{
						
						$(".myStarPointCompleted").attr("src","/pyongjjeom/resources/img/p"+myStarPoint+".png");
						$(".myStarPoint1").show("fast");
						$(".myStarPoint2").hide("fast");
						$(".pointModifyWrap").attr("left","710px");
					}
					
					
					var myPostCD = data.whole.myComment.postCD;
					$(".myPostCD").text(myPostCD);

					
				}//success End
			});
		});


})(jQuery);