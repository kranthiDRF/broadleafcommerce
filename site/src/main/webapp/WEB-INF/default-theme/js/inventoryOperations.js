$(function(){
   
    var modalAccountOptions = {
        maxWidth    : 200,
        maxHeight   : 600,
        minHeight   : 150,
        fitToView   : false,
        width       : '100%',
        height      : '100%',
        autoSize    : true,
        closeClick  : false,
        topRatio    : 0,
        openEffect  : 'none',
        closeEffect : 'none'
    };
    
    // Bind all links with class 'create-review' to open the review modal
    $('body').on('click', 'a.inventoryNotification', function() {
        BLC.ajax({url: $(this).attr('href')}, function(data) {
            var extendedOptions = $.extend({
                afterShow: function() {
                    $('.simplemodal-wrap').find('form:first').find('input:first').focus();
                    return true;
                }
            }, modalAccountOptions);
            $.modal(data, extendedOptions);
        });
        return false;
    });
    
    $('body').on('click','.simplemodal-wrap input.subscribe_button', function() {
        var $form = $(this).closest("form");
        BLC.ajax({url: $form.attr('action'), 
                type: "POST",
                data: $form.serialize()
            }, function(responseData) {
                if (responseData.success) {
                    $.modal.close();
                    HC.showNotification("Successfully subscribed to inventory notifications");
                }
            }
        );
        return false;
    });     

});