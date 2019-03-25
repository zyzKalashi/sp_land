//task
// 状态过滤-zyz
Vue.filter('taskStatusFilter', function (val) {
	var ss = "--";
	if (val == 0) {
		ss = "待审核";
	}
	if (val == 1) {
		ss = "正在运行";
	}
	if (val == 2) {
		ss = "暂停";
	}
	if (val == 3) {
		ss = "结束";
	}
	if (val == -1) {
		ss = "审核失败";
	}
	if (val == -2) {
		ss = "删除";
	}
	return ss;
});


