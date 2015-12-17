<script type="text/template" id="hotelDetailsTemplate">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title bold">Hotel Details</h3>
    </div>
    <div class="panel-body">
        {{#each hotel}}
            <h4 class="header">Hotel Name</h4>
                <div>{{name}}</div>
            <h4 class="header">Location</h4>
                <div>{{location.streetAddress}}, {{location.city}}, {{location.country}}</div>
            <h4 class="header">Description</h4>
                <div>{{description}}</div><br />
                <div><a href="{{detailsUrl}}">{{detailsUrl}}</a></div>
            <h4 class="header">Room Types</h4>
                {{#each roomTypes}}
                    <div> {{description}}: {{price.baseRate.value}}  {{price.baseRate.currency}}
                    ({{#if refundable}} Refundable {{else}} Non Refundable {{/if}})</div>
                {{/each}}
            {{#if amenities.amenities}}
                <h4 class="header">Amenities</h4>
                <div>
                    <ul>
                        {{#each amenities.amenities}}
                            <li>{{this}}</li>
                        {{/each}}
                    </ul>
                </div>
            {{/if}}
        {{/each}}
    </div>
</div>


</script>