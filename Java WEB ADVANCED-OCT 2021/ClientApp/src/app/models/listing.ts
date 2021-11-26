import { FormBuilder, Validators } from "@angular/forms";
import { CategoryCreateForm, CategoryView } from "./category";
import { ConditionCreateForm, ConditionView } from "./condition";
import { DeliveryCreateForm, DeliveryView } from "./delivery";
import { SellingCreateForm, SellingFormatView } from "./sellingFormat";


export function ListingCreateForm(fb: FormBuilder) {
    return {
        id: [null, Validators.required],
        createOn: [null, Validators.required],
        title: [null, Validators.required],
        description: [null, Validators.required],
        imageUrl: [null, Validators.required],
        condition: fb.group(ConditionCreateForm()),
        category: fb.group(CategoryCreateForm()),
        sellingFormat: fb.group(SellingCreateForm()),
        deliveryDomestic: fb.group(DeliveryCreateForm()),
        deliveryInternational: fb.group(DeliveryCreateForm()),
        payment: [null, Validators.required],
        createFrom: [null],
        owner: [null],
        active: [null],
        watchCount: [null]
    }
}

export class ListingView {
    id: string;
    createOn: any;
    title: string;
    description: string;
    imageUrl: string;
    condition: ConditionView;
    category: CategoryView;
    sellingFormat: SellingFormatView;
    deliveryDomestic: DeliveryView;
    deliveryInternational: DeliveryView;
    payment: string
    owner: boolean;
    active: boolean;
    createFrom: string;
    watchCount: number;
    watched: boolean;
    constructor() {
        this.id = "";
        this.createOn = Date.now();
        this.title = "";
        this.description = "";
        this.imageUrl = ""
        this.condition = { title: "", id: '' }
        this.category = { id: '', title: '', parentTitle: '', subList: [] }
        this.sellingFormat = { id: '', title: '', duration: 1, price: 0, quantity: 0 }
        this.deliveryDomestic = { deliveryService: [], price: 0 }
        this.deliveryInternational = { deliveryService: [], price: 0 }
        this.payment = ''
        this.owner = false;
        this.active = false;
        this.createFrom = "";
        this.watchCount = 0;
        this.watched = false;
    }
}



export interface ListingInListView {
    id: string;
    imageUrl: string;
    price: number
    title: string;
    // constructor() {
    //     this.id = ''
    //     this.imageUrl = ''
    //     this.price = 0
    //     this.title = ''
    // }
}