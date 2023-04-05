package hiag0liveira.github.io.upcar.controller.view;

import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/view/Agendamentos")
public class AgendamentoViewController {

    @Autowired
    private AgendamentoService service;

    @GetMapping(path = "/{id}")
    public String buscarAgendamentoByID(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("agendamento", service.getAgendamentoById(id));
        return "Agendamento/BuscarPorID";
    }

    @GetMapping(path = "/SaveNewAgendamento")
    public ModelAndView NovoAgendamento() {
        ModelAndView mv = new ModelAndView("Agendamento/CadastroAgendamento");
        return mv;
    }

    @PostMapping
    public String salvarNewAgendamento(Agendamento agendamento) {
        service.saveOneNewAgendamento(agendamento);
        return "redirect:Agendamento/TodosAgendamentos";
    }

    @GetMapping
    public String buscarTodosAgendamento(Model model) {
        model.addAttribute("agendamento", service.findAllAgendamentos());
        return "Agendamento/TodosAgendamentos";
    }

    @GetMapping("/{id}/deletarAgendamento")
    public String deletarAgendamento(@PathVariable int id) {
        service.deleteAgendamentoByID(id);
        return "redirect:Agendamento/TodosAgendamentos";
    }
}
