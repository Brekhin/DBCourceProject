<#import "parts/common.ftl" as c>

<@c.page>

<div>
    ${sportsman.firstName}
    </div>
    <div>
    ${sportsman.lastName}
    </div>
    <div>
    ${sportsman.alias}
</div>
<#include "parts/sportsmanUpdate.ftl" />
</@c.page>