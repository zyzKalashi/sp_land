var myChart = echarts.init(document.getElementById('main'));
$.post("/charts/getDashBordChart","",function (resp) {
    var option = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['土地承包','林权转让','养殖水面','四荒承包']
        },
        calculable : true,
		grid:{
			x:100,
		},
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : resp.category
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value} 万元'
                }
            }
        ],
        series : resp.series
    };

    myChart.setOption(option);
});