$(function () { 
    var RankChart = Highcharts.chart('schart', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '分数分布区间'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            name: '比重',
            colorByPoint: true,
            data: [{
                name: '90~100',
                y: 50
            }, {
                name: '80~90',
                y: 20
            }, {
                name: '70~80',
                y: 10
            }, {
                name: '60~70',
                y: 15
            }, {
                name: '<60',
                y: 5
            }]
        }]
    });

});