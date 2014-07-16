(function($) {
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
/***********Ajax JSoN 별표************/
		$(".pointSubmit").click(function() {
			var starPoint=$(".starPoint").html();
			var pointText=$(".pointText").val();

			alert(starPoint);
			alert(pointText);
			var formData = {
				name : starPoint,
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
					$(".pointText").attr("disabled","disabled");
					alert("success");

				}
			});
		});
		
		/******************Quick TOP  롤오버***********************/
		$(function() {
			$(".quickImg").mouseenter(function() {
				$(this).attr("src","${pageContext.request.contextPath}/resources/img/forTop2.png");
			});
			$(".quickImg").mouseleave(function() {
				$(this).attr("src","${pageContext.request.contextPath}/resources/img/forTop1.png");
			});
		});
/**********************ScrollTop button PLUG-IN******************/
    smoothScroll.init();

/********************이미지 좌우 슬라이드********************/
			$('#foo3').carouFredSel({
				width : 1030,
				height : 480,
				prev : '#prev3',
				next : '#next3',
				auto : false
			});
	/*******************슬라이드이미지 롤오버*********************/
			$(".imgLink").mouseenter(function() {
				$(".innerOver", this).fadeIn();
				$(".innerOver2", this).fadeIn();
			});
			$(".imgLink").mouseleave(function() {
				$(".innerOver").hide();
				$(".innerOver2").hide();
			});
	/******************모달 내부 : 예고편 슬라이드 다운**********************/
			$("#overButtonPreview").click(function() {
				$(".overPreviewWrap").slideDown("slow");
			});
	/******************모달윈도우 : 컨텐츠 상세**********************/	
			$("#glayLayer").click(function() {
				$(this).hide()
				$("#overLayer").hide();
				$(".overPreviewWrap").css("display","none");
				$(".pointText").val("");
			});

			$(".imgLink,#imgWrapMovie,#tableTitleLinkMovie").click(function() {
				var scrollTest = $(document).scrollTop();
				$("#overLayer").css('top',scrollTest + 400 + "px");

				$("#glayLayer").show();
				$("#overLayer").fadeIn("Fast");
				return false;
			});
			$(".exit").click(function() {
				$("#glayLayer").hide()
				$("#overLayer").hide();
			});

			if ($.browser.msie && $.browser.version < 7) {
				$(window).scroll(
						function() {
							$("#glayLayer").css('top', $(document).scrollTop());
							$("#overLayer").css(
									'top',
									($(document).scrollTop() + $("#overLayer").height() / 2)
											+ "px");
						});
			}
	/*******************Ajax JSoN 영화*********************/
		$(".imgLink,#imgWrapMovie,#tableTitleLinkMovie").click(function() {
			var test=$(".statusIndex",(this)).html();

			var formData = {
				name : test,
				data : "Hello"
			};
			
			$.ajax({
				type : "post",
				url : "currentMovieContextJson.do",
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
					
					var genre = data.whole.contentMovieDetail.genre;
					var nation = data.whole.contentMovieDetail.nation;
					var open = data.whole.contentMovieDetail.open;
					var grade = data.whole.contentMovieDetail.grade;
					var count = data.whole.contentMovieDetail.count;
					var context = data.whole.contentMovieDetail.context;
					var grades = data.whole.contentMovieDetail.grades;
					var video = data.whole.contentMovieDetail.video;
					
					
					var poster = data.whole.contentMovieDetail.poster;
					
					var title = data.movie.title;
					var code = data.movie.code;

					var link = data.movie.link;
					var subtitle = data.movie.subtitle;
					var pubDate = data.movie.pubDate;
					var director = data.movie.director;
					var actor = data.movie.actor;
					var userRating = data.movie.userRating;
					
					var naverMg = data.whole.grades.naverMg;
					var daumMg = data.whole.grades.daumMg;
					var cgvMg = data.whole.grades.cgvMg;
					var lotteMg = data.whole.grades.lotteMg;
					var megaBoxMg = data.whole.grades.megaBoxMg;
					
					var avg = data.whole.avg;					
					$(".avgPoint").text(avg);


					$(".bigPoster").attr("src",poster);
					$(".smallPoster").attr("src",poster);
					
					if(poster==null||poster==""){
						$(".bigPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
						$(".smallPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
					}
					
					$(".overTableMovieTitle").text(title + " " +pubDate);
					$(".overTableMovieTitle").append(code);
					$(".overTableSubtitle").text(subtitle +"  "+ genre +" | "+ nation +" | "+ open);
					$(".overTableDirector").text(director);
					$(".overTableActor").text(actor);
					
					$(".overTableNaver").text(userRating);
					$(".overTableDaum").text(daumMg);
					$(".overTableCGV").text(cgvMg);
					$(".overTableMega").text(megaBoxMg);
					$(".overTableLotte").text(lotteMg);

					$(".overSynop").text(context);
					$("#overButtonLink").attr("href",link);
					
					
					$("#overButtonPreview").click(function() {
						$(".previewIframe").attr("src",video);
							});
					$("#glayLayer,.exit").click(function() {
						$(".previewIframe").attr("src","");
							});

					
					var commentList = data.whole.commentList;
					var content = '<h3 class="overContTitle">코멘트</h3>';
					

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
								content += '<h3 class="userComment">' + list[i].comment + '</h3>';
								content += '<h5 class="userDate">' + list[i].formatUpdateDate + '</h5>';
								content += '</div>';
								content += '<div class="clear"></div>';
					}
					content += '<a href="#" class="commentMore">더보기</a>';
					$(".overCont3").html(content);
					
					var myComment = data.whole.myComment.comment;
					$(".pointText").attr("value",myComment);
					$(".myPointText").text(myComment);

				}//success End
			});
		});
/*********************Ajax JSoN : My 평점 올리기*******************/

		$(".imgLink,#imgWrapMovie,#tableTitleLinkMovie").click(function() {
			var test=$(".statusIndex",(this)).html();

			var formData = {
				name : test,
				data : "Hello"
			};
			
			$.ajax({
				type : "post",
				url : "currentMovieContextJson.do",
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
					
					var genre = data.whole.contentMovieDetail.genre;
					var nation = data.whole.contentMovieDetail.nation;
					var open = data.whole.contentMovieDetail.open;
					var grade = data.whole.contentMovieDetail.grade;
					var count = data.whole.contentMovieDetail.count;
					var context = data.whole.contentMovieDetail.context;
					var grades = data.whole.contentMovieDetail.grades;
					var video = data.whole.contentMovieDetail.video;
					
					
					var poster = data.whole.contentMovieDetail.poster;
					
					var title = data.movie.title;
					var code = data.movie.code;

					var link = data.movie.link;
					var subtitle = data.movie.subtitle;
					var pubDate = data.movie.pubDate;
					var director = data.movie.director;
					var actor = data.movie.actor;
					var userRating = data.movie.userRating;
					
					var naverMg = data.whole.grades.naverMg;
					var daumMg = data.whole.grades.daumMg;
					var cgvMg = data.whole.grades.cgvMg;
					var lotteMg = data.whole.grades.lotteMg;
					var megaBoxMg = data.whole.grades.megaBoxMg;
					
					var avg = data.whole.avg;					
					$(".avgPoint").text(avg);

				

					$(".bigPoster").attr("src",poster);
					$(".smallPoster").attr("src",poster);
					
					if(poster==null||poster==""){
						$(".bigPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
						$(".smallPoster").attr("src","${pageContext.request.contextPath}/resources/img/ready.jpg");
					}
					
					$(".overTableMovieTitle").text(title + " " +pubDate);
					$(".overTableMovieTitle").append(code);
					$(".overTableSubtitle").text(subtitle +"  "+ genre +" | "+ nation +" | "+ open);
					$(".overTableDirector").text(director);
					$(".overTableActor").text(actor);
					
					$(".overTableNaver").text(userRating);
					$(".overTableDaum").text(daumMg);
					$(".overTableCGV").text(cgvMg);
					$(".overTableMega").text(megaBoxMg);
					$(".overTableLotte").text(lotteMg);

					$(".overSynop").text(context);
					$("#overButtonLink").attr("href",link);
					
					
					$("#overButtonPreview").click(function() {
						$(".previewIframe").attr("src",video);

							});
					$("#glayLayer,.exit").click(function() {
						$(".previewIframe").attr("src","");

							});

				}
			});
		});
/*******************모달 : 내 평점 수정하기*********************/
			$(".pointModify,.pointText").click(function() {
				$(".pointText").removeAttr("disabled");
			});
			
})(jQuery);