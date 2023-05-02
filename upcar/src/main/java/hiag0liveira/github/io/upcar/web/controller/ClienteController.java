package hiag0liveira.github.io.upcar.web.controller;

import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.domain.entity.TipoCliente;
import hiag0liveira.github.io.upcar.domain.entity.UF;
import hiag0liveira.github.io.upcar.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(path = "clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping("/listar")
    public String buscarTodosClientes(Model model) {
        model.addAttribute("clientes", service.findAllClientes());
        return "Cliente/Lista";
    }

    @GetMapping(path = "/cadastrar")
    public String cadastrar(Cliente cliente) {
        return "Cliente/Cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "Cliente/Cadastro";
        }
        service.Salvar(cliente);
        attr.addFlashAttribute("success", "Cadastro Concluido com sucesso.");
        return "redirect:/clientes/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cliente", service.getClienteById(id));
        return "Cliente/Cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "Cliente/Cadastro";
        }

        service.updateCliente(cliente);
        attr.addFlashAttribute("success", "Dados editado com sucesso.");
        return "redirect:/clientes/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.deleteClienteByID(id);
        attr.addFlashAttribute("success", "Cliente removido com sucesso.");
        return "redirect:/clientes/listar";
    }

    @ModelAttribute("ufs")
    public UF[] getUFs() {
        return UF.values();
    }


    @ModelAttribute("tiposDeCliente")
    public TipoCliente[] getTipos() {
        return TipoCliente.values();
    }
}

