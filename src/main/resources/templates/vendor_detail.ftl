<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<#include "navigation.ftl"/>
<div class="container-fluid">
    <div class="row">
    <#include "menu.ftl"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="form-group"><label>查看行程商</label></div>
            <div class="form-group"><input type="text" id="j_name" class="form-control"
                                           <#if editing = false>disabled</#if> placeholder="请输入行程商名称"
                                           value="${vendor.name}">
            </div>
            <div class="form-group"><input type="text" id="j_email" class="form-control"
                                           <#if editing = false>disabled</#if> placeholder="请输入行程商邮箱"
                                           value="${vendor.email}">
            </div>
            <div class="form-group"><input type="text" id="j_phone" class="form-control"
                                           <#if editing = false>disabled</#if> placeholder="请输入行程商电话"
                                           value="${vendor.phone!''}">
            </div>

        <#if editing = false>
            <button id="j_edit" class="btn btn-primary form-group">修改</button>
        <#else>
            <button id="j_update" class="btn btn-primary form-group">提交</button>
        </#if>
        </div>
    </div>
</div>

<#include "third_party_file.ftl"/>
<script src="/js/vendor_detail.js"></script>
</body>
</html>
