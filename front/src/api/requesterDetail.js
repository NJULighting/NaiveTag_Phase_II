export function fetchRequesterDetail(username, callback) {
    mockDetail(username, callback);
}


function mockDetail(username, calllback) {
    let res = {
        name: 'deep♂dark♂fantasy',
        email: '22223@22.com',
        username: 'van',
        score: 999
    };
    calllback(res)
}