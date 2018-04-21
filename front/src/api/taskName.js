export function taskName(taskType) {
    switch (taskType) {
        case 100:
            return "整体标"
            break;
        case 101:
            return "整体注"
            break;
        case 200:
            return "单框标"
            break;
        case 201:
            return "单框注"
            break;
        case 300:
            return "多框标"
            break;
        case 301:
            return "多框注"
            break;
        case 400:
            return "边界注"
            break;
        case 401:
            return "边界标注"
            break;
        default:
            break;
    }
}