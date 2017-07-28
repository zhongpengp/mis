<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="<%=path %>/js/jquery.validate.min.js"></script>
<title>角色管理</title>
<script type="text/javascript">
	var tableSelectRoleID;
	var tableSelectRoleName;
	$(function(){
		addRoleModalFormValidator();
		roleEditModalFormValidator();
		initRoleTable();
		$('#menuSelect').multiSelect({
			selectableOptgroup:true,
			selectableHeader: "<div class='custom-header'>未拥有的功能</div>",
			selectionHeader: "<div class='custom-header'>已拥有的功能</div>",
		});
		
		$("#functionEditModalBtnReset").on("click",function(){
			initMenuSelector();
		});
		$("#functionEditModalBtnSave").on("click",function(){
			var dialogInstance = BootstrapDialog.confirm({
	            title: '修改角色权限',
	            message: '您即将修改角色权限信息，是否继续？',
	            type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
	            closable: false, // <-- Default value is false
	            draggable: false, // <-- Default value is false
	            btnCancelLabel: '取消', // <-- Default value is 'Cancel',
	            btnOKLabel: '确定修改', // <-- Default value is 'OK',
	            btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
	            callback: function(result) {
	                // result will be true if button was click, while it will be false if users close the dialog directly.
	                if(result) {
	                	$.ajax({
	        				url:'<%=path%>/menuController/saveRole_Menu',
	        				data:$("#menuSelectForm").serialize(),
	        				success:function(data){
	        					$("#roleEditModal").modal('hide');
	    						BootstrapDialog.alert({
	    				            title: '修改角色权限',
	    				            message: '修改角色权限成功!',
	    				            size:'size-small',
	    				            type:'type-success', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
	    				            closable: true, // <-- Default value is false
	    				            buttonLabel: '确定', // <-- Default value is 'OK',
	    				            callback: function(result) {
	    				                // result will be true if button was click, while it will be false if users close the dialog directly.
	    				            }
	    				        });
	        				},
	        				error:function(data){
	        					BootstrapDialog.alert({
	    				            title: '修改角色权限',
	    				            message: '修改角色权限失败!请重试',
	    				            size:'size-small',
	    				            type:'type-danger', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
	    				            closable: true, // <-- Default value is false
	    				            buttonLabel: '确定', // <-- Default value is 'OK',
	    				            callback: function(result) {
	    				                // result will be true if button was click, while it will be false if users close the dialog directly.
	    				            }
	    				        });
	        				}
	        			});
	                }else {
	                	dialogInstance.close();
	                }
	            }
	        });
			
			
			
			
			
			
			
		});
		
		$("#btnRoleAdd").on("click",function(){
			$("#roleAddModal").modal("show");
		});
		
		$("#roleAddModalBtnSave").on("click", function(){
			$("#roleAddModalForm").bootstrapValidator('validate');
			var isValid = $("#roleAddModalForm").data("bootstrapValidator").isValid();
			if(isValid==true){
				$.ajax({
					url:'<%=path%>/menuController/saveNewRole',
					method:'post',
					data:$("#roleAddModalForm").serialize(),
					success:function(data){
						$("#roleAddModal").modal('hide');
						 BootstrapDialog.alert({
				            title: '新增角色',
				            message: '添加角色成功!',
				            size:'size-small',
				            type:'type-success', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
				            closable: true, // <-- Default value is false
				            draggable: true, // <-- Default value is false
				            buttonLabel: '确定', // <-- Default value is 'OK',
				            callback: function(result) {
				                // result will be true if button was click, while it will be false if users close the dialog directly.
				            }
				        });
						resetValidator();
						initRoleTable();
					}
				});
			}
		});
		
		$("#roleEditModalBtnSave").on("click", function(){
			$("#roleEditModalForm").bootstrapValidator('validate');
			var isValid = $("#roleEditModalForm").data("bootstrapValidator").isValid();
			if(isValid==true){
				var dialogInstance = BootstrapDialog.confirm({
		            title: '修改角色',
		            message: '您即将修改角色信息，是否继续？',
		            type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
		            closable: false, // <-- Default value is false
		            draggable: false, // <-- Default value is false
		            btnCancelLabel: '取消', // <-- Default value is 'Cancel',
		            btnOKLabel: '确定修改', // <-- Default value is 'OK',
		            btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
		            callback: function(result) {
		                // result will be true if button was click, while it will be false if users close the dialog directly.
		                if(result) {
		                	$.ajax({
		    					url:'<%=path%>/menuController/updateNewRole',
		    					method:'post',
		    					data:$("#roleEditModalForm").serialize(),
		    					success:function(data){
		    						$("#roleEditModal").modal('hide');
		    						BootstrapDialog.alert({
		    				            title: '修改角色',
		    				            message: '修改角色成功!',
		    				            size:'size-small',
		    				            type:'type-success', // <-- Default value is BootstrapDialog.TYPE_PRIMARY
		    				            closable: true, // <-- Default value is false
		    				            buttonLabel: '确定', // <-- Default value is 'OK',
		    				            callback: function(result) {
		    				                // result will be true if button was click, while it will be false if users close the dialog directly.
		    				            }
		    				        });
		    						resetValidator();
		    						initRoleTable();
		    					}
		    				});
		                }else {
		                	dialogInstance.close();
		                }
		            }
		        });
				
			}
		});
		
		$("#query").on("click",function(){
			initRoleTable();
		});
		
		$("#tableBtnFunctionEdit").on("click",function(){
			var tableSelected = $("#roleTable").bootstrapTable('getSelections');
			if(tableSelected.length!=1){
				showAlarmMessage("请只选择一条数据进行操作！","alert-warning");
			}else{
				tableSelectRoleName = tableSelected[0].roleName;
				tableSelectRoleID = tableSelected[0].roleID;
				$("#iptRoleID").val(tableSelectRoleID);
				$("#functionEditModal").modal("show");
			}
		});
		$("#tableBtnRoleEdit").on("click",function(){
			var tableSelected = $("#roleTable").bootstrapTable('getSelections');
			if(tableSelected.length!=1){
				showAlarmMessage("请只选择一条数据进行操作！","alert-warning");
			}else{
				tableSelectRoleName = tableSelected[0].roleName;
				tableSelectRoleID = tableSelected[0].roleID;
				$("#roleEditModal").modal("show");
			}
		});
		$("#tableBtnRoleDelete").on("click",function(){
			var selectedIDs='';
			var tableSelected = $("#roleTable").bootstrapTable('getSelections');
			if(tableSelected.length==0){
				showAlarmMessage("请先选择要删除的角色！","alert-warning");
			}else{
				$(tableSelected).each(function(index,value){
					if(index==tableSelected.length-1){
						selectedIDs+=value.roleID;
					}else{
						selectedIDs+=value.roleID+",";
					}
				});
				var dialogInstance = BootstrapDialog.show({
					title:'删除角色',
					type:'type-danger',
					closable:false,
					message:'您即将删除所选择的角色，是否确认删除？！',
					buttons:[
						{
							label:'取消',
							action:function(dialog){
								dialog.close();
							}
						},
						{
							 icon: 'glyphicon glyphicon-trash',
							 label:'确认删除',
							 cssClass:'btn-danger',
							 autospan:true,
							 action:function(dialog){
								 dialog.enableButtons(false);
								 dialog.setClosable(false);
								 $.ajax({
									url:'<%=path%>/menuController/deleteRoleByIDs',
									data:{
										'roleIDs':selectedIDs
									},
									success:function(data){
										initRoleTable();
										dialogInstance.close();
										BootstrapDialog.alert({
											title:'删除菜单',
											message:'删除角色成功！',
											type:'type-success',
											size:'size-small'
										});
									}
								 });
							 }
						}
						
					]
				});
			}
		});
		
		$("#functionEditModal").on("show.bs.modal",function(){
			$("#functionEditModalTitle").text(tableSelectRoleName);
			initMenuSelector();
		})
		
		$("#roleAddModal").on("show.bs.modal",function(){
			$("#roleAddModalForm")[0].reset();
			resetValidator();
		})
		$("#roleEditModal").on("show.bs.modal",function(){
			initRoleEditModal();
		})
		$("#roleDeleteModal").on("show.bs.modal",function(){
			$("#roleDeleteModalForm").show();
			$("#roleDeleteModalErrorMessage").hide();
			$("#roleDeleteModalSuccessMessage").hide();
		})
		$("#roleDeleteModalBtnSave").on("click",function(){
			$.ajax({
				url:'<%=path%>/menuController/deleteRoleByRoleIDs',
				data:{
					'roleIDs':selectedIDs
				},
				success:function(){
					initRoleTable();
					$("#roleDeleteModalForm").hide();
					$("#roleDeleteModalSuccessMessage").show();
				},
				error:function(){
					$("#roleDeleteModalErrorMessage").show();
				}
			});		
		})
	});
	
	function resetValidator(){
		$("#roleAddModalForm").bootstrapValidator('resetForm');
		$("#roleEditModalForm").bootstrapValidator('resetForm');
	}
	
	function addRoleModalFormValidator(){
		$('#roleAddModalForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {/*验证*/
                roleName: {/*键名username和input name值对应*/
                    message: '角色名称无效',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '角色名称不能为空'
                        },
                        stringLength: {/*长度提示*/
                            max: 30,
                            message: '角色名称长度必须小于30'
                        },
                        threshold :  1 , //有1字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，1字符以上才开始）
                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                            url: '<%=path%>/menuController/checkRoleNameExist',//验证地址
                            message: '该角色名称已存在，请输入其他名称',//提示消息
                            delay :  1000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            type: 'POST'//请求方式
                            /**自定义提交数据，默认值提交当前input value
                             *  data: function(validator) {
                                  return {
                                      password: $('[name="passwordNameAttributeInYourForm"]').val(),
                                      whatever: $('[name="whateverNameAttributeInYourForm"]').val()
                                  };
                               }
                             */
                        }
                    }
                }
            }
        });
	}
	
	function roleEditModalFormValidator(){
		$('#roleEditModalForm').bootstrapValidator({
			 message: 'This value is not valid',
	            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
	                valid: 'glyphicon glyphicon-ok',
	                invalid: 'glyphicon glyphicon-remove',
	                validating: 'glyphicon glyphicon-refresh'
	            },
	            fields: {/*验证*/
	                roleName: {/*键名username和input name值对应*/
	                    message: '角色名称无效',
	                    validators: {
	                        notEmpty: {/*非空提示*/
	                            message: '角色名称不能为空'
	                        },
	                        stringLength: {/*长度提示*/
	                            max: 30,
	                            message: '角色名称长度必须小于30'
	                        },
	                        threshold :  1 , //有1字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，1字符以上才开始）
	                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
	                            url: '<%=path%>/menuController/checkEditRoleNameExist',//验证地址
	                            message: '该角色名称已存在，请输入其他名称',//提示消息
	                            delay :  1000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
	                            type: 'POST'//请求方式
                            /**自定义提交数据，默认值提交当前input value
                             *  data: function(validator) {
                                  return {
                                      password: $('[name="passwordNameAttributeInYourForm"]').val(),
                                      whatever: $('[name="whateverNameAttributeInYourForm"]').val()
                                  };
                               }
                             */
                             ,data: function(validator) {
                                 return {
                                     oldName: tableSelectRoleName,
                                     newName: $("#roleEditModalFormRoleName").val()
                                 };
                              }
                        }
                    }
                }
            }
        });
	}
	
	function initRoleEditModal(){
		$.ajax({
			url:'<%=path%>/menuController/getRoleByRoleID',
			async:false,
			data:{
				'roleID':tableSelectRoleID
			},
			success:function(data){
				$("#roleEditModalFormRoleID").val(data.roleID);
				$("#roleEditModalFormRoleName").val(data.roleName);
				$("#roleEditModalFormRoleDesc").val(data.roleDesc);
			}
		});
	}
	
	function checkRoleNameExist(iptRoleName){
		var count = '';
		$.ajax({
			url:'<%=path%>/menuController/checkRoleNameExist',
			async:false,
			data:{
				'roleName':encodeURI(iptRoleName)
			},
			success:function(data){
				count=data;
			}
		});
		return count;
	}
	function initRoleTable(){
		$("#roleTable").bootstrapTable("destroy");
		$("#roleTable").bootstrapTable({
			url: '<%=path%>/menuController/getRolesByName',
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
           strictSearch: true,
           //showColumns: true,     //是否显示所有的列
           //showRefresh: true,     //是否显示刷新按钮
           minimumCountColumns: 2,    //最少允许的列数
           clickToSelect: true,    //是否启用点击选中行
			queryParams : function(data) {
			    data.roleName=encodeURI($('#formRoleName').val());
				return data;
			},
			onDblClickRow : function(row,$element,field) {
				
			},
			columns : [
					{field : 'check_box', checkbox : true},
				    {field : 'roleID', title : '角色编号', visible : true},
				    {field : 'roleName', title : '角色名称', visible : true},
				    {field : 'roleDesc', title : '角色描述', visible : true}
			]
		});
	}
	
	function showAlarmMessage(message,classType){
		$("#alertMessageFont").text(message);
		$("#alertDIV").addClass(classType).show().delay("3000").fadeOut();;
	}
	function initMenuSelector(){
		$.ajax({
			async:false,
			url:'<%=path%>/menuController/getMenusWithIsOwned',
			data:{
				'roleID':tableSelectRoleID
			},
			success:function(data){
				//debugger;
				$("#menuSelect").empty();
				$('#menuSelect').multiSelect('refresh');
				var appendText='';
				$(data).each(function(index,value){
					if (value.belongMenuID == '0') {
						appendText+='<optgroup label="'+value.menuName+'">';
					} else if (index == data.length - 1|| data[index + 1].belongMenuID == '0') {
						if(value.roleID=="null"||value.roleID==null){
							appendText+='<option value="'+value.menuID+'">'+value.menuName+'</option></optgroup>';
						}else{
							appendText+='<option value="'+value.menuID+'" selected>'+value.menuName+'</option></optgroup>';
						}
					} else {
						if(value.roleID=="null"||value.roleID==null){
							appendText+='<option value="'+value.menuID+'">'+value.menuName+'</option>';
						}else{
							appendText+='<option value="'+value.menuID+'" selected>'+value.menuName+'</option>';
						}
					}
				});
				$("#menuSelect").append(appendText);
				$('#menuSelect').multiSelect('refresh');
			}
		});
	}
	
</script>
</head>
<body>
	<div class="content">
		<div class="page-content-wrapper">
			<div id="title_query">
				<ul class="breadcrumb" style="font-size: 13px; margin: 0">
					<li>成绩管理系统</li>
					<li>权限管理</li>
					<li class="active">角色管理</li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="tjsx_title" id="chooseDIV">条件筛选：</div>
			<form id="queryForm" class="form-horizontal" role="form">
				<div id="filter">
					<div id="queryDIV" class="filtrate_box clearfix">
						<ul class="filtrate_list">
							<li class="child_li first_sort">
								<div class="list_left">角色名称：</div>
								<div class="list_right">
									<div class="list_content fix_list">
										<div id="roleSelecter" class="clearfix"></div>
										<div class="col-md-3">
											<input type="text" class="form-control" id="formRoleName" name="formRoleName"/>
										</div>
										<button id="query" type="button" class="btn btn-info">
											查询</button>
										<button id="queryReset" type="button" class="btn btn-warning">
											重置</button>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</form>
		</div>
		<div id="alertDIV" class="alert" style="display: none">
			<a href="#" class="close" data-dismiss="alert">&times;</a> 
			<strong><font id="alertMessageFont"></font></strong>
		</div>
		<button id="btnRoleAdd" class="btn btn-success">新增角色</button>
		<button id="tableBtnRoleEdit" class="btn btn-warning">修改角色</button>
		<button id="tableBtnRoleDelete" class="btn btn-danger">删除角色</button>
		<button id="tableBtnFunctionEdit" class="btn btn-info">权限修改</button>
		<table id="roleTable" class="table">
			<thead style="background-color : #87CEFF"></thead>
		</table>
		
		<!-- 权限修改模态框（Modal） -->
		<div class="modal fade" id="functionEditModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">角色【<font id="functionEditModalTitle"></font>】权限修改</h4>
		            </div>
		            <div class="modal-body">
		            	<form id="menuSelectForm" role="form">
							<input id="iptRoleID" name="roleID" style="display: none" /> 
							<select multiple="multiple" id="menuSelect" name="menuSelect" style="width:100%; margin: 0 auto">
							</select>
						</form>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                <button id="functionEditModalBtnReset" type="button" class="btn btn-info">重置</button>
		                <button id="functionEditModalBtnSave" type="button" class="btn btn-primary">保存</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!-- 新增角色模态框（Modal） -->
		<div class="modal fade" id="roleAddModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">【新增角色】</h4>
		            </div>
		            <div class="modal-body">
						<form id="roleAddModalForm" class="form-horizontal" role="form">
						  <div class="form-group">
						    <label for="roleName" class="col-sm-2 control-label">角色名称</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="roleName" placeholder="请输入名称"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="roleDesc" class="col-sm-2 control-label">角色描述</label>
						    <div class="col-sm-10">
						      <textarea class="form-control" rows="3" name="roleDesc" placeholder="请输入角色描述"></textarea>
						    </div>
						  </div>
						  <div class="form-group" align="center">
						    <button id="roleAddModalBtnReset" type="button" class="btn btn-default">重置</button>
		                	<button id="roleAddModalBtnSave" type="button" class="btn btn-primary">保存</button>
						  </div>
						</form>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!-- 修改角色模态框（Modal） -->
		<div class="modal fade" id="roleEditModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">【修改角色】</h4>
		            </div>
		            <div class="modal-body">
						<form id="roleEditModalForm" class="form-horizontal" role="form">
						  <div class="form-group" style="display: none">
						    <label for="roleID" class="col-sm-2 control-label">角色名称</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="roleEditModalFormRoleID" name="roleID"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="roleName" class="col-sm-2 control-label">角色名称</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" id="roleEditModalFormRoleName" name="roleName" placeholder="请输入名称"/>
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="roleDesc" class="col-sm-2 control-label">角色描述</label>
						    <div class="col-sm-10">
						      <textarea class="form-control" rows="3"  id="roleEditModalFormRoleDesc" name="roleDesc" placeholder="请输入角色描述"></textarea>
						    </div>
						  </div>
						  <div class="form-group" align="center">
						    <button id="roleEditModalBtnReset" type="button" class="btn btn-default">重置</button>
		                	<button id="roleEditModalBtnSave" type="button" class="btn btn-primary">保存</button>
						  </div>
						</form>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!-- 删除角色模态框（Modal） -->
		<div class="modal fade" id="roleDeleteModal" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">【删除角色】</h4>
		            </div>
		            <div class="modal-body">
			            <div id="roleDeleteModalSuccessMessage" class="alert alert-success" style="display: none">
							<a href="#" class="close" data-dismiss="alert">&times;</a> 
							<strong>删除成功！</strong>
						</div>
			            <div id="roleDeteteModalErrorMessage" class="alert alert-danger" style="display: none">
							<a href="#" class="close" data-dismiss="alert">&times;</a> 
							<strong>删除失败，请重试！</strong>
						</div>
						<form id="roleDeleteModalForm" class="form-horizontal" role="form">
						  <div class="form-group" align="center">
						  	您即将删除<font id="roleDeleteModalDeleteNum"></font>个角色，是否确认删除？
						  </div>
						  <div class="form-group" align="center">
						    <button id="roleDeleteModalBtnReset" type="button" class="btn btn-default">取消</button>
		                	<button id="roleDeleteModalBtnSave" type="button" class="btn btn-primary">确认删除</button>
						  </div>
						</form>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>

	</div>
</body>
</html>