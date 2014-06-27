<!--------- 모달윈도우 : 컨텐츠 상세 -------->
<script type="text/javascript">
	$(function() {
		$("#glayLayer").click(function() {
			$(this).hide()
			$("#overLayer").hide();
		});

		$("a.imgLink, a.listImgLink").click(function() {
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
								($(document).scrollTop() + $("#overLayer")
										.height() / 2)
										+ "px");
					});
		}
	});
</script>