var SMART_FILL_URL = "http://192.168.70.69:8183"

$(function(){
    var searchResultCollection = new SearchResultCollection();
	var searchView = new SearchView({collection: searchResultCollection});
    var searchResultView = new SearchResultView({collection: searchResultCollection});
       $('.datepicker').datepicker({format: "yyyy-mm-dd", startDate: new Date()});

$('#checkout').on('changeDate', function(ev){
    $(this).datepicker('hide');
});

$.fn.stars = function() {
    return $(this).each(function() {
        var val = parseFloat($(this).html());
        var size = Math.max(0, (Math.min(5, val))) * 16;
        var $span = $('<span />').width(size);
        $(this).html($span);
    });
}

$("#cityAutoComplete").autocomplete(
{
    source: function (request, response)
    {
        $.ajax(
        {
            url: SMART_FILL_URL + "/getSolutions",
            data:
            {
                location: $("#cityAutoComplete").val(),
            },
            success: function (data)
            {
               response($.map(data, function (item) {
                   return {
                       value: item.locationName,
                       id:   item.id,
                   };
                }));
            },
            error: function(error) {
                  $('#cityCode').val()
            }
        });
    },
    minLength: 2,
    select: function (event, ui)
    {
        $('#cityCode').val(ui.item.id);
    },
    search: function(event, ui) {
        $(this).addClass("wait");
    },
    open: function(event, ui) {
        $(this).removeClass("wait");
    },

});


})
