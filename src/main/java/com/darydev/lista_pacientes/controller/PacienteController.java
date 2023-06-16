package com.darydev.lista_pacientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darydev.lista_pacientes.model.Paciente;
import com.darydev.lista_pacientes.sevice.PacienteService;

@RequestMapping("/")
@Controller
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("pacientes", service.getPacientes());
        return "login";
    }

   

    @GetMapping()
    public String findall(Model model) {

        model.addAttribute("pacientes", service.getPacientes());
        return "index";

    }

    @GetMapping("/post")
    public String post(Model model) {
        Paciente paciente = new Paciente();

        model.addAttribute("titulo", "Crear Nuevo Paciente");
        model.addAttribute("paciente", paciente);
        return "post";
    }

    @GetMapping("/put/{id}")
    public String put(@PathVariable("id") Long id, Model model, RedirectAttributes att) {

        try {

            model.addAttribute("titulo", "Actualizar Paciente");
            model.addAttribute("paciente", service.getPacienteById(id));

            return "post";

        } catch (Exception e) {
            att.addFlashAttribute("danger", "Accion Denegada");
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model, RedirectAttributes att) {
        try {
            att.addFlashAttribute("warning", "Eliminado con Exito!");
            service.delete(id);
            return "redirect:/";
        } catch (Exception e) {
            att.addFlashAttribute("danger", "Accion Denegada!");
            return "redirect:/";
        }

    }

    @PostMapping("/paciente/save")
    public String save(@ModelAttribute Paciente paciente, Model model, RedirectAttributes att) {

        try {
            boolean f = false;

            if (paciente.getId() == null) {
                f = true;
            }

            service.saveOrUpdate(paciente);
            if (f) {
                att.addFlashAttribute("succes", "Accion Exitosa!");
                return "redirect:/post";
            } else {
                att.addFlashAttribute("succes", "Accion Exitosa!");
                return "redirect:/";
            }
        } catch (Exception e) {
            att.addFlashAttribute("danger", "Accion Denegada");
            return "redirect:/";
        }
    }

    @GetMapping("/max")
    public String getMax(Model model) {

        model.addAttribute("p", service.getMaxDebt());
        service.getMaxDebt().getId();

        return "redirect:/put/" + service.getMaxDebt().getId();

    }

}
