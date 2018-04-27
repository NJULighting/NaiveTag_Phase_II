import {getUrl} from "~/api/tool";

export function fetchAdminDetail(callback) {
    mock(callback)
}

function fetchFromServer(callback) {
    $.get(getUrl('admin.html'),res=>{
        callback(JSON.parse(res));
    })
}

function getStep() {
    return Math.ceil(Math.random()*10);
}

function mock(callback) {
    var now=new Date(2017,3,1);
    var worker=0;
    var date;
    var activeWorker=[];
    var totalWorker=[];
    var totalRequester=[];
    let mock={
        taskQuantity:160,
        completedTask:50,
        activeWorkerTrend:activeWorker,
        totalWorkerTrend:totalWorker,
        totalRequesterTrend:totalRequester
    };

    for (let i=0; i<100; i++){
        date = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/');
        worker+=getStep();
        totalWorker[date]=worker;
        activeWorker[date] =Math.ceil(getStep()/10*totalWorker[date]);
        totalRequester[date]=getStep();

        now.setDate(now.getDate()+1)
    }

    callback(mock);

}