package hiag0liveira.github.io.upcar.rest.controller.view;

import hiag0liveira.github.io.upcar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/view/clientes")
public class ClienteViewController {

    @Autowired
    private ClienteService service;

    @GetMapping(path = "/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", service.getClienteById(id));
        return "FormClientes";
    }
}
//    @GetMapping
//    public String buscarClientes(Model model) {
//        model.addAttribute("clientes", repoClientes.findAll());
//        return "clientes";
//    }

