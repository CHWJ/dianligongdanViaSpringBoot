const commonMethod = {
    // 只能用于加载 iframe
    httpRequest: function (keyValue) {
        let empty = "";
        let search = location.search.slice(1);
        let arr = search.split("&");
        for (let i = 0; i < arr.length; i++) {
            let ar = arr[i].split("=");
            if (ar[0] === keyValue) {
                if (unescape(ar[1]) === 'undefined') {
                    return empty;
                } else {
                    return unescape(ar[1]);
                }
            }
        }
        return empty;
    }
};