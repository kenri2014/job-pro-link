//空文字列のフィルタリング
function dealObjectValue(obj: object) {
    var param = {};
    for (let key in obj) {
        let propertyType = typeof obj[key as keyof typeof obj];
        if (propertyType !== "string" && (obj[key as keyof typeof obj] as Array<any>).length > 0) {
            param[key as keyof typeof param] = obj[key as keyof typeof obj];
        } else if (propertyType == "string" && obj[key as keyof typeof obj] !== null && obj[key as keyof typeof obj] !== undefined && obj[key as keyof typeof obj] !== "") {
            param[key as keyof typeof param] = obj[key as keyof typeof obj];
        } else if (propertyType == "number" && obj[key as keyof typeof obj] !== null && obj[key as keyof typeof obj] !== undefined && obj[key as keyof typeof obj] !== "") {
            param[key as keyof typeof param] = obj[key as keyof typeof obj];
        }
    };
    return param;
}

export default dealObjectValue
