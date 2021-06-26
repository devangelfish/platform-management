const List = function(config) {
	let url = config.url;
	let ejs = config.ejs;
	let length = config.length;
	let isLink = config.isLink;
	
	let isEnd = false;
	let lastKeyword = '';
	
	let scrollDown = function() {
			let scrollHeight = $(document).height();
				
			$('html').animate({
				scrollTop : scrollHeight
			}, 600);
		};
	
	let focus = function() {
		$(this).addClass("focus").find("#search-input").focus() && $(".fas.fa-eye").addClass("open");
	};
	
	let unfocus = function() {
		$(this).closest("#search-section").removeClass("focus") && $(".fas.fa-eye").removeClass("open");
	};
	
	let fetch = function() {
		let lastElement = $('#list-section .list-group').last();
		let lastIndex = $(lastElement).find('.no-item').text();
		let startNo = $(lastElement).data('no');
		let keyword = $('#search-input').val();
		
		if(keyword != lastKeyword) {
			isEnd = false;
		}
		
		if(isEnd) {
			return;
		}
		
		if(lastKeyword != keyword) {
			lastIndex = 0;
			startNo = '';
			$('#list-section .list-group').remove();
		}
		$.ajax({
		url: url + 'search?keyword=' + keyword + '&' + 'no=' + startNo,
		async: true,
		type: 'get',
		dataType: 'json',
		success: function(response) {
			if(response.result != 'success') {
				console.error(response.message);
				return;
			}
			
			if(response.data.length < length) {
				isEnd = true;
			}
			
			const html = ejs.render({data: response.data, index: parseInt(lastIndex) + 1});
			$('#list-section').append(html) && scrollDown();
			lastKeyword = keyword;
		},
		error: function(status, e) {
			console.log(status + ':' + e);
		}});
	};
		
	let addEvent = function() {
		$("#search-section").click(focus);
		$("#search-input").blur(unfocus);
		$("#search-input").keydown(function (key) {
			if(key.keyCode == 13) { fetch(); }
		});
		$('#search-button').click(fetch);
		$('#more-arrow').click(fetch);
		if(isLink === true) {
			$('#list-section').on('click', '.list-group', function() {
				$(location).attr('href', url + $(this).data('no'));
			});
		};
	}
	
	return {
		init: function() {
			addEvent();
		}
	}
}