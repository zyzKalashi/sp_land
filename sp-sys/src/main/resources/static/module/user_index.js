var vm = new Vue({
	el : '#app',
	data : {
		queryData_pro: {
			createUser: "",
			pageSize: 8,
			pageNo: 1,
		},
		queryData_dem: {
			createUser: "",
			pageSize: 6,
			pageNo: 1,
		},
		userData: {},
		loginLog: {},
		projectList:[],
		demandList:[],
		areaDic:[],
		childAreas:[],
		winFlag: {
			win_indexInfo: true,
			win_baseInfo: false,
			win_idCard: false,
			win_password: false,
			win_phone: false,
			win_email: false,
		},
		useFlag: {
        	userNameFlag: false,
        	emailFlag: false,
        	mobileFlag: false,
        },
	},
	mounted : function() {
		this.initArea();
		this.userData.userId = this.queryData_pro.createUser = this.queryData_pro.queryData_dem = $("#baseUserId").text();
		if(!this.userData.userId){
			location.href = "../html/login";
		} 
		this.initUser();
		this.initProjectList();
		this.initUploadPlugin("userPic");
	},
	methods : {
		initUser: function () {
			var tUser = new Object();
			tUser.userId = this.userData.userId;
			$.post("/user/userDetail", tUser, function (result) {
				if (result.code == 0) {
                	vm.userData = result.userData;
                	vm.loginLog = result.loginLog;
                	if(!vm.userData.areaCode){
                		vm.userData.areaCode = 0;
                		if(!vm.userData.townCode){
                			vm.userData.townCode = 0;
                		}
                	}
                } else {
					alert(result.msg);
                    layer.msg(result.msg);
                }
            });
		},
		initProjectList: function () {
			hzToolObj.getdomInit("/project/simpleList", this.queryData_pro, function(result){
                	vm.projectList = result.pageInfo.list;
			});
		},
		initDemandList: function () {
			hzToolObj.getdomInit("/demand/simpleList", this.queryData_dem, function(result){
                	vm.demandList = result.pageInfo.list;
			});
		},
		modifyProject: function(projectId){
			window.location.href = "../login/project_add?projectId=" + projectId;
		},
		modifyDemand: function(demandId){
			window.location.href = "../login/demand_add?demandId=" + demandId;
		},
		cancelUser: function(){
			layer.confirm("确认注销吗？", {
                icon: 3,
                title: '提示',
                btn: ["注销", "取消"]
            }, function (index) {
            	layer.closeAll('dialog');
            	vm.modifyUser("cancelUser");
            	var projectIds = [];
            	projectList.filter((item)=>{
            		if(item.status == 2){
            			projectIds.add(item.projectId);
            		}
                });
            	var demandIds = [];
            	demandList.filter((item)=>{
            		if(item.status == 2){
            			demandIds.add(item.demandId);
            		}
                });
            	var obj = {
            			projectIds: projectIds,
            		 	demandIds: demandIds,
            			status: 0,
            	}
            	$.post("/project/batchModify", obj, function (result) {});
            	$.post("/demand/batchModify", obj, function (result) {});
            	window.location.herf = "/logoutCommon";
            });
		},
		delProject: function(projectId){
			 layer.confirm("确认删除吗？", {
                    icon: 3,
                    title: '提示',
                    btn: ["删除", "取消"]
                }, function (index) {
                	layer.closeAll('dialog');
                    var newObj = {
                    	projectId: projectId,
                        projectStatus: 0,
                    }
                    vm.updateProject(newObj);
                });
		},
		updateProject: function(obj){
			$.post("/project/projectModify", obj, function (result) {
				if (result.code == 0) {
                	vm.initProjectList();
                	layer.alert("操作成功");
                } else {
                    layer.msg(result.msg);
                }
        	});
		},
		delDemand: function(demandId){
			 layer.confirm("确认删除吗？", {
                    icon: 3,
                    title: '提示',
                    btn: ["删除", "取消"]
                }, function (index) {
                	layer.closeAll('dialog');
                    var newObj = {
                    	demandId: demandId,
                        demandStatus: 0,
                    }
                    vm.updateDemand(newObj);
                });
		},
		updateDemand: function(obj){
			$.post("/demand/demandModfiy", obj, function (result) {
				if (result.code == 0) {
                	vm.initDemandList();
                	layer.alert("操作成功");
                } else {
                    layer.msg(result.msg);
                }
        	});
		},
		goProDetail: function(id){
			storage.setItem("projectQueryData",JSON.stringify(vm.queryData_pro));
			window.location.href="../html/project_detail?projectId=" + id;
		},
		goDemDetail: function(id){
			storage.setItem("demandQueryData",JSON.stringify(vm.queryData_dem));
			window.location.href="../html/demand_detail?demandId=" + id;
		},
		openWin: function(flag){
			if(flag == 'win_baseInfo'){
				vm.winFlag.win_baseInfo = true;
				vm.winFlag.win_indexInfo = false;
				vm.winFlag.win_idCard = false;
				vm.winFlag.win_password = false;
				vm.winFlag.win_phone = false;
				vm.winFlag.win_email = false;
			} else if(flag == 'win_idCard'){
				vm.winFlag.win_idCard = true;
				vm.winFlag.win_indexInfo = false;
				vm.winFlag.win_baseInfo = false;
				vm.winFlag.win_password = false;
				vm.winFlag.win_phone = false;
				vm.winFlag.win_email = false;
				if(!$("#idCardPic").hasClass("webuploader-container")){
					vm.initUploadPlugin("idCardPic");
					vm.initUploadPlugin("idCardPicBack");
				}
			} else if(flag == 'win_password'){
				vm.winFlag.win_idCard = false;
				vm.winFlag.win_indexInfo = false;
				vm.winFlag.win_baseInfo = false;
				vm.winFlag.win_password = true;
				vm.winFlag.win_phone = false;
				vm.winFlag.win_email = false;
			} else if(flag == 'win_phone'){
				vm.winFlag.win_idCard = false;
				vm.winFlag.win_indexInfo = false;
				vm.winFlag.win_baseInfo = false;
				vm.winFlag.win_password = false;
				vm.winFlag.win_phone = true;
				vm.winFlag.win_email = false;
			} else if(flag == 'win_email'){
				vm.winFlag.win_idCard = false;
				vm.winFlag.win_indexInfo = false;
				vm.winFlag.win_baseInfo = false;
				vm.winFlag.win_password = false;
				vm.winFlag.win_phone = false;
				vm.winFlag.win_email = true;
			}
		},
		closeOpenWin: function(){
			vm.winFlag.win_indexInfo = true;
			vm.winFlag.win_idCard = false;
			vm.winFlag.win_baseInfo = false;
			vm.winFlag.win_password = false;
			vm.winFlag.win_phone = false;
			vm.winFlag.win_email = false;
		},
		updUserPassword: function(flag){
			if(vm.userData.newPassword.length < 6){
				layer.alert("密码长度应大于6位！");
			}
			var tUser = new Object();
			tUser.userId = vm.userData.userId;
			$.post("/user/checkUser", tUser, function (result) {
				if (result.code == 0) {
					vm.modifyUser("changePassword");
                } else {
                	layer.msg(result.msg);
                }
        	});
		},
		modifyUser: function(flag){
			if(flag == "changeMobile"){
				if(!vm.userData.newMobile){
					layer.alert("请重填写新手机号码！");  
					return; 
				} else if(!(mobileReg.test(vm.userData.newMobile))){ 
					layer.alert("手机号码有误，请重填！");  
					return; 
				} else if(!vm.useFlag.mobileFlag){
					layer.alert("手机号码已注册，请重填！");  
					return; 
				} else {
					vm.userData.mobile = this.userData.newMobile;
				}
			} else if (flag == "changeEmail") {
				if(!vm.userData.newEmail){
					layer.alert("请重填写新邮箱！");  
					return; 
				} else if(!emailReg.test(vm.userData.newEmail)){
					layer.alert("邮箱格式有误，请重填");  
					return; 
				} else if(!vm.useFlag.emailFlag){
					layer.alert("邮箱已注册，请重填！");  
					return; 
				} else {
					vm.userData.email = vm.userData.newEmail;
				}
			} else if (flag == "baseInfo") {
				if (!vm.userData.userName) {
                    layer.alert("请输入用户名！");
                    return;
				} else if(!vm.useFlag.emailFlag){
					layer.alert("用户名已注册，请重填！");  
					return; 
				} 
			} else if (flag == "changePassword") {
                if (!vm.userData.newPassword) {
                    layer.alert("请输入密码！");
                    return;
                } else if(vm.user.newPassword.length < 6){
                	 layer.alert("密码长度应大于6位！");
                     return;
                } else if(vm.user.newPassword != vm.user.newPassword_v){
                	 layer.alert("两次密码不一致，请确认！");
                     return;
                } else {
					vm.userData.password = hex_md5(this.userData.newPassword)
                }
			} else if (flag == "cancelUser"){
				vm.userData.userStatus = 0;
			} else if (flag == "changeIdCard") {
				if (vm.userData.idCardNo && !idCardReg.test(vm.userData.idCardNo)) {
					layer.alert("身份证号有误，请重填！");  
					return; 
				}
				vm.userData.userStatus = 2;
			} 
			delete vm.userData.createDate;
            delete vm.userData.updateDate;
            delete vm.userData.auditDate;
			$.post("/user/users_modify", vm.userData, function (result) {
				if (result.code == 0) {
					layer.msg("修改成功！",{icon:1, time:2000, shade:0.4},function () {
						vm.initUser();
						closeWin();
					});
                } else {
                	layer.msg(result.msg);
                }
        	});
		},
		initArea: function(){
			$.post("/area/initArea", {}, function (result) {
                if (result.code == 0) {
                	vm.areaDic = result.area;
                } else {
                    layer.msg(result.msg);
                }
            });
		},
		initUploadPlugin: function(id) {
			WebUploader.create({
				auto: true,
				swf: '/static/plugin/webuploader/Uploader.swf',
				server: '/file/upload',
				pick: '#' + id,
				resize: false,
				formData: {
					fileKind: 5,
				}
			}).on("uploadSuccess",function(file, resp){
				if(0 == resp.code){
					eval('vm.userData.' + id + "='" + resp.url + "';");
					if(id == "userPic"){
						vm.modifyUser("userPic");
					}
				} else {
					alert(resp.msg);
				}
			});
		}
	},
	watch: {
		'userData.areaCode': function(code){
			if(code && code != 0) {
				vm.childAreas = vm.areaDic.filter((item)=>{
                    return item.code == code
                })[0].childAreas;
			}	
		},
	}
});