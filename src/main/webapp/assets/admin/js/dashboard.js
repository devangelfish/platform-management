$(function(){
	const dashboardTemplate = new EJS({
		url: 'assets/admin/ejs/dashboard-question-template.ejs'
	});
	
	const list = new List({url: 'dashboard/', ejs: dashboardTemplate, length: 10, isLink: true});
	list.init();
	let identifierPerson;
	let identifierCompany;
	let startContract;
	let endContract;
	let countData = function(){
		$.ajax({
			url: 'dashboard/count',
			async: false,
			type: 'get',
			dataType: 'json',
			success:function(response){
				if(response.result != 'success') {
					console.error(response.message);
					return;
				}
				identifierPerson = response.data['personCount'];
				identifierCompany = response.data['companyCount'];
				startContract = response.data['startContractCount'];
				endContract = response.data['endContractCount'];
			},
			error: function(status, e) {
				console.log(status + ':' + e);
			}
		});
	}
	countData();
	var userIdentifier = $('#user-identifier');
	var userIdentifierChart = function(){new Chart(userIdentifier, {
		type: 'pie',
		data: {
			labels: ['Person', 'Company'],
			datasets: [{
				data: [identifierPerson, identifierCompany],
				backgroundColor: [
						"#2ecc71",
						"#3498db"
						],
				borderWidth: 2
	          }]
	      },
		options: {
			responsive: true,
			legend: { display: true, position: 'right'},
			title: { display : true, text: '회원구분', fontSize: 24, fontStyle:'bold'}
		}
	});
	}
	userIdentifierChart();
	var contract = $('#contract');
	var contractChart = function(){new Chart(contract, {
		type: 'pie',
		data: {
			labels: ['계약 중', '계약 종료'],
			datasets: [{
				data: [startContract, endContract],
	              backgroundColor: [
						"#95a5a6",
				        "#9b59b6"
	              ],
				borderWidth: 2
	          }]
	      },
		options: {
			responsive: true,
			legend: { display: true, position: 'right'}, 
			title: { display : true, text: '계약', fontSize: 24, fontStyle:'bold'}
		}
	});
	}
	contractChart();
	setInterval(function(){
		countData();
		userIdentifierChart();
		contractChart();
	},5000);
	
	
})