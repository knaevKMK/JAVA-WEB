package spring_fundametals.mobilele.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_fundametals.mobilele.services.impl.OfferServiceImpl;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferServiceImpl offerService;

    public OfferController(OfferServiceImpl offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    public String allOffers(Model model) throws Exception {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }
}
