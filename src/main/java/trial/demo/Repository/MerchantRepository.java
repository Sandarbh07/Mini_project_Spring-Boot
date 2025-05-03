package trial.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import trial.demo.Model.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository <Merchant,Long> {

}
