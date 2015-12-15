$(function(){	
    var searchResultCollection = new SearchResultCollection();
	var searchView = new SearchView({collection: searchResultCollection});
    var searchResultView = new SearchResultView({collection: searchResultCollection});
       $('.datepicker').datepicker();



$("#cityAutoComplete").autocomplete(
{
    source: function (request, response)
    {
        $.ajax(
        {
            url: "js/country.json",
            dataType: "json",
            data:
            {
                term: $("#cityAutoComplete").val(),
            },
            success: function (data)
            {
               response($.map(data, function (item) {
                   return {
                       label: item.name,
                       value: item.name,
                       id:   item.code,
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
