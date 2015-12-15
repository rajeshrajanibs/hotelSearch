$(function(){	
    var searchResultCollection = new SearchResultCollection();
	var searchView = new SearchView({collection: searchResultCollection});
    var searchResultView = new SearchResultView({collection: searchResultCollection});
       $('.datepicker').datepicker({format: "yyyy-mm-dd"});



$("#cityAutoComplete").autocomplete(
{
    source: function (request, response)
    {
        $.ajax(
        {
            url: "http://192.168.71.98:8120/getSolutions",
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
    }
});


})
