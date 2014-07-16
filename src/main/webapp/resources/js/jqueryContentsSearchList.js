(function($) {



/** Quick TOP  롤오버  */
			$(".quickImg").mouseenter(function() {
				$(this).attr("src","${pageContext.request.contextPath}/resources/img/forTop2.png");
			});
			$(".quickImg").mouseleave(function() {
				$(this).attr("src","${pageContext.request.contextPath}/resources/img/forTop1.png");
			});


/**ScrollTop button PLUG-IN */

    smoothScroll.init();


/**모달 내부 : My 평점, 예고편 슬라이드 다운  */
			$("#overButtonPreview").click(function() {
				$(".overPreviewWrap").slideDown("slow");
			});
			$("#overButtonPoint").click(function() {
					$(".overPointWrap").toggle("slow");
			});

/** Ajax JSoN 영화*/

		$("#imgWrapMovie,#tableTitleLinkMovie").click(function() {
			var test=$(".statusIndex",(this)).html();

			var formData = {
				name : test,
				data : "Hello"
			};
			
			$.ajax({
				type : "post",
				url : "movieContextJson.do",
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
															
															
															
														}
													});
										});


/** 모달윈도우 : 영화 상세 */
			$("#glayLayer").click(function() {
				$(this).hide()
				$("#overLayer").hide();
				$("#overLayerBook").hide();
				$(".overPreviewWrap").css("display","none");
			});

			$("#imgWrapMovie,#tableTitleLinkMovie").click(function() {
				var scrollTest = $(document).scrollTop();
				$("#overLayer").css('top',$(document).scrollTop() + 400 + "px");
				
				$("#glayLayer").show();
				$("#overLayer").fadeIn("Fast");
				return false;
			});
			$("#imgWrapBook,#tableTitleLinkBook").click(function() {
				var scrollTest = $(document).scrollTop();
				$("#overLayerBook").css('top',$(document).scrollTop() + 400 + "px");
				
				$("#glayLayer").show();
				$("#overLayerBook").fadeIn("Fast");
				return false;
			});
			$(".exit").click(function() {
				$("#glayLayer").hide()
				$("#overLayer").hide();
				$("#overLayerBook").hide();
			});
			
			

	
	
})(jQuery);