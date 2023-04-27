package hiag0liveira.github.io.upcar.web.controller;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import hiag0liveira.github.io.upcar.domain.entity.TipoCombustivel;
import hiag0liveira.github.io.upcar.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping("/listar")
    public String buscarTodosCarros(Model model) {
        model.addAttribute("carros", service.findAllCarros());
        return "Carro/Lista";
    }

    @GetMapping(path = "/cadastrar")
    public String cadastrar(Carro carro) {
        return "Carro/Cadastro";
    }


    @PostMapping("/salvar")
    public String salvar(@Valid Carro carro, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "Carro/Cadastro";
        }
        service.Salvar(carro);
        attr.addFlashAttribute("success", "Cadastro Concluido com sucesso.");
        return "redirect:/carros/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("carro", service.getCarroById(id));
        return "Carro/Cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Carro carro, BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            return "Carro/Cadastro";
        }
        service.updateCarro(carro);
        attr.addFlashAttribute("success", "Dados editado com sucesso.");
        return "redirect:/carros/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.deleteCarroByID(id);
        attr.addFlashAttribute("success", "Carro removido com sucesso.");
        return "redirect:/carros/listar";
    }

    @ModelAttribute("tiposDeCombustiveis")
    public TipoCombustivel[] getTipoDoCombustivel() {
        return TipoCombustivel.values();
    }



}
