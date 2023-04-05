package hiag0liveira.github.io.upcar.controller.view;

import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(path = "/view/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteService service;

    @GetMapping(path = "/{id}")
    public String buscarClienteByID(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", service.getClienteById(id));
        return "Cliente/BuscarPorID";
    }

    @GetMapping(path = "/SaveNewCliente")
    public ModelAndView NovoCliente() {
        ModelAndView mv = new ModelAndView("Cliente/CadastroCliente");
        return mv;
    }

    @PostMapping
    public String salvarNewCliente(Cliente cliente) {
        service.saveOneNewCliente(cliente);
        return "redirect:/view/clientes/SaveNewCliente";
    }

    @GetMapping
    public String buscarTodosClientes(Model model) {
        model.addAttribute("clientes", service.findAllClientes());
        return "Cliente/TodosClientes";
    }

    @GetMapping("/{id}/deletarCliente")
    public String deletarCliente(@PathVariable int id) {
        service.deleteClienteByID(id);
        return "redirect:/view/clientes";
    }
}

