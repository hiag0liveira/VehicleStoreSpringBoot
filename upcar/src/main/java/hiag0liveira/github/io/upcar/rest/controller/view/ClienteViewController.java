package hiag0liveira.github.io.upcar.rest.controller.view;

import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping(path = "/view/clientes")
public class ClienteViewController {

    @Autowired
    private Clientes repoClientes;

    public ClienteViewController(Clientes clientes) {
        this.repoClientes = clientes;
    }


    @GetMapping(path = "/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("cliente", repoClientes.findById(id).orElseThrow());
        return "FormClientes";
    }

    @GetMapping
    public String buscarClientes(Model model) {
        model.addAttribute("clientes", repoClientes.findAll());
        return "clientes";
    }
}
