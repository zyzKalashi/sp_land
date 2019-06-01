var vm = new Vue({
			el : '#app',
			data : {
				aeaList: [],
				childAreas: [],
				projectData : {
					// projectPerson
					sex: 0,
					townCode: 0,
					areaCode: 0,
					infoKind: 0,
					
					// project
					projectKind: 0,
					rightKind: 0,
					otherRightFlag: 0,
					againFlag: 0,
					agreeFlag: 0,
					giveupRightFlag: 1,
				}
			},
			mounted : function() {
				this.initArea();
				var id =  window.atob(getUrlParam('projectId'));
				if(id != "ée"){
					this.projectData.projectId = id;
				}
			},
			methods : {
				openUpload: function(flag, projectId){
					var indexOpen = layer.open({
	                    type: 2,
	                    title: '上传',
	                    area: ['90%', '90%'],
	                    fixed: false, // 不固定
	                    skin: 'layer-skin',
	                    maxmin: true,
	                    content: '/admin/project/upload?projectId=' + projectId + "&flag=" + flag,
	                    btn: ["关闭"],
	                    btn: function(index, layero){
	                    	layer.close(layer.index);
	                        return false;
	                    },
	                });
				},
				audit: function (type) {
	                vm.projectData.projectStatus = type;
	                var index = layer.load(0, { shade: [0.1,'#fff'] });
	                delete vm.projectData.createDate;
	                delete vm.projectData.updateDate;
	                delete vm.projectData.auditDate;
	                $.post("/project/projectModify", vm.projectData, function (result) {
	                	if (result.code == 0) {
	                		layer.msg("保存成功！",{icon:1, time:2000, shade:0.4},function () {
	                			var index = parent.layer.getFrameIndex(window.name);
	                			layer.close(index);
	                			parent.layer.close(index);
	                		});
	                		parent.vm.doQuery();
	                	} else {
	                		layer.msg(result.msg);
	                	}
	                });
	            },
				initArea: function(){
					$.post("/area/initArea", {}, function (result) {
                        if (result.code == 0) {
                        	vm.aeaList = result.area;
                        	if(vm.projectData.projectId){
            					vm.initProject();
            				} else {
            					vm.initUser();
            				}
                        } else {
                            layer.msg(result.msg);
                        }
                    });
				},
				submitProject : function(kind) {
					if (vm.checkProject()) {
						var index = layer.load(0, { shade: [0.1,'#fff'] });
						var url = "/project/projectAdd";
						if(kind == "upd"){
							url = "/project/projectModify";
						}
						vm.projectData.projectStatus = 7;
					  	$.post(url, vm.projectData, function (result) {
	                        if (result.code == 0) {
	                            layer.alert("请携带身份证、产权证去邻近乡镇柜台办理！",{icon:1, shade:0.4},function () {
	                                window.location.href = "../login/user_index";
	                            });
	                        } else {
	                            layer.msg(result.msg);
		                    	layer.close(index);
	                        }
	                    });
					}
				},
				checkProject : function() {
					if(!vm.projectData.mobile && !(/^1[34578]\d{9}$/.test(vm.projectData.mobile))){
						layer.msg("手机号码有误，请重填");  
						$("#mobile").focus();
						return false; 
					}
					if(!vm.projectData.name){
						layer.msg("请填写姓名");  
						$("#name").focus();
						return false; 
					}
					if(!vm.projectData.projectName){
						layer.msg("请填写项目名称");  
						$("#projectName").focus();
						return false; 
					}
					if(!vm.projectData.projectKind){
						layer.msg("请选择流转方式");  
						$("#projectKind").focus();
						return false; 
					}
					if(!vm.projectData.showPreice){
						layer.msg("请填写标的公告价格");  
						$("#showPreice").focus();
						return false; 
					}
					return true;
				},
				initProject: function(){
					if (this.projectData.projectId) {
						$.post("/project/queryDetail", this.projectData, function (result) {
	                        if (result.code == 0) {
	                            vm.projectData = result.projectData;
	                            $("#assessDate").val( vm.projectData.assessDate);
	                            $("#oldRentDateStart").val( vm.projectData.oldRentDateStart);
	                            $("#oldRentDateEnd").val( vm.projectData.oldRentDateEnd);
	                            $("#hopeOutputDateStart").val( vm.projectData.hopeOutputDateStart);
	                            $("#hopeOutputDateEnd").val( vm.projectData.hopeOutputDateEnd);
	                        } else {
	                            layer.msg(result.msg);
	                        }
	                    });
					} else {
						this.initUser();
					}
				},
				cancel: function(){
					window.location.href = "/login/user_index";
				},
				initUser: function () {
					var tUser = {
							userId: $("#baseUserId").text(),
					};
					$.post("/user/userDetail", tUser, function (result) {
						if (result.code == 0) {
		                	var userData = result.userData;
		                	vm.projectData.name = userData.nickName;
		                	vm.projectData.townCode = userData.townCode;
		                	vm.projectData.areaCode = userData.areaCode;
		                	vm.projectData.address = userData.address;
		                	vm.projectData.mobile = userData.mobile;
		                	vm.projectData.idCardFrontUrl = userData.idCardPic;
		                	vm.projectData.idCardBackUrl = userData.idCardPicBack;
		                } 
		            });
				},
			},
			watch: {
				'projectData.areaCode': function(code){
					if(code && code != 0) {
						vm.childAreas = vm.aeaList.filter((item)=>{
		                    return item.code == code
		                })[0].childAreas;
					}	
				},
			}
		});
		
		
		jeDate("#assessDate", {
		    format: "YYYY-MM-DD",
			donefun : function(obj) {
				vm.projectData.assessDate = $("#assessDate").val();
			}
		});
		jeDate("#hopeOutputDateStart", {
	        minDate:'1949-10-01',
	        maxDate:'2100-10-01',
	        format: 'YYYY-MM-DD',
			donefun : function(obj) {
				vm.projectData.hopeOutputDateStart = $("#hopeOutputDateStart").val();
			}
		});
		jeDate("#hopeOutputDateEnd", {
			minDate:'1949-10-01',
			maxDate:'2100-10-01',
			format: 'YYYY-MM-DD',
			donefun : function(obj) {
				vm.projectData.hopeOutputDateEnd = $("#hopeOutputDateEnd").val();
			}
		});
		jeDate("#oldRentDateStart", {
			minDate:'1949-10-01',
			maxDate:'2100-10-01',
			format: 'YYYY-MM-DD',
			donefun : function(obj) {
				vm.projectData.oldRentDateStart = $("#oldRentDateStart").val();
			}
		});
		jeDate("#oldRentDateEnd", {
			minDate:'1949-10-01',
			maxDate:'2100-10-01',
			format: 'YYYY-MM-DD',
			donefun : function(obj) {
				vm.projectData.oldRentDateEnd = $("#oldRentDateEnd").val();
			}
		});