$(function() {
	const listTemplate = new EJS({
		url: 'assets/admin/ejs/member-list-template.ejs'
	});
	
	const tupleTemplate = new EJS({
		url: 'assets/admin/ejs/member-tuple-template.ejs'
	});
	
	const list = new List({url: 'member/', ejs: listTemplate, length: 7, isLink: false});
	modalInit();
	list.init();
	
	let noNull = function(){
		var content = '회원을 선택해주세요';
		setModal('memberChoice', content, false);
		setTimeout(function (){
			removeModal('memberChoice');
		},1000);
	}
	
	$('#info-password-re').click(function() {
		let no = $('.list-tuple.focus').closest('.list-group').data('no');
		if(no == null) {
			noNull();
		}
		else{
			var content = '초기화된 비밀번호를 등록된 메일로 보내겠습니까?';
			setModal('password-re', content, true);
		}
	});
	
	$('#modal-wrapper').on('click', '.common-button.password-re', function(){
		let no = $('.list-tuple.focus').closest('.list-group').data('no');
		let name = $('.input-wrapper #name').text();
		let email = $('input#email').val();
		removeModal('password-re');
		$('.wrap-loading').removeClass('display-none');
		$.ajax({
		url: 'member/mail?no=' + no + '&email='+email + '&name=' + name,
		async: true,
		type: 'get',
		dataType: 'json',
		success:function(response){
			if(response.result != 'success') {
				console.error(response.message);
				return;
			}
		},
		complete:function(){
			$('.wrap-loading').addClass('display-none');
			var content = '재발급이 완료되었습니다.';
			setModal('sendPassword', content, false);
			setTimeout(function (){
				removeModal('sendPassword');
			},1000);
    	},
		error: function(status, e) {
			console.log(status + ':' + e);
		}
		});
	});
	
	let changeReceive = function(response) {
		$('.list-tuple').hasClass('focus') && response.data['emailReceive'] && $('#email-receive').addClass('on') && $('#email-receive').children().addClass('on')
		|| $('#email-receive').removeClass('on') && $('#email-receive').children().removeClass('on');
			
		$('.list-tuple').hasClass('focus') && response.data['smsReceive'] && $('#sms-receive').addClass('on') && $('#sms-receive').children().addClass('on')
		|| $('#sms-receive').removeClass('on') && $('#sms-receive').children().removeClass('on');
	}
	
	$('#modify').click(function() {
		let no = $('.list-tuple.focus').closest('.list-group').data('no');
		if(no == null) {
			noNull();
		}
		else{
			let identifier = $('#identifier').val();
			let email = $('#email').val();
			let email_receive = $('#email-receive').hasClass('on');
			let mobi_no = $('#mobi-no').val();
			let tel_no = $('#tel-no').val();
			let sms_receive = $('#sms-receive').hasClass('on');
			$.ajax({
			url: 'member/modify/' + no,
			async: true,
			type: 'post',
			dataType: 'json',
			data: {identifier: identifier, email: email, emailReceive: email_receive,
				   mobiNo: mobi_no, telNo: tel_no, smsReceive: sms_receive},
			success: function(response) {
				if(response.result != 'success') {
					console.error(response.message);
					return;
				}
				
				$('#identifier').val(response.data['identifier']);
				$('#email').val(response.data['email']);
				$('#mobi-no').val(response.data['mobiNo']);
				$('#tel-no').val(response.data['telNo']);
				
				$('.list-tuple.focus .class-item').text(response.data['identifier']);
				$('.list-tuple.focus .email-item').text(response.data['email']);
				$('.list-tuple.focus .phone-item').text(response.data['telNo']);
				changeReceive(response);
			},
			beforesend:function(){
				$('.wrap-loading').removeClass('display-none');
			},
			complete:function(){
				complateModify();
	        	$('.wrap-loading').addClass('display-none');
	    	},
			error: function(status, e) {
				console.log(status + ':' + e);
			}
			});	
		}
	});
	
	let complateModify = function(){
		var content = '수정이 완료되었습니다.';
		setModal('modifyConfirm', content, false);
		setTimeout(function (){
			removeModal('modifyConfirm');
		},1000);
	}
	
	let userInnerText = function(response) {
			$('.list-tuple').hasClass('focus') && 
			$('#id').text(response.data['id']) &&
			$('#name').text(response.data['name']) &&
			$('#company-name').text(response.data['companyName']) &&
			$('#company-number').text(response.data['companyNumber']) &&
			$('#identifier').text(response.data['identifier']) &&
			$('#email').text(response.data['email']) &&
			$('#tel-no').text(response.data['telNo']) &&
			$('#mobi-no').text(response.data['mobiNo']) ||
			
			!$('.list-tuple').hasClass('focus') && 
			$('#id').text('아이디') &&
			$('#name').text('이름') &&
			$('#company-name').text('기업명') &&
			$('#company-number').text('사업자번호') &&
			$('#identifier').text('회원구분') &&
			$('#email').text('이메일') &&
			$('#tel-no').text('전화번호') &&
			$('#mobi-no').text('휴대폰번호');
			
			changeReceive(response);
	}
	let lastKeyword = '';
	let maxCount = function() {
		var count;
		$.ajax({
		url: 'member/maxCount?keyword=' + lastKeyword,
		async: false,
		type: 'post',
		dataType: 'json',
		success: function(response) {
			count = response.data;
		},
		error: function(status, e) {
			console.log(status + ':' + e);
		}});
		
		return count;
	}
	let addNextText = function() {
		let lastElement = $('#list-section .list-group').last();
		let lastNo = $(lastElement).data('no');
		let lastIndex = $(lastElement).find('.no-item').text();
		$.ajax({
		url: 'member/deleteNext?no=' + lastNo + '&keyword=' + lastKeyword,
		async: true,
		type: 'get',
		dataType: 'json',
		data: '',
		success: function(response) {
			if(response.result != 'success') {
				console.error(response.message);
				return;
			}
			
			const html = tupleTemplate.render({data: response.data, index: parseInt(lastIndex) + 1});	
			$('#list-section').append(html);	
		},
		error: function(status, e) {
			console.log(status + ':' + e);
		}});
	}
	
	$('#search-button, #more-arrow').click(function(){
		lastKeyword = $('#search-input').val();
	});
	
	$('#search-input').keydown(function(k){
		if(k.keyCode == 13){
			lastKeyword = $('#search-input').val();
		}
	})
	
	$('#delete').click(function() {
		let no = $('.list-tuple.focus').closest('.list-group').data('no');
		if(no == null) {
			noNull();
		}
		else {
			var content = '정말 계정을 삭제하시겠습니까?';
			setModal('deleteConfirm', content, true);	
		}
	});

	$('#modal-wrapper').on('click', '.common-button.deleteConfirm', function() {
		let no = $('.list-tuple.focus').closest('.list-group').data('no');
		let firstElement = $('#list-section .list-group').first();
		let lastElement = $('#list-section .list-group').last();
		let lastElementNo = lastElement.data('no');
		removeModal('deleteConfirm');
		$.ajax({
		url: 'member/delete?no=' + no +'&keyword=' + lastKeyword,
		async: true,
		type: 'get',
		dataType: 'json',
		success: function(response) {
			if(response.result != 'success') {
				console.error(response.message);
				return;
			}
			$('.list-tuple.focus').closest('.list-group').remove();
			if(response.data != null) {
				let resNo = response.data['no'];
				$('.list-group[data-no=' + resNo + '] .list-tuple').addClass('focus');
				if(firstElement.data('no') != resNo){
					for(let i = lastElementNo; i <= resNo; i++ ) {
						$('.list-group[data-no=' + i + '] .list-tuple .no-item').text($('.list-group[data-no=' + i + '] .list-tuple .no-item').text()-1);
					}
					lastElement = $('#list-section .list-group').last();
					if(lastElement.find('.list-tuple .no-item').text() != maxCount()) {
						addNextText();
					}
				}	
			}
			userInnerText(response);
		},
		error: function(status, e) {
			console.log(status + ':' + e);
		}});
	});
	
	$('#list-section').on('click', '.list-tuple', function() {
		
		let this_list = $(this);
		
		$('.list-tuple').removeClass('focus');
		this_list.addClass('focus');
		
		let no = this_list.closest('.list-group').data('no');
		$.ajax({
		url: 'member/find?no=' + no,
		async: true,
		type: 'get',
		dataType: 'json',
		success: function(response) {
			if(response.result != 'success') {
				console.error(response.message);
				return;
			}
			
			userInnerText(response);
		},
		error: function(status, e) {
			console.log(status + ':' + e);
		}});
	});
	
	$('.reception-toggle-wrapper').click(function() {
		$(this).children('.reception-toggle-circle').toggleClass('on') &&
			$(this).toggleClass('on');

	});
})