//task
// 状态过滤-zyz
Vue.filter('projectKindFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "待审核";
	} else if (val == 1) {
		ss = "土地承包";
	} else if (val == 2) {
		ss = "林权转让";
	} else if (val == 3) {
		ss = "养殖水面";
	} else if (val == 4) {
		ss = "四荒承包";
	}
	return ss;
});

Vue.filter('projectInfoKindFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "家庭个人";
	} else if (val == 1) {
		ss = "集体单位";
	}
	return ss;
});

Vue.filter('projectRightKind', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "家庭个人";
	} else if (val == 1) {
		ss = "集体单位";
	}
	return ss;
});

Vue.filter('commonStatusFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "删除";
	} else if (val == 1) {
		ss = "正常";
	} else if (val == 2) {
		ss = "待审核";
	} else if (val == 3) {
		ss = "拒绝";
	} else if (val == 4) {
		ss = "结束";
	} else if (val == 5) {
		ss = "禁用";
	}
	return ss;
});

Vue.filter('commonYesNoFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "否";
	} else if (val == 1) {
		ss = "是";
	}
	return ss;
});

Vue.filter('sexFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "男";
	} else if (val == 1) {
		ss = "女";
	}
	return ss;
});