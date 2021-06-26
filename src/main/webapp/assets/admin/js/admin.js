$(function(){
	let dt = new Date();
    let Year = "" + dt.getFullYear();        
    let Month = "" + (dt.getMonth()+1);
    let Day = "" + dt.getDate();            
    
    if(Month.length < 2) Month = "0" + Month;
    if(Day.length < 2) Day = "0" + Day;
    
    let Today = Year + '-' + Month + '-' + Day;
	
	$('#sidebar-wrapper .list-group-item-date').text(Today);
})