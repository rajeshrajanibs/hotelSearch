var SEARCH_URL = "http://192.168.70.69:8182";
var REVIEW_URL =  "http://192.168.70.69:8184"

var SearchModel = Backbone.Model.extend({
    url: SEARCH_URL + "/searchHotels",
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
         $("#error").html("");
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
            $("#spinner").show()
            $("#spinner").html("<img src='/img/loading.gif'>")
            this.model.fetch({
              data: searchParams,
              success: function(model, response) {
                  if (response.hotelsolutions != null && response.hotelsolutions != "") {
                     self.collection.add(response)
                  } else {
                    $("#submitBut").show()
                    $("#spinner").hide()
                    $("#error").html("No Result Found")
                  }
              },
              error: function (model, error) {
                  $("#submitBut").show()
                  $("#spinner").hide()
                  $("#error").html("No Result Found")
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
	    'click #review a' : 'review',
	    'click #hotelName a' : 'hotelDetals'

	},
	initialize: function(){
        this.listenTo(this.collection, 'add', this.render);
	},
	render: function(){
	    console.log(this.collection.toJSON())
		this.$el.html(this.template({searchResults: this.collection.toJSON()}))
		$('span.stars').stars();
	},

	review: function(e) {
	    e.preventDefault();
	    var hotelId = $(e.currentTarget).attr("hotelId");
	    var hotelName = $(e.currentTarget).attr("hotelName");
	    var reviewModel = new ReviewModel({hotelId: hotelId, hotelName: hotelName})
	    new ReviewView({model: reviewModel});

	},

	hotelDetals: function(e) {
	    e.preventDefault();
	    var hotelId = $(e.currentTarget).attr("hotelId");
        var detailModel = new DetailModel({hotelId: hotelId})
        new DetailView({model: detailModel});
	}
})


var ReviewModel = Backbone.Model.extend({
    url: REVIEW_URL + "/getReviews",
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
       this.$el.html(this.template({reviews : this.collection.toJSON(), hotelName: this.model.get("hotelName")}))
    }

})


var DetailModel = Backbone.Model.extend({
    url: SEARCH_URL + "/getHotel",
    initialize: function(){
        console.log("Detail Model is created");
    }
})

var DetailCollection = Backbone.Collection.extend({
    initialize: function(){
        console.log("Collection initialized");
    }
})

var DetailView =  Backbone.View.extend({
    template: Handlebars.compile($("#hotelDetailsTemplate").html()),

    initialize: function(){
        this.collection = new ReviewCollection();
        this.listenTo(this.collection,'add', this.render);
        this.details()
    },

    el: "#hotelDetails",

    details: function() {
        var self = this
        $("#hotelDetails").html("<img src='/img/loading.gif'>")
        window.scrollTo(0,0)
        this.model.fetch({data: {hotelId: this.model.get("hotelId"),
                                regionIds: $("#regionId").val(),
                                fromDate: $("#checkInDate").val(),
                                toDate: $("#checkOutDate").val()},
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
       this.$el.html(this.template({hotel : this.collection.toJSON()}))

    }

})