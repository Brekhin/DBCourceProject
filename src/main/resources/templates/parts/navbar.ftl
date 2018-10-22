<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
                </li>
                <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/index">All fighters</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/fights">All fights</a>
                </li>
                </#if>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/users">User list</a>
                </li>
                </#if>
            </ul>
            <div class="navbar-text mr-3"><#if user??>${name}<#else>Please login</#if></div>
                <@l.logout />
            </div>
    </div>
  </div>
</nav>