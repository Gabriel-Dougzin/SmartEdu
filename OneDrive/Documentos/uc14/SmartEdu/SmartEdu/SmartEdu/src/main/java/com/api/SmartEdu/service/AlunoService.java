
package com.api.SmartEdu.service;

import com.api.SmartEdu.data.AlunoEntity;
import com.api.SmartEdu.data.AlunoRepository;
import com.api.SmartEdu.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;
public AlunoEntity criarAluno(AlunoEntity func){
func.setId(null);
alunoRepository.save(func);
return func;
}
public AlunoEntity atualizarAluno (Integer funcId, AlunoEntity alunoRequest){
    AlunoEntity func = getAlunoId(funcId);
    func.setNome(alunoRequest.getNome());
    func.setCpf(alunoRequest.getCpf());
    func.setN_matricula(alunoRequest.getN_matricula());
    func.setIdade(alunoRequest.getIdade());
    func.setNota_1(alunoRequest.getNota_1());
    func.setNota_2(alunoRequest.getNota_2());
    func.setNota_3(alunoRequest.getNota_3());
    func.setAprov(alunoRequest.getAprov());
    alunoRepository.save(func);
    return func;
}
public AlunoEntity AdicionarNotas (Integer funcId, AlunoEntity alunoRequest){
    AlunoEntity func = getAlunoId(funcId);
    func.setNome(alunoRequest.getNome());
    func.setCpf(alunoRequest.getCpf());
    func.setN_matricula(alunoRequest.getN_matricula());
    func.setIdade(alunoRequest.getIdade());
    func.setNota_1(alunoRequest.getNota_1());
    func.setNota_2(alunoRequest.getNota_2());
    func.setNota_3(alunoRequest.getNota_3());
    double nota_1db = Double.parseDouble(alunoRequest.getNota_1());
    double nota_2db = Double.parseDouble(alunoRequest.getNota_2());
    double nota_3db = Double.parseDouble(alunoRequest.getNota_3());
    if((nota_1db + nota_2db + nota_3db)/3 >= 6){
        func.setAprov("APROVADO");
    }
    else{
        func.setAprov("REPROVADO");
    }
    alunoRepository.save(func);
    return func;
}
public AlunoEntity getAlunoId(Integer funcId){
    return alunoRepository.findById(funcId).orElseThrow(() -> new ResourceNotFoundException("Aluno com id: " + funcId + "  não existe" ));
}
public List<AlunoEntity> listarTodosAlunos(){
    return alunoRepository.findAll();
}
public void deletarAluno(Integer funcId){
    AlunoEntity func = getAlunoId(funcId);
    alunoRepository.deleteById(func.getId());
}
public List<AlunoEntity> getAlunoPorNome(String nome){
    return alunoRepository.findByNomeContaining(nome);
}
}
