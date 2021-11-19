import { Validators } from "@angular/forms";


export function CategoryCreateForm() {
    return {
        title: [null, Validators.required],
        parentTitle: [null, Validators.required],
        subList: [null, Validators.required],
        id: [null, Validators.required],
    }
}

export interface CategoryView {
    id: string,
    title: string,
    parentTitle: any,
    subList: CategoryView[]
}