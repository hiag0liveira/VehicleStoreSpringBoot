package hiag0liveira.github.io.upcar.web.controller;

import hiag0liveira.github.io.upcar.domain.entity.UF;
import hiag0liveira.github.io.upcar.domain.entity.Usuario;
import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
import hiag0liveira.github.io.upcar.service.UsuarioService;
import hiag0liveira.github.io.upcar.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "vendedores")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @Autowired
    private UsuarioService usuarioService;

    // abrir pagina de dados pessoais de vendedor pelo Vendedor
    @GetMapping({"/dados"})
    public String abrirPorVendedor(Vendedor vendedor, ModelMap model, @AuthenticationPrincipal User user) {
        if (vendedor.hasNotId()) {
            vendedor = service.buscarPorEmail(user.getUsername());
            model.addAttribute("vendedor", vendedor);
        }
        return "vendedor/cadastro";
    }
    // salvar Vendedor
    @PostMapping({"/salvar"})
    public String salvar(Vendedor vendedor, RedirectAttributes attr, @AuthenticationPrincipal User user) {
        if (vendedor.hasNotId() && vendedor.getUsuario().hasNotId()) {
            Usuario usuario = usuarioService.buscarPorEmail(user.getUsername());
            vendedor.setUsuario(usuario);
        }
        service.salvar(vendedor);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
        attr.addFlashAttribute("vendedor", vendedor);
        return "redirect:/vendedores/dados";
    }

    // editar Vendedor
    @PostMapping({"/editar"})
    public String editar(Vendedor vendedor, RedirectAttributes attr) {
        service.editar(vendedor);
        attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
        attr.addFlashAttribute("vendedor", vendedor);
        return "redirect:/vendedores/dados";
    }


    @GetMapping("/listar")
    public ResponseEntity<?> buscarTodosVendedores() {
        return ResponseEntity.ok(service.findAllVendedores());
    }

    @ModelAttribute("ufs")
    public UF[] getUFs() {
        return UF.values();
    }


}
