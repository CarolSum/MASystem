var numbers = [0,0,0,0,0];

$(function () { 

    $.get('/MASystem/getHomeworkInfo', function(arr) {
        console.log(arr);
        numbers = [0,0,0,0,0];
        _.forEach(arr, function(obj){
            console.log(obj);
            if (obj.score >= 90) {
                numbers[0]++;
            }else if(obj.score >= 80){
                numbers[1]++;
            }else if(obj.score >= 70){
                numbers[2]++;
            }else if(obj.score >= 60){
                numbers[3]++;
            }else{
                numbers[4]++;
            }
        })

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
                    y: numbers[0]
                }, {
                    name: '80~90',
                    y: numbers[1]
                }, {
                    name: '70~80',
                    y: numbers[2]
                }, {
                    name: '60~70',
                    y: numbers[3]
                }, {
                    name: '<60',
                    y: numbers[4]
                }]
            }]
        });

    });

});
