package hiag0liveira.github.io.upcar.web.controller;


import hiag0liveira.github.io.upcar.domain.entity.Perfil;
import hiag0liveira.github.io.upcar.domain.entity.PerfilTipo;
import hiag0liveira.github.io.upcar.domain.entity.Usuario;
import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
import hiag0liveira.github.io.upcar.service.UsuarioService;
import hiag0liveira.github.io.upcar.service.VendedorService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("u")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    @Autowired
    private VendedorService vendedorService;

    // abrir cadastro de usuarios (medico/admin/paciente)
    @GetMapping("/novo/cadastro/usuario")
    public String cadastroPorAdminParaAdminVendedor(Usuario usuario) {

        return "usuario/cadastro";
    }

    // abrir lista de usuarios
    @GetMapping("/lista")
    public String listarUsuarios() {

        return "usuario/lista";
    }

    // listar usuarios na datatables
    @GetMapping("/datatables/server/usuarios")
    public ResponseEntity<?> listarUsuariosDatatables(HttpServletRequest request) {

        return ResponseEntity.ok(service.buscarTodos(request));
    }

    // salvar cadastro de usuarios por administrador
    @PostMapping("/cadastro/salvar")
    public String salvarUsuarios(Usuario usuario, RedirectAttributes attr) {
            try {
                service.salvarUsuario(usuario);
                attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
            } catch (DataIntegrityViolationException ex) {
                attr.addFlashAttribute("falha", "Cadastro não realizado, email já existente.");
            }
        return "redirect:/u/novo/cadastro/usuario";
    }

    // pre edicao de credenciais de usuarios
    @GetMapping("/editar/credenciais/usuario/{id}")
    public ModelAndView preEditarCredenciais(@PathVariable("id") Long id) {
        return new ModelAndView("usuario/cadastro", "usuario", service.buscarPorId(id));
    }

    // pre edicao de cadastro de usuarios
    @GetMapping("/editar/dados/usuario/{id}/perfis/{perfis}")
    public ModelAndView preEditarCadastroDadosPessoais(@PathVariable("id") Long usuarioId,
                                                       @PathVariable("perfis") Long[] perfisId) {
        Usuario us = service.buscarPorIdEPerfis(usuarioId, perfisId);

        if (us.getPerfis().contains(new Perfil(PerfilTipo.ADMIN.getCod())) &&
                !us.getPerfis().contains(new Perfil(PerfilTipo.VENDEDOR.getCod())) ) {

            return new ModelAndView("usuario/cadastro", "usuario", us);
        } else if (us.getPerfis().contains(new Perfil(PerfilTipo.VENDEDOR.getCod()))) {

            Vendedor vendedor = vendedorService.buscarPorUsuarioId(usuarioId);
            return vendedor.hasNotId()
                    ? new ModelAndView("vendedor/cadastro", "vendedor", new Vendedor(new Usuario(usuarioId)))
                    : new ModelAndView("vendedor/cadastro", "vendedor", vendedor);
        }
        return new ModelAndView("redirect:/u/lista");
    }

    @GetMapping("/editar/senha")
    public String abrirEditarSenha() {

        return "usuario/editar-senha";
    }

    @PostMapping("/confirmar/senha")
    public String editarSenha(@RequestParam("senha1") String s1, @RequestParam("senha2") String s2,
                              @RequestParam("senha3") String s3, @AuthenticationPrincipal User user,
                              RedirectAttributes attr) {

        if (!s1.equals(s2)) {
            attr.addFlashAttribute("falha", "Senhas não conferem, tente novamente");
            return "redirect:/u/editar/senha";
        }

        Usuario u = service.buscarPorEmail(user.getUsername());
        if(!UsuarioService.isSenhaCorreta(s3, u.getSenha())) {
            attr.addFlashAttribute("falha", "Senha atual não confere, tente novamente");
            return "redirect:/u/editar/senha";
        }

        service.alterarSenha(u, s1);
        attr.addFlashAttribute("sucesso", "Senha alterada com sucesso.");
        return "redirect:/u/editar/senha";
    }

    // abre a pagina de pedido de redefinicao de senha
    @GetMapping("/p/redefinir/senha")
    public String pedidoRedefinirSenha() {

        return "usuario/pedido-recuperar-senha";
    }

    // form de pedido de recuperar senha
    @GetMapping("/p/recuperar/senha")
    public String redefinirSenha(String email, ModelMap model) throws MessagingException {
        service.pedidoRedefinicaoDeSenha(email);
        model.addAttribute("sucesso", "Em instantes você reberá um e-mail para "
                + "prosseguir com a redefinição de sua senha.");
        model.addAttribute("usuario", new Usuario(email));
        return "usuario/recuperar-senha";
    }

    // salvar a nova senha via recuperacao de senha
    @PostMapping("/p/nova/senha")
    public String confirmacaoDeRedefinicaoDeSenha(Usuario usuario, ModelMap model) {
        Usuario u = service.buscarPorEmail(usuario.getEmail());
        if (!usuario.getCodigoVerificador().equals(u.getCodigoVerificador())) {
            model.addAttribute("falha", "Código verificador não confere.");
            return "usuario/recuperar-senha";
        }
        u.setCodigoVerificador(null);
        service.alterarSenha(u, usuario.getSenha());
        model.addAttribute("alerta", "sucesso");
        model.addAttribute("titulo", "Senha redefinida!");
        model.addAttribute("texto", "Você já pode logar no sistema.");
        return "login";
    }
}
