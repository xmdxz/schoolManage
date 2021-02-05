'use strict';

$(document).ready(function() {

	// Area chart
	//在线测试网站 https://wow.techbrood.com/fiddle/41653
	//属性大全 https://apexcharts.com/docs/options/chart/toolbar/
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
			data: [45, 60, 75, 51, 42, 42, 30]
		}, {
			name: "准假人数",
			color: '#FFBC53',
			data: [24, 48, 56, 32, 34, 52, 25]
		}],
		xaxis: {				//X周单位内容
			categories: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
		}
	}
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
			name: "Boys",
			color: '#fdbb38',
			data: [420, 532, 516, 575, 519, 517, 454, 392, 262, 383, 446, 551, 563, 421, 563, 254, 452],
		}, {
			name: "Girls",
			color: '#19affb',
			data: [336, 612, 344, 647, 345, 563, 256, 344, 323, 300, 455, 456, 526, 652, 325, 425, 436],
		}],
		labels: [2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020],
		xaxis: {
			labels: {
				show: false
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