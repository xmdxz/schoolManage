'use strict';

$(document).ready(function () {

    // Area chart
    //在线测试网站 https://wow.techbrood.com/fiddle/41653
    //属性大全 https://apexcharts.com/docs/options/chart/toolbar/
	var areaarray=['太原', '大同', '阳泉', '长治', '晋城', '朔州', '晋中', '运城', '忻州', '临汾', '吕梁', '山东', '河南', '北京', '陕西', '河北'];
	var obj=null;
	var label=[];
	var label_sd=['周一','周二','周三','周四','周五','周六','周日'];
	var datas=[];
	var data_sd=[];
	var j=0;
	var i=0;
	$.ajax({
		type: "post",
		url: "/student/findbyarea",
		data:{comy:'2019',area1:areaarray[0],area2:areaarray[1],area3:areaarray[2],area4:areaarray[3],area5:areaarray[4],area6:areaarray[5],area7:areaarray[6],area8:areaarray[7],area9:areaarray[8],area10:areaarray[9],area11:areaarray[10],area12:areaarray[11],area13:areaarray[12],area14:areaarray[13],area15:areaarray[14],area16:areaarray[15]},
		async: false,
		dataType: "json",
	}).done(function (res) {
		obj=res;
		var props = "";
		for(var p in obj){
			if(typeof(obj[p])=="function"){
				obj[p]();
			}else{
				label[i]=p;
				datas[i]=(parseInt(obj[p]))
				i++;
			}
		}
	});
    $.ajax({
        type: "post",
        url: "/QingJia/findBYweek",
        data:{comy:'2019'},
        dataType: "json",
        async: false,
    }).done(function (res) {
        obj=res;
        for(;j<=6;j++)
        {
            var a=label_sd[j];
            data_sd[j]=obj[a]
        }
    });
    var options = {
        chart: {
            height: 350,
            type: "area",	//图表类型  area为瀑布类型  bar为柱状图
            toolbar: {
                show: false	//隐藏右上角的图标 包括缩放 拖动 恢复等按钮
            },
        },
        dataLabels: {
            enabled: false		//是否在图标上显示数据
        },
        stroke: {
            curve: "smooth"
        },
        series: [{					//数据内容以及内容值
            name: "请假人数",
            data: data_sd
        }],
        xaxis: {				//X周单位内容
            categories: label_sd,
        }
    };
    var chart = new ApexCharts(
        document.querySelector("#apexcharts-area"),
        options
    );
    chart.render();

    // Bar chart

    var optionsBar = {
        chart: {
            type: 'bar',
            height: 350,
            width: '100%',
            stacked: true,
            events: { // 添加柱状图数据的点击事件
                dataPointSelection: function (event, chartContext, config) {
                    console.log(config.w.config.labels[config.dataPointIndex]);
                    var area = config.w.config.labels[config.dataPointIndex];
                    window.location.href='students.html?area='+area;
                }
            },
            toolbar: {
                show: false
            },
        },
        dataLabels: {
            enabled: false
        },
        plotOptions: {
            bar: {
                columnWidth: '45%',
            }
        },
        series: [{
            name: "该地区学生人数",
            color: '#19affb',
            data: datas,
        }],
        labels:label,
        xaxis: {
            labels: {
                show: true
            },
            axisBorder: {
                show: false
            },
            axisTicks: {
                show: false
            },
        },
        yaxis: {
            axisBorder: {
                show: false
            },
            axisTicks: {
                show: false
            },
            labels: {
                style: {
                    colors: '#777'
                }
            }
        },
        title: {
            text: '',
            align: 'left',
            style: {
                fontSize: '18px'
            }
        }

    }

    var chartBar = new ApexCharts(document.querySelector('#bar'), optionsBar);
    chartBar.render();

});