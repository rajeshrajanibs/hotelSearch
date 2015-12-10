var BackModel = Backbone.Model.extend({
	initialize: function(){
		console.log("Model Initialized");			
	},
	validate: function (attrs) {
			alert(attrs);
            if (!attrs.originStation) {
                return 'Please fill email field.';
            }
            if (!attrs.destinationStation) {
                return 'Please fill feedback field.';
            }
    },
	url: '/createSolution'
})

var BackCollection = Backbone.Collection.extend({
	initialize: function(){				
		console.log("Collection Initialized");		
	},
	url: '/list',
	parse: function(data) {
		return data;
	}
})

var AddUserView = Backbone.View.extend({
	initialize: function(){
		console.log("Add User View Initialized");		
	},
	el: "#userForm",		
	events: {
		'click button.submitButton' : 'submitMe'
	},	
	submitMe: function(e) {
		
		var originStation = $("#originStation").val(), 
		    destinationStation = $("#destinationStation").val(),
		    trainNumber = $("#trainNumber").val()
		    totalCost = $("#totalCost").val();
		var userModel = new BackModel({originStation: originStation, destinationStation: destinationStation,
						trainNumber: trainNumber, totalCost: totalCost});

		var self = this;
		userModel.fetch({
			beforeSend: function (xhr) {
		    		xhr.setRequestHeader('Content-Type', 'application/json');
			},
			data: JSON.stringify(userModel),
            type:'POST',
            success: function() {
            	self.collection.fetch();
            }
		});
		e.preventDefault();		
	}
})

var BackView = Backbone.View.extend({	
	template: Handlebars.compile($("#backTemplate").html()),
        events: {
		'click img.deleteUser' : 'deleteUser'
	},
	initialize: function(){				
		console.log("List View Initialized");
		this.listenTo(this.collection, 'add', this.render);
		this.listenTo(this.collection, 'sync', this.render);
		this.collection.fetch();
	},
	render: function(){
		this.$el.html(this.template({solutions: this.collection.toJSON()}))
	},
	deleteUser: function(e) {		
		e.preventDefault();	
	}
})



