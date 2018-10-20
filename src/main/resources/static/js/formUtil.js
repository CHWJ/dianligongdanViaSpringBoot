/**
 * 需要引用 jQuery 文件
 */

let SERIALIZE = {
    toObj: function (formId) {
        let serializeObj = {};
        let array = $('#' + formId).serializeArray();

        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });

        return serializeObj;
    }
};