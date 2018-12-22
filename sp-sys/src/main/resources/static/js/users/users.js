var vm = new Vue({
	el : "#app",
	data : {
		users_add_title: "创建一个新的用户",
		passwordSure: "",
		user: {
		},
		userId: "",
	},
	mounted : function() {
		this.userId = getUrlParam("userId");
		if(this.userId && this.userId != ""){
			this.users_add_title = "修改用户"; 
			this.getUser(this.userId);
		}
	},
	methods : {
		getUser: function(userId){
			hzToolObj.getRpc("/users/users_querUser?userId="+userId).done(function(result) {
				if(result.code == 0){
					if(result.flag != 0){
						vm.user = result.user;
					}
				} else {
					layer.msg(result.msg);
				}
			});	
		},
		checkUser: function(){
			if(!vm.user.userName || vm.user.userName == ""){
				layer.alert('请输入用户名称！', {icon: 8});
				return false;
			}
			if(!vm.user.password || vm.user.password == ""){
				layer.alert('请输入密码！', {icon: 8});
				return false;
			}
			if(!vm.passwordSure || vm.passwordSure == ""){
				layer.alert('请输入确认密码！', {icon: 8});
				return false;
			}
			hzToolObj.postRpc("/users/users_checkName", vm.user).done(function(result) {
				if(result.code == 0){
					if(result.flag != 0){
						layer.alert('该用户名称已被注册！', {icon: 8});
						vm.user.userName = "";
						return false;
					}
				} else {
					layer.msg(result.msg);
				}
			});
			if(vm.user.password != vm.passwordSure){
				layer.alert('两次密码不一致，请确认！', {icon: 8});
				vm.passwordSure = "";
				return false;
			}else {
				vm.user.password = hex_md5(vm.user.password); 
			}
			return true;
		},
		userAdd: function(flag) {
			var url = "";
			if(!vm.checkUser()){
				return;
			}
			var index = layer.load(1);
			if (flag == "save"){
				url = "/users/operate_add";
			} else if (flag == "update") {
				url = "/users/operate_update";
			}
			hzToolObj.postRpc(url, vm.user).done(function(result) {
				if(result.code == 0){
					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					if(index){
						parent.layer.close(index);
					}
				} else {
					layer.msg(result.msg);
				}
			});
		},
	},
});