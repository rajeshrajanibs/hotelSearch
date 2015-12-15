<script type="text/template" id="searchResult">
    <div class="row">
        <div class="col-md-6">
            {{#each searchResults}}
                {{#each this.hotelsolutions}}
               <div class="row card">
                   <div class="col-md-3">

                           <img class="card-img-top" data-src="..." alt="Card image cap" src="{{thumbnailUrl}}" width="100%" height="100%">
                   </div>
                   <div class="col-md-6">
                            <h4><a href="#">{{name}}</a></h4>
                           <div>{{description}}</div>
                           <div id="review" class='reviews"'><a href="" hotelId="{{hotelID}}">Reviews</a></div>
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
               </div><!--/row-->
                {{/each}}
            {{/each}}
        </div>
        <div class="col-md-6">
            <div id="hotelDetails"></div>
        </div>
    </div><!--/row-->
</script>



