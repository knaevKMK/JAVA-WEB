import { Validators } from "@angular/forms"

export function SearchForm() {
    return {
        'title': [null, Validators.required],
        'titleSort': ["Current", Validators.required],
        'description': [null, Validators.required],

        'category': ["Select...", Validators.required],
        'condition': ["Select...", Validators.required],

        'seller': [null, Validators.required],

        'sellingFormat': ["Select...", Validators.required],

        'price': [null, Validators.required],
        'priceSort': ["Current", Validators.required],
        'priceArrow': ["Current", Validators.required],

        'timeSort': ["Current", Validators.required],

    }
}

export function SearchResult(data: any) {

    data['category'] = data['category'] == "Select..."
        ? null
        : data['category'];

    data['condition'] = data['condition'] == "Select..."
        ? null
        : data['condition'];

    data['sellingFormat'] = data['sellingFormat'] == "Select..."
        ? null
        : data['sellingFormat'];


    data['titleSort'] = data['titleSort'] == "Current"
        ? null
        : data['titleSort'];

    data['priceArrow'] = data['priceArrow'] == "Current"
        ? null
        : data['priceArrow'];
    data['priceSort'] = data['priceSort'] == "Current"
        ? null
        : data['priceSort'];

    data['timeSort'] = data['timeSort'] == "Current"
        ? null
        : data['timeSort'];

    let _filterResult = Object.entries(data)
        .filter(([k, v]) => v != null)
        .reduce((acc, [k, v]) => ({ ...acc, [k]: v }), {});
    return _filterResult;
}