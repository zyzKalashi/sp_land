let projectKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "土地承包"},
	{value: 2, label: "林权转让"},
	{value: 3, label: "养殖水面"},
	{value: 4, label: "四荒承包"},
];
let demandKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "土地承包"},
	{value: 2, label: "林权转让"},
	{value: 3, label: "养殖水面"},
	{value: 4, label: "四荒承包"},
	{value: 5, label: "其他"},
];
let noticeKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "新闻"},
	{value: 2, label: "政策"},
	{value: 3, label: "法规"},
	{value: 4, label: "公告"},
];
let docKindDic = [
	{value: 0, label: "全部"},
	{value: 1, label: "帮助中心"},
	{value: 2, label: "资料下载"},
];
let projectInfoKindDic = [
	{value: 0, label: "家庭个人"},
	{value: 1, label: "集体单位"},
];
let commonStatusterDic = [
	{value: 0, label: "删除"},
	{value: 1, label: "正常"},
	{value: 2, label: "待审核"},
	{value: 3, label: "拒绝"},
	{value: 4, label: "结束"},
	{value: 5, label: "禁用"},
];
let commonYesNoDic = [
	{value: 0, label: "否"},
	{value: 1, label: "是"},
];
let sexDic = [
	{value: 0, label: "男"},
	{value: 1, label: "女"},
];
let sexRespectDic = [
	{value: 0, label: "先生"},
	{value: 1, label: "女士"},
];
let projectStatusDic = [
	{value: 0, label: "已删除"},
	{value: 1, label: "进行中"},
	{value: 2, label: "待审核"},
	{value: 3, label: "已拒绝"},
	{value: 4, label: "已结束"},
	{value: 5, label: "禁用"},
];
let moneyLevelDic = [
	{value: 0, label: "1万-10万"},
	{value: 1, label: "10万-50万"},
	{value: 2, label: "50万-100万"},
	{value: 3, label: "100万以上"},
];

// task
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


 