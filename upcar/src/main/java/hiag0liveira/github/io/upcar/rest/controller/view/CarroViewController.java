package hiag0liveira.github.io.upcar.rest.controller.view;

import hiag0liveira.github.io.upcar.domain.entity.Carro;
import hiag0liveira.github.io.upcar.domain.entity.Cliente;
import hiag0liveira.github.io.upcar.service.CarroService;
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
@RequestMapping(path = "/view/carros")
public class CarroViewController {

    @Autowired
    private CarroService service;

    @GetMapping(path = "/{id}")
    public String buscarCarroByID(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("carro", service.getCarroById(id));
        return "Carro/BuscarPorID";
    }

    @GetMapping(path = "/SaveNewCarro")
    public ModelAndView NovoCarro() {
        ModelAndView mv = new ModelAndView("Carro/CadastroCarro");
        return mv;
    }

    @PostMapping
    public String salvarNewCarro(Carro carro) {
        service.saveOneNewCarro(carro);
        return "redirect:Carro/TodosCarros";
    }

    @GetMapping
    public String buscarTodosCarros(Model model) {
        model.addAttribute("carros", service.findAllCarros());
        return "Carro/TodosClientes";
    }

    @GetMapping("/{id}/deletarCarro")
    public String deletarCarro(@PathVariable int id) {
        service.deleteCarroByID(id);
        return "redirect:Carro/TodosCarros";
    }
}
