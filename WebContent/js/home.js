

$(function () { 

    $.get('/MASystem/getUserInfo', function(arr) {
        var names = _.map(arr, getHomeworkId);
        var scores = _.map(arr, getScores);
        var ranks = _.map(arr, getRank);
        var ScoreChart = Highcharts.chart('score-chart', {
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
                categories: names
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
                data: scores
            }]
        });


        var RankChart = Highcharts.chart('rank-chart', {
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
                categories: names
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
                data: ranks
            }]
        });


    });

    

});


function getHomeworkId(obj){
    return '作业'+obj.hwId;
}

function getScores(obj){
    return obj.score;
}

function getRank(obj){
    return obj.rank;
}