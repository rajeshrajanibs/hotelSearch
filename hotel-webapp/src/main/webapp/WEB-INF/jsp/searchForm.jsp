<script type="text/template" id="searchTemplate">
    <div class="container">
        <div class="containerBody">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="city" class="col-sm-4 control-label">City</label>
                    <div class="col-sm-2">
                        <input type="text" name="city" id="cityAutoComplete"  autocomplete="off"  class="form-control" placeholder="City" />
                        <input type="hidden" name="cityCode" id="cityCode"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="checkin" class="col-sm-4 control-label">Check In</label>
                    <div class="col-sm-2">
                        <input type="text" name="checkin" id="checkin" class="form-control datepicker" placeholder="Check In" autocomplete="off"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="checkout" class="col-sm-4 control-label">Check Out</label>
                    <div class="col-sm-2">
                        <input type="text" name="checkout" id="checkout" class="form-control datepicker" placeholder="Check Out" autocomplete="off"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="guest" class="col-sm-4 control-label">Guests</label>
                    <div class="col-sm-2">
                        <select name="guest" id="guest" class="col-sm-2 form-control">
                            <c:forEach var="i" begin="1" end="4">
                                <option value="${i}" >${i}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-2" >
                        <button id="submitBut" class="btn btn-primary btn-block submitButton" type="submit">Search</button>
                        <div id="spinner"></div>
                    </div>
                </div>
            </form>
        </div>
        <div id="content"></div>
    </div> <!-- /.container -->
</script>
