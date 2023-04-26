//package hiag0liveira.github.io.upcar.controller.view;
//
//import hiag0liveira.github.io.upcar.domain.entity.Vendedor;
//import hiag0liveira.github.io.upcar.service.VendedorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping(path = "/view/vendedores")
//public class VendedorViewController {
//
//    @Autowired
//    private VendedorService service;
//
//    @GetMapping(path = "/{id}")
//    public String buscarVendedorByID(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("vendedor", service.getVendedorById(id));
//        return "Vendedor/BuscarPorID";
//    }
//
//    @GetMapping(path = "/SaveNewVendedor")
//    public ModelAndView NovoVendedor() {
//        ModelAndView mv = new ModelAndView("Vendedor/CadastroVendedor");
//        return mv;
//    }
//
//    @PostMapping
//    public String salvarNewVendedor(Vendedor vendedor) {
//        service.saveOneNewVendedor(vendedor);
//        return "redirect:Vendedor/TodosVendedores";
//    }
//
//    @GetMapping
//    public String buscarTodosVendedores(Model model) {
//        model.addAttribute("vendedores", service.findAllVendedores());
//        return "Vendedor/TodosVendedores";
//    }
//
//    @GetMapping("/{id}/deletarCliente")
//    public String deletarVendedor(@PathVariable int id) {
//        service.deleteVendedorByID(id);
//        return "redirect:Vendedor/TodosVendedores";
//    }
//}
