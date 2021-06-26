$(function() {
	$("#id-section").click(function() {
		$(this).addClass("focus").children().focus();
	});
	
	$("#password-section").click(function() {
		$(this).addClass("focus").children().focus();
	});

	$(".id-password-input").blur(function() {
		$(this).parents().removeClass("focus");
	});

	$("#id-save-group").click(function() {
		saveHighlightToggler();
	});
	
	let saveHighlightToggler = function () {
		$('#remember').is(':checked') && $('#remember').prop('checked', false) && $(".fa-check-circle").css('color', '#dadada') ||
		$('#remember').prop('checked', true) && $(".fa-check-circle").css('color', '#EE8200');
	}
	
	$("#hidden").click(function() {
		$(this).hasClass('fa-eye-slash') &&
		$(this).removeClass('fa-eye-slash') &&
		$(this).addClass('fa-eye') &&
		$("#password-section .id-password-input").attr('type', 'text') ||
		$(this).removeClass('fa-eye') &&
		$(this).addClass('fa-eye-slash') &&
		$("#password-section .id-password-input").attr('type', 'password');
	})
	
	let isRemember = function() {
		let id =  Cookies.get('remember');
		id !== undefined && $('.id-password-input[name="id"]').val(id) && saveHighlightToggler();
	}
	
	isRemember();
})