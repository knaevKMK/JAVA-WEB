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