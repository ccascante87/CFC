/**
 * 
 */
$(document).ready(function() {
	loadTable();
	
});

function loadTable() {
	var url = '/cfc/efectivo/getSaldos';
	$('#mainTableBody').empty();
	$.ajax({
		method : 'GET',
		url : url
	}).success(
			function(data) {
				var html = '';
				$.each(data, function(index, elem) {
					
					html+='<div class="col-md-12"><span>';
					html+=elem.idSaldo
					html+='</span></div>';
					
				});
				$('#mainTableBody').append(html);
			}).done(function(data) {
		//alert('done' + data);
	}).complete(function() {
		//alert('complete');
	}).fail(
			function(jqXHR, textStatus, errorThrown) {
				alert('fail: ' + textStatus + ' errorThrown: ' + errorThrown
						+ ' jqXHR: ' + jqXHR);
			});
}
