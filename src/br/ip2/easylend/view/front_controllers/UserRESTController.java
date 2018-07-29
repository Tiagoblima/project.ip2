package br.ip2.easylend.view.front_controllers;

import br.ip2.easylend.model.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ip2.easylend.controller.ClienteController;

@RestController
public class UserRESTController {

@RequestMapping("/Details")
public Cliente greeting(@RequestParam(value="name", defaultValue="World") String name) {

    ClienteController clienteController  = ClienteController.getInstance();
    Cliente cliente = clienteController.getCliente();
    cliente.setNome(name);
    return cliente;
}

}
