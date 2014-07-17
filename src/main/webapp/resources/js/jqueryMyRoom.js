(function($) {
	
	
	$(".myStarPointP").append(" 점");

	

/**************상세 슬라이드 다운*************/
			$("dd").css("display", "none");
			$("dl dt").click(function() {
				
				alert("start");
				var test=$("#postCD",(this)).html();
				alert(test);

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
						alert("success");
						
					}//success End
				});
				
				
				
				
				
				
				
				
				

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
			


})(jQuery);