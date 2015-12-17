<script type="text/template" id="reviewTemplate">
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">Reviews</h3>
    </div>
    <div class="panel-body">
        {{#each reviews}}
            {{#each reviewMBList}}
                {{#if reviewTitle}}
                    <div class="row card">
                        <div class="col-md-3">
                            <h5 class="review-name">
                                {{#if userName}}
                                    {{userName}}
                                 {{else}}
                                    Anonymous
                                 {{/if}}
                            </h5>
                            <h6>{{submissionDate}}</h6>
                        </div>
                        <div class="col-md-9">
                            <h4 class="review-title">{{reviewTitle}}</h4>
                            <div>{{reviewText}}</div>
                        </div>
                    </div>
                {{/if}}
            {{/each}}
        {{/each}}
    </div>
</div>
</script>
