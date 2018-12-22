// 校验文本长度4
Vue.filter('filter_length', function (val) {
	if(val){
    	if(val.length > 20){
    		return val.substring(0,20) + "...";
    	} else {
    		return val;
    	}
	} else {
		return "--";
	}
});

// 校验为Null时 填充"--"
Vue.filter('filter_checkNull', function (val) {
	if(val && val != ""){
		return val;
	} else {
		return "--";
	}
});

// 格式化金额（包含分）
Vue.filter('fomartMoney', function (val) {
	var str = (val/100).toFixed(2) + '';
	var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );//取到整数部分
	var dot = str.substring(str.length,str.indexOf("."))//取到小数部分搜索
	var ret = intSum + dot;
	return ret;
});

