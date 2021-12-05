export function _allData(data: any) {
    return Object(data)['data']
}
export function ApiResponse(data: Object) {
    const _data = Object(data)['data'];

    const getId = _data['id'];



    const confirm = _data['confirm'];
    const isDelete = _data['delete'];


    const getListing = _data['listing']
    const getListings = _data['listings']
    const getOrder = _data['order']
    const getOrders = _data['orders']
    const getWatch = _data['watch']
    const getPurchses = _data['purchases'];
    // const getDelivery =  _data['delivery']
    const getSellingFormat = _data['selling-formats']
    const getCategories = _data['categories'];
    const getConditions = _data['conditions'];
    const getFeedbacks = _data['feedbacks']
    const getMessagess = _data['msg']


    //msgs
    const msg = _data['left']

    //identity
    const getUser = _data['user'];
    // const getToken = _data['login']['token'];



    return {
        getId,
        getUser,
        confirm, isDelete,
        msg,
        getListing, getListings,
        getOrder, getOrders,
        getWatch, getPurchses,
        getSellingFormat, getCategories, getConditions, getFeedbacks, getMessagess
    }
}

export function responsePageble(data: Object) {
    return Object(data)['page'];
}

export function responceId(data: any) {
    return _allData(data)['id']
}
export function responceConfirm(data: any) {
    return _allData(data)['confirm']
}
export function responceListing(data: any) {
    return _allData(data)['listing']
}
export function responceListings(data: any) {
    return _allData(data)['listings']
}
export function responseOrder(data: any) {
    return _allData(data)['order']
}
export function responseWatch(data: any) {
    return _allData(data)['watch']
}
export function responsePurchases(data: any) {
    return _allData(data)['purchases']
}

export function responceDeliveryByArea(data: any, index: number) {
    return _allData(data)['delivery'][index]['deliveryService']
}

export function responceSellingFormat(data: any) {
    return _allData(data)['selling-formats']
}
export function responeseUser(data: any) {
    return _allData(data)['user']
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

