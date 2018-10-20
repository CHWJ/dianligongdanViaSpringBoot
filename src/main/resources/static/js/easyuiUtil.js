const easyuiUtil = {};
easyuiUtil.datagrid = {
    defaultOption: {
        iconCls: '',//图标
        nowrap: false,
        border: true,
        collapsible: true,//是否可折叠的
        fit: true,//自动大小
        remoteSort: false,
        pagination: true,//分页控件
        rownumbers: true,//行号,
        singleSelect: true,
        fitColumns: true,   //若不加，则有列标题和列内容不对齐的问题
        pageSize: 20,
        pageList: [20, 30, 50],
        url: null,
        columns: null,
        frozenColumns: [[
            {field: 'ck', checkbox: true}
        ]],
        onLoadSuccess: function (r) {
        },
        onLoadError: function () {
        }
    },
    getOptionTemplate: function () {
        return {
            iconCls: "",
            url: "",
            columns: [],
        }
    },
    combineOption: function (option) {
        return $.extend(easyuiUtil.datagrid.defaultOption, option);
    }
};
easyuiUtil.datetimespinner = {
    formatter: function (date) {
        if (!date) {
            return '';
        }
        let y = date.getFullYear();
        let m = date.getMonth() + 1;
        return y + '-' + (m < 10 ? ('0' + m) : m);
    },
    parser: function (s) {
        if (!s) {
            return null;
        }
        let ss = s.split('-');
        let y = parseInt(ss[0], 10);
        let m = parseInt(ss[1], 10);
        if (!isNaN(y) && !isNaN(m)) {
            return new Date(y, m - 1, 1);
        } else {
            return new Date();
        }
    }
};
easyuiUtil.Formatter = {
    validLongText: function ValidLongText(cell, row) {
        if (typeof cell === "string")
            cell.endWithEllipsis(18);
        return cell;
    }
};
