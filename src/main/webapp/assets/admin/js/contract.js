$(function() {
	modalInit();
	
	let sliderTemplate = new EJS({
		url: '/starxr-admin/assets/admin/ejs/slider-template.ejs'
	});
	
	let lastClicked;

	let getStatus = function(no) {
	$('#textarea-container').css('margin-left', '0');
	
	let scrollDown = function() {
		let scrollHeight = $(document).height();
			
		$('html').animate({
			scrollTop : scrollHeight
		}, 600);
	};
	
	let drawStatus = function(length) {	
		let progressedSize = (100 / $('#status-list-wrapper ul').children().length) * length;
		$('.status-bar.detacted').css('width', progressedSize + '%');
		$('.status-bar.undetacted').css('width', (100 - progressedSize) + '%');
	};
	
	let highlightStatus = function(status) {
		let initStatusHighlight = function() {
			$('#status-list-wrapper li').removeClass('highlight');
		}
		let addHighlight = function() {
			for(index in status) {
				$('#status-list-wrapper li[data-no=' + status[index].statusNo + ']').addClass('highlight');
			}
		}
		initStatusHighlight();
		addHighlight();
	};
	
	let initTextarea = function(status) {
		let initTextAreaWrapperWidth = function() {
			$('#textarea-container').css('width', (100 * status.length + '%'));
		}
		let adjustSelectedStatusTextWidth = function() {
			$('#textarea-container textarea').css('width', (100 / $('#textarea-container').children().length) + '%');
		}
		let adjustSelectedStatusTextLocation = function() {
			let clearDecorator = function() {
				$('#status-list-wrapper li').removeClass('selected-status');
			}
			let setDecorator = function() {
				$('#status-list-wrapper li[data-no=' + status[status.length - 1].statusNo + ']').addClass('selected-status');
			}
			clearDecorator();
			$('#textarea-container').css('margin-left', '-' + (((status[status.length - 1].statusNo) * 100) - 100) + '%');
			lastClicked = status[status.length - 1].statusNo;
			setDecorator();
		}
		
		let clearAllStatusText = function() {
			$('#textarea-container textarea').remove();
		}
		let displayCurrentStatus = function() {
			$('#status-progress h1').text('현재 \'' + status[status.length - 1].name + '\'' + ' 단계');	
		}
		let renderAllStatusText = function() {
			const html = sliderTemplate.render({data: status});
			$('#textarea-container').append(html);
		}
		clearAllStatusText();
		displayCurrentStatus();
		renderAllStatusText();
		initTextAreaWrapperWidth();
		adjustSelectedStatusTextWidth();
		adjustSelectedStatusTextLocation();
		scrollDown();
	}
	
	$.ajax({
		url: no + '/status',
		async: true,
		type: 'get',
		dataType: 'json',
		success: function(response) {
			if(response.result != 'success') {
				console.error(response.message);
				return;
			}	
			$('textarea[name="status-input"]').val(response.data[response.data.length - 1].contents);
			initTextarea(response.data);
			highlightStatus(response.data);
			drawStatus(response.data.length);
		},
		error: function(status, e) {
			console.log(status + ':' + e);
		}});
	};
	
	$('#button-section a').click(function(event) {
		event.preventDefault();
	}); 

	$('#status-list-wrapper').on('click', 'li.highlight', function() {
		$('li.highlight').removeClass('selected-status');
		if($(this).data('no') != lastClicked || lastClicked !== 'undefined') {
			$('#textarea-container').css('margin-left', '-' + ((($(this).data('no')) * 100) - 100) + '%');		
		}
		lastClicked = $(this).data('no');
		$(this).addClass('selected-status');
	});
	
	$('#list-section').on('click', '.list-tuple', function() {
		$('.list-tuple').removeClass('focus');
		$(this).addClass('focus');
		let no = $(this).parent('.list-group').data('no');
		getStatus(no);
	});
	
	$('.exit-click').click(function(event) {
		event.preventDefault();
		$('#next-modal-wrapper').removeClass('show');
		$('body').removeClass('scroll-frozen');
	});

	$('#next-btn').click(function() {
		if(lastClicked === undefined) {
			return;
		}	
		setModal('next-confirm', '다음단계로 넘어가시겠습니까?', true);
		$('#next-modal-wrapper').addClass('show');
		$('body').addClass('scroll-frozen');
	});
	
	$('body').on('click', '.next-confirm', function() {
		
		let param = {
			contents : $('textarea#' + lastClicked).val(),
			statusNo : lastClicked
		}
		
		let contractNo = $('.list-tuple.focus').parent().data('no');
		
		$.ajax({
			url: parseInt(contractNo) + '/status',
			async: true,
			type: 'post',
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(param),
			success: function(response) {
				$('.wrap-loading').addClass('display-none');
				
				if(response.result != 'success') {
					$('.wrap-loading').addClass('display-none');
					setModal('next', '이미 진행된 단계입니다.', false);
					return;
				}
				
				if(response.data === 0) {
					setModal('next', '마지막 단계입니다.', false);
					return;
				}
				
				setModal('next', '상태가 변경되었습니다.', false);
				getStatus(parseInt(contractNo));
				setTimeout(function() {
					removeModal('next')
				}, 1000);
			},
			beforeSend: function() {
				$('.wrap-loading').removeClass('display-none');
			}
		});	
	});
	
	$('body').on('click', '#save-btn', function() {
		if($('textarea#' + lastClicked).val() === undefined) {
			return;
		}
		
		let param = {
			contents : $('textarea#' + lastClicked).val(),
			statusNo : lastClicked
		}
		
		let contractNo = $('.list-tuple.focus').parent().data('no');
		
		$.ajax({
			url: parseInt(contractNo) + '/status',
			async: true,
			type: 'put',
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(param),
			success: function(response) {
				if(response.result != 'success') {
					console.error(response.message);
					return;
				}
				$('.wrap-loading').addClass('display-none');
				setModal('next', '상태 메시지 저장을 완료했습니다.', false);
				setTimeout(function() {
					removeModal('next')
				}, 1000);
			},
			beforeSend: function() {
				$('.wrap-loading').removeClass('display-none');
			},
			error: function(status) {
				$('.wrap-loading').addClass('display-none');
				setModal('next', '상태 업데이트를 실패했습니다.', false);
				setTimeout(function() {
					removeModal('next')
				}, 1000);
				console.log(status);
			}
		});
	});
	
	$('input[name="checked_info"]').click(function() {
		console.log($(this).prop('value'));
		$('.list-tuple.hidden').removeClass('hidden');
		
		$(this).prop('value') === 'contract' &&
		$('.list-tuple').not('[data-date]').addClass('hidden') ||
		$('.list-tuple[data-date]').addClass('hidden')
		
		
		
	});
});