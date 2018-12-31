/*分享到新浪微博，QQ空间，人人网，生成二维码*/
    var myTitle=$("title").text();
    var myHref = window.location.href;
    function shareweibo(title,url,picurl)  
    {  
        var sharesinastring='http://v.t.sina.com.cn/share/share.php?title='+title+'&url='+url+'&content=utf-8&sourceUrl='+url+'&pic='+picurl;  
        window.open(sharesinastring,'newwindow','height=400,width=400,top=100,left=100');  
    }
    function sharetoqqzone(title,url,picurl)  
    {  
        var shareqqzonestring='http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?summary='+title+'&url='+url+'&pics='+picurl;  
        window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100');  
    }   
    function sharerenren(title,url,picurl){
        var shareqqzonestring='http://***/share/buttonshare.do?link='+myHref+'&title='+myTitle+'';  
        window.open(shareqqzonestring,'newwindow','height=400,width=400,top=100,left=100');  
    }
    function sharewxcode() {
        var text ="北京晨诺达技术有限公司";
        //生成二维码可能和网上其他地方的资料不一样，添加了logo图片路径（之前不知道哪位高手写的第一版本，貌似没有logo功能，在此基础上加的）
        $('#div_code').qrcode({
            text: utf16to8(text),
            height: 200,
            width: 200,
            colorDark : '#000000',
            colorLight : '#ffffff',
            correctLevel : QRCode.CorrectLevel.H
          //此处添加了个logo，可以随意替换链接
          /*src: 'file:///E:/test/erweima/images/123211.jpg'*/
      });
    }
    function utf16to8(str) { //转码
        var out, i, len, c;
        out = "";
        len = str.length;
        for (i = 0; i < len; i++) {
            c = str.charCodeAt(i);
            if ((c >= 0x0001) && (c <= 0x007F)) {
                out += str.charAt(i);
            } else if (c > 0x07FF) {
                out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
                out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
                out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
            } else {
                out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
                out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
            }
        }
        return out;
    }
    $("#weibo").click(function(){
        shareweibo(myTitle,myHref,"");
    });
    $("#qq").click(function(){
        sharetoqqzone(myTitle,myHref,"");
    });
    $("#weixin").click(function(){
        sharewxcode();
    });
    $(".cancel").click(function(){
        $("#div_code").empty();
    });
    $("#renren").click(function(){
        sharerenren();
    });

<script type="text/javascript" src="js/jquery-1.10.0.js"></script>
<script type="text/javascript" src="js/qrcode.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
