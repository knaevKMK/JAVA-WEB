export function _allData(data: any) {
    return Object(data)['data']
}

export function responceId(data: any) {
    return _allData(data)['id']
}

export function responceListing(data: any) {
    return _allData(data)['listing']
}
export function responceListings(data: any) {
    return _allData(data)['listings']
}
export function responceDeliveryByArea(data: any, index: number) {
    return _allData(data)['delivery'][index]['deliveryService']
}

export function responceSellingFormat(data: any) {
    return _allData(data)['selling-formats']
}

export function responceCategory(data: any) {
    return _allData(data)['categories']
}
export function responceCondition(data: any) {
    return _allData(data)['conditions']
}
export function responceToken(data: any) {
    return _allData(data)['login']['token'];
}