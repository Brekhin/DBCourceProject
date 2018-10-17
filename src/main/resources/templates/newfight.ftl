<#import "parts/common.ftl" as c>
<@c.page>
<form action="/newfight" method="post" enctype="multipart/form-data" >
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
        <div class="form-group-row">
                        <label class="col-sm-2 col-form-label">description</label>
                        <div class="col-sm-6">
                            <input type="text" name="description" class="form-control"
                                   placeholder="input description"/>
                        </div>
                </div>
        <div>
                <div class="form-group">
                                <div class="custom-file">
                                    <input type="file" name="file" id="customFile">
                                    <label class="custom-file-label" for="customFile">Choose file</label>
                                </div>
                </div>
            </div>

    <button class="btn btn-primary" type="submit">BTN</button>
</form>
</@c.page>