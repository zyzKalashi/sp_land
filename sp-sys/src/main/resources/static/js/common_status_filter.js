//task
// 状态过滤-zyz
Vue.filter('projectKindFilter', function(val) {
	var ss = "全部";
	if (val == 1) {
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
// 状态过滤-zyz
Vue.filter('demandKindFilter', function(val) {
	var ss = "全部";
	if (val == 1) {
		ss = "土地承包";
	} else if (val == 2) {
		ss = "林权转让";
	} else if (val == 3) {
		ss = "养殖水面";
	} else if (val == 4) {
		ss = "四荒承包";
	} else if (val == 5) {
		ss = "其他";
	}
	return ss;
});
// 状态过滤-zyz
Vue.filter('noticeKindFilter', function(val) {
	var ss = "全部";
	if (val == 1) {
		ss = "新闻";
	} else if (val == 2) {
		ss = "政策";
	} else if (val == 3) {
		ss = "法规";
	} else if (val == 4) {
		ss = "公告";
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

Vue.filter('sexRespectFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "先生";
	} else if (val == 1) {
		ss = "女士";
	}
	return ss;
});

Vue.filter('projectStatusFilter', function(val) {
	var ss = "--";
	if (val == 0) {
		ss = "删除";
	} else if (val == 1) {
		ss = "进行中";
	} else if (val == 2) {
		ss = "待审核";
	} else if (val == 3) {
		ss = "拒绝";
	} else if (val == 4) {
		ss = "已结束";
	} else if (val == 5) {
		ss = "禁用";
	}
	return ss;
});

Vue.filter('moneyLevelFilter', function(val) {
	var ss = "--";
	if (val == 1) {
		ss = "1万-10万";
	} else if (val == 2) {
		ss = "10万-50万";
	} else if (val == 3) {
		ss = "50万-100万";
	} else if (val == 4) {
		ss = "100万以上";
	} 
	return ss;
});