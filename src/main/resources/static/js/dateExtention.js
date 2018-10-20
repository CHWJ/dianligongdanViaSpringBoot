/**
 * 需要引用 stringExtention.js 文件
 */

Date.prototype.toDateString = function () {
    let d = this;
    return d.getFullYear()
        + "-" + (d.getMonth() + 1).toString().leftPad(2)
        + "-" + d.getDate().toString().leftPad(2);
};
Date.prototype.toDateTimeString = function () {
    let d = this;
    return d.getFullYear()
        + "-" + (d.getMonth() + 1).toString().leftPad(2)
        + "-" + d.getDate().toString().leftPad(2)
        + " " + d.getHours()
        + ":" + d.getMinutes().toString().leftPad(2)
        + ":" + d.getSeconds().toString().leftPad(2);
};
Date.prototype.setTodayBegin = function () {
    let d = this;
    d.setHours(0);
    d.setMinutes(0);
    d.setSeconds(0);
    d.setMilliseconds(0);
    return d;
};
Date.prototype.addDays = function (days) {
    let d = this;
    d.setDate(d.getDate() + days);
    return d;
};
Date.prototype.setTodayEnd = function () {
    let d = this;
    d.setHours(23);
    d.setMinutes(59);
    d.setSeconds(59);
    d.setMilliseconds(999);
    return d;
};
Date.prototype.setMonthBegin = function () {
    let d = this;
    d.setDate(1);
    d.setHours(0);
    d.setMinutes(0);
    d.setSeconds(0);
    d.setMilliseconds(0);
    return d;
};
Date.prototype.setMonthEnd = function () {
    let d = this;
    d.setMonth(d.getMonth() + 1);
    d.setMonthBegin();
    d.setDate(0);
    d.setTodayEnd();
    return d;
};