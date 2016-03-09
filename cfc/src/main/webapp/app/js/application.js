/**
 * 
 */
$(document).ready(function() {
	loadTableSaldos();
	loadTableMovimientos();
	loadTableHistoricos();
	loadTableSucursales();
	
});

function loadTableSaldos() {
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
					html+=elem.nomAgencia
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

function loadTableHistoricos() {
	var url = '/cfc/efectivo/getHistoricos';
	$('#mainTableBody').empty();
	$.ajax({
		method : 'GET',
		url : url
	}).success(
			function(data) {
				var html = '';
				$.each(data, function(index, elem) {
					
					html+='<div class="col-md-12"><span>';
					html+=elem.nomAgencia
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

function loadTableMovimientos() {
	var url = '/cfc/efectivo/getMovimientos';
	$('#mainTableBody').empty();
	$.ajax({
		method : 'GET',
		url : url
	}).success(
			function(data) {
				var html = '';
				$.each(data, function(index, elem) {
					
					html+='<div class="col-md-12"><span>';
					html+=elem.nomRegion
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

function loadTableSucursales() {
	var url = '/cfc/efectivo/getSucursales';
	$('#mainTableBody').empty();
	$.ajax({
		method : 'GET',
		url : url
	}).success(
			function(data) {
				var html = '';
				$.each(data, function(index, elem) {
					
					html+='<div class="col-md-12"><span>';
					html+=elem.nomAgencia
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
