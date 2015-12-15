<script type="text/template" id="hotelDetails">
    <table class="table table-striped">
        <tr>
        <th>Review Title</th>
        <th>User</th>
        <th>Complete Review</th>
        <th>Over All Rating</th>
        <th>Negative reviews</th>
        </tr>
        {{#each myAlbum}}
        <tr>
        <td>{{this.songName}}</td>
       <td>{{this.artist}}</td>
        </tr>
        {{/each}}
    </table>
</script>