
export function fetchAdminDetail(callback) {
    mock(callback)
}
function getstep() {
    return Math.ceil(Math.random()*10);

}

function mock(callback) {
    var now=new Date(2017,3,1);
    var worker=0;
    var date;
    var workerTrend=[];
    var totalWorker=[];
    var totalRequester=[];
    let mock={
        taskQuantity:100,
        completedTask:50,
        activeWorkerTrend:workerTrend,
        totalWorkerTrend:totalWorker,
        totalRequesterTrend:totalRequester
    };

    for (let i=0; i<100; i++){
        date = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/');
        worker+=getstep();
        workerTrend[date]=worker;
        totalWorker[date] =Math.floor(getstep()/10*workerTrend[date]);
        totalRequester[date]=getstep();

        now.setDate(now.getDate()+1)
    }

    callback(mock);

    console.log(workerTrend);

}