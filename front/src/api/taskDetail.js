import axios from 'axios'
import {getUrl} from "~/api/tool";

export function getTaskDetail(taskId,username,callback) {
    fetchFromServer(taskId,username,callback);
}

function fetchFromServer(taskId,username,callback) {
    $.get(getUrl('requester/details.html'),{taskId:taskId,username:username},
            res=>callback(JSON.parse(res)));
}

function mockTaskDetail(taskId) {
    console.log('get')
    return [
        {
            taskProcess: 0.8,
            taskInfo: {
                taskType: 201,
                description: '请用方框标出图中的动物'
            },
            taskParticipant: [
                {
                    name:'萨达特',
                    rank: 1000,
                    ability: 1.22,
                    rankRate: 0.1,
                },
                {
                    name:'萨达特',
                    rank: 200,
                    ability: 0.88,
                    rankRate: 0.2
                }
            ]
        },
        {
            taskProcess: 1.0,
            taskInfo: {
                taskType: 400,
                description: '请对图中的狗进行描边'
            },
            taskParticipant: [
                {
                    name:'萨达特',
                    rank: 1000,
                    ability: 1.22,
                    rankRate: 0.1
                },
                {
                    name:'萨达特',
                    rank: 200,
                    ability: 0.88,
                    rankRate: 0.2
                }
            ]
        },
        {
            taskProcess: 0.3,
            taskInfo: {
                taskType: 301,
                description: '请对图中的狗进行描边'
            },
            taskParticipant: [
                {
                    name:'萨达特',
                    rank: 1000,
                    ability: 1.22,
                    rankRate: 0.1
                },
                {
                    name:'萨达特',
                    rank: 200,
                    ability: 0.88,
                    rankRate: 0.2
                }
            ]
        }
    ];

}