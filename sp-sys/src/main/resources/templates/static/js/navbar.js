var $$ = function (id) {
			return document.getElementById(id);
		}
		
		var move = function (obj, target) {
			var timer;
			clearInterval(timer);
			timer = setInterval(function () {
				var speed = (target - obj.offsetTop)/3;
				speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
				if (Math.abs(obj.offsetTop - target) < 4) {
					clearInterval(timer);
					obj.style.marginTop = target + "px";
				} else {
					obj.style.marginTop = obj.offsetTop + speed + "px";
				}
			}, 30);

		}

		var toggle = function (menuId, btnId) {
			var menu = $$(menuId);
			var btn = $$(btnId);
			var countNum = 0;
			var menuHeight = menu.offsetHeight;
			menu.style.marginTop = - menuHeight + "px";
			btn1.onclick = function () {
				if (countNum === 0) {
					move(menu, 0);
					countNum = 1;
				} else {
					move(menu, -menuHeight);
					countNum = 0;
				}
			}
		}

		onload = function () {
			if ($$("btn")) {
				toggle("menu", "btn");
			} else {
			}
		}

		onresize = function () {
			location.reload();
		}