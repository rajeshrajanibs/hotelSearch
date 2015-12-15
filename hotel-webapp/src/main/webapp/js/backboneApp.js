var SearchModel = Backbone.Model.extend({
    url: 'http://192.168.71.98:8122/searchHotels',
    initialize: function() {
       this.on("invalid",function(model,error){
           alert(error);
       });
    },
	validate: function (attrs) {
	    var errors = new Array();
        if (!attrs.regionIds) {
            return 'Please fill city field.';
        }
        if (!attrs.fromDate) {
            return 'Please fill checkin field.';
        }
        if (!attrs.toDate) {
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
		'click button.submitButton' : 'submitMe',
	},
    render: function() {
        this.$el.html(this.template())
    },
	submitMe: function(e) {
        e.preventDefault();
        var searchParams = {
            regionIds: this.$("#cityCode").val(),
            fromDate:  this.$("#checkin").val(),
            toDate: this.$("#checkout").val()
//            guest: this.$("#guest").val()
        };
		this.model.set(searchParams);
		var self = this;
        console.log()
        if (this.model.isValid()) {
            $("#submitBut").hide()
            $("#spinner").html("<img src='/img/loading.gif'>")
            this.model.fetch({
              beforeSend: function (xhr) {
                xhr.setRequestHeader('Content-Type', 'application/json');
              },
              data: JSON.stringify(this.model),
              type:'POST',
              success: function(model, response) {
                  self.collection.add(response)
              },
              error: function (model, error) {
                  $("#submitBut").show()
                  $("#spinner").hide()
              }
            });
        }
	}
});

var SearchResultCollection = Backbone.Collection.extend({
    url: "",
    parse: function(data) {
        return data;
    }
})

var SearchResultView = Backbone.View.extend({
    el: "#body",
	template: Handlebars.compile($("#searchResult").html()),
	initialize: function(){
        this.listenTo(this.collection, 'add', this.render);
	},
	render: function(){
		this.$el.html(this.template({searchResults: this.collection.toJSON()}))
	}
})

