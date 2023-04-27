package hiag0liveira.github.io.upcar.web.controller;

import hiag0liveira.github.io.upcar.domain.entity.Agendamento;
import hiag0liveira.github.io.upcar.domain.entity.PerfilTipo;
import hiag0liveira.github.io.upcar.service.AgendamentoService;
import hiag0liveira.github.io.upcar.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @Autowired
    private ClienteService clienteServiceService;

    // abre a pagina de agendamento de reunioes
    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @GetMapping({"/agendar"})
    public String agendarReuniao(Agendamento agendamento) {

        return "agendamento/cadastro";
    }

    // busca os horarios livres, ou seja, sem agendamento
    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @GetMapping("/horario/vendedor/{id}/data/{data}")
    public ResponseEntity<?> getHorarios(@PathVariable("id") Long id,
                                         @PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        return ResponseEntity.ok(service.buscarHorariosNaoAgendadosPorVendedorIdEData(id, data));
    }

    // salvar uma reuniao agendada
    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @PostMapping({"/salvar"})
    public String salvar(@AuthenticationPrincipal User user, RedirectAttributes attr, Agendamento agendamento) {
        service.salvar(agendamento);
        attr.addFlashAttribute("sucesso", "Sua Reuniao foi agendada com sucesso.");
        return "redirect:/agendamentos/agendar";
    }

    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @GetMapping({"/historico/reunioes"})
    public String historico() {

        return "agendamento/historico-vendedores";
    }

    // localizar o historico de agendamentos por usuario logado
    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @GetMapping("/datatables/server/historico")
    public ResponseEntity<?> historicoAgendamentosPorVendedor(HttpServletRequest request,
                                                              @AuthenticationPrincipal User user) {

        if (user.getAuthorities().contains(new SimpleGrantedAuthority(PerfilTipo.ADMIN.getDesc()))) {

            return ResponseEntity.ok(service.buscarHistoricoPorVendedorEmail(user.getUsername(), request));
        }

        if (user.getAuthorities().contains(new SimpleGrantedAuthority(PerfilTipo.VENDEDOR.getDesc()))) {

            return ResponseEntity.ok(service.buscarHistoricoPorVendedorEmail(user.getUsername(), request));
        }

        return ResponseEntity.notFound().build();
    }

    // localizar agendamento pelo id e envia-lo para a pagina de cadastro
    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @GetMapping("/editar/agendamento/{id}")
    public String preEditarReuniaoCliente(@PathVariable("id") Long id,
                                            ModelMap model, @AuthenticationPrincipal User user) {

        Agendamento agendamento = service.buscarPorId(id);

        model.addAttribute("agendamento", agendamento);
        return "agendamento/cadastro";
    }

    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @PostMapping("/editar")
    public String editarAgendamento(Agendamento agendamento,
                                 RedirectAttributes attr, @AuthenticationPrincipal User user) {

        service.editar(agendamento, user.getUsername());
        attr.addFlashAttribute("sucesso", "Seu agendamento foi alterada com sucesso.");
        return "redirect:/agendamentos/agendar";
    }


    @PreAuthorize("hasAnyAuthority('VENDEDOR', 'ADMIN')")
    @GetMapping("/excluir/agendamento/{id}")
    public String excluirAgendamento(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.remover(id);
        attr.addFlashAttribute("sucesso", "O Agendamento excluída com sucesso.");
        return "redirect:/agendamentos/historico/cliente";
    }

}
