function markeSelect(oSel){
		var oDiv=document.createElement('div');
			oSel.parentNode.insertBefore(oDiv,oSel);
			oDiv.className='quanbu';
		var oSpan=document.createElement('span');
			oDiv.appendChild(oSpan);
			oSpan.innerHTML=oSel.options[oSel.selectedIndex].text;
		oSpan.onclick=function(){
			oUl.style.display='block';
			};
		var oUl=document.createElement('ul');
			oUl.className='zindex'
			oDiv.appendChild(oUl);
			for(var i=0;i<oSel.options.length;i++){
				var oLi=document.createElement('li');
					oLi.innerHTML=oSel.options[i].text;
				(function(index){
					oLi.onclick=function(){
						oSpan.innerHTML=this.innerHTML;
						oUl.style.display='none';
						oSel.value=oSel.options[index].value;
						};
					})(i);
				oUl.appendChild(oLi);
				};	
			oSel.style.display='none';
		};
		
		

		function addEvent(obj, sEv, fn)
{
	if(obj.attachEvent)
	{
		obj.attachEvent('on'+sEv, fn);
	}
	else
	{
		obj.addEventListener(sEv, fn, false);
	}
}

function removeEvent(obj, sEv, fn)
{
	if(obj.detachEvent)
	{
		obj.detachEvent('on'+sEv, fn);
	}
	else
	{
		obj.removeEventListener(sEv, fn, false);
	}
}


addEvent(window,'load',public);

function public(){
	
	
		
		 var oSel=document.getElementsByName('sel1')[0];
	   markeSelect(oSel);
	 var oSel2=document.getElementsByName('sel2')[0];
	   markeSelect(oSel2);
	   
	
	
      var oZhank=document.getElementById('zhankai');
	var oHiddenlist=document.getElementById('list_hidden');
	var oHidden=document.getElementById('hidden1');
	oZhank.onclick=function(){
		oZhank.style.display='none';
		
		startMove(oHiddenlist,{left:20,width:70,height:280,opacity:100},function(){

			startMove(oZhank,{width:0,height:0,opacity:0})
			
			})	

		
		};
		
	oHidden.onclick=function(){
		
		startMove(oHiddenlist,{left:-85,width:0,height:0,opacity:0},function(){

			startMove(oZhank,{width:28,height:72,opacity:100})
			
			})
		oZhank.style.display='block';
		};
	   
	
	var oFhdb=document.getElementById('fanhuid');
    var timer_1=null;
    var yonghugd=true;
	
		window.onscroll=function(){
		
		if(!yonghugd){
			clearInterval(timer_1);
			};
		yonghugd=false;
		};
	
	oFhdb.onclick=function(){
		clearInterval(timer_1);
		timer_1=setInterval(function (){
			var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
			
			var speed=(0-scrollTop)/7;
			speed=speed>0?Math.ceil(speed):Math.floor(speed);
			
			scrollTop+=speed;
			
			if(scrollTop==0)
			{
				clearInterval(timer_1);
			}
			
			yonghugd=true;
			
			document.documentElement.scrollTop=scrollTop;
			document.body.scrollTop=scrollTop;
		},30)
		};	
		
		

	
	}












