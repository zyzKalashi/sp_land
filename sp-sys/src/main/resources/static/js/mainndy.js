
	
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

addEvent(window,'load',main);

	
function main(){

	var oPartns=document.getElementById('parents');
	var aDiv5=oPartns.getElementsByTagName('div');
	var now5=0;
	var timer_t=null;
	function tab2(){
		
		for(var i=0;i<aDiv5.length;i++){
		
			aDiv5[i].style.display='none';
			
			};
			
		aDiv5[now5].style.display='block';
		
		};
	
	function nexts5(){
		now5++;
		if(now5==aDiv5.length){
			now5=0;
			};
		tab2();
		};
		
	clearInterval(timer_t);
	timer_t=setInterval(nexts5,3000);
	oPartns.onmouseover=function(){
		clearInterval(timer_t);
		};
		
	oPartns.onmouseout=function(){
		timer_t=setInterval(nexts5,3000);
		
		};	
	
	
	
	
	
	var oMain = document.getElementById('lunbo_img');
	var oUl = oMain.getElementsByTagName('ul')[0];
	var aLi = oUl.getElementsByTagName('li');
	
	var oBtn = document.getElementById('btn');
	var aA = oBtn.getElementsByTagName('a');
	
	var iNow = 1;
	var iNow2 = 1;
	var bBtn = true;
	var num = 3;
	var timer = null;
	
	oUl.style.width = aLi.length * aLi[0].offsetWidth + 'px';
	
	aA[aA.length-1].onclick=aA[0].onclick =function(){
		if(bBtn){
			clearInterval(timer);
			timer = setInterval(autoPlay,3000);
			for(var i=0;i<aLi.length;i++){
				aLi[i].style.position = 'relative';
				aLi[i].style.filter = 'alpha(opacity=100)';
				aLi[i].style.opacity = 1;
			}
			
			oUl.style.left = -(iNow-1)*aLi[0].offsetWidth + 'px';
			
			if(iNow==1){
				iNow = aLi.length;
				aLi[aLi.length-1].style.position = 'relative';
				aLi[aLi.length-1].style.left = -aLi.length * aLi[0].offsetWidth + 'px';
			}
			else{
				iNow--;
			}
			iNow2--;
			toRun();
			bBtn = false;
		}
	};
	  
	for(var i=1;i<aA.length-1;i++){
		aA[i].index = i;
		aA[i].onclick = function(){
			clearInterval(timer);
			timer = setInterval(autoPlay,3000);
			iNow = this.index;
			iNow2 = this.index;
			toShow();
		};
	}
	
	function toRun(){	
		for(var i=1;i<aA.length-1;i++){
			aA[i].className = 'index';
		}
		aA[iNow].className = 'active';
		
		startMove(oUl,{left:-(iNow2-1)*aLi[0].offsetWidth},function(){
			if(iNow==1){
				aLi[0].style.position = 'relative';
				aLi[0].style.left = 0;
				oUl.style.left = 0;
				iNow2 = 1;
			}
			else if(iNow==aLi.length){
				aLi[aLi.length-1].style.position = 'relative';
				aLi[aLi.length-1].style.left = 0;
				oUl.style.left = -(aLi.length-1)*aLi[0].offsetWidth + 'px';
				iNow2 = aLi.length;
			}
			
			for(var i=0;i<aLi.length;i++){
				aLi[i].style.position = 'absolute';
				aLi[i].style.filter = 'alpha(opacity=0)';
				aLi[i].style.opacity = 0;
			}
			oUl.style.left = 0;
			aLi[iNow2-1].style.zIndex = num++;
			aLi[iNow2-1].style.filter = 'alpha(opacity=100)';
			aLi[iNow2-1].style.opacity = 1;
			
			bBtn = true;
		});
	}
	
	function toShow(){
		for(var i=1;i<aA.length-1;i++){
			aA[i].className = 'index';
		}
		for(var i=0;i<aLi.length;i++){
			startMove(aLi[i],{opacity:0});
		}
		aA[iNow].className = 'active';
		startMove(aLi[iNow-1],{opacity:100},function(){
			aLi[iNow-1].style.zIndex = num++;
			
		});
	}
	
	timer = setInterval(autoPlay,3000);
	
	function autoPlay(){
		if(iNow==aLi.length){
			iNow = 1;
			iNow2 = 1;
		}
		else{
			iNow++;
			iNow2++;
		}
		
		toShow();
	}
	 
	 
	
 function muosUp(obj){	 
	 var aLi2=obj.getElementsByTagName('li');
	 var aP2=obj.getElementsByTagName('p');
	 
	 for(var i=0;i<aLi2.length;i++){
		 aLi2[i].index=i;
		 aLi2[i].onmouseover=function(){

			 startMove(aP2[this.index],{top:75},null)
			 
			 };
			 
		 aLi2[i].onmouseout=function(){
			 
			 startMove(aP2[this.index],{top:150},null)
			 
			 };
		 
		 };
	 };
	 
	  var oUl2=document.getElementById('uls3');
		 muosUp(oUl2);
	  

	
	function mousUp2(obj2){
		 
	  var aBord=getByClass(obj2,'borde_img');
	  var aP3=obj2.getElementsByTagName('p');
	  
	   for(var i=0;i<aBord.length;i++){
		 aBord[i].index=i;
		 aBord[i].onmouseover=function(){

			 startMove(aP3[this.index],{top:86},null)
			 
			 };
			 
		 aBord[i].onmouseout=function(){
			 
			 startMove(aP3[this.index],{top:150},null)
			 
			 };
		 
		 };
	};
	
		  var oJing=document.getElementById('jingxuan_xinx');
		    mousUp2(oJing);
		 var oJing2=document.getElementById('jingxuan_xinx2');
		    mousUp2(oJing2);
		 var oJing3=document.getElementById('jingxuan_xinx3');
		    mousUp2(oJing3);
		 var oJing4=document.getElementById('jingxuan_xinx4');
		    mousUp2(oJing4);
	
	
			var oBox8=document.getElementById('div8');
			var aDiv8=getByClass(oBox8,'xuanxk_m');
			var oUl8=document.getElementById('numbb');
			var aLi8=oUl8.getElementsByTagName('li');
			for(var i=0;i<aLi8.length;i++){
				aLi8[i].index=i;
				aLi8[i].onclick=function(){
					for(var i=0;i<aLi8.length;i++){
						aLi8[i].className='';
						aDiv8[i].style.display='none';
					};
					this.className='abous';
					aDiv8[this.index].style.display='block';
					};
				};	 
		 
		 
		 		     
		 var oTuijian=document.getElementById('tuijian_xinx');
		 var aDetail=getByClass(oTuijian,'tuijian_detail');
		 var oUlls=document.getElementById('tuijian_list');
		 var aLis=oUlls.getElementsByTagName('li');

		 for(var i=0;i<aLis.length;i++){
			aLis[i].index=i;
			aLis[i].onmouseover=function(){
			 for(var i=0;i<aLis.length;i++){
				 aLis[i].className='';
				 aDetail[i].style.display='none';
				 };
			    aLis[this.index].className='dangqq';
				aDetail[this.index].style.display='block';
				};

 };
 	 
  /*	
	function getStyle(obj){
		var l=0;
		var t=0;
		if(obj){
			l+=obj.offsetLeft;
			t+=obj.offsetTop;
			obj=obj.offsetparent;
			};
		return {left:l,top:t};
		};
		
    window.onscroll=window.onresize=function(){
			var oKefu=document.getElementById('kefu');
			var Tp=getStyle(oKefu);
			var T=0;
			var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
			if(T<scrollTop){
				if(window.navigator.userAgent.indexOf('MSIE 6')!=-1){
					oKefu.style.position='absolute';
					oKefu.style.top=scrollTop+310+'px';
					}else{
					oKefu.style.position='fixed';
					oKefu.style.top=310+"px";
					}
				
				}else{
					oKefu.style.position='';
					};
 
  
	}; 
*/

	
	
	
	
 };















