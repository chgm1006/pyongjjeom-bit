(function($) {


/**슬라이드이미지 롤오버*/
			$(".quickImg").mouseenter(function() {
				$(this).attr("src","${pageContext.request.contextPath}/resources/img/forTop2.png");
			});
			$(".quickImg").mouseleave(function() {
				$(this).attr("src","${pageContext.request.contextPath}/resources/img/forTop1.png");
			});

/**ScrollTop button PLUG-IN -*/
    smoothScroll.init();




	/** 이미지 좌우 슬라이드 PLUG-IN */


	/**이미지 좌우 슬라이드 */

			//	Variable number of visible items with variable sizes
			$('#foo3').carouFredSel({
				width : 830,
				height : 480,
				prev : '#prev3',
				next : '#next3',
				auto : false
			});

/** 슬라이드이미지 롤오버  */
			$(".imgLink").mouseenter(function() {
				$(".innerOver", this).fadeIn();
				$(".innerOver2", this).fadeIn();
			});
			$(".imgLink").mouseleave(function() {
				$(".innerOver").hide();
				$(".innerOver2").hide();
			});

/** 예고편 슬라이드 다운  */
			$("#overButtonPreview").click(function() {
				$(".overPreviewWrap").slideDown();
			});



/** 모달윈도우 : 도서 상세 */
			$("#glayLayerBook").click(function() {
				$(this).hide()
				$("#overLayerBook").hide();
			});

			$(".imgLink,.imgWrap,#tableTitleLinkBook").click(function() {
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


/**Ajax JSoN 도서*/

		$(".imgLink,.imgWrap,#tableTitleLinkBook").click(function() {
			var test=$(".statusIndex",(this)).html();

			var formData = {
				name : test,
				data : "Hello"
			};

			$
			.ajax({
				type : "post",
				url : "currentBookContextJson.do",
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


	
	
	
	
	
	
	
})(jQuery);