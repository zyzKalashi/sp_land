var storage = window.localStorage;

/* zyz begin*/
/* 浏览器逻辑 */
$(function(){
	initFooter();
	
	if( $("#baseUserName").text() ){
		$("#loginWin").hide();
		document.getElementById("userWin").style.display = ""; 
	}
	
	var useragent = navigator.userAgent;
	if (is_weixn()) {
		window.location.href = 'index_wx.html';
	} else {
		var url = window.location.href;
		var cb = cusBrowser();
		if ( url.indexOf("index_browserError") <= -1 ) {
			if ( "IE" == cb ) {
				if ( !IEVersion() ) {
					window.location.href = '/index_browserError';
				} 
			} else {
				if ("Chrome" != cb && "Firefox" != cb && "Safari" != cb && "UC" != cb) {
					window.location.href = '/index_browserError';
				} 
			}
		} else {
			if ( "IE" == cb ) {
				if ( IEVersion() ) {
					window.location.href = '/index';
				} 
			} else {
				if ("Chrome" != cb && "Firefox" != cb && "Safari" != cb && "UC" != cb) {
					
				} else {
					window.location.href = '/index';
				}
			}
		}
	}
});
function initFooter(){
	$("#fullyear").text((new Date).getFullYear().toString());
	$.post("/picInfo/picList?picType=3",null ,function(resp){
		$("#friendlink").html("");
		if(resp.data){
			$("#friendlink").append("<li>友情链接：&nbsp;</li>");
			for(var x in resp.data){
				$("#friendlink").append('<li><a href="' + resp.data[x].picLink + '" target="_blank">' + resp.data[x].title + '</a></li>&nbsp;&nbsp;');
			}
		}
	});
}
/* 判断浏览器种类 */
function cusBrowser(){
    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
    var OsObject=navigator.userAgent;// 包含「Opera」文字列 
    if(OsObject.indexOf("Opera") != -1) { 
    		return "Opera"
    } else if(OsObject.indexOf("compatible") > -1 && OsObject.indexOf("MSIE") > -1 && OsObject.indexOf("Opera") <= -1) { // 包含「MSIE」文字列
	    	return "IE";
    } else if(OsObject.indexOf("Chrome") != -1) { // 包含「chrome」文字列 ，不过360浏览器也照抄chrome的UA
    		return "Chrome"; 
    } else if(OsObject.indexOf("UCBrowser") != -1) { // 包含「UCBrowser」文字列 
	    	return "UC"; 
    } else if(OsObject.indexOf("BIDUBrowser") != -1) { // 包含「BIDUBrowser」文字列
	    	return "baidu"; 
    } else if(OsObject.indexOf("Firefox") != -1) { // 包含「Firefox」文字列 
    		return "Firefox";
    } else if(OsObject.indexOf("Netscape") != -1) { // 包含「Netscape」文字列 
	    	return "Netscape";
    } else if(OsObject.indexOf("Safari") != -1) { // 包含「Safari」文字列 
    		return "Safari";
    } else { 
	    	return "xxx";
    } 
}

/* 判断ie浏览器版本 */
function IEVersion() {
	var IE5 = IE55 = IE6 = IE7 = IE8 = false;
    var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
    reIE.test(navigator.userAgent);
    var fIEVersion = parseFloat(RegExp["$1"]);
    IE55 = fIEVersion == 5.5;
    IE6 = fIEVersion == 6.0;
    IE7 = fIEVersion == 7.0;
    IE8 = fIEVersion == 8.0;
    IE9 = fIEVersion == 9.0;
    IE10 = fIEVersion == 10.0;
    if ( IE55 || IE6 || IE7 || IE8 || IE9 || IE10 ) {
        return false;
    } else {
    		return true;
    }
}

/*判断是否为微信登录*/
function is_weixn(){  
    var ua = navigator.userAgent.toLowerCase();  
    if(ua.match(/MicroMessenger/i)=="micromessenger") {  
        return true;  
    } else {  
        return false;  
    }  
}  

/* 提示 + 跳转 + 关闭页面 */
function closePage(){
	window.opener=null;
	window.open('','_self');
	window.location.href="about:blank";//用于Chrome
	window.close();
}
/* zyz end*/
function indexSearch () {
	var searchProjectName = $("#searchProjectName").val();
	window.location.href = "../html/project_list?projectName=" + searchProjectName; 
}

/* 按钮提示 zyz */
function showBtnTip(msg, id) {
	layer.tips(msg, "#" + id, {
		tips : [ 3, '#36c6d3' ],
		time : 3000
	});
}

/* 日期插件 zyz */
function daterangepicker_page(id, startDate, endDate, searchFun) {
	daterangepicker_init(id, startDate, endDate, searchFun);
	$('#' + id).on('cancel.daterangepicker', function(ev, picker) {
		daterangepicker_init(id, startDate, endDate, searchFun);
	});
}

function daterangepicker_init(id, startDate, endDate, searchFun) {
	if (startDate && endDate) {
		$('#' + id).daterangepicker.startDate = startDate;
		$('#' + id).daterangepicker.endDate = endDate;
	} else {
		$('#' + id).daterangepicker.autoUpdateInput = false;
	}
	$('#' + id).daterangepicker(function(start, end, label) {
		searchFun;
	});
};

// 关闭弹窗 返回按钮
function closeWin() {
	layer.closeAll();
	// var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
	// parent.layer.close(index); // 再执行关闭
};

// 重新加载
function reload() {
	location.reload();
}

// 获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}

// head右上角连接 @不知道谁
function baseInfo() {
	var userId = $("#baseUserId").text();
	window.location.href = "/users/common_base?userId=" + userId;
}

// 公共js @zyz
(function() {
	var hzObj = {};
	hzObj.postRpc = function(url, data) {
		if (url) {
			var index = layer.load(0, { shade: [0.1,'#fff'] });
			return $.ajax({
				url : url,
				data : data,
				dataType : "json",
				type : "POST",
				traditional : true,
				timeout : 20000,
				error : function(err) {
					console.log(err)
					layer.alert("请求超时，请重试！");
					layer.close(index);
				},
				success : function() {
					layer.close(index);
				},
			})
		}
	};

	hzObj.getRpc = function(url, data) {
		var index = layer.load(0, { shade: [0.1,'#fff'] });
		return $.ajax({
			url : url,
			data : data,
			dataType : "json",
			type : "GET",
			timeout : 20000,
			error : function(err) {
				console.log(err)
				layer.alert("请求超时，请重试！");
				layer.close(index);
			},
			success : function() {
				layer.close(index);
			},
		})
	};

	/**
	 * 判断 str 字符串中是否含有字符串 subStr
	 * 
	 * @param {}
	 *            str 原字符串
	 * @param {}
	 *            subStr 要查找的字符串
	 * @param {}
	 *            isIgnoreCase 是否忽略大小写
	 * @return {Boolean}
	 */
	hzObj.contains = function(str, subStr, isIgnoreCase) {
		if (isIgnoreCase) {
			// 忽略大小写
			str = str.toLowerCase();
			subStr = subStr.toLowerCase();
		}
		var startChar = subStr.substring(0, 1);
		var strLen = subStr.length;
		for (var j = 0; j < str.length - strLen + 1; j++) {
			if (str.charAt(j) == startChar) {
				/* 如果匹配起始字符,开始查找 */
				if (str.substring(j, j + strLen) == subStr) {
					/* 如果从j开始的字符与 str 匹配 */
					return true;
				}
			}
		}
		return false;
	}
	// 判断是否为数字(整数)
	hzObj.isNumber = function(value) {
		var patrn = /^[0-9]*[1-9][0-9]*$/;
		if (patrn.exec(value) == null || value == "") {
			return false
		} else {
			return true
		}
	}
	/**
	 * 打开一个layer的open弹窗
	 * 
	 * @param urlwithparam
	 *            url带参数 例子："/users/common_detail?userId=1"
	 */
	hzObj.openWin = function(urlwithparam) {
		layer.open({
			type : 2,
			title : "客户详情页",
			shade : 0.4,
			offset : '30px',
			area : [ '90%', '90%' ],
			shadeClose : true,
			content : urlwithparam
		});
	}

	// 排序
	hzObj._thOrder = function(url, data, fn, currPage) {
		$("th[data-hz=order]").click(function(e) {
			var el = $(e.target);
			var sort = el.children("span");
			var desc = sort.hasClass('am-icon-sort-desc');
			var asc = sort.hasClass('am-icon-sort-asc');
			var orderKey = e.target.getAttribute("data");
			var orderName = '';
			if (!desc && !asc) {
				sort.removeClass("am-icon-sort");
				sort.addClass("am-icon-sort-desc");
				orderName = "desc";
			}
			if (desc) {
				sort.removeClass("am-icon-sort-desc");
				sort.addClass("am-icon-sort-asc");
				orderName = "asc";
			}
			if (asc) {
				sort.removeClass("am-icon-sort-asc");
				sort.addClass("am-icon-sort");
				orderName = "";
			}
			data.orderName = orderName;
			data.orderKey = orderKey;
			data.pageNo = 1; // 回到第一页
			if (currPage) {
				hzObj.getdomSetPage(url, data, currPage, fn);
			} else {
				hzObj.getdom(url, data, fn)
			}
			// hzObj.getdom(url, data, fn)
		})
	}
	hzObj.getdomInit = function(url, data, fn, currPage) {
		if (currPage) {
			hzObj.getdomSetPage(url, data, currPage, fn);
		} else {
			hzObj.getdom(url, data, fn);
			hzObj._thOrder(url, data, fn);
		}
	}
	hzObj.getdom = function(url, data, fn) {
		hzObj.postRpc(url, data).done(function(r) {
			if (r.code == 0) {
				var pageInfo = r.pageInfo;
				$('#pagination').bootstrapPaginator({
					bootstrapMajorVersion : 3, // bootstrap的版本要求
					currentPage : pageInfo.pageNum == 0 ? 1 : pageInfo.pageNum, // 设置当前页
					totalPages : pageInfo.pages == 0 ? 1 : pageInfo.pages,
					size : "mini", // 允许的值: mini, small,
					// normal,large。值：mini版的、小号的、正常的、大号的。
					numberOfPages : data.pageSize, // 设置显示的页码数
					alignment : "right",
					totalCount : pageInfo.total,
					onPageClicked : function(event, originalEvent, type, page) { // 点击事件
						data.pageNo = page;
						hzObj.getdom(url, data, fn);
					}
				});
				fn(r);
				setTimeout(function() {
				}, 200)
			}
		});
	}
	hzObj.getdomSetPage = function(url, data, currPage, fn) {
		hzObj.postRpc(url, data).done(function(r) {
			if (r.code == 0) {
				var pageInfo = r.pageInfo;
				$('#pagination').bootstrapPaginator({
					bootstrapMajorVersion : 3, // bootstrap的版本要求
					currentPage : currPage, // 设置当前页
					totalPages : pageInfo.pages == 0 ? 1 : pageInfo.pages,
					size : "normal", // 允许的值: mini, small,
					// normal,large。值：mini版的、小号的、正常的、大号的。
					numberOfPages : data.pageSize, // 设置显示的页码数
					alignment : "right",
					totalCount : pageInfo.total,
					onPageClicked : function(event, originalEvent, type, page) { // 点击事件
						data.pageNo = page;
						hzObj.getdom(url, data, fn);
					}
				});
				fn(r);
				setTimeout(function() {
				}, 200)
			}
		});
	}
	// 获取url参数
	hzObj.getQueryString = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var params = window.location.search.substr(1);
		params = window.decodeURIComponent(window.atob(params));
		var r = params.match(reg);
		if (r != null) {
			return decodeURI(r[2]);
		}
		return null;
	}
	// 复制内容
	hzObj.copyValue = function(className) {
		var clipboard = new ClipboardJS("." + className);
		clipboard.on('success', function(e) {
			layer.alert("复制成功");
			// 如果是结合vue的@click用一定要加destroy销毁
			// 如果是直接在<script></script>中不用加destroy()方法
			clipboard.destroy()
		});
		clipboard.on('error', function(e) {
			layer.alert("复制失败");
			clipboard.destroy()
		});
	}
	this.hzToolObj = hzObj;
})();

/**
 * Vue全局权限校验方法 权限验证方法
 */
Vue.prototype.hasPermission = function(perms) {
	var allPerms = $("#perms").text();
	if (allPerms.indexOf(perms) > -1) {
		return true;
	} else {
		return false;
	}
}