$(function() {
	const listTemplate = new EJS({
		url: 'assets/admin/ejs/question-list-template.ejs'
	});
	
	const list = new List({url: 'question/', ejs: listTemplate, length: 10, isLink: true});
	
	list.init();
	
	$('#checked-section').on('click', 'input[type="radio"]', function() {
		let statusNo = $(this).prop('value');
		
		if(statusNo != 0) {
			location.href = '?no=' + statusNo;
		} else {
			location.href = '/starxr-admin/question';
		}
	});
});