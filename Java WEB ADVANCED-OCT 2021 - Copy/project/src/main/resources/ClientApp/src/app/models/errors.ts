export class CreateListingErrors {
    fatalError: string[];
    title: string[];
    description: string[];
    imageUrl: string[];
    payment: string[];
    listingCreateModel: string[];
    confirmPassword: string[];
    constructor() {
        this.fatalError = [];
        this.title = [];
        this.description = [];
        this.imageUrl = [];
        this.payment = [];
        this.listingCreateModel = [];
        this.confirmPassword = []
    }
}



export class UserRegisterErrors {
    fatalError: string[];
    firstName: string[];
    lastName: string[];
    username: string[];
    email: string[];
    password: string[];
    confirmPassword: string[];
    constructor() {
        this.fatalError = [];
        this.firstName = [];
        this.lastName = [];
        this.username = [];
        this.email = [];
        this.password = [];
        this.confirmPassword = []
    }
}

export function responseAllError(err: any) {
    return Object(err)['error']['errors'];
}
export function responseError(err: any) {
    return Object(err)['errors']['errors'];
}
export function setErrors(err: any, errors: any) {
    let responce: [] = responseAllError(err);
    (responce.forEach(e => {
        let field = e['field'];
        let error_ = e['defaultMessage']
        errors[field].push(error_);
    }));
    return errors;
}

export function ErrorResponse(data: Object) {
    console.log(data)
    const baseError = Object(data)['error'];
    // console.log(baseError)

    const errorStatus = baseError['status'];
    const errorMessage = baseError['message'];
    const errors = baseError['errors'];
    //   const errorLists = Object(data)['errors']['errors'];
    console.log(errorStatus)
    if (errorStatus == 401 && errorMessage === "200_Full authentication is required to access this resource") {
        //  console.log(errorMessage)
        // console.log(localStorage.getItem('token'))
        // console.log(localStorage.getItem('user'))
        localStorage.clear();
        window.location.reload();
    }
    return { errors };
}

