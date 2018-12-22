// exportFlag
Vue.filter('exportFlag_filter', function(val) {
	if (val == 0) {
		return "失败";
	} else if (val == 1) {
		return "成功";
	}
});

// exportSet
Vue.filter('exportSet_filter', function(val) {
	if (val == 0) {
		return "全部匹配";
	} else if (val == 1) {
		return "模糊匹配";
	} else if (val == 2) {
		return "精确匹配";
	}
});

// exportSet
Vue.filter('exportSet_userColumn_filter', function(val) {
	if (val == 'tradeFirst') {
		return "一级分类";
	} else if (val == 'tradeSecond') {
		return "二级分类";
	} else if (val == 'urlId') {
		return "URL ID";
	} else if (val == 'urlName') {
		return "URL名称";
	} else if (val == 'mtagName') {
		return "标签";
	} else if (val == 'linkUrl') {
		return "URL";
	} else if (val == 'urlFilter') {
		return "是否过滤搜索引擎";
	} 
});
