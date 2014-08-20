/* Function to update uncacheable data like cart quantity, user first name,  in-cart indicators and stock indicators */
function updateUncacheableData(params) {
	updateCustomerData(params);
	updateOutOfStockData(params);
	updateInCartData(params);
	updateXSRFToken(params);
}

function updateXSRFToken(params) {
	$('input[name="csrfToken"]').val(params['csrfToken']);	
}

function updateCustomerData(params) {
	var anonymous = params['anonymous'];
	if (anonymous) {		
		$('#anonymous-customer-header').removeClass('hidden');
		$('#registered-customer-header').addClass('hidden');
	} else {
		$('#registered-customer-header').removeClass('hidden');
		$('#anonymous-customer-header').addClass('hidden');
		$('#welcome-first-name').text(params['firstName']);
	}
}

function updateOutOfStockData(params) {
	var outOfStockProducts = params['outOfStockProducts'];
	for (var i=0; i < outOfStockProducts.length; i++) {
		var containerElement = $('.productActions' + outOfStockProducts[i]).closest('.product_container');
		containerElement.find('div.out_of_stock').removeClass('hidden');
		containerElement.find('div.add_to_cart').addClass('hidden');		
	}
}

function updateInCartData(params) {
	var cartItemIds = params['cartItemIdsWithoutOptions'];
	for (var i=0; i < cartItemIds.length; i++) {
		var containerElement = $('.productActions' + cartItemIds[i]).closest('.product_container');
		containerElement.find('div.in_cart').removeClass('hidden');
		containerElement.find('div.add_to_cart').addClass('hidden');
		containerElement.find('div.out_of_stock').addClass('hidden');
	}
		
	// updateHeaderCartItemsCount(params['cartItemCount']);  --> This was not found copying below
    //Pull the word that was set in the html from the internationalized version from the locale
	var newCount = params['cartItemCount']
    var singularItem = $('span#headerCartItemWordSingular_i18n').text();
    var plurarlItem = $('span#headerCartItemWordPlural_i18n').text();

    $('.headerCartItemsCount').html(newCount);
    $('.headerCartItemsCountWord').html((newCount == 1) ? singularItem: plurarlItem);
}
