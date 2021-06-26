$(function() {
	$(".arrow-toggler").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
		$(".arrow-toggler").toggleClass("sidebar-toggle");
	});
})