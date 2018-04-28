import {getUrl} from "~/api/tool";

export function fetchAdminDetail(callback) {
    fetchFromServer(callback)
}

function fetchFromServer(callback) {
    $.get(getUrl('admin.html'), res => {
        let result = JSON.parse(res);
        /**
         * 处理后端返回的数据
         * 原格式为 [{04-01:12},{04-02:13}]
         * 处理为 {04-01:12,04-02:13}
         */
        result.totalWorkerTrend = result.totalWorkerTrend.reduce((prev, curr) => ({
            ...prev,
            [Object.keys(curr)[0]]: Object.values(curr)[0]
        }), {});
        result.activeWorkerTrend = result.activeWorkerTrend.reduce((prev, curr) => ({
            ...prev,
            [Object.keys(curr)[0]]: Object.values(curr)[0]
        }), {});
        result.totalRequesterTrend=result.totalRequesterTrend.reduce((prev, curr) => ({
            ...prev,
            [Object.keys(curr)[0]]: Object.values(curr)[0]
        }), {});
        callback(result);
    })
}

function getStep() {
    return Math.ceil(Math.random() * 10);
}

function mock(callback) {
    var now = new Date(2017, 3, 1);
    var worker = 0;
    var date;
    var activeWorker = [];
    var totalWorker = [];
    var totalRequester = [];
    let mock = {
        taskQuantity: 1,
        completedTask: 0,
        activeWorkerTrend: activeWorker,
        totalWorkerTrend: totalWorker,
        totalRequesterTrend: totalRequester
    };

    for (let i = 0; i < 100; i++) {
        date = [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/');
        worker += getStep();
        totalWorker[date] = worker;
        activeWorker[date] = Math.ceil(getStep() / 10 * totalWorker[date]);
        totalRequester[date] = getStep();

        now.setDate(now.getDate() + 1)
    }

    callback(mock);

}