<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/mainPage.css">
	<script type="text/javascript">
	var remaintime = '${remaintime}';
	$(function(){
		//document.getElementById("mainFrame").height = "99%";
	});
    var t = null;
    time();//开始执行
    function time()
    {
       clearTimeout(t);//清除定时器
       dt = new Date();
       var y=dt.getFullYear();
       var m=dt.getMonth()+1;
       var d=dt.getDate();
       var h=dt.getHours();
       var mm=dt.getMinutes();
       if(mm<10){
    	   mm="0"+mm;
       }
       $("#timeShow").text("时间："+y+"-"+m+"-"+d+"  "+h+":"+mm);
       t = setTimeout(time,5000); //设定定时器，循环执行             
    } 
    

	</script>
<script type="text/javascript">
	var userID = '<%=request.getSession().getAttribute("userID")%>';
	var userName = '<%=request.getSession().getAttribute("userName")%>';
	var userType = '<%=request.getSession().getAttribute("userType")%>';
	var loginMessage = '<%=request.getSession().getAttribute("loginMessage")%>';
	$(function(){
		$("#changePassword").click(function(){
			if($("#menu04").attr("aria-expanded")!="true"){
			 $("#infoMngMenu").trigger("click"); 
			}
			 $("#userInfoMenu i").trigger("click"); 
	    });
	    $("#logout").click(function(){ 
	    	$("#toLoginout").submit();
	    });
	    $("#shouye").click(function(){ 
	    	//window.location.href="${path}/logindmp.html"; 
	    });
	    
		if(loginMessage.indexOf("未修改")>0){
			var dialogInstance = BootstrapDialog.show({
				title:'信息修改',
				type:'type-info',
				closable:false,
				message:'欢迎您登录本系统！\n<font color="red">您还未修改过个人信息，为了您的安全，请前往个人中心修改或完善信息!</font>',
				buttons:[
					{
						label:'稍后修改',
						action:function(dialog){
							dialog.close();
						}
					},
					{
						 icon: 'glyphicon glyphicon-circle-arrow-right',
						 label:'前往修改',
						 cssClass:'btn-success',
						 autospan:true,
						 action:function(dialog){
							 dialog.close();
							 if($("#menu04").attr("aria-expanded")!="true"){
								 $("#infoMngMenu").trigger("click"); 
								}
							 $("#userInfoMenu i").trigger("click"); 
						 }
					}
					
				]
			});
		}
			
		$("#mainPage").height($(document).height()-$("#mainTitle").height()-20);
		initMenuItem(userID);
	});
	function initMenuItem(){
		var appendText='';
		if(userType=="4"){//系统管理员
			appendText+='<li><a href="#menu01" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;注册审批 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu01" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a href="<%=path %>/views/apply/register_applyList_gs.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>公司审批</a></li>';
			appendText+='<li><a href="<%=path %>/views/apply/register_applyList_gys.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>供应商审批</a></li></ul>';
			appendText+='<li><a href="#menu03" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;日志管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu03" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a href="<%=path %>/views/log/loginLog.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>登录日志</a></li></ul></li>';
		}else if(userType=="2"){//项目
			appendText+='<li><a  href="#menu05" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;项目管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu05" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/common/projectInfo.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>项目信息</a></li></ul></li>';
			appendText+='<li><a  href="#menu06" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;设备管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu06" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/baseProjectInfo/baseMachineInfo.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>设备基础信息</a></li>';
			appendText+='<li><a  href="<%=path %>/views/baseProjectInfo/CheckMachineList.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>设备检定信息</a></li>';
			appendText+='<li><a  href="<%=path %>/views/baseProjectInfo/RepairMachineList.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>设备维修信息</a></li>';
			appendText+='<li><a  href="<%=path %>/views/baseProjectInfo/newMachineApply.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>新设备申请 &nbsp;&nbsp;</a></li></ul></li>';
		}else if(userType=="1"){//公司
			appendText+='<li><a  href="#menu_gs_registerApproval" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;注册审批 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu_gs_registerApproval" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/apply/register_applyList_xm.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>项目审批</a></li></ul></li></ul>';
			appendText+='<li><a  href="#menu_gs_supplierMng" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;供应商管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu_gs_supplierMng" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/supplierMng/companySupplierMng.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>我的供应商</a></li></ul></li></ul>';
			appendText+='<li><a  href="#menu_gs_projectMng" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;项目管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu_gs_projectMng" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/projectMng/projectList_gs.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>我的项目</a></li></ul></li></ul>';
			appendText+='<li><a  href="#menu_gs_machineMng" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;设备管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu_gs_machineMng" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/baseProjectInfo/importProjectMachineApproval.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>项目设备审批</a></li></ul></li></ul>';
		}else if(userType=="3"){//供应商
			appendText+='<li><a  href="#menu_gys_approvalSupplier" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;合作审批 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu_gys_approvalSupplier" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/supplierMng/approvalSupplierApplyFromGS.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>公司审批</a></li>';
			appendText+='<li><a  href="<%=path %>/views/supplierMng/approvalSupplierApplyFromXM.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>项目审批</a></li></ul>';
			appendText+='<li><a  href="#menu_gys_projectMachineMng" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;设备管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu_gys_projectMachineMng" class="nav nav-list collapse secondmenu" style="height: 0px;">';
			appendText+='<li><a  href="<%=path %>/views/baseProjectInfo/importProjectMachineInfo.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>项目设备管理</a></li>';
			appendText+='<li><a  href="<%=path %>/views/baseProjectInfo/approvalSupplierApplyFromXM.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>设备发货</a></li></ul>';
		}
		appendText+='<li><a id="infoMngMenu" href="#menu04" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;个人中心 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu04" class="nav nav-list collapse secondmenu" style="height: 0px;">';
		appendText+='<li><a id="userInfoMenu" href="<%=path %>/views/common/userInfo.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>信息修改</a></li></ul></li>';
		appendText+='<li><a id="msgInfoMenu" href="#menu07" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;消息中心 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu07" class="nav nav-list collapse secondmenu" style="height: 0px;">';
		appendText+='<li><a id="msgListMenu" href="<%=path %>/views/projectMsg/projectMsgList.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>消息列表</a></li>';
		appendText+='<li><a id="addMsgMenu" href="<%=path %>/views/projectMsg/addProjectMsg.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>发送消息</a></li></ul></li>';
		appendText+='<li><a id="fileMenu" href="#menu08" class="nav-header collapsed" data-toggle="collapse"><i class="glyphicon glyphicon-th-large"></i>&nbsp;&nbsp;附件管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span></a><ul id="menu08" class="nav nav-list collapse secondmenu" style="height: 0px;">';
		appendText+='<li><a id="FileListMenu" href="<%=path %>/views/FileMng/FileList.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>附件列表</a></li>';
		appendText+='<li><a id="addFileMenu" href="<%=path %>/views/FileMng/addUploadFile.jsp" target="fname"><i class="glyphicon glyphicon-th-list"></i>附件上传</a></li></ul></li>';
		$("#main-nav").val("");
		$("#main-nav").append(appendText);
	}
</script>
</head>

<body>
	<div id="mainTitle" class="navbar navbar-duomi navbar-static-top" role="navigation">
		<div class="container-fluid" style="padding-left: 0px;padding-right: 0px;">
			<div class="navbar-header">
				
			</div>
		
		
		 <div class="top_rt">          
          <div class="top_rt_1" style="width:100%;">
          <a class="navbar-brand" href="#">xxxx管理系统 </a>
            <span style="color: white">用户名 :&nbsp;&nbsp;${userName}</span>
            <span  style=" margin-right:30px;color: white" id ="timeShow"></span>
            <a id="shouye" style="cursor: pointer;"><img src="<%=path %>/img/ico-shouye.png" width="21" height="18"/ style=" margin-left:30px;"></a>
            <a id="changePassword" style="cursor: pointer;" ><img src="<%=path %>/img/ico-denglu.png" width="18" height="18" /></a>
            <a id="logout" style="cursor: pointer;"><img src="<%=path %>/img/ico-tuichu.png" width="18" height="18"/></a>
          </div>
        </div>
      </div></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-xs-2 col-sm-2 col-lg-2" style="padding-left:1px;padding-right: 0;">
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
				</ul>
			</div>
			<div id="mainPage" class="col-md-10 col-xs-10 col-sm-10 col-lg-10" style="padding: 0">
				<iframe name="fname" style="width:100%;height:100%;border:none;border-left-style: solid;border-color: #4F94CD"></iframe>
			</div>
		</div>
	</div>
</body>
</html>