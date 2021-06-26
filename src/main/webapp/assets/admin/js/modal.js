const modalInit = function(){
	let loadingModalTemplate = new EJS({
		url: '/starxr-admin/assets/admin/ejs/loading-and-modal-template.ejs'
	});
	let html = loadingModalTemplate.render();
	$('body').append(html);
	
	$('.exit-click, #exit-button').click(function(){
		$('#modal-wrapper').removeClass('show');
		$('body').removeClass('scroll-frozen');
	});	
}

const setModal = function(identifier, content, hasButtons) {
	hasButtons && $('#modal-buttons').removeClass('display-none') && $('#modal-wrapper').removeClass('alert') ||
	$('#modal-buttons').addClass('display-none') && $('#modal-wrapper').addClass('alert');
	
	$('#modal-wrapper').addClass('show');
	$('#modal #modal-contents').text(content);
	$('#modal #modal-buttons #change-id').addClass(identifier);
	$('body').addClass('scroll-frozen');
};

const removeModal = function(class_name) {
	$('#modal-wrapper').addClass('opacity');
	setTimeout(function(){
		$('#modal-wrapper').removeClass('opacity');
		$('#change-id').removeClass(class_name);
		$('#modal-wrapper').removeClass('show');
	},200);
	$('body').removeClass('scroll-frozen');
}