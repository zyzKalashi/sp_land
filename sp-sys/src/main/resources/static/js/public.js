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
}












