package trial.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trial.demo.Model.Merchant; 
import trial.demo.Service.MerchantService;

@RestController
@RequestMapping("/mer") 
public class MerchantController {


    @Autowired
    private MerchantService merservice;

    
    @GetMapping("/{id}")
    public Merchant getMerchant(@PathVariable Long id) {
    return merservice.getById(id);
    }


    @PostMapping("/addmer")
     public Merchant sandharbh(@RequestBody Merchant one) {

        Merchant mer = merservice.addmer(one);

        return mer;
    }


    @PutMapping("/update/{id}")
    public Merchant updatemerchant(@PathVariable Long id, @RequestBody Merchant updatedmerchant) {
        return merservice.updatemer(id, updatedmerchant);
    }

    
    @DeleteMapping("/delete/{id}")
    public String deleteMerchant(@PathVariable Long id) {
        merservice.deletemer(id);
        return "Merchant with ID " + id + " deleted successfully.";
    }
     
    }
        
     



