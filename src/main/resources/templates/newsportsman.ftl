<form action="/newsportsman" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="form-group-row">
            <label class="col-sm-2 col-form-label">firstName</label>
            <div class="col-sm-6">
                <input type="text" name="firstName" class="form-control"
                       placeholder="input firstname"/>
            </div>
    </div>
     <div class="form-group-row">
                <label class="col-sm-2 col-form-label">lastName</label>
                <div class="col-sm-6">
                    <input type="text" name="lastName" class="form-control"
                           placeholder="input lastName"/>
                </div>
        </div>
         <div class="form-group-row">
                    <label class="col-sm-2 col-form-label">alias</label>
                    <div class="col-sm-6">
                        <input type="text" name="alias" class="form-control"
                               placeholder="input alias"/>
                    </div>
            </div>
    <button class="btn btn-primary" type="submit">BTN</button>
</form>