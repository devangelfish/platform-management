$(function() {
	const listTemplate = new EJS({
		url: 'assets/admin/ejs/service-list-template.ejs'
	});
	
	const list = new List({url: 'contract/', ejs: listTemplate, length: 10, isLink: true});

	list.init();
})