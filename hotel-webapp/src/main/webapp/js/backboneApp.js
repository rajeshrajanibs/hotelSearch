var SearchModel = Backbone.Model.extend({
    url: 'http://terminal2.expedia.com/x/hotels?regionids=178279&dates=2016-05-19,2016-05-22&adults=3&childages=6,9&apikey=9jAXuI5XTCCdk7AbqtUy0jSrHfCZ07S3',
    initialize: function() {
       this.on("invalid",function(model,error){
           alert(error);
       });
    },
	validate: function (attrs) {
	    var errors = new Array();
        if (!attrs.city) {
            return 'Please fill city field.';
        }
        if (!attrs.checkin) {
            return 'Please fill checkin field.';
        }
        if (!attrs.checkout) {
            return 'Please fill checkout field.';
        }
    }
});

var SearchView = Backbone.View.extend({
    el: "#body",
    model: new SearchModel(),
    template: Handlebars.compile($("#searchTemplate").html()),
	initialize: function(){
	    this.render();
		console.log("Add User View Initialized");		
	},
    events: {
		'click button.submitButton' : 'submitMe'
	},
    render: function() {
        this.$el.html(this.template())
    },
	submitMe: function(e) {
        e.preventDefault();
        var searchParams = {
            city: this.$("#city").val(),
            checkin:  this.$("#checkin").val(),
            checkout: this.$("#checkout").val(),
            guest: this.$("#guest").val()
        };
		this.model.set(searchParams);
		var self = this;
        var options = {
            success: function (model, response) {
                var searchResultCollection = new SearchResultCollection(response);
               	var searchResultView = new SearchResultView({collection: searchResultCollection});
            },
            error: function (model, error) {
                alert(error);
            }
        };
        if (this.model.isValid()) {
            this.model.fetch(searchParams, options);
        }
	}
});

var SearchResultCollection = Backbone.View.extend({
    url: "",
    parse: function(data) {
        return data;
    }
})

var SearchResultView = Backbone.View.extend({
    el: "#body",
	template: Handlebars.compile($("#searchResult").html()),
	initialize: function(){
		this.render()
	},
	render: function(){
		this.$el.html(this.template({searchResults: this.collection.toJSON()}))
	}
})

