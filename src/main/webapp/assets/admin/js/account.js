$(function(){
	modalInit();
	$('#modify').click(function(){
		
		let id = $('#id').text();
		let password = $('input[name=password]').val();
		let email = $('input[name=email]').val();
		let contactNo = $('input[name=contactNo]').val();
		let faxNo = $('input[name=faxNo]').val();
		
		var content = '수정이 완료되었습니다.';
		setModal('accountModify',content, false);
		$.ajax({
			url:'account/modify',
			async: true,
			type: 'post',
			dataType: 'json',
			data:{id:id, password:password, email:email, contactNo:contactNo, faxNo:faxNo},
			success:function(response){
				if(response.result != 'success') {
					console.error(response.message);
					return;
				}
				$('input[name=password]').val('');
			},
			beforesend:function(){
				$('.wrap-loading').removeClass('display-none');
			},
			complete:function(){
	        	$('.wrap-loading').addClass('display-none');
				setTimeout(function(){
					removeModal('accountModify');
				},1000);
	    	},
			error: function(status, e) {
				console.log(status + ':' + e);
			}
		});
	})
});