<script type="text/template" id="searchResult">
    <div class="row">
        <div class="col-sm-8">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title bold">Hotel Search Results</h3>
                </div>
                <div class="panel-body">
                    {{#each searchResults}}
                        <input type="hidden" id="checkInDate" value="{{stay.checkInDate}}" />
                        <input type="hidden" id="checkOutDate" value="{{stay.checkOutDate}}" />
                        <input type="hidden" id="regionId" value="{{regionId}}" />
                        {{#each this.hotelsolutions}}
                           <div class="panel panel-default">
                               <div class="panel-body">
                                   <div class="col-md-3">
                                       <img class="card-img-top" data-src="..." alt="Card image cap" src="{{thumbnailUrl}}" width="60%" height="100%">
                                   </div>
                                   <div class="col-md-6">
                                        <h4 id="hotelName"><a href="#" hotelId="{{hotelID}}">{{name}}</a></h4>
                                        <h5 class="location-style">{{location.streetAddress}}, {{location.city}}, {{location.country}}</h5>
                                        <div id="review" class='reviews"'><a href="" hotelId="{{hotelID}}" hotelName="{{name}}">Reviews</a></div>
                                        <div><span class="stars">{{starRating}}</span></div>
                                        <input type="hidden" id="hoteId" name="hotelId" value="{{hotelID}}"/>
                                   </div>
                                   <div class="col-md-3">
                                        {{#if roomTypes}}
                                            {{#each roomTypes}}
                                                <h3 class="blue">{{price.baseRate.value}}  {{price.baseRate.currency}}</h3>
                                            {{/each}}
                                        {{else}}
                                              <h4 class="red">No Room Available</h4>
                                        {{/ if}}
                                   </div>
                               </div>
                           </div>
                        {{/each}}
                    {{/each}}
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div id="spinner"></div>
            <div id="hotelDetails">

            </div>
        </div>
    </div><!--/row-->
</script>



