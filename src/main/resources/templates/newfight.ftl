<form action="/newfight" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="form-group-row">
            <label class="col-sm-2 col-form-label">aliasFirstFighter</label>
            <div class="col-sm-6">
                <input type="text" name="aliasFirstFighter" class="form-control"
                       placeholder="input aliasFirstFighter"/>
            </div>
    </div>
     <div class="form-group-row">
                <label class="col-sm-2 col-form-label">aliasSecondFighter</label>
                <div class="col-sm-6">
                    <input type="text" name="aliasSecondFighter" class="form-control"
                           placeholder="input aliasSecondFighter"/>
                </div>
        </div>
    <button class="btn btn-primary" type="submit">BTN</button>
</form>