<form method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="form-group-row">
            <label class="col-sm-2 col-form-label">firstName</label>
            <div class="col-sm-6">
                <input type="text" name="firstName" class="form-control"
                       value="${sportsman.firstName}" />
            </div>
    </div>
    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">lastName</label>
        <div class="col-sm-6">
            <input type="text" name="lastName" class="form-control"
                   value="${sportsman.lastName}" />
        </div>
    </div>
    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">alias</label>
        <div class="col-sm-6">
            <input type="text" name="alias" class="form-control"
                   value="${sportsman.alias}" />
        </div>
    </div>
    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">growth</label>
        <div class="col-sm-6">
        <input type="text" name="growth" class="form-control"
               value="${sportsman.growth}" />
        </div>
    </div>
    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">weight</label>
        <div class="col-sm-6">
        <input type="text" name="weight" class="form-control"
               value="${sportsman.weight}" />
        </div>
    </div>
    <div class="form-group-row">
        <label class="col-sm-2 col-form-label">lengthOfHands</label>
        <div class="col-sm-6">
        <input type="text" name="lengthOfHands" class="form-control"
               value="${sportsman.lengthOfHands}" />
        </div>
    </div>
    <div>
<div>
    <button class="btn btn-primary" type="submit">Save</button>
</div>
</div>
</form>