
package com.api.SmartEdu.data;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {

    public List<AlunoEntity> findByNomeContaining(String nome);

    
    
}
