(function($) {
	
	
	$(".myStarPointP").append(" 점");



/**************상세 슬라이드 다운*************/
			$("dd").css("display", "none");
			$("dl dt").click(function() {
				
				var test=$("#postCD",(this)).html();

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

						var replyList = data.replyList;
						var content = '<br><h3 class="overContTitle">댓글</h3>';

								
						for (var i = 0; i < replyList.length; i++) {
									content += '<div class="commentBoxLeft">';
									content += '<div class="userPhoto">';
									content += '<a href="userRoomLink.do?memCD=' + replyList[i].memCD + '" class="userRoomLink">';
									content += '<img src="' + replyList[i].imgPath + '">';
									content += '</a></div>';
									content += '<div class="commentName">' + replyList[i].memNm + '</div>';
									content += '</div>';
									content += '<div class="commentBoxRight">';
									content += '<p class="replyCD">' + replyList[i].replyCD + '</p>';
									content += '<div class="clear"></div>';
									
									content += '<h3 class="userComment">' + replyList[i].reply + '</h3>';
									content += '<h5 class="userDate">' + replyList[i].formatUpdateDate + '</h5>';
									content += '</div>';
									content += '<div class="clear"></div>';
						}
						
						$(".overCont3Reply").html(content);


						
						
						
					}//success End
				});
				
				
				
				$("dl dt").click(function(){
					if($("+dd",this).css("display")=="none"){
						$("dd").slideUp("fast");
						$("+dd",this).slideDown("fast");
						$("dt").removeClass("selected");
						$(this).addClass("selected");
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