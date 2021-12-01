export interface SetUser {
    username: string,
    fullName: string
}
export class Profile {
    username: string
    firstName: string
    lastName: string
    feedbacks: []
    listingsCount: number
    owner: boolean
    createOn: any
    stars: number
    constructor() {
        this.username = ''
        this.firstName = ''
        this.lastName = ''
        this.feedbacks = [];
        this.listingsCount = 0;
        this.owner = false;
        this.createOn = Date.now()
        this.stars = 0;
    }

}