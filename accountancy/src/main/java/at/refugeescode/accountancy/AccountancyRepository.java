package at.refugeescode.accountancy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountancyRepository extends JpaRepository<Patient,Long> {


}
