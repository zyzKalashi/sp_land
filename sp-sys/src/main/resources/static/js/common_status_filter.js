//task
// 状态过滤-zyz
Vue.filter('projectKindFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "待审核";
	}
	if (val == 1) {
		ss = "土地承包";
	}
	if (val == 2) {
		ss = "林权转让";
	}
	if (val == 3) {
		ss = "养殖水面";
	}
	if (val == 4) {
		ss = "四荒承包";
	}
	return ss;
});

Vue.filter('commonStatusFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "删除";
	}
	if (val == 1) {
		ss = "正常";
	}
	if (val == 2) {
		ss = "待审核";
	}
	if (val == 3) {
		ss = "拒绝";
	}
	if (val == 4) {
		ss = "禁用";
	}
	return ss;
});