<script type="text/template" id="searchResult">
    <div class="row">
        <div class="col-md-6">
            {{#each searchResults.hotelsolutions}}
               <div class="row card">
                   <div class="col-md-3">
                           <img class="card-img-top" data-src="..." alt="Card image cap" src="{{thumbnailUrl}}" width="100%" height="100%">
                   </div>
                   <div class="col-md-6">
                            {{name}}
                           {{description}}
                   </div>
                   <div class="col-md-3">
                          {{#each roomTypes}}
                             {{price.baseRate.value}}  {{price.baseRate.USD}}
                          {{/each}}
                   </div>
               </div><!--/row-->
            {{/each}}
        </div>
        <div class="col-md-6">
            <div id="hotelDetails"></div>
        </div>
    </div><!--/row-->
</script>



