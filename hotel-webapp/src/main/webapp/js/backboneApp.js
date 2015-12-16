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
              data: searchParams,
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
	events: {
	    'click #review a' : 'review'

	},
	initialize: function(){
        this.listenTo(this.collection, 'add', this.render);
	},
	render: function(){
	    console.log(this.collection.toJSON())
		this.$el.html(this.template({searchResults: this.collection.toJSON()}))
	},

	review: function(e) {
	    e.preventDefault();
	    var hotelId = $(e.currentTarget).attr("hotelId");
	    var reviewModel = new ReviewModel({hotelId: hotelId})
	    new ReviewView({model: reviewModel});

	}
})


var ReviewModel = Backbone.Model.extend({
    url: "http://192.168.71.98:8123/getReviews",
    initialize: function(){
        console.log("Model is created");
    }
})

var ReviewCollection = Backbone.Collection.extend({
    initialize: function(){
        console.log("Collection initialized");
    },
    model: ReviewModel

})

var ReviewView =  Backbone.View.extend({
    template: Handlebars.compile($("#reviewTemplate").html()),

    initialize: function(){
        this.collection = new ReviewCollection();
        this.listenTo(this.collection,'add', this.render);
        this.reviews()
    },

    el: "#hotelDetails",

    reviews: function() {
        var self = this
        $("#hotelDetails").html("<img src='/img/loading.gif'>")
        window.scrollTo(0,0)
        this.model.fetch({data: {hotelId: this.model.get("hotelId")},
            success: function(model, response) {
                self.collection.add(response)
            },
            error: function (model, error) {
                $("#submitBut").show()
                $("#spinner").hide()
            }

        })
    },
    render: function(){
       this.$el.html(this.template({reviews : this.collection.toJSON()}))
    }

})