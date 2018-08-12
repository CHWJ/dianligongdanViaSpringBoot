var WOKRORDER = {
    status:{
        "wait": "待派工",
        "send": "已派工",
        "accept": "已接收",
        "refuse": "已拒绝",
        "start": "开始出发",
        "arrive": "到达现场",
        "handle": "处理完成",
        "nohandle": "未处理",
        "revoke": "撤销",
        "archive": "已归档"
    },
    formatStatus:function (val) {
        return WOKRORDER.status[val];
    }
};