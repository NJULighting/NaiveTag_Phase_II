export function uploadTaskDescription(file, callback) {
    let formData = new FormData();
    formData.append('taskconf', file);

    // $.post('http://localhost:8000/naive/requester/check.html', formData, res => callback(res))
    $.ajax({
        url: 'http://localhost:8000/naive/requester/check.html',
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            callback(res)
        }
    })
}