import { Validators } from "@angular/forms";

export function ConditionCreateForm() {
    return {
        title: [null, Validators.required],
        id: [null, Validators.required],
    };
}

export interface ConditionView {
    id: string,
    title: string,


}