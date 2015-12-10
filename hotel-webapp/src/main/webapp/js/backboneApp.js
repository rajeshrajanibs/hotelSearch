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

var AddUserView = Backbone.View.extend({
	initialize: function(){
		console.log("Add User View Initialized");		
	},
	el: "#userForm",		
	events: {
		'click button.submitButton' : 'submitMe'
	},	
	submitMe: function(e) {
		
		var city = $("#city").val(),
		    checkin = $("#checkin").val(),
		    checkout = $("#checkout").val(),
		    guest = $("#checkout").val()
		var userModel = new BackModel({city: city, checkin: checkin,
						checkout: checkout, totalCost: totalCost});

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

