function goUrl(url){
	window.location.href=url;
}
/* 按钮提示 zyz */
function showBtnTip(msg, id){
	 layer.tips(msg, "#" + id, {
         tips: [3, '#36c6d3'],
         time: 3000
     });
}
function nowDate(){
	var myDate = new Date();
	var month = myDate.getMonth() + 1;
	var weekDay;
	switch (myDate.getDay()) {
	case 0:
		weekDay = "日";
		break;
	case 1:
		weekDay = "一";
		break;
	case 2:
		weekDay = "二";
		break;
	case 3:
		weekDay = "三";
		break;
	case 4:
		weekDay = "四";
		break;
	case 5:
		weekDay = "五";
		break;
	case 6:
		weekDay = "六";
		break;
	}
	return myDate.getFullYear() + "年" + month + "月" + myDate.getDate() + "日 星期" + weekDay;
}
/* 日期插件 zyz */ 
function daterangepicker_page(id, startDate, endDate, searchFun){
	daterangepicker_init(id, startDate, endDate, searchFun);
	$('#' + id).on('cancel.daterangepicker', function (ev, picker) { 
		daterangepicker_init(id, startDate, endDate, searchFun);
	});
}
function daterangepicker_init(id, startDate, endDate, searchFun){
	if ( startDate && endDate) {
		$('#' + id).daterangepicker.startDate = startDate;
		$('#' + id).daterangepicker.endDate = endDate;
	} else {
		$('#' + id).daterangepicker.autoUpdateInput = false;
	}
	$('#' + id).daterangepicker(function (start, end, label) {
		searchFun;
	});
};

//关闭弹窗 返回按钮
function closeWin() {
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
};

//重新加载
function reload () {
    location.reload();
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}

// 菜单选中 @zyz
function chooseMenu() {
    // 获取url信息
    var urls = window.location.pathname.split("/");
    // 获取菜单信息路径字符串
    var menuStr = "menu";
    urls[0] ? menuStr = urls[0] : menuStr = urls[1];
    // 匹配路径
    var menuArray = {
        "task": "task",
        "rules": "task",
        "account": "account"
    }
    var menu = menuArray[menuStr];
    if (menu && menu != "menu") {
        $("." + menu).addClass("active");
    }
}


// 菜单选中
function chooseSecondMenu() {
    // 获取url信息
    var urls = window.location.pathname.split("/");
    // 获取菜单信息路径字符串
    var menuStr = "menu";
    urls[0] ? menuStr = urls[0] : menuStr = urls[2];
    // 匹配路径
    var menuArray = {
        // url管理
        "urls_list" : "urls_list",
        "urls_import_list" : "urls_import_list",
        "urls_export_list" : "urls_export_list",
        "urls_group_list" : "urls_group_list",
    }
    var menu = menuArray[menuStr];
    if (menu && menu != "menu") {
        $(".sidebar-nav-link .sidebar-nav-sub").css("display", "none");
        $("." + menu).parents('.sidebar-nav-sub').css("display", "block");
        $("." + menu).children("a").addClass("sub-active");
    }
}


// head右上角连接 - 修改密码
function baseInfo() {
    var userId = $("#baseUserId").text();
    window.location.href = "/users/common_base?userId="+ userId;
}


// 页面加载
$(function () {
    chooseMenu();
    chooseSecondMenu();
});

// 公共js @zyz
(function () {
    var hzObj = {};
    hzObj.postRpc = function (url, data) {
    	if (url) {
    		var index = layer.load(1);
    		return $.ajax({
    			url: url,
    			data: data,
    			dataType: "json",
    			type: "POST",
    			traditional: true,
                // timeout: 200000,
                error: function (err) {
                    console.log(err)
                    layer.alert("请求超时，请重试！");
                    layer.close(index);
                },
                success: function () {
                    layer.close(index);
                },
    		})
		}
    };
    hzObj.postRpcAsync = function (url, data) {
    	if (url) {
    		var index = layer.load(1);
    		return $.ajax({
    			url: url,
    			data: data,
    			dataType: "json",
    			type: "POST",
    			// traditional: true,
                async:false,// 同步
                // timeout: 200000,
                error: function (err) {
                    console.log(err)
                    layer.alert("请求超时，请重试！");
                    layer.close(index);
                },
                success: function () {
                    layer.close(index);
                },
    		})
		}
    };

    hzObj.getRpc = function (url, data) {
        var index = layer.load(1);
        return $.ajax({
            url: url,
            data: data,
            dataType: "json",
            type: "GET",
            // timeout: 200000,
            error: function (err) {
                console.log(err)
                layer.alert("请求超时，请重试！");
                layer.close(index);
            },
            success: function () {
                layer.close(index);
            },
        })
    };

    /**
     * 判断 str 字符串中是否含有字符串 subStr
     * @param {} str 原字符串
     * @param {} subStr 要查找的字符串
     * @param {} isIgnoreCase 是否忽略大小写
     * @return {Boolean}
     */
    hzObj.contains = function (str, subStr, isIgnoreCase) {
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
                    /*如果从j开始的字符与 str 匹配 */
                    return true;
                }
            }
        }
        return false;
    }
    // 判断是否为数字(整数)
    hzObj.isNumber = function (value) {
        var patrn = /^[0-9]*[1-9][0-9]*$/;
        if (patrn.exec(value) == null || value == "") {
            return false
        } else {
            return true
        }
    }
    /**
     * 打开一个layer的open弹窗
     * @param urlwithparam url带参数
     *      例子："/users/common_detail?userId=1"
     */
    hzObj.openWin = function (urlwithparam) {
        layer.open({
            type: 2,
            title: "客户详情页",
            shade: 0.4,
            offset: '30px',
            area: ['90%', '90%'],
            shadeClose: true,
            content: urlwithparam
        });
    }

    //排序
    hzObj._thOrder = function (url, data, fn, currPage) {
        $("th[data-hz=order]").click(function (e) {
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
    hzObj.getdomInit = function (url, data, fn, currPage) {
        if (currPage) {
            hzObj.getdomSetPage(url, data, currPage, fn);
        } else {
            hzObj.getdom(url, data, fn);
            hzObj._thOrder(url, data, fn);
        }
    }
    hzObj.getdom = function (url, data, fn) {
        hzObj.postRpc(url, data).done(function (r) {
            if (r.code == 0) {
                var pageInfo = r.pageInfo;
                $('#pagination').bootstrapPaginator({
                    bootstrapMajorVersion: 3, //bootstrap的版本要求
                    currentPage: pageInfo.pageNum == 0 ? 1 : pageInfo.pageNum, //设置当前页
                    totalPages: pageInfo.pages == 0 ? 1 : pageInfo.pages,
                    size: "normal", // 允许的值: mini, small, normal,large。值：mini版的、小号的、正常的、大号的。
                    numberOfPages: data.pageSize, //设置显示的页码数
                    alignment: "right",
                    totalCount: pageInfo.total,
                    onPageClicked: function (event, originalEvent, type, page) { //点击事件
                        data.pageNo = page;
                        hzObj.getdom(url, data, fn);
                    }
                });
                fn(r);
                setTimeout(function () {}, 200)
            }
        });
    }
    hzObj.getdomSetPage = function (url, data, currPage, fn) {
        hzObj.postRpc(url, data).done(function (r) {
            if (r.code == 0) {
                var pageInfo = r.pageInfo;
                $('#pagination').bootstrapPaginator({
                    bootstrapMajorVersion: 3, //bootstrap的版本要求
                    currentPage: currPage, //设置当前页
                    totalPages: pageInfo.pages == 0 ? 1 : pageInfo.pages,
                    size: "normal", // 允许的值: mini, small, normal,large。值：mini版的、小号的、正常的、大号的。
                    numberOfPages: data.pageSize, //设置显示的页码数
                    alignment: "right",
                    totalCount: pageInfo.total,
                    onPageClicked: function (event, originalEvent, type, page) { //点击事件
                        data.pageNo = page;
                        hzObj.getdom(url, data, fn);
                    }
                });
                fn(r);
                setTimeout(function () {}, 200)
            }
        });
    }
    //获取url参数
    hzObj.getQueryString = function (name) {
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
    hzObj.copyValue = function (className) {
        var clipboard = new ClipboardJS("." + className);
        clipboard.on('success', function (e) {
            layer.alert("复制成功");
            // 如果是结合vue的@click用一定要加destroy销毁
            // 如果是直接在<script></script>中不用加destroy()方法
            clipboard.destroy()
        });
        clipboard.on('error', function (e) {
            layer.alert("复制失败");
            clipboard.destroy()
        });
    }
    this.hzToolObj = hzObj;
})();

/**
 * Vue全局权限校验方法
 * 权限验证方法
 */
Vue.prototype.hasPermission = function (perms) {
    var allPerms = $("#perms").text();
    if (allPerms.indexOf(perms) > -1) {
        return true;
    } else {
        return false;
    }
}