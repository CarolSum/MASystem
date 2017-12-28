$(function () { 
    var RankChart =       

    Highcharts.chart('rank-chart', {
        chart: {
            type: 'spline'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: ['作业1', '作业2', '作业3', '作业4', '作业5','作业6', '作业7', '作业8', '作业9', '作业10']
        },
        yAxis: {
            title: {
                text: '排名'
            },
            labels: {
                formatter: function () {
                    return this.value ;
                }
            },
            reversed: true
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [{
            name: '排名',
            marker: {
                symbol: 'circle'
            },
            data: [1,2,3,4,20,30,1,14,2,1]
        }]
    });



    var ScoreChart =       

    Highcharts.chart('score-chart', {
        chart: {
            type: 'spline'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: ['作业1', '作业2', '作业3', '作业4', '作业5','作业6', '作业7', '作业8', '作业9', '作业10']
        },
        yAxis: {
            title: {
                text: '分数'
            },
            labels: {
                formatter: function () {
                    return this.value ;
                }
            }
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [{
            name: '分数',
            marker: {
                symbol: 'square'
            },
            data: [100,90,99,95,96,97,98,99,100,98]
        }]
    });
});