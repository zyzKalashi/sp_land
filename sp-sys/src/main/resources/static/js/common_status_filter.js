var projectPicDic = [
	{value: 1, label: "身份证"},
	{value: 2, label: "产权证"},
	{value: 2, label: "合同书"},
];
var userStatusDic = [
	{value: 1, label: "已认证"},
	{value: 2, label: "未认证"},
];
var projectKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "土地承包"},
	{value: 2, label: "林权转让"},
	{value: 3, label: "养殖水面"},
	{value: 4, label: "四荒承包"},
];
var demandKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "土地承包"},
	{value: 2, label: "林权转让"},
	{value: 3, label: "养殖水面"},
	{value: 4, label: "四荒承包"},
	{value: 5, label: "其他"},
];
var noticeKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "新闻"},
	{value: 2, label: "政策"},
	{value: 3, label: "法规"},
	{value: 4, label: "公告"},
];
var docKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "帮助中心"},
	{value: 2, label: "资料下载"},
];
var projectInfoKindDic = [
	{value: 0, label: "家庭个人"},
	{value: 1, label: "集体单位"},
];
var commonStatusterDic = [
	{value: 0, label: "删除"},
	{value: 1, label: "正常"},
	{value: 2, label: "待审核"},
	{value: 3, label: "拒绝"},
	{value: 4, label: "结束"},
	{value: 5, label: "禁用"},
];
var commonYesNoDic = [
	{value: 0, label: "否"},
	{value: 1, label: "是"},
];
var sexDic = [
	{value: 0, label: "男"},
	{value: 1, label: "女"},
];
var sexRespectDic = [
	{value: 0, label: "先生"},
	{value: 1, label: "女士"},
];
var projectStatusDic = [
	{value: 0, label: "已删除"},
	{value: 1, label: "进行中"},
	{value: 2, label: "待审核"},
	{value: 3, label: "已拒绝"},
	{value: 4, label: "已结束"},
	{value: 5, label: "禁用"},
	{value: 6, label: "待结束"},
	{value: 7, label: "待乡镇审核"},
	{value: 8, label: "待区域审核"},
];
var selectStatusDic = [
	{value: 14, label: "全部"},
	{value: 1, label: "进行中"},
	{value: 4, label: "已结束"},
];
var moneyLevelDic = [
	{value: 0, label: "1万-10万"},
	{value: 1, label: "10万-50万"},
	{value: 2, label: "50万-100万"},
	{value: 3, label: "100万以上"},
];
var picTypeDict = [
	{value: 1, label: '宣传图片', hasPic: true, hasLink: false},
	{value: 2, label: '合作单位', hasPic: true, hasLink: true},
	{value: 3, label: '友情链接', hasPic: false, hasLink: true}]
;
var timeFrameDict = [
	{value: 1, label:'近一季度'},
	{value: 2, label:'近半年'},
	{value: 3, label:'近一年'},
	{value: 4, label:'近三年'},
	{value: 5, label:'近五年'},
];

var timeGranDict = [
	{value: 1, label:'月'},
	{value: 2, label:'季度'},
	{value: 3, label:'年'},
];

// task
// 状态过滤-zyz
Vue.filter('picTypeFilter', function(val) {
	if(val || val == undefined) return '';
	return picTypeDict.filter((item)=>{
		return item.value == val
	})[0].label;
});
// 状态过滤-zyz
Vue.filter('userStatusFilter', function(val) {
	if(val == undefined) return '';
	return userStatusDic.filter((item)=>{
		return item.value == val
	})[0].label;
});
// 状态过滤-zyz
Vue.filter('projectKindFilter', function(val) {
	if(val == undefined) return '';
	return projectKindDic.filter((item)=>{
        return item.value == val
    })[0].label;
});
// 状态过滤-zyz
Vue.filter('demandKindFilter', function(val) {
	if(val == undefined) return '';
	return demandKindDic.filter((item)=>{
        return item.value == val
    })[0].label;
});
// 状态过滤-zyz
Vue.filter('noticeKindFilter', function(val) {
	if(val == undefined) return '';
	return noticeKindDic.filter((item)=>{
        return item.value == val
    })[0].label;
});

Vue.filter('docKindFilter', function(val) {
	if(val == undefined) return '';
	return docKindDic.filter((item)=>{
		return item.value == val
	})[0].label;
});

Vue.filter('projectInfoKindFilter', function(val) {
	if(val == undefined) return '';
	return projectInfoKindDic.filter((item)=>{
        return item.value == val
    })[0].label;
});

Vue.filter('commonStatusFilter', function(val) {
	if(val == undefined) return '';
	return commonStatusterDic.filter((item)=>{
		return item.value == val
	})[0].label;
});

Vue.filter('commonYesNoFilter', function(val) {
	if(val == undefined) return '';
	return commonYesNoDic.filter((item)=>{
		return item.value == val
	})[0].label;
});

Vue.filter('sexFilter', function(val) {
	if(val == undefined) return '';
	return sexDic.filter((item)=>{
		return item.value == val
	})[0].label;
});

Vue.filter('sexRespectFilter', function(val) {
	if(val == undefined) return '';
	return sexRespectDic.filter((item)=>{
		return item.value == val
	})[0].label;
});

Vue.filter('projectStatusFilter', function(val) {
	if(val == undefined) return '';
	return projectStatusDic.filter((item)=>{
		return item.value == val
	})[0].label;
});

Vue.filter('moneyLevelFilter', function(val) {
	if(val == undefined) return '';
	return moneyLevelDic.filter((item)=>{
		return item.value == val
	})[0].label;
});

Vue.filter('simpleNameFilter', function(val) {
	var simpleName = "";
	if (val && typeof val != "undefined" && val.length > 1) {
		simpleName = val.substr(0, 1);
	}
	return simpleName;
});


 