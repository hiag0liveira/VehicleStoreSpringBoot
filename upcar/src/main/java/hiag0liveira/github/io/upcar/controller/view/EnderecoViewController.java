package hiag0liveira.github.io.upcar.controller.view;

import hiag0liveira.github.io.upcar.domain.entity.Endereco;
import hiag0liveira.github.io.upcar.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/view/endereco")
public class EnderecoViewController {

    @Autowired
    private EnderecoService service;

    @GetMapping(path = "/{id}")
    public String buscarEnderecoByID(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("endereco", service.getEnderecoById(id));
        return "Endereco/BuscarPorID";
    }

    @GetMapping(path = "/SaveNewEndereco")
    public ModelAndView NovoEndereco() {
        ModelAndView mv = new ModelAndView("Endereco/CadastroEndereco");
        return mv;
    }

    @PostMapping
    public String salvarNewEndereco(Endereco endereco) {
        service.saveOneNewEndereco(endereco);
        return "redirect:Endereco/TodosEnderecos";
    }

    @GetMapping
    public String buscarTodosEnderecos(Model model) {
        model.addAttribute("enderecos", service.findAllEnderecos());
        return "Endereco/TodosEnderecos";
    }

    @GetMapping("/{id}/deletarEndereco")
    public String deletarEndereco(@PathVariable int id) {
        service.deleteEnderecoByID(id);
        return "redirect:Endereco/TodosEnderecos";
    }
}
