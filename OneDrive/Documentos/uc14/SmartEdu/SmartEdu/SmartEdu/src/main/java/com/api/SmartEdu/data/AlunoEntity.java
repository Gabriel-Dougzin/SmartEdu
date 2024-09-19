
package com.api.SmartEdu.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="aluno")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message="Informe o nome do aluno")
    private String nome;
    
    @NotBlank(message="Informe o cpf do aluno")
    private String cpf;
    
    @NotBlank(message="Informe o número de matricula do aluno")
    private String n_matricula;
    
    
    @Pattern(regexp = "^[0-9]+$", message = "A string deve conter apenas números.")
    @Min(value = 0, message = "O valor mínimo é 0.")
    @Max(value = 10, message = "O valor máximo é 100.")
    private String idade;
    
  
    @Pattern(regexp = "^[0-9]+(,[0-9]+)?$", message = "A string deve conter apenas números.")
    @Min(value = 0, message = "O valor mínimo é 0.")
    @Max(value = 10, message = "O valor máximo é 10.")
    private String nota_1 = "0";
    
    
    @Pattern(regexp = "^[0-9]+(,[0-9]+)?$", message = "A string deve conter apenas números.")
    @Min(value = 0, message = "O valor mínimo é 0.")
    @Max(value = 10, message = "O valor máximo é 10.")
    private String nota_2= "0";
    
    
    @Pattern(regexp = "^[0-9]+(,[0-9]+)?$", message = "A string deve conter apenas números.")
    @Min(value = 0, message = "O valor mínimo é 0.")
    @Max(value = 10, message = "O valor máximo é 10.")
    private String nota_3= "0";
    
    @NotBlank(message="Erro, média não pode ser calculada")
    private String aprov= "N/A";
    
}
