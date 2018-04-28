# 文件格式要求

## 数据集

数据集的格式应是`.zip`格式，压缩包中必须要有一个名为`data`的文件夹，`data`文件夹中放置数据集的图片

## 数据集配置文件

上传数据集时需要上传一个名为`task.json` 的文件，文件的格式如下

```json
[
  {
    "taskType": 100,
    "format": "jpg",
    "classes": [
      "ugly",
      "not beautiful"
    ],
    "description": "您认为图片中的人物漂亮吗?"
  },
  {
    "taskType": 101,
    "format": "jpg",
    "description": "请标出图中的动漫人物"
  },
  {
    "taskType": 200,
    "format": "jpg",
    "classes": [
      "here no boys",
      "girl"
    ],
    "description": "框出图片中的动漫人物并标识其性别"
  },
  {
    "taskType": 201,
    "format": "jpg",
    "description": "请标出图中的动漫人物"
  },
  {
    "taskType": 300,
    "format": "jpg",
    "classes": [
      "man",
      "woman"
    ],
    "description": "框出图片中的动漫人物并标识其性别"
  },
  {
    "taskType": 301,
    "format": "jpg",
    "description": "请标出图中的动漫人物"
  },
  {
    "taskType": 400,
    "format": "jpg",
    "description": "勾勒出图片中动漫人物及其轮廓"
  },
  {
    "taskType": 401,
    "format": "jpg",
    "description": "请标出图中的动漫人物",
    "classes": ["frog"]
  }
]

```

- 最外层必须得是`json`数组
- 数组中一个`JsonObject` 表示一个类型的任务，每一个 `JsonObject` 对应一个用户想要的对上传数据集进行的标记操作，上传后数据集中的每个图片都会被执行该文件中定义的所有操作，详情见需求规格说明文档。

## 现成数据集及配置文件

见文档仓库 `dataset` 文件夹