$(function() {
	$(".imgLink").mouseenter(function() {
		$(".innerOver", this).fadeIn();
		$(".innerOver2", this).fadeIn();
	});
	$(".imgLink").mouseleave(function() {
		$(".innerOver").hide();
		$(".innerOver2").hide();
	});
});
