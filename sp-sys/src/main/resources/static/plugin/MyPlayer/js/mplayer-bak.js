var MyPlayer = function(){
		this.baseUrl = null;
		this.baseId = null;
		this.audioUrl = null;
		this.config = function(url,audioUrl,id){
			this.baseUrl = url;
			this.baseId = id;
			this.audioUrl = audioUrl;
			this.genPlayer();
		},
			this.genPlayer = function(){
				$("#"+this.baseId).empty();
				$("#"+this.baseId).append(
					'<div class="sample-amr box-shadow" style="background:#F6F6F8;width:100%;height: 47px;position: relative;display: -webkit-flex;display: flex;line-height: 47px;min-width: 680px;">'+
						'<div style="padding:4px 32px;display: inline-block;vertical-align: middle;flex-shrink: 0;">'+
							//'<span class="fa fa-play-circle play"></span>'+
							//'<span class="fa fa-pause-circle stop"></span>'+
							'<img class="play" src="img/play1.png" width="37px" height="37px" style="margin-right: 15px;">'+
							'<img class="stop" src="img/stop.png" width="37px" height="37px">'+
						'</div>'+
						'<span class="curTime">00:00:00</span>'+
						'<div style="flex-shrink: 1;flex-grow: 2;">'+
							'<input  class="playSlider" type="hidden" name="playSlider" value="" />'+
						'</div>'+
						'<span class="totalTime">00:00:00</span>'+
						'<img class="sound" src="img/sound.png">'+
						'<div class="v" style="width:80px;display: inline-block;flex-shrink: 0;padding: 17px 20px 17px 0px;">'+
							'<input  class="volumeSlider" type="hidden" name="volumeSlider" value="" />'+
						'</div>'+
					'</div>'
				);
				this.initEventHandler();
			},
			this.initEventHandler = function(){
				var mp = this;
				//������
				console.log($("#"+mp.baseId+" .playSlider"));
				$("#"+mp.baseId+" .playSlider").ionRangeSlider({
					type: 'single',
					min:0,
					hide_min_max: true,
					hide_from_to: true,
					onChange:function(obj){
						//����ʱ�϶�������
						if(boxes.status=="play"){
							boxes.stop();
						}
					}
				});
				var boxes = new Boxes();
				boxes.baseUrl = mp.baseUrl;
				boxes.baseId = mp.baseId;
				//������
				$("#"+this.baseId+" .volumeSlider").ionRangeSlider({
					type: 'single',
					min:0,
					max:1,
					step: 0.1,
					from:boxes.volumeValue,
					hide_min_max: true,
					hide_from_to: true,
					force_edges:true,
					onFinish: function(obj){
						boxes.volumeValue = parseFloat($("#"+boxes.baseId+" .volumeSlider").val());
						if(boxes.gainNode){
							boxes.gainNode.gain.value = boxes.volumeValue;
						}
					}
				});
				boxes.initAPI();
				boxes.$curTime = $("#"+boxes.baseId+" .sample-amr .curTime");
				boxes.$totalTime = $("#"+boxes.baseId+" .sample-amr .totalTime");
				//������ͣ
				E("#"+mp.baseId+" .sample-amr .play").onclick = function() {
					//���水ť����
					boxes.playBtn = this;
					if(boxes.status=="stop"){
						this.src=boxes.baseUrl+"img/pause1.png";
						boxes.fetchBlob(mp.audioUrl, function(blob) {
							//��֮�ڵ����ݽ���ͼ��ض�����Ҫʱ���,�ʲ��Ų���Ҫд�����ڵĻص���
							boxes.playAmrBlob(blob);
						});
					}else if(boxes.status=="play"){
						this.src= boxes.baseUrl+"img/play1.png";
						boxes.playStart = parseFloat($("#"+boxes.baseId+" .playSlider").val());
						boxes.stop();
					}else{
						alert("״̬�쳣");
					}

				};
				//��ֹ
				E("#"+mp.baseId+" .sample-amr .stop").onclick = function() {
					boxes.playBtn.src=boxes.baseUrl+"/img/play.png";
					boxes.terminal();
				}
			}

	}




	function E(selector) {
		return document.querySelector(selector);
	}

	var Boxes = function() {
		this.baseId = null;
		this.baseUrl = null;
		this.playBtn = null;     //���Ű�ť����
		this.interId = null;     //��ʱ����id
		this.status = "stop"; //��ǰ����״̬
		this.startTime = 0;  //��ʼ����ʱ��
		this.totalTime = 0;  //��ʱ��
		this.$curTime = null;  //��ʾ��ǰʱ��jquery����
		this.$totalTime = null;  //��ʾ��ʱ���jquery����
		this.playStart = 0;  //��Ƶ�ļ���ʼ����ʱ���
		this.buffer = null; //Ҫ������ļ�
		this.audioContext = null; //������Ƶ����������ģ��Ժ����г�ʼ��
		this.source = null; //������Ƶ
		this.gainNode = null; //��Ƶ����ڵ�
		this.volumeValue = 0.5; //����ֵ

		this.initAPI= function() {
			//ͳһǰ׺���������
			window.AudioContext = window.AudioContext || window.webkitAudioContext || window.mozAudioContext || window.msAudioContext;
			//��ȫ��ʵ����һ��AudioContext����ֵ��audioContext�����ϣ�������洦����Ƶʹ��
			try {
				this.audioContext = new AudioContext();
			} catch (e) {
				console.log('!�����������֧��AudioContext:(');
				console.log(e);
			}
		},
			this.fetchBlob= function(url, callback) {
				var xhr = new XMLHttpRequest();
				xhr.open('GET', url);
				xhr.responseType = 'blob';
				xhr.onload = function() {
					callback(this.response);
				};
				xhr.onerror = function() {
					alert('Failed to fetch ' + url);
				};
				xhr.send();
			},
			this.readBlob= function(blob, callback) {
				var reader = new FileReader();
				reader.onload = function(e) {
					var data = new Uint8Array(e.target.result);
					callback(data);
				};
				reader.readAsArrayBuffer(blob);
			},
			this.playAmrBlob= function(blob, callback) {
				var self = this;
				this.readBlob(blob, function(data) {
					self.playAmrArray(data);
				});
			},
			this.playAmrArray= function(array) {
				var samples = AMR.decode(array);
				if (!samples) {
					alert('Failed to decode!');
					return;
				}
				this.playPcm(samples);
			},
			this.playPcm= function(samples) {
				this.source = this.audioContext.createBufferSource();
				this.gainNode = this.audioContext.createGain();
				if(this.buffer){

				}else{
					this.buffer = this.audioContext.createBuffer(1, samples.length, 8000);
					if (this.buffer.copyToChannel) {
						this.buffer.copyToChannel(samples, 0, 0)
					} else {
						var channelBuffer = this.buffer.getChannelData(0);
						channelBuffer.set(samples);
					}
				}
				this.source.buffer = this.buffer;
				this.source.connect(this.gainNode);
				this.gainNode.connect(this.audioContext.destination);
				this.gainNode.gain.value = this.volumeValue;
				this.totalTime = this.formatTime(this.buffer.duration);
				console.log("totalTime:"+this.totalTime)
				this.$totalTime.text(this.totalTime);
				this.play();
			},
			//ֹͣ(��ͣ)
			this.stop= function(){
				if(this.status=="play"){
					this.stopPro();
					this.source.stop();
					//���³�ʼ��һ��source
					this.source = this.audioContext.createBufferSource();
					this.gainNode = this.audioContext.createGain();
					this.source.buffer = this.buffer;
					this.source.connect(this.gainNode);
					this.gainNode.connect(this.audioContext.destination);
					this.gainNode.gain.value = this.volumeValue;

					this.status="stop";
				}
			},
			//��ֹ
			this.terminal=function(){
				this.stop();
				this.playStart = 0;
				var slider = $("#"+this.baseId+" .playSlider").data("ionRangeSlider");
				slider.update({
					from:0
				});
				this.$curTime.text("00:00:00");
				this.$totalTime.text("00:00:00");
			},
			//����
			this.play= function(){
				if(this.status=="stop"){
					//ctx.currentTime��¼��ΪӲ����ʱ���,�ǴӲ���ʱ�俪ʼ��ʱ,�ʲ���ǰ��Ҫ��¼һ����ʼʱ��.
					this.startTime=this.audioContext.currentTime;
					console.log("startTime:"+this.startTime);

					this.status="play";

					if(this.playStart>=this.buffer.duration){
						this.playStart = 0;
					}
					this.source.start(0,this.playStart);
					this.startPro();

				}else if(this.status="play"){
					this.stop();
				}else{
					console.log("״̬�쳣");
				}
			},
			//��ʼ������
			this.startPro= function(data,offset,samples){
				var self = this;
				this.interId = setInterval(function(){self.pro();},1000);
			},
			//ֹͣ������
			this.stopPro= function(){
				console.log("clear Inter");
				clearInterval(this.interId);
			},
			//������
			this.pro= function(){
				var self = this;
				var src = this.source;
				var buffer = this.buffer;
				var ctx = this.audioContext;
				console.log("hardware currentTimeStamp:"+ctx.currentTime);
				console.log("audio offset:"+this.playStart);
				console.log("audio startTime:"+this.startTime);
				console.log("played time:"+(parseFloat(ctx.currentTime)-parseFloat(this.startTime)+parseFloat(this.playStart)));
				var slider = $("#"+this.baseId+" .playSlider").data("ionRangeSlider");
				var from = parseFloat(ctx.currentTime)-parseFloat(this.startTime)+parseFloat(this.playStart);
				if(from>=buffer.duration){
					from = buffer.duration;
					this.playStart = buffer.duration;
					console.log("play end");
					this.stopPro();
					this.playBtn.src=this.baseUrl+"/img/play.png";
					this.status = "stop";
				}
				// Call sliders update method with any params
				slider.update({
					min: 0,
					max: buffer.duration,
					from:from,
					type: 'single',
					step: 0.1,
					postfix: " seconds",
					prettify: false,
					hasGrid: true,
					onFinish: function(obj){
						self.stop();
						self.playStart = parseFloat($("#"+self.baseId+" .playSlider").val());
						self.playBtn.src=self.baseUrl+"img/pause1.png";
						self.play();
					}
				});
				this.$curTime.text(this.formatTime(from));
			},
			this.formatTime=function(value) {
				var theTime = parseInt(value);// ��
				var theTime1 = 0;// ��
				var theTime2 = 0;// Сʱ
				// alert(theTime);
				if(theTime > 60) {
					theTime1 = parseInt(theTime/60);
					theTime = parseInt(theTime%60);
					// alert(theTime1+"-"+theTime);
					if(theTime1 > 60) {
						theTime2 = parseInt(theTime1/60);
						theTime1 = parseInt(theTime1%60);
					}
				}
				var result;
				if(theTime<10){
					result = "0"+parseInt(theTime);
				}else{
					result = ""+parseInt(theTime);
				}
				if(theTime1 >= 10) {
					result = ""+parseInt(theTime1)+":"+result;
				}else if(theTime1 >0&&theTime1<10){
					result = "0"+parseInt(theTime1)+":"+result;
				}else{
					result = "00"+":"+result;
				}
				if(theTime2 >= 10) {
					result = ""+parseInt(theTime2)+":"+result;
				}else if(theTime2 >0&&theTime2<10){
					result = "0"+parseInt(theTime2)+":"+result;
				} else{
					result = "00"+":"+result;
				}
				return result;
			}
	};
