
package com.api.SmartEdu.controller;

import com.api.SmartEdu.data.AlunoEntity;
import com.api.SmartEdu.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerMain {
    @Autowired
    AlunoService alunoService;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listarAlunos", alunoService.listarTodosAlunos());
        return "home";
    }
    @GetMapping("/deletarAluno/{id}")
    public String deletarAluno(@PathVariable(value = "id")Integer id){
        alunoService.deletarAluno(id);
        return "redirect:/";
    }
    @GetMapping("/criarAlunoForm")
    public String criarAlunoForm(Model model){
        AlunoEntity func = new AlunoEntity();
        model.addAttribute("aluno", func);
        return"cadastrar";
    }
    
    @PostMapping("/cadastrarAluno")
    public String salvarAluno(@Valid @ModelAttribute("aluno")AlunoEntity func,BindingResult result){
        if(result.hasErrors()){
            return "cadastrar";
        }
        if(func.getId()==null){
            alunoService.criarAluno(func);
    }
        return "redirect:/";
    }
    @PostMapping("/atualizarAluno")
    public String atualizarfuncionario(@Valid @ModelAttribute("aluno")AlunoEntity func, BindingResult result){
        if(result.hasErrors()){
            return "atualizar";
        }
        if(func.getId()!=null){
          alunoService.atualizarAluno(func.getId(), func);  
        }
        return "redirect:/";
    }
    @PostMapping("/AdicionarNotas")
    public String adicionarNotas(@Valid @ModelAttribute("aluno")AlunoEntity func, BindingResult result){
        if(result.hasErrors()){
            return "adicionar";
        }
        if(func.getId()!=null){
          alunoService.AdicionarNotas(func.getId(), func);  
        }
        return "redirect:/";
    }
    @GetMapping("/criarFormAtualizar/{id}")
    public String atualizarAlunoForm(@PathVariable(value = "id")Integer id, Model model){
        AlunoEntity func = alunoService.getAlunoId(id);
        model.addAttribute("aluno", func);
        return "atualizar";
    }
    @GetMapping("/criarFormAdicionar/{id}")
    public String adicionarAlunoForm(@PathVariable(value = "id")Integer id, Model model){
        AlunoEntity func = alunoService.getAlunoId(id);
        model.addAttribute("aluno", func);
        return "adicionar";
    }

}
