$(function() {	
	$('#writing-textarea').keyup(function () {
		$(this).css('height', 'auto');
		let height = $(this).prop('scrollHeight');
		$(this).css('height', height);
		$(window).scrollTop($('body').prop('scrollHeight'));
	});
	
	$('.fa-cog').click(function() {
		$(this).parent('#floating-toolbar').toggleClass('hide');
		$(this).toggleClass('rotate');
	});
	
	$('.fa-angle-double-down').click(function() {
		let scrollHeight = $(document).height();
		$('html').animate({
			scrollTop : scrollHeight
		}, 600);
	})
	
	$('.fa-angle-double-up').click(function() {
		let scrollHeight = $(document).height();
		$('html').animate({
			scrollTop : 0
		}, 200);
	})
	
	$(document).scroll(function () {
		$(window).scrollTop() > 48.8 && $('#floating-toolbar').addClass('fixed') || $('#floating-toolbar').removeClass('fixed');
	})
	
	$('#status-section > select').change(function() {
		let statusNo = $(this).prop('value');
		
		console.log(statusNo);
		
		$.ajax({
			url: '',
			async: true,
			type: 'post',
			dataType: 'json',
			data: {statusNo: statusNo},
			success: function(response) {
				if(response.result != 'success') {
					console.error(response.message);
					return;
				}
			},
			error: function(status, e) {
				console.log(status + ':' + e);
			}
		});
	}) 
});