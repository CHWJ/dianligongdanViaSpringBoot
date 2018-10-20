String.prototype.leftPad = function (num) {
    let i = 0;
    let pad = "";
    while (i < num) {
        pad += "0";
        i++;
    }
    return (pad + this).slice(-pad.length);
};
String.prototype.endWithEllipsis = function (num) {
    if (this !== "" && this !== undefined && this !== null) {
        if (this.length > num) {
            return this.substr(0, num) + "...";
        }
    }

    return this;
};