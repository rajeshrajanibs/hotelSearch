$(function(){	
    var searchResultCollection = new SearchResultCollection();
	var searchView = new SearchView({collection: searchResultCollection});
    var searchResultView = new SearchResultView({collection: searchResultCollection});
	$(".datepicker").datepicker();
})
