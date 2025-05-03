package trial.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import trial.demo.Model.Merchant;
import trial.demo.Repository.MerchantRepository;

@Service
public class MerchantService {
    
    @Autowired
    MerchantRepository merchantRepository;
    
    public Merchant getmerById(Long id) {
        return merchantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found with ID: " + id));
    }
    

    public Merchant addmer(Merchant one) {
        Merchant saved = new Merchant();
        saved.setName(one.getName());
        saved.setEmail(one.getEmail());
        saved.setUsername(one.getUsername());
        saved.setPassword(one.getPassword());

        Merchant merc = merchantRepository.save(saved); 
        return merc;
        
    }
    public Merchant updatemer(Long id, Merchant updated){

       Optional<Merchant> optional = merchantRepository.findById(id);
       if (optional.isPresent()) {
        Merchant existing = optional.get();
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setUsername(updated.getUsername());
        existing.setPassword(updated.getPassword());
        return merchantRepository.save(existing);
       }   else {
        return null;
       }
    }
    
    public void deletemer(long id) {
        merchantRepository.deleteById(id);
    }


    public Merchant getById(Long id) {
    return merchantRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Merchant not found with id " + id));
    }


}
