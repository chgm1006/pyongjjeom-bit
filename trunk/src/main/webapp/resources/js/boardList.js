<script type="text/javascript">
	$(function() {
		$("dd").css("display", "none");
		$("dl dt,dl dt.selected").click(function() {
			if ($("+dd", this).css("display") == "none") {
				$("+dd", this).slideDown("fast");
				$("dt").removeClass("selected");
				$(this).addClass("selected");
			} else {
				$("+dd", this).slideUp("fast");
				$(this).removeClass("selected");
			}
		});
	});
</script>