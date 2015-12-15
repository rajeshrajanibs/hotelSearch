var BackModel = BackBone.Model.extend({
    initialize : function(){
    console.log("Model is created");
    }
})

var BackBoneCollection = BackBone.Collection.extend({
    initialize: function(){
    console.log("Collection initialized");
    },
    model: BackModel,
    url: "/getReviews"
})

var BackView =  BackBone.View.extend({
    template: Handlebars.compile($("#hotelDetails").html()),
    initialize: function(){
    this.listenTo(this.collection,'add', this.render);
    console.log("View initialized");
    },

    el: "#searchForm",
    events: {
        'click button.review': 'review'
    },
    review: function(e){
        e.preventDefault();
        var hotelId = $("#hotelId").val();
        var userModel = new BackModel({hotelId: hotelId});
        var self = this;
        this.collection.fetch(userModel, success: function(){

        })
       /* userModel.fetch({
            beforeSend: function(xhr){
            xhr.setRequestHeader('Content-type','application/json');
            },
            data: JSON.stringify(userModel),
            type: 'GET',
            success: function(userModel, response){
                self.collection.add(response);

            }
        });*/
    },
    render: function(){
       this.$el.html(this.template({reviewMBs : this.collection.toJSON()}))
    }

})

