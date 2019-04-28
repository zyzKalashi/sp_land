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
				this.projectData.projectId = getUrlParam('projectId');
				if(this.projectData.projectId){
					this.initProject();
				} else {
					this.initUser();
				}
			},
			methods : {
				openUpload: function(flag, projectId){
					layer.open({
	                    type: 2,
	                    title: '上传',
	                    area: ['90%', '90%'],
	                    fixed: false, // 不固定
	                    skin: 'layer-skin',
	                    maxmin: true,
	                    content: '/admin/project/upload?projectId=' + projectId + "&flag=" + flag,
	                    // btn: buttons,
	                    yes: function(index, layero){
	                        if(3 == buttons.length) {
	                            var iframeWin = window[layero.find('iframe')[0]['name']];
	                            iframeWin.vm.audit('1');
	                        } else {
	                            layer.close(layer.index);
	                        }
	                    },
	                    no: function(index, layero){
	                    },
	                });
				},
				audit: function (type) {
	                vm.projectData.projectStatus = type;
	                if (vm.checkProject()) {
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
	                }
	            },
				initArea: function(){
					$.post("/area/initArea", {}, function (result) {
                        if (result.code == 0) {
                        	vm.aeaList = result.area;
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
	                            $("#oldRentDate").val( vm.projectData.oldRentDate);
	                            $("#assessDate").val( vm.projectData.assessDate);
	                            $("#hopeOutputDate").val( vm.projectData.hopeOutputDate);
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
		
		
		jeDate("#oldRentDate", {
			multiPane:false,
			range:" 至 ",
	        minDate:'1949-10-01',
	        maxDate:'2100-10-01',
	        format: 'YYYY-MM-DD',
	        shortcut:[
	            {name:"一周",val:{DD:7}},
	            {name:"一个月",val:{DD:30}},
	            {name:"二个月",val:{MM:2}},
	            {name:"三个月",val:{MM:3}},
	            {name:"一年",val:{DD:365}}
	        ],
			donefun : function(obj) {
				vm.projectData.oldRentDate = $("#oldRentDate").val();
			}
		});
		jeDate("#assessDate", {
		    format: "YYYY-MM-DD",
			donefun : function(obj) {
				vm.projectData.assessDate = $("#assessDate").val();
			}
		});
		jeDate("#hopeOutputDate", {
			multiPane:false,
			range:" 至 ",
	        minDate:'1949-10-01',
	        maxDate:'2100-10-01',
	        format: 'YYYY-MM-DD',
	        shortcut:[
	            {name:"一周",val:{DD:7}},
	            {name:"一个月",val:{DD:30}},
	            {name:"二个月",val:{MM:2}},
	            {name:"三个月",val:{MM:3}},
	            {name:"一年",val:{DD:365}}
	        ],
			donefun : function(obj) {
				vm.projectData.hopeOutputDate = $("#hopeOutputDate").val();
			}
		});