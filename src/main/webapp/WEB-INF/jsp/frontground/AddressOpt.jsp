<%--
  Created by IntelliJ IDEA.
  User: 23676
  Date: 2020/5/22
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>地址操作界面</title>

</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/MbDefault.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/updateAddress.js"></script>
<body>
<div class="mainPage">
    <div class="col-md-5 ml-auto">
        <div class="card">
            <div class="card-body p-4">
                <h4 class="text-center">编辑收货信息</h4>
                <form class="signup-form" action="${pageContext.request.contextPath}/address/UpdateAddress" method="post">

                    <div class="form-group">
                        收货人：<input type="text" class="form-control" name="newName" value="${sessionScope.address.addressName}">
                    </div>
                    <div class="form-group">
                        联系方式：<input type="text" class="form-control" name="newPhone" value="${sessionScope.address.addressPhone}">
                    </div>
                    <div class="form-group">
                        省：
                        <select name="newProvince" id="province">
                            <option value="">请选择</option>
                        </select>
                        市：
                        <select name="newCity" id="city" disabled="disabled">
                            <option value="">请选择</option>
                        </select>
                        区：
                        <select name="newDistrict" id="district" disabled="disabled">
                            <option value="">请选择</option>
                        </select>
                    </div>
                    <div class="form-group">
                        &nbsp;邮编:<input type="text" class="form-control" name="newPostcode"  value="${sessionScope.address.addressPostcode}">
                    </div>
                    <div class="form-group">
                        &nbsp;详细地址： <input type="text" class="form-control"  name="newDetail" value="${sessionScope.address.detailedAddress}">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">修改</button>
                    </div>



                </form>

            </div>
        </div>
    </div>
</div>

</body>
</html>
