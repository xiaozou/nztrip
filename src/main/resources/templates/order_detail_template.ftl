<div class="form-group"><label>订单详情</label></div>
<div class="form-group"><input type="text" id="j_name" class="form-control" disabled placeholder="项目" value="${order.sku}">
</div>
<div class="form-group"><label>价格:</label><span>   ${order.price}</span></div>
<div class="form-group"><label>Reference Number:</label><span>   ${order.referenceNumber}</span></div>
<div class="form-group"><label>游客信息</label></div>
<div class="form-group">
    <table class="table">
        <thead>
        <tr>
            <th>票种</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>体重</th>
        </tr>
        </thead>
        <tbody id="j_ticket_container">
        <#list tickets as ticket>
        <tr>
            <td>${ticket.skuTicket}</td>
            <td>${ticket.name}</td>
            <td>${ticket.age}</td>
            <td>${ticket.weight}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
<div class="form-group"><label>主要联系人</label></div>
<div class="form-group"><input type="text" id="j_primary_contact" class="form-control" <#if editing=false>disabled</#if> placeholder="主要联系人" value="${order.primaryContact}">
</div>
<div class="form-group"><input type="text" id="j_primary_contact_email" class="form-control" <#if editing=false>disabled</#if> placeholder="Email" value="${order.primaryContactEmail}">
</div>
<div class="form-group"><input type="text" id="j_primary_contact_phone" class="form-control" <#if editing=false>disabled</#if> placeholder="联系电话" value="${order.primaryContactPhone}">
</div>
<div class="form-group"><input type="text" id="j_primary_contact_wechat" class="form-control" <#if editing=false>disabled</#if> placeholder="微信" value="${order.primaryContactWechat}">
</div>
<div class="form-group"><label>备用联系人</label></div>
<div class="form-group"><input type="text" id="j_secondary_contact" class="form-control" <#if editing=false>disabled</#if> placeholder="备用联系人" value="${order.secondaryContact}">
</div>
<div class="form-group"><input type="text" id="j_secondary_contact_email" class="form-control" <#if editing=false>disabled</#if> placeholder="Email" value="${order.secondaryContactEmail}">
</div>
<div class="form-group"><input type="text" id="j_secondary_contact_phone" class="form-control" <#if editing=false>disabled</#if> placeholder="联系电话" value="${order.secondaryContactPhone}">
</div>
<div class="form-group"><input type="text" id="j_secondary_contact_wechat" class="form-control" <#if editing=false>disabled</#if> placeholder="微信" value="${order.secondaryContactWechat}">
</div>