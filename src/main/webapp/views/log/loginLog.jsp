<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录日志</title>
<script type="text/javascript">
	$(function(){
		initloginLogTable();
	});
	
	function initloginLogTable(){
		$("#loginLogTable").bootstrapTable("destroy");
		$("#loginLogTable").bootstrapTable({
			url: '<%=path%>/logController/getAllLoginLog',
	 		method: 'get',
           //toolbar: '#toolbar',    //工具按钮用哪个容器
           striped: true,      //是否显示行间隔色
           cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
           pagination: true,     //是否显示分页（*）
           maintainSelected:true,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
           //sortable: false,      //是否启用排序
           //sortOrder: "asc",     //排序方式
           //pageNumber:1,      //初始化加载第一页，默认第一页
           pageSize: 10,      //每页的记录行数（*）
           pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
           queryParamsType:'', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                               // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
           //queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
           sidePagination: "client",   //分页方式：client客户端分页，server服务端分页（*）
           //search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
           //strictSearch: true,
           //showColumns: true,     //是否显示所有的列
           //showRefresh: true,     //是否显示刷新按钮
           minimumCountColumns: 2,    //最少允许的列数
           clickToSelect: true,    //是否启用点击选中行
			//queryParams : function(data) {
			  //  data.roleName=encodeURI($('#formRoleName').val());
				//return data;
			//},
			onDblClickRow : function(row,$element,field) {
				
			},
			columns : [
					//{field : 'check_box', checkbox : true},
				    {field : 'loginName', title : '登录用户名', visible : true},
				    {field : 'loginpassword', title : '登录密码', visible : true,
				    	formatter:function(value,row,index){
				    		return "******";
				    	}
				    },
				    {field : 'loginTime', title : '登录时间', visible : true},
				    {field : 'loginTime', title : '登录状态', visible : true,
				   		formatter:function(value,row,index){
				   			if(row.loginMessage.indexOf("登录成功")>=0){
				   				return "成功";
				   			}else{
				   				return "失败";
				   			}
				   		}
				    },
				    {field : 'loginMessage', title : '登录信息', visible : true},
				    {field : 'loginIP', title : '登录IP地址', visible : true}
			]
		});
	}
</script>
</head>
<body>
	<div class="content">
		<div class="page-content-wrapper">
			<div id="title_query">
				<ul class="breadcrumb" style="font-size: 13px;margin: 0">  
					<li>成绩管理系统</li>  
					<li>日志管理</li>  
					<li class="active">登陆日志</li>
				</ul>
			</div>
		</div>
		<div>
			<table id="loginLogTable" class="table table-condensed">
				<thead style="background-color : #87CEFF"></thead>
			</table>
		</div>
	</div>
</body>
</html>